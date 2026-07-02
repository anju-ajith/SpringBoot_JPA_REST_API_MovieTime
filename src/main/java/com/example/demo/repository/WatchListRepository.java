package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.WatchList;
import java.util.List;


@Repository
public interface WatchListRepository extends JpaRepository<WatchList, Integer> {
	
public List<WatchList> findByUserId(int userId);
public List<WatchList> findByUserIdAndImdbid(int userId,String imdbId);
void deleteByUserIdAndImdbid(int userId, String imdbid);
}
