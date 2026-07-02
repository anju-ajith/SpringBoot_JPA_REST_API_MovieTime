package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.MovieDetails;
import com.example.demo.service.WatchListService;

@Controller
public class WatchListController {

	private final WatchListService watchListService;

	public WatchListController(WatchListService watchListService) {
		super();
		this.watchListService = watchListService;
	}

	@PostMapping("/addToWatchlist/{imdbId}")
	public ResponseEntity<String> saveWatchList(@PathVariable String imdbId) {

		boolean watchList = watchListService.addToWatchList(imdbId, 1);
		if(watchList)
		{

		return ResponseEntity.ok("Movie added successfully");
		}
		
			return ResponseEntity.ok("already exists");
		
	}

	@GetMapping("/getWatchList")
	public String getWatchList(Model m) {
		List<MovieDetails> watchList = watchListService.getWatchList(1);
		System.out.println("--------------------------------"+watchList);
		m.addAttribute("watchList", watchList);
		return "Watchlist";

	}
	@DeleteMapping("/removeFromWatchList/{imdbId}")
	public ResponseEntity<String> deleteWatchList(@PathVariable String imdbId) {
		
		boolean watchList = watchListService.deleteFromWatchList(imdbId, 1);
		if(watchList)
		{

		return ResponseEntity.ok("Movie Deleted successfully");
		}
		
			return ResponseEntity.ok("error");
		

	}
	
	
	

}
