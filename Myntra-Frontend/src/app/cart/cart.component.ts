import { Component, HostListener } from '@angular/core';
import { PostService } from '../services/post.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { shoppingCart } from 'src/model';
import { Location, PlatformLocation } from '@angular/common';
import { Subject, fromEvent, takeUntil } from 'rxjs';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent {
  offerpercent = [{ "cardname": "ICICI Card Users", "offeramount": 100 }, { "cardname": "HDFC Card Users", "offeramount": 200 }, { "cardname": "KOTAK Card Users", "offeramount": 300 }];
  displayedColumns: string[] = ['remove', 'image', 'price', 'qty', 'name', 'orderid', 'Brand', 'size'];
  favoriteOffer!: number;
  totalPrice: any;
  selected = 'any';// select option
  checked = false;//check box
  isType = false;
  cartItems: any;
  cartForm: any;
  cartTotal = 0;
  addCart = new Array<any>(); // for cart component
  shoppingcart = new Array<any>();
  quantitydata = [1, 2, 3, 4, 5];
  Sizes = ["S", "M", "L", "XL", "XXL"]
  cartLocalData: any;
  quantity = 1;
  quantityTotalAmount = Array<any>();
  totalPrice1 = 0;
  amount!: number;
  token!: string;
  btn: boolean = true;

  constructor(public dservice: PostService, private snackbar: MatSnackBar, private location:Location,private pflocation: PlatformLocation,) {
  }
  private unsubscriber: Subject<void> = new Subject<void>();
  ngOnInit() {
    this.favoriteOffer = 100;
    this.discountedAmount(this.favoriteOffer);
    this.getData();
    this.token = localStorage.getItem('token')!;
    if (this.token) {
      this.btn = false;
    }
    // const innerScreenHeight = window.innerHeight;
    // // document.querySelector("#footer").style.top = innerScreenHeight + "px";
    // window.location.hash = 'no-back-button';
    // window.location.hash = 'Again-No-back-button'; // again because google chrome don't insert first hash into history
    // window.onhashchange = function () { window.location.hash = 'no-back-button'; }

    // history.pushState(null, "", location.href);
    // history.pushState(location.href, '', "");
    // this.pflocation.onPopState(() => {
    //   history.pushState(null, "", location.href);
    // })

    // history.pushState(null, '');
    // fromEvent(window, 'popstate').pipe(
    //   takeUntil(this.unsubscriber)
    // ).subscribe(() => {
    //   history.pushState(null, '');
    //   this.snackbar.open('Browser Back Button Disabled', '', { duration: 3000 })
    // });
  }
  // ngOnDestroy(): void {
  //   this.unsubscriber.next();
  //   this.unsubscriber.complete();
  // }
  // @HostListener('window:popstate', ['$event'])
  // onPopState() {
  //   this.location.forward();
  // }

  getData() {
    this.addCart = new Array<any>();
    let apiURL = "http://localhost:6062/api/myntra/shoppingCart";
    this.dservice.getAlldata(apiURL).subscribe((response: any) => {
      response.cartViewList.forEach((element: shoppingCart) => {
        if(element.username == localStorage.getItem('Username')){
          this.addCart.push(element);
        }
      });
      this.getTotalPrice();
    }, error => {
      console.log(error);
    })
  }
  delteFromcart(data: any) {
    let apiUrl = "http://localhost:6062/api/myntra/shoppingCart/delete"
    this.dservice.delete(apiUrl, data).subscribe((res) => {
      debugger
      console.log(res);
      this.snackbar.open('Item removed from Cart', 'Dismiss', { duration: 3000 });
      if (res) {
        this.getData();
      }
    }, err => {
      console.log(err);
    })
    this.snackbar.open('Item removed from Cart', 'Dismiss', { duration: 3000 })
  }
  getTotalPrice() {
    this.cartTotal = 0;
    this.addCart.forEach(element => {
      this.cartTotal += (element.qty * element.price)
    });
    this.discountedAmount(this.favoriteOffer);
  }
  updateQuantity(index: number) {
    this.cartTotal = 0;
    this.addCart.forEach((ele, i) => {
      if (index == i) {
        this.cartTotal += (ele.price * ele.qty);
      } else {
        this.cartTotal += (ele.qty * ele.price)
      }
    })
    this.getTotalPrice();
  }
  discountAmount!: number;
  discountedAmount(favoriteOffer: any) {

    this.discountAmount = this.cartTotal - favoriteOffer;
  }
  mac: any
  t: any
  ta: any
  o: any
  c: any
  goToPaymentPage(amount: any) {
    // localStorage.setItem('ta', JSON.stringify(this.cartTotal));
    this.mac = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZWxmc2VydmVAbWh1dno3ZTNtaSIsImlhdCI6MTcxODI2MTc5NiwiZXhwIjoxNzE4MjY0NDk2fQ.Pr6SH1nzFB3z5KYYCdAvoBvN-ZoNjlUHztRMUvE7UkM";
    this.t = '5697513i';
    this.o = '1716965870821';
    this.ta = amount;
    this.c = 'INR';
    console.log("mac" + this.mac);
    const mapForm = document.createElement('form');
    mapForm.method = 'POST';
    mapForm.target = "_self";
    mapForm.action = 'https://pay-dev.acq.toucanint.com/api/auth/getpaymentsession';
    const mapInputT = document.createElement('input');
    mapInputT.type = 'hidden';
    mapInputT.name = 't';
    mapInputT.setAttribute('value', this.t);
    mapForm.appendChild(mapInputT);
    const mapInputO = document.createElement('input');
    mapInputO.type = 'hidden';
    mapInputO.name = 'o';
    mapInputO.setAttribute('value', this.o);
    mapForm.appendChild(mapInputO);
    const mapInputTa = document.createElement('input');
    mapInputTa.type = 'hidden';
    mapInputTa.name = 'ta';
    mapInputTa.setAttribute('value', this.ta);
    mapForm.appendChild(mapInputTa);
    const mapInputC = document.createElement('input');
    mapInputC.type = 'hidden';
    mapInputC.name = 'c';
    mapInputC.setAttribute('value', this.c);
    mapForm.appendChild(mapInputC);
    const mapInputMac = document.createElement('input');
    mapInputMac.type = 'hidden';
    mapInputMac.name = 'mac';
    mapInputMac.setAttribute('value', this.mac);
    mapForm.appendChild(mapInputMac);
    document.body.appendChild(mapForm);
    mapForm.submit();
  }
  goToLanding() {
    let token = localStorage.getItem('token');

  }
}

