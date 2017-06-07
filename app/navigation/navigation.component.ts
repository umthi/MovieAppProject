// This component is for the navigation bar
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { MovieService } from '../service/movie.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],

})
export class NavigationComponent implements OnInit {
a=[];
  constructor(private router:Router,private movieService: MovieService) { }

  ngOnInit() {
  }


clickonmovies() {
this.router.navigate(['favmovie']);
  }


}

