package com.stackroute.ng2boot.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Movie extends ResourceSupport {
	
	 public String title;
	    public String year;
	    public String poster;
	    @Id
	    public String imdbID;
	  
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @JsonProperty("release_date")
    public String getYear() {
        return year;
    }




    public void setYear(String year) {
        this.year = year;
    }



    @JsonProperty("poster_path")
    public String getPoster() {
        return poster;
    }




    public void setPoster(String poster) {
        this.poster = poster;
    }



  @JsonProperty("id")
    public String getImdbID() {
        return imdbID;
    }




    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
    
    
     }