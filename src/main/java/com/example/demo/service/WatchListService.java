package com.example.demo.service;

import java.util.List;

import com.example.demo.model.MovieDetails;
import com.example.demo.model.WatchList;

public interface WatchListService {
	public boolean addToWatchList(String imbdId,int userId);
	public boolean deleteFromWatchList(String imbdId,int userId);
	public List<MovieDetails> getWatchList(int userId);
	public boolean getWatchlistedMovie(String imdbId, int userId);

}
