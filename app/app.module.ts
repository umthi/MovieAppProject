import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from '@angular/material';
import { MdButtonModule, MdCardModule, MdMenuModule, MdToolbarModule, MdIconModule, MdInputModule} from '@angular/material';
import { NavigationComponent } from './navigation/navigation.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { MovieComponent } from './movie/movie.component';
import { Routes , RouterModule } from '@angular/router';
import { MovieService } from './service/movie.service';
import { MovieAppMaterialModule } from './movie-app-material.module';
import {MovieModule} from './movie/movie.module';
import {FavMovieComponent} from './fav-movie/favmovie.component';



@NgModule({
 declarations: [
   AppComponent,
   NavigationComponent,
   SearchBarComponent,
   MovieComponent,
   FavMovieComponent

   ],
 imports: [
   BrowserModule,
   FormsModule,
   HttpModule,
   BrowserAnimationsModule,
   MdButtonModule,
   MdMenuModule,
   MdCardModule,
   MdToolbarModule,
   MdIconModule,
   MdInputModule,
   MaterialModule,
   MovieAppMaterialModule,
  MovieModule
 ],
 exports: [
   BrowserAnimationsModule,
   MdButtonModule,
   MdMenuModule,
   MdCardModule,
   MdToolbarModule,
   MdIconModule,
   MdInputModule,
   RouterModule,
   SearchBarComponent
],
 providers: [ MovieService ],
 bootstrap: [AppComponent]
})
export class AppModule { }
