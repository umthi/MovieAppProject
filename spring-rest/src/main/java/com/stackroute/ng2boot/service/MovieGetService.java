package com.stackroute.ng2boot.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.ng2boot.domain.Movie;

public interface MovieGetService {
	public ArrayList<Movie> getmovies();
	
	
	public void deleteMovie(String string);

	public Iterable<Movie> listAllMovies();
		
	public Movie getMovieById(String string);


	public Movie saveMovie(Movie movie1);


	public void updateMovie(String id, Movie movie);
	

}