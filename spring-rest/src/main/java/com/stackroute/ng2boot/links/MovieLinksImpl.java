package com.stackroute.ng2boot.links;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.stackroute.ng2boot.controllers.MovieRestController;
import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.service.MovieGetService;
@Service
public class MovieLinksImpl implements MovieLinks {
	
	
	public List<Movie> getallmovielinks(List<Movie> allmovie)
	{
		
	 for ( Movie movie : allmovie) {
	        Link selfLink = linkTo(MovieRestController.class).slash(movie.getImdbID()).withSelfRel();
	        Link  insertlink= linkTo(MovieRestController.class).slash(movie.getImdbID()).withRel("Insert");
	        Link  updatelink= linkTo(MovieRestController.class).slash(movie.getImdbID()).withRel("Update");
	        Link  removelink= linkTo(MovieRestController.class).slash(movie.getImdbID()).withRel("Delete");
	        
	        movie.add(selfLink);
	        movie.add(insertlink);
	        movie.add(updatelink);
	        movie.add(removelink);
	        
	    }
	 return allmovie;
	}

	

}
