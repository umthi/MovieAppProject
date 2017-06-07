import { Injectable } from '@angular/core';
import { Http,Headers } from '@angular/http';
import {Movie} from '../model/movie';
import 'rxjs/add/operator/map';
// The class where the response is being get from  API

const link = 'http://www.omdbapi.com/?s=';
@Injectable()
export class MovieService {
constructor(private http: Http) { }
movies:Movie;
getMovies(movieName: string) {
    return this.http.get('https://api.themoviedb.org/3/search/movie?include_adult=false&page=1&query='+movieName+'&language=en-US&api_key=8f5d948e528c5ef8b2eb93deda363671')
    .map((response) => response.json().results || []);
  }

  favmovies()
  { 
  	return this.http.get('http://localhost:8080/v1/api/movie')
    .map((response) => response.json() || []);
  	
  }
  savethemovie(a)
  {var headers=new Headers();
    //headers.append('Content-Type','application/x-www-form-urlencoded');
    console.log(a);
    return this.http.post("http://localhost:8080/v1/api/movie",a).map(res=>res.json()||[]);
  }
  delthemovie(id:string)
  {
    return this.http.delete("http://localhost:8080/v1/api/movie/"+id);
  }
  }
