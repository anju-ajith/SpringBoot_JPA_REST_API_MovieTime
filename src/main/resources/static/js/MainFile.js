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

	                    output += `
	                    <div class="col  mb-4">
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

