import { Component, OnInit } from '@angular/core';
import { LogginService } from '../login/loggin.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  userRole: any;
  status: boolean;
  constructor(public lService: LogginService) {}

  ngOnInit(): void {
    
  }

  Logout() {
    this.lService.logout();
    sessionStorage.clear();
    
  }
}
