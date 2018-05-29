package com.hwa.dao;

import java.util.List;

import com.hwa.orm.Movies;

public interface MoviesDao extends GenericDao<Movies, Long>{

	List<Movies> getMovies();

}
