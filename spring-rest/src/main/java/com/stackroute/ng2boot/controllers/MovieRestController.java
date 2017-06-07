package com.stackroute.ng2boot.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.links.MovieLinks;
import com.stackroute.ng2boot.service.MovieGetService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(value="moviecruiser", description="Operations pertaining to the Movie Cruiser App")
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("v1/api/movie")
public class MovieRestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());



//    @ApiOperation(value = "View a list of available movies",response = Iterable.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    }
//    )

@Autowired
private MovieGetService moviegetservice;

@Autowired
private MovieLinks movielinks;

@RequestMapping(value="",method=RequestMethod.GET)
    public @ResponseBody  Iterable<Movie>  list() {
	System.out.println("hi i am in list contoller");
	List<Movie> allmovies = (List<Movie>) moviegetservice.listAllMovies();
	List<Movie> all=movielinks.getallmovielinks(allmovies);
	return all;
		
}

    //@ApiOperation(value = "Search a movie with an ID",response = Movie.class)
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public Movie getMovie(@PathVariable String id){
		return moviegetservice.getMovieById(id);

    }

    @ApiOperation(value = "Add a movie")
    @RequestMapping(value="",method=RequestMethod.POST)
    public Movie saveMovie(@RequestBody Movie movie){
    	logger.debug("hi this is controller"+movie.getImdbID()+" "+movie.getPoster());
		return moviegetservice.saveMovie(movie);

    }

    @ApiOperation(value = "Update a movie")
    @RequestMapping(value="{id}",method=RequestMethod.PUT)
    public ResponseEntity<Map<String, String>> updateMovie(@PathVariable String id, @RequestBody Movie movie){
        moviegetservice.updateMovie(id,movie);
        movie.setTitle(movie.getTitle());
        movie.setPoster(movie.getPoster());
        movie.setYear(movie.getYear());
        Map<String, String> msgMap = new HashMap<String,String>();
        msgMap.put("message","Movie updated successsfully");
        return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);
}

    @ApiOperation(value = "Delete a movie")
    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public ResponseEntity deleteMovie(@PathVariable String id){
    	moviegetservice.deleteMovie(id);
    	Map msgMap = new HashMap<String,String>();
        msgMap.put("message","Movie deleted successsfully");
        return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);

    }
}
