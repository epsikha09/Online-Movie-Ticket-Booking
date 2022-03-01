import { TestBed } from '@angular/core/testing';

import { TheatreRouteGuard } from './theatre-route.guard';

describe('TheatreRouteGuard', () => {
  let guard: TheatreRouteGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(TheatreRouteGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
