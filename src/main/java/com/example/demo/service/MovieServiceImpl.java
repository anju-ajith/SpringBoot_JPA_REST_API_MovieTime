package com.example.demo.service;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.MovieDetails;
import com.example.demo.model.MovieResponse;

@Service
public class MovieServiceImpl implements MovieService {
	private final RestTemplate restTemplate;
	 private final String API_KEY = "80ab01";
	

	public MovieServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}



	@Override
	public MovieResponse getMovieDetails(String searchText) {
		// TODO Auto-generated method stub
		 String url = "http://www.omdbapi.com/?s=" + searchText + "&apikey=" + API_KEY;
		
	        return restTemplate.getForObject(url, MovieResponse.class);

	}



	@Override
	public MovieDetails getMovie(String imdbId) {
		// TODO Auto-generated method stub
		String url = "http://www.omdbapi.com/?i=" + imdbId + "&apikey=" + API_KEY;
		System.out.println("********************"+url);
		return restTemplate.getForObject(url, MovieDetails.class);
	}

}
