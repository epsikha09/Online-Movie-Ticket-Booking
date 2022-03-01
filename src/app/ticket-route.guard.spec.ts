import { TestBed } from '@angular/core/testing';

import { TicketRouteGuard } from './ticket-route.guard';

describe('TicketRouteGuard', () => {
  let guard: TicketRouteGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(TicketRouteGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
