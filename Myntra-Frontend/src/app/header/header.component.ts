import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PostService } from '../services/post.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  constructor(private router: Router,
    public dservice: PostService,
    public dialog: MatDialog) {
  }
  addCart = new Array<any>();
  cartValue: number = 0;
  ngOnInit() {
    // localStorage.removeItem('token');
    this.getData();
  }
  getData() {
    let apiURL = "http://localhost:6062/api/myntra/shoppingCart";
    this.dservice.getAlldata(apiURL).subscribe((response: any) => {
      // this.addCart = response[0];
      this.cartValue = this.addCart?.length;
      // this.getTotalQty();
    }, error => {
      console.log(error);
    })
    // this.cartValue = this.addCart?.length;
  }
  // getTotalQty() {
  //   
  //   this.cartValue = 0;
  //   this.addCart.forEach(element => {
  //     this.cartValue += element.qty;
  //   });
  // }
  ngAfterViewInit() {
    this.getData();
  }
  goToLanding() {
    this.router.navigate(['/landing']);
  }

  // showWishList() {
  //   this.router.navigate(['/wishlist']);
  // }
  showCart() {
    debugger
    this.router.navigate(['/cart']);
  }
  logout() {
    this.dservice.isUserLoggedIn = false;
    localStorage.removeItem('token');
  }

}




