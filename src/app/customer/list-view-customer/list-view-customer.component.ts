import { Component, OnInit } from '@angular/core';
import { CustmerService } from '../custmer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-list-view-customer',
  templateUrl: './list-view-customer.component.html',
  styleUrls: ['./list-view-customer.component.css'],
})


export class ListViewCustomerComponent implements OnInit {
  customer: any[];

  constructor(private cService: CustmerService) {}

  ngOnInit(): void {
    this.cService.getAllCustomer().subscribe((data: Customer[]) => {
      this.customer = data;
    });
  }
  removeCustomer(custId: number) {
    this.cService.deleteCustomer(custId).subscribe((data: Customer) => {
      this.ngOnInit();
      console.log(data);
    });
  }
}
