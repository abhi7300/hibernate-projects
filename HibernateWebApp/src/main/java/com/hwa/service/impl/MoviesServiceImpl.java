package com.hwa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hwa.dao.MoviesDao;
import com.hwa.orm.Movies;
import com.hwa.service.MoviesService;

@Service("moviesService")
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	private MoviesDao moviesDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Movies> getMovies() throws Exception {

		List<Movies> movieList = moviesDao.getMovies();

		return movieList;
	}

	public MoviesDao getMoviesDao() {
		return moviesDao;
	}

	public void setMoviesDao(MoviesDao moviesDao) {
		this.moviesDao = moviesDao;
	}

}
