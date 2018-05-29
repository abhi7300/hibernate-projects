package com.hwa.service;

import java.util.List;

import com.hwa.orm.Movies;

public interface MoviesService {

	List<Movies> getMovies() throws Exception;
	
}
