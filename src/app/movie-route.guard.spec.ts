import { TestBed } from '@angular/core/testing';

import { MovieRouteGuard } from './movie-route.guard';

describe('MovieRouteGuard', () => {
  let guard: MovieRouteGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(MovieRouteGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
