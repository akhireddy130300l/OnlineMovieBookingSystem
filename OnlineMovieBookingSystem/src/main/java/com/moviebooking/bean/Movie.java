package com.moviebooking.bean;

import java.sql.Blob;

public class Movie {


	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", actors=" + actors + ", director=" + director + ", postername="
				+ postername + ", poster=" + poster + "]";
	}

	// id int primary key auto_increment, name varchar(20),actors
	// varchar(100),director varchar(40));
	private int id;
	private String name;
	private String actors;
	private String director;
	private String postername;
	private Blob poster;

	public Movie() {
	}

	public Movie(String name, String actors, String director,String postername) {
		this.name = name;
		this.actors = actors;
		this.director = director;
		this.setPostername(postername);
	}

	/**
	 * @param id
	 * @param name
	 * @param actors
	 * @param director
	 * @param postername
	 * @param poster
	 */
	public Movie(int id, String name, String actors, String director, String postername, Blob poster) {
		this.id = id;
		this.name = name;
		this.actors = actors;
		this.director = director;
		this.postername = postername;
		this.poster = poster;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostername() {
		return postername;
	}

	public void setPostername(String postername) {
		this.postername = postername;
	}

	public Blob getPoster() {
		return poster;
	}

	public void setPoster(Blob poster) {
		this.poster = poster;
	}


}
