package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MovieResponse;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {

	private final MovieService movieService;

	public MovieController(MovieService movieService) {

		this.movieService = movieService;
	}

	@GetMapping("/getMovieDetails/{searchText}")
	public ResponseEntity<MovieResponse> getMovieDetails(@PathVariable("searchText") String searchText) {
		MovieResponse response = movieService.getMovieDetails(searchText);
		 System.out.println("response"+response); 
		return new ResponseEntity<MovieResponse>(response, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/getMovie") public String getMovie(@RequestParam String id,Model
	 * m){
	 * 
	 * MovieResponse response = movieService.getMovie(id);
	 * System.out.println("response"+response); m.addAttribute("movie", response);
	 * 
	 * return "MovieDetails";
	 * 
	 * }
	 */

}
