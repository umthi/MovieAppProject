
package com.stackroute.ng2boot.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.ng2boot.controllers.MovieRestController;
import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.repository.CrudsRepository;
import com.stackroute.ng2boot.repository.MovieRepository;
@Service
public class MovieGetServiceImpl implements MovieGetService{

	private MovieRepository movieRepository;
	private CrudsRepository crudrepository;
	@Autowired
	public void setCrudsRepository( CrudsRepository crudrepository)
	{
		this.crudrepository=crudrepository;
	}
	@Autowired
	public void setMovieRepository(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	public ArrayList<Movie> getmovies() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public void deleteMovie(String imdbID) {
		crudrepository.delete(imdbID);
		
	}

	public List<Movie> listAllMovies()  {
		// TODO Auto-generated method stub
//		ObjectMapper mapper = new ObjectMapper();
//		ArrayList<Movie> lis=new ArrayList<Movie>();
//		Movie obj[];
//		try {
//			obj = mapper.readValue(new File("./src/main/resources/json/movie.json"), Movie[].class);
//			System.out.println(obj);
//			for(Movie i:obj)
//			{
//			
//				movieRepository.save(i);
//			}
//		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("hi i am in list service");
		return (List<Movie>) crudrepository.findAll();
	}

	public Movie getMovieById(String imdbID) {
//		for(Movie movie:lis)
//		{if(movie.getImdbID().equals(id))
//		{
//			
//			return movie;
//		}
//		
//		}
//		
//		Movie movie = new Movie();
//        movie.setImdbID("imdb1");
//        movie.setTitle("Meter");
//        movie.setPoster("meter.jpg");
//        movie.setYear("2015");
//		return movie;
		
		return crudrepository.findOne(imdbID);
		
	}

	@Override
	public Movie saveMovie(Movie movie) {
		System.out.println("inside service"+movie.getImdbID()+" "+movie.getPoster()+" "+movie.getTitle()
		+""+ movie.getYear());
        return crudrepository.save(movie);
		
	}

	@Override
	public void updateMovie(String id, Movie movie) {
		
		crudrepository.save(movie);
		
	}
	

}
