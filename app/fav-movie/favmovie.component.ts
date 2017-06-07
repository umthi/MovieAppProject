import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Movie } from '../model/movie';
import { MovieService } from '../service/movie.service';
@Component({
  selector: 'fav-app-movie',
  templateUrl: './favmovie.component.html',
  styleUrls: ['./favmovie.component.css']
})

export class FavMovieComponent  {
//movies: Movie[];
a=[];
constructor(private route: ActivatedRoute, private movieService: MovieService) { }
// The movies get stored in the movies property as an object
ngOnInit(): void {
      this.route.params
        .switchMap((params: Params) => this.movieService.favmovies())
        .subscribe(a => this.a = a);
    }


clickonmovies(){
      this.movieService.favmovies().subscribe(a => this.a = a );
    }
    ondel(id:string)
{
	console.log("id :"+id)
	this.movieService.delthemovie(id).subscribe();
}

}
