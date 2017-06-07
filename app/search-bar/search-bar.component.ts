//// This component is for the Search bar
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieComponent } from '../movie/movie.component';
@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {
   constructor(private router: Router) { }

  ngOnInit() {
  }
// The router navigates to the path specified ie.,movie
searchMovie(movieName: String) {
this.router.navigate(['movie', movieName]);
  }


}
