// spec file to check the moviecomponent
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { TestBed, async } from '@angular/core/testing';
import { MockBackend } from '@angular/http/testing';
import { Observable } from 'rxjs/Observable';
import { MovieComponent } from './movie.component';
import { MovieService } from '../service/movie.service';
import {ActivatedRoute, Params } from '@angular/router';
import 'rxjs/add/observable/of';
import {
  Http,
  Response,
  ResponseOptions,
  BaseRequestOptions,
  ConnectionBackend
} from '@angular/http';


describe('Component: MovieComponent', () => {
  let fixture;
  let component;
  let movieService;
  let spy;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        MockBackend,
        BaseRequestOptions,
        {
          provide: Http,
          useFactory: (backend: MockBackend, defaultOptions: BaseRequestOptions) => {
            return new Http(backend, defaultOptions);
          },
          deps: [MockBackend, BaseRequestOptions]
        },
       MovieService, {
        provide: ActivatedRoute,
        useValue: {
        params: Observable.of({id: 123})
       }
        },
      ],
      declarations: [MovieComponent],
       schemas: [ NO_ERRORS_SCHEMA ]
    });

    fixture = TestBed.createComponent(MovieComponent);
    component = fixture.debugElement.componentInstance;
    movieService = fixture.debugElement.injector.get(MovieService);

    const observable: Observable<Response> = Observable.create(observer => {
     const responseOptions = new ResponseOptions({
        body: '[{ "movieName": "titanic" }]'
      });

      observer.next(new Response(responseOptions));
    });

    spy = spyOn(movieService, 'getMovies')
      .and.returnValue(observable);
  });

  it('should create an instance', () => {
    expect(component).toBeTruthy();
  });

});
