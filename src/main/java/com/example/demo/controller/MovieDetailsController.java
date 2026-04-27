package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.MovieDetails;
import com.example.demo.model.MovieResponse;
import com.example.demo.service.MovieService;

@Controller
public class MovieDetailsController {
	private final MovieService movieService;
	
	
	
	public MovieDetailsController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}



	@GetMapping("/getMovie")
	public String getMovie(@RequestParam String id,Model  m){
		 System.out.println("Id--------------------"+id);
		 MovieDetails response = movieService.getMovie(id);
		  System.out.println("response"+response); 
		  m.addAttribute("movie", response);
		 
             return "MovieDetails";
		

}
}
