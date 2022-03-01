import { TestBed } from '@angular/core/testing';

import { ScreenRouteGuard } from './screen-route.guard';

describe('ScreenRouteGuard', () => {
  let guard: ScreenRouteGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ScreenRouteGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
