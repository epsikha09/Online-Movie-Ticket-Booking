import { TestBed } from '@angular/core/testing';

import { ShowRouteGuard } from './show-route.guard';

describe('ShowRouteGuard', () => {
  let guard: ShowRouteGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ShowRouteGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
