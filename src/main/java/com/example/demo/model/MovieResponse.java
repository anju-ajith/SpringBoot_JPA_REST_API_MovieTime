package com.example.demo.model;

import java.util.List;

public class MovieResponse {
	private List<MovieList> Search;
    private String totalResults;
    private String Response;
	public List<MovieList> getSearch() {
		return Search;
	}
	public void setSearch(List<MovieList> search) {
		Search = search;
	}
	public String getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}
	public String getResponse() {
		return Response;
	}
	public void setResponse(String response) {
		Response = response;
	}
	@Override
	public String toString() {
		return "MovieResponse [Search=" + Search + ", totalResults=" + totalResults + ", Response=" + Response + "]";
	}
	
    

}
