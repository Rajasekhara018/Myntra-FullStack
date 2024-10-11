import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PostService } from 'src/app/services/post.service';
import { Cart, shoppingCart } from 'src/model';
@Component({
  selector: 'app-sweaters',
  templateUrl: './sweaters.component.html',
  styleUrls: ['./sweaters.component.scss']
})
export class SweatersComponent {
  constructor(public service: PostService, public snackbar: MatSnackBar) {

  }
  tShirtData = new Array<any>();

  ngOnInit(): void {
    this.getTshirtData();
  }
  // getTshirtData() {
  //   let apiURL = "http://localhost:6062/api/myntra/men/sweaters";
  //   this.service.getAlldata(apiURL).subscribe((response: any) => {
  //     this.tShirtData = response;
  //     console.log(response);
  //   }, error => {
  //     console.log(error);
  //   })
  // }
  getTshirtData() {
    let apiURL = "http://localhost:6062/api/myntra/men/sweaters";
    this.service.getAlldata(apiURL).subscribe((response: any) => {
      this.tShirtData = response;
      console.log(response);
    }, error => {
      console.log(error);
    })
  }
  myntraCart!: shoppingCart[];
  addTocart(data: any) {
    let shopCart = new shoppingCart();
    this.myntraCart = new Array<any>();
    if (data) {
      shopCart.image = data.images[0].src;
      shopCart.price = data.price;
      shopCart.qty = 1;
      shopCart.name = data.additionalInfo;
      shopCart.orderId = data.productId;
      shopCart.brand = data.brand;
      shopCart.size = data.sizes;
      shopCart.username = localStorage.getItem('Username')!;
      let apiUrl = "http://localhost:6062/api/myntra/shoppingCart"
      this.service.postdata(apiUrl, shopCart).subscribe((response) => {
        
        this.snackbar.open('Item Added to Cart', 'Dismiss', { duration: 3000 })
      }, err => {
        console.log(err);
        this.snackbar.open(err.error, 'Dismiss', { duration: 3000, panelClass: 'snackbar-btn' });
      })
    }
  }
  addToWishlist(data: any) {
    for (let i = 0; i <= this.service.searchArray.length; i++) {
      let element = this.service.searchArray[i];
      if (element.id == data.id) {
        element.iswl = true;
        this.service.wlCount++;
        this.snackbar.open('Added to wishlist', 'Close', {
          duration: 2000,
        });
        break;
      }
    }

    localStorage.setItem(
      'updatedData',
      JSON.stringify(this.service.searchArray)
    );
  }
  removeWishList(data: any) {
    if (this.service?.searchArray?.length > 0) {
      this.service?.searchArray?.forEach(ele => {
        if (ele.id === data.id) {
          ele.iswl = false;
          this.service.wlCount = this.service.wlCount - 1;
          console.log(this.service.wlCount);
          this.snackbar.open('Removed from wishlist', 'Close', {
            duration: 2000,
          });
        }
      })
    }
    this.service.searchArray = [...this.service.searchArray];

    localStorage.setItem('updatedData', JSON.stringify(this.service.searchArray)
    );
  }
  // addTocart(data: any) {
  //   if (data) {
  //     let obj = new shoppingCart();
  //     obj.id = data.id;
  //     obj.image = data.images[0].src;
  //     obj.price = data.price;
  //     obj.qty = 1;
  //     obj.name = data.additionalInfo;
  //     obj.orderId = data.productId;
  //     obj.brand = data.brand;
  //     obj.size = data.sizes[0];
  //     let apiUrl = "http://localhost:6062/api/myntra/shoppingCart"
  //     this.service.postdata(apiUrl, obj).subscribe((response) => {
  //       this.snackbar.open('Item Added to Cart', 'Dismiss', { duration: 3000 })
  //     }, err => {
  //       console.log(err);
  //       this.snackbar.open(err.error, 'Dismiss', { duration: 3000, panelClass: 'snackbar-btn' });
  //     })
  //     // this.service.cartJson.push(obj);
  //     // this.service.cartCount++;
  //   }
  // }
}
