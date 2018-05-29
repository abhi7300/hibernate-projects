package com.hwa.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hwa.dao.MoviesDao;
import com.hwa.orm.Movies;

@Repository("moviesDao")
public class MoviesDaoImpl extends GenericDaoImpl<Movies, Long> implements MoviesDao {

	@Autowired
	private DataSource datasource;

	public List<Movies> getMovies() {
		return findAll();
	}

	@Override
	protected Class<Movies> getEntityClass() {
		return Movies.class;
	}

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

}
