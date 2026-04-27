package com.example.demo.service;

import com.example.demo.model.MovieDetails;
import com.example.demo.model.MovieResponse;

public interface MovieService {
	MovieResponse getMovieDetails(String searchText);
	MovieDetails	getMovie(String imdbId);

}
