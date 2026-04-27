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
	  private long imdbid;
	  private String poster;
	  private String title;
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
	  public long getImdbid() {
		  return imdbid;
	  }
	  public void setImdbid(long imdbid) {
		  this.imdbid = imdbid;
	  }
	  public String getPoster() {
		  return poster;
	  }
	  public void setPoster(String poster) {
		  this.poster = poster;
	  }
	  public String getTitle() {
		  return title;
	  }
	  public void setTitle(String title) {
		  this.title = title;
	  }
	  @Override
	  public String toString() {
		return "WatchList [id=" + id + ", userId=" + userId + ", imdbid=" + imdbid + ", poster=" + poster + ", title="
				+ title + "]";
	  }
	  

}
