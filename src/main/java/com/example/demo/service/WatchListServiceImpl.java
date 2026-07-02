package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.MovieDetails;
import com.example.demo.model.WatchList;
import com.example.demo.repository.WatchListRepository;

import jakarta.transaction.Transactional;

@Service
public class WatchListServiceImpl implements WatchListService {

	private final WatchListRepository watchListRepo;
	private final RestTemplate restTemplate;
	private final String API_KEY = "80ab01";

	public WatchListServiceImpl(WatchListRepository watchListRepo, RestTemplate restTemplate) {
		super();
		this.watchListRepo = watchListRepo;
		this.restTemplate = restTemplate;
	}

	@Override
	public boolean addToWatchList(String imdbId, int userId) {

		List<WatchList> iswatchlisted = watchListRepo.findByUserIdAndImdbid(userId, imdbId);
		// TODO Auto-generated method stub

		if (!iswatchlisted.isEmpty()) {
			return false;
		}
		WatchList watchList = new WatchList();
		watchList.setUserId(userId);
		watchList.setImdbid(imdbId);
		watchListRepo.save(watchList);

		return true;

	}
	
	@Override
	public boolean getWatchlistedMovie(String imdbId, int userId) {
		List<WatchList> iswatchlisted = watchListRepo.findByUserIdAndImdbid(userId, imdbId);
		if (!iswatchlisted.isEmpty()) {
			return false;
		}
	return true;
	}

	@Override
	public List<MovieDetails> getWatchList(int userId) {
		// TODO Auto-generated method stub
		List<WatchList> watchList = watchListRepo.findByUserId(userId);
		List<MovieDetails> movies = new ArrayList<>();

		for (WatchList w : watchList) {
			String imdbId= w.getImdbid();

			String url = "http://www.omdbapi.com/?i=" + imdbId + "&apikey=" + API_KEY;

			MovieDetails movie = restTemplate.getForObject(url, MovieDetails.class);
			
			movie.setImdbID(imdbId);

			movies.add(movie);
		}
		return movies;

	}

	@Override
	@Transactional
	public boolean deleteFromWatchList(String imbdId, int userId) {
		// TODO Auto-generated method stub
		watchListRepo.deleteByUserIdAndImdbid(userId,imbdId);
		return true;
	}

}
