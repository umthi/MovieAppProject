// It is a mock file where the properties are being located
export class Movie {
  title: string;
  year: number;
  poster: string;
  imdbID: string;
 constructor (imdbID, title, year, poster) {
this.imdbID = imdbID;
this.title = title;
this.poster = poster;
this.year = year;
}
// A method which is for testing
clone() {
   return new Movie(this.imdbID, this.title, this.year, this.poster);
 }
}
