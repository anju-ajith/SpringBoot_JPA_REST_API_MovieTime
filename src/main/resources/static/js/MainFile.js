let timer;

document.getElementById("searchText").addEventListener("keyup", function() {

    clearTimeout(timer);

    let searchText = this.value;

    timer = setTimeout(() => {
        if (searchText.length > 2) {
            getMovies(searchText);
        } else {
            document.getElementById("movies").innerHTML = '';
            /*document.getElementById("pNotfound").innerText = 'No Results found. Please check the movie name that you have entered.';*/
        }
    }, 500);
});

function getMovies(searchText) {
    fetch('/getMovieDetails/' + searchText, {
        method: 'GET'
    }).then(response => response.json())
        .then(data => {

            let output = '';

            if (data.Response === "False") {
                output = "<h3>No Results Found</h3>";
            } else {
                data.Search.forEach(movie => {

                    let poster = movie.Poster !== "N/A"
                        ? movie.Poster
                        : "/images/no-image.jpg";

                    output += `<div class="col-lg-3 col-md-4 col-sm-6 mb-4">
	                        <div class="card h-100">
	                            <img src="${poster}" class="card-img-top movie-img" alt="${movie.Title}">
	                            <div class="card-body">
	                                <h6 class="card-title card-font">${movie.Title}</h6>
									<div class="text-center">
									<a class="btn btn-primary btnDetails" href="/getMovie?id=${movie.imdbID}">Movie Details</a>
									</div>
	                            </div>
	                        </div>
	                    </div>`;
                });
            }

            document.getElementById("movies").innerHTML = output;
        })
        .catch(error => console.error(error));
}

function addToWatchList() {



    let imdbId = document.getElementById("imdbIds").value;
    let btn = document.getElementById("imdbIds");

    fetch('/addToWatchlist/' + imdbId, {
        method: 'POST'
    })
        .then(response => {
            if (response.ok) {

                btn.innerHTML = "WatchListed";

            } else {
                alert("Failed to add movie.");
            }
        })
        .catch(error => {
            console.error(error);
        });
}

let msg = document.getElementById("successMsg");
msg.style.display = "block";

setTimeout(() => {
    msg.style.display = "none";
}, 3000);

function removeFromWatchList() {

    let imdbId = document.getElementById("removeimdbIds").value;
    let btn = document.getElementById("removeimdbIds");
    fetch('/removeFromWatchList/' + imdbId, {
        method: 'DELETE'
    }).then(response => {
        if (response.ok) {
            btn.innerHTML = "Add To WatchList";
        } else {
            alert("Failed to delete.");
        }
    })
        .catch(error => {
            console.error(error);
        });

}

function deleteWatchList() {

	let imdbId = document.getElementById("imdbid").value;
    fetch('/removeFromWatchList/' + imdbId, {
        method: 'DELETE'
    }).then(response => {
        if (response.ok) {
			location.reload()
        } else {
            alert("Failed to delete.");
        }
    })
        .catch(error => {
            console.error(error);
        });






}


const modal = new bootstrap.Modal(
    document.getElementById('watchListModal')
);

modal.show();