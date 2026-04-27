package com.example.demo.model;

public class MovieDetails {
	 private String Title;
	    private String Year;
	    private String Genre;
	    private String Director;
	    private String Poster;
	    private String Plot;
	    private String imdbRating;
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getYear() {
			return Year;
		}
		public void setYear(String year) {
			Year = year;
		}
		public String getGenre() {
			return Genre;
		}
		public void setGenre(String genre) {
			Genre = genre;
		}
		public String getDirector() {
			return Director;
		}
		public void setDirector(String director) {
			Director = director;
		}
		public String getPoster() {
			return Poster;
		}
		public void setPoster(String poster) {
			Poster = poster;
		}
		public String getPlot() {
			return Plot;
		}
		public void setPlot(String plot) {
			Plot = plot;
		}
		public String getImdbRating() {
			return imdbRating;
		}
		public void setImdbRating(String imdbRating) {
			this.imdbRating = imdbRating;
		}
		@Override
		public String toString() {
			return "MovieDetails [Title=" + Title + ", Year=" + Year + ", Genre=" + Genre + ", Director=" + Director
					+ ", Poster=" + Poster + ", Plot=" + Plot + ", imdbRating=" + imdbRating + "]";
		}
	    
	    

}
