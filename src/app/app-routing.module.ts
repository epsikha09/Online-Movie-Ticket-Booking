import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingComponent } from './booking/booking.component';
import { CreateBookingComponent } from './booking/create-booking/create-booking.component';
import { ListViewBookingComponent } from './booking/list-view-booking/list-view-booking.component';
import { DetailViewBookingComponent } from './booking/detail-view-booking/detail-view-booking.component';
import { AdminDetailsComponent } from './movie/admin-details/admin-details.component';
import { AllMoviesComponent } from './movie/all-movies/all-movies.component';
import { CreateMovieComponent } from './movie/create-movie/create-movie.component';
import { DetailViewMovieComponent } from './movie/detail-view-movie/detail-view-movie.component';
import { MovieDashboardComponent } from './movie/movie-dashboard/movie-dashboard.component';
import { MovieComponent } from './movie/movie.component';
import { UpdateMoviesComponent } from './movie/update-movies/update-movies.component';
import { CreateScreenComponent } from './screen/create-screen/create-screen.component';
import { DetailViewScreenComponent } from './screen/detail-view-screen/detail-view-screen.component';
import { ListViewScreenComponent } from './screen/list-view-screen/list-view-screen.component';
import { ScreenComponent } from './screen/screen.component';
import { ListViewSeatComponent } from './seat/list-view-seat/list-view-seat.component';
import { SeatComponent } from './seat/seat.component';
import { CreateShowComponent } from './show/create-show/create-show.component';
import { DetaiViewShowComponent } from './show/detai-view-show/detai-view-show.component';
import { ListViewShowComponent } from './show/list-view-show/list-view-show.component';
import { ShowComponent } from './show/show.component';
import { CreateTheatreComponent } from './theatre/create-theatre/create-theatre.component';
import { DetailViewTheatreComponent } from './theatre/detail-view-theatre/detail-view-theatre.component';
import { ListViewTheatreComponent } from './theatre/list-view-theatre/list-view-theatre.component';
import { TheatreComponent } from './theatre/theatre.component';
import { TheatresBookingComponent } from './theatre/theatres-booking/theatres-booking.component';
import { UpdateTheatreComponent } from './theatre/update-theatre/update-theatre.component';
import { CreateTicketComponent } from './ticket/create-ticket/create-ticket.component';
import { TicketComponent } from './ticket/ticket.component';
import { LoginComponent } from './login/login.component';
import { CreateUserComponent } from './user/create-user/create-user.component';
import { AuthGuard } from './auth.guard';
import { CustomerComponent } from './customer/customer.component';
import { CreateCustomerComponent } from './customer/create-customer/create-customer.component';
import { ListViewCustomerComponent } from './customer/list-view-customer/list-view-customer.component';
import { HomeComponent } from './home/home.component';
import { UpdateScreensComponent } from './screen/update-screens/update-screens.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { CreateSeatComponent } from './seat/create-seat/create-seat.component';
import { SeatRouteGuard } from './seat-route.guard';
import { MovieRouteGuard } from './movie-route.guard';
import { TheatreRouteGuard } from './theatre-route.guard';
import { ScreenRouteGuard } from './screen-route.guard';
import { ShowRouteGuard } from './show-route.guard';
import { TicketRouteGuard } from './ticket-route.guard';
import { CustomerRouteGuard } from './customer-route.guard';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'signIn', component: LoginComponent },
  { path: 'signUp', component: CreateUserComponent },
  {
    canActivate: [MovieRouteGuard],
    path: 'movie',
    component: MovieComponent,
    children: [
      { path: '', component: AllMoviesComponent },
      { path: 'admin/list', component: MovieDashboardComponent },
      { path: 'view/:movieId', component: DetailViewMovieComponent },
      { path: 'admin/details/:movieId', component: AdminDetailsComponent },
      { path: 'add', component: CreateMovieComponent },
      { path: 'update/:movieId', component: UpdateMoviesComponent },
    ],
  },
  {
    canActivate: [TheatreRouteGuard],
    path: 'theatre',
    component: TheatreComponent,
    children: [
      { path: '', component: ListViewTheatreComponent },
      { path: 'view/:theatreId', component: DetailViewTheatreComponent },
      { path: 'add', component: CreateTheatreComponent },
      { path: 'update/:theatreId', component: UpdateTheatreComponent },
      { path: 'viewbyMovie/:movieId', component: TheatresBookingComponent },
    ],
  },
  {
    canActivate: [ScreenRouteGuard],
    path: 'screen',
    component: ScreenComponent,
    children: [
      { path: '', component: ListViewScreenComponent },
      { path: 'view/:screenId', component: DetailViewScreenComponent },
      { path: 'add/:theatreId', component: CreateScreenComponent },
      { path: 'update/:screenId', component: UpdateScreensComponent },
    ],
  },
  {
    canActivate: [ShowRouteGuard],
    path: 'show',
    component: ShowComponent,
    children: [
      { path: '', component: ListViewShowComponent },
      { path: 'view/:showId', component: DetaiViewShowComponent },
      { path: 'add/:theatreId/:screenId', component: CreateShowComponent },
    ],
  },
  {
    canActivate: [AuthGuard],
    path: 'booking',
    component: BookingComponent,
    children: [
      { path: '', component: ListViewBookingComponent },
      { path: 'view/:bookingId', component: DetailViewBookingComponent },
      { path: 'add/:showId', component: CreateBookingComponent },
    ],
  },
  {
    canActivate: [TicketRouteGuard],
    path: 'ticket',
    component: TicketComponent,
    children: [{ path: 'add/:bookingId', component: CreateTicketComponent }],
  },
  {
    canActivate: [SeatRouteGuard],
    path: 'seat',
    component: SeatComponent,
    children: [
      { path: '', component: ListViewSeatComponent },
      { path: 'add', component: CreateSeatComponent },
    ],
  },
  {
    canActivate: [CustomerRouteGuard],
    path: 'customer',
    component: CustomerComponent,
    children: [
      { path: '', component: ListViewCustomerComponent },
      { path: 'update/:customerId', component: UpdateCustomerComponent },
      { path: 'add', component: CreateCustomerComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
