import { Movie } from './movie';
/*Test for Movie model
Update test code to instansiate new Movie in beforEach() block*/
describe('Movie', () => {
    it('has title', () => {
       const movie = new Movie('tt0120338', 'Titanic', '1997', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2.jpg');
    expect(movie.title).toBe('Titanic');
  });

  it('has imdb Id', () => {
    const movie = new Movie('tt0120338', 'Titanic', '1997', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2.jpg');
    expect(movie.imdbID).toBe('tt0120338');
  });

  it('has poster', () => {
    const movie = new Movie('tt0120338', 'Titanic', '1997', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2.jpg');
    expect(movie.poster).toBe('https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2.jpg');
  });

  it('has year', () => {
    const movie = new Movie('tt0120338', 'Titanic', '1997', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2.jpg');
    expect(movie.year).toBe('1997');
  });

  it('can clone itself', () => {
    const movie = new Movie('tt0120338', 'Titanic', '1997', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2.jpg');
    const clone = movie.clone();
    expect(movie).toEqual(clone);
  });
});
