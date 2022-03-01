import { TestBed } from '@angular/core/testing';

import { SeatRouteGuard } from './seat-route.guard';

describe('SeatRouteGuard', () => {
  let guard: SeatRouteGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(SeatRouteGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
