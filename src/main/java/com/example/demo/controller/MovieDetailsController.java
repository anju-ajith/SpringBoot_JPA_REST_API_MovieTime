package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.MovieDetails;
import com.example.demo.model.MovieResponse;
import com.example.demo.service.MovieService;
import com.example.demo.service.WatchListService;

@Controller
public class MovieDetailsController {
	private final MovieService movieService;
	private final WatchListService watchListService;

	public MovieDetailsController(MovieService movieService, WatchListService watchListService) {
		super();
		this.movieService = movieService;
		this.watchListService = watchListService;
	}

	@GetMapping("/getMovie")
	public String getMovie(@RequestParam String id, Model m) {
		System.out.println("Id--------------------" + id);
		MovieDetails response = movieService.getMovie(id);
		System.out.println("response" + response);

		boolean watchList = watchListService.getWatchlistedMovie(id,1);

		m.addAttribute("movie", response);
		m.addAttribute("imdbId", id);
		m.addAttribute("watchlisted", watchList);
		return "MovieDetails";

	}
}
