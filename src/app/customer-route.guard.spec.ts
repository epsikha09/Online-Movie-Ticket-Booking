import { TestBed } from '@angular/core/testing';

import { CustomerRouteGuard } from './customer-route.guard';

describe('CustomerRouteGuard', () => {
  let guard: CustomerRouteGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(CustomerRouteGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
