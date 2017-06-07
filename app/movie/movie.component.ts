// This component is for the details of the movies which are stored as object
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Movie } from '../model/movie';
import { MovieService } from '../service/movie.service';
@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})

export class MovieComponent implements OnInit {
movies: Movie[];
constructor(private route: ActivatedRoute, private movieService: MovieService) { }
// The movies get stored in the movies property as an object
ngOnInit(): void {
      this.route.params
        .switchMap((params: Params) => this.movieService.getMovies(params['movieName']))
        .subscribe(movies => this.movies = movies);
    }
onsave(a)
{
	this.movieService.savethemovie(a).subscribe((data)=>{});
}


}

