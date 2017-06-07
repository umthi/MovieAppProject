import { MovieComponent } from './movie.component';
import { Routes , RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import {FavMovieComponent} from '../fav-movie/favmovie.component';
const routes: Routes = [

  { path: 'movie/:movieName',  component: MovieComponent },
  {path:'favmovie',component: FavMovieComponent}];
// router's path and the modules are imported here
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class MovieModule {}
