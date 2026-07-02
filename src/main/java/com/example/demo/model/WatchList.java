package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WatchList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private int userId;
	  private String imdbid;
	  public int getId() {
		  return id;
	  }
	  public void setId(int id) {
		  this.id = id;
	  }
	  public int getUserId() {
		  return userId;
	  }
	  public void setUserId(int userId) {
		  this.userId = userId;
	  }
	  public String getImdbid() {
		  return imdbid;
	  }
	  public void setImdbid(String imdbid) {
		  this.imdbid = imdbid;
	  }
	  @Override
	  public String toString() {
		return "WatchList [id=" + id + ", userId=" + userId + ", imdbid=" + imdbid + "]";
	  }
	  
	 
}
