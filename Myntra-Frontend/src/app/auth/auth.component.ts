import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ErrorMessageModule, Login, Registration } from 'src/model';
import { PostService } from '../services/post.service';
import { Router } from '@angular/router';
import { SocialAuthService, SocialUser } from '@abacritt/angularx-social-login';
import { every } from 'rxjs';
import { animate } from '@angular/animations';
import { CommonServiceService } from '../services/common-service.service';
import { CryptoGraphService } from '../services/crypto-graph.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent {
  value: any;
  removable = false;
  acceptedType = 'image/*,.pdf,.doc,.docx';
  prefixFolder: string = "DISPTES";
  modelKey: string = "Rajasekhar";
  // user!: SocialUser;
  user: any;
  loggedIn: any;
  dataObj!: Registration
  loginObj!: Login;
  confirmPassword!: string;
  constructor(private snackBar: MatSnackBar, private router: Router, public service: PostService,
     public commonService: CommonServiceService, private authService: SocialAuthService,
    private cryptoGraphService:CryptoGraphService) { }
  @ViewChild('RegisterForm') registerForm!: NgForm;
  @ViewChild('LoginForm') loginForm!: NgForm;
  genders: string[] = ['Female', 'Male', 'other']
  newDS = new Array<classfied>();
  isFileUploaded:boolean = true;
  ngOnInit(): void {
    // let category = ["openLoop","ClosedLoop","Loop"]

    // for 2 stage 
    // let SubCategory = ['prepaid', 'debit', 'credit'];
    // let cardClass = ['classic', 'gold', 'silver', 'bronze'];
    // SubCategory.forEach((ele, i) => {
    //   if (!this.newDS[i]) {
    //     this.newDS[i] = new classfied();
    //   }
    //   this.newDS[i].subCategory = SubCategory[i];
    //   this.newDS[i].cardClass = cardClass;
    //   console.log(this.newDS);
    // })

    const subCategory = ['prepaid', 'debit', 'credit'];
    const cardClass = ['classic', 'gold', 'silver', 'bronze'];
    const productCategory = ["openLoop", "closedLoop", "Loop"];
    const productData = [];
    for (const category of productCategory) {
      const subCategories = [];
      for (const sub of subCategory) {
        subCategories.push({
          subCategory: sub,
          cardClass: [...cardClass],
        });
      }
      productData.push({
        productCategory: category,
        productSubCategory: subCategories,
      });
    }
    console.log(productData);




    this.dataObj = new Registration();
    this.loginObj = new Login();
    // this.authService.authState.subscribe((user) => {
    //   this.user = user;
    //   this.loggedIn = (user != null);
    //   console.log(user)
    // });
    // this.sessionTimerForOtp();

    // this.authService.authState.subscribe((user) => {
    //   localStorage.setItem('g', JSON.stringify(user));
    //   this.appName = user?.firstName + ' ' + user?.lastName;
    //   this.signUpObj.name.firstName = user?.firstName;
    //   this.signUpObj.name.lastName = user?.lastName;
    //   this.signUpObj.emailId = user?.email;
    //   // this.signUpObj.merchantType = 'BOTH';
    //   this.signUpObj.goolgeIdToken = user?.idToken;
    //   this.isGoogleSignupd = true;
    //   console.log(user)
    // });
  }
  Register(data: Registration) {
    // let apiURL = "http://localhost:8080/api/myntra/register";
    // let apiURL = "http://localhost:8080/api/auth/register";
    let apiURL = "http://localhost:6062/flipkart/register";
     data.email= this.cryptoGraphService.encryptUsingAES256(data.email);
     console.log(data.email);
    this.service.postdata(apiURL, data).subscribe((response) => {
      if (response) {
        // this.router.navigate(['registerData'])
      }
      this.snackBar.open("registered Successfully", 'Dismiss', { duration: 3000, panelClass: 'snackbar-btn' });
    }, (err: any) => {
      this.snackBar.open(err.message, 'Dismiss', { duration: 3000, panelClass: 'snackbar-btn' });
    })
    this.registerForm.resetForm();
  }
  // ResendOtp:boolean = false;
  // otpMinutes!:number;
  // otpSeconds!:number;
  // sessionTimerForOtp() {
  //   
  //   // this.otpMinutes = 0;
  //   // this.otpSeconds = 0;
  //   let counter = 360;
  //   const interval = setInterval(() => {
  //     // if (counter > 0) {
  //     //   this.otpMinutes = Math.floor(counter / 60);
  //     //   this.otpSeconds = (counter % 60);
  //     //   counter--;
  //     //   if (counter > 300) {
  //     //     this.enableResendOTP = true;
  //     //   } else {
  //     //     this.enableResendOTP = false;
  //     //   }
  //     // } else {
  //     //   counter = this.coData.pgPageTimeOut;
  //     // }
  //     if (this.ResendOtp) {
  //       clearInterval(interval);
  //       this.ResendOtp = false;
  //       // counter = 0;
  //       // this.sessionTimerForOtp();
  //     } else if (counter === 0) {
  //       clearInterval(interval);
  //       // this.snackbar.open('Timed out', 'Dismiss', { duration: 4000 });
  //       // this.otpShow = false;
  //       // this.isccDc = true;
  //       // this.redirectfurl = localStorage.getItem('redirectfurl');
  //       // this.paymentFailurePage();
  //       // this.clocation.back();
  //       // window.location.href = 'https://merchantunit.toucanus.net/#/dashboard/shoppingcart/';
  //       // this.router.navigate(['https://merchantunit.toucanus.net/toucan-0.0.1-SNAPSHOT/ap/dashboard/shoppingcart']);
  //     } else if (counter > 0) {
  //       this.otpMinutes = Math.floor(counter / 60);
  //       this.otpSeconds = (counter % 60);
  //       counter--;
  //       if (counter > 300) {
  //         // this.enableResendOTP = true;
  //       } else {
  //         // this.enableResendOTP = false;
  //       }
  //     } else {
  //       // counter = this.coData.pgPageTimeOut;
  //     }
  //   }, 1000);
  // }
  // reGenerateOTP() {
  //   this.ResendOtp = true;
  //   this.sessionTimerForOtp();
  // }
  uEmail!: string
  uPassword!: string
  LogIn(data: Login) {
    // let apiURL = "http://localhost:8080/api/myntra/login";
    // let apiURL = "http://localhost:8080/api/auth/login";
    // let apiURL = "http://localhost:6062/app/login";
    let apiURL = "http://localhost:6062/flipkart/login";


    this.service.postdata(apiURL, data).subscribe((res: any) => {

      this.router.navigateByUrl('men/menClothing');
      console.log("response" + res.message);

      this.service.isUserLoggedIn = true;
      this.snackBar.open(res.message, 'Dismiss', { duration: 3000, panelClass: 'snackbar-btn' });
      localStorage.setItem('token', res.token);
      localStorage.setItem('Username', data.email);
      this.loginForm.resetForm();
    }, (error: any) => {

      // console.log("response" + error);
      // this.router.navigateByUrl('/men/menClothing');
      this.snackBar.open(error.message, 'Dismiss', { duration: 3000, panelClass: 'snackbar-btn' });
    })
  }
  public handleError(err: any) {
    let errorCode = '0000';
    let errorMessageDesc = 'Unknown Error Occured, Contact Administrator';
    if (err.error instanceof ErrorEvent) {
      console.error('An error occurred: ErrorEvent - Post Service');
      errorMessageDesc = err.error.message;
    } else {
      console.error('An error occurred: Backend Error - Post Service');
      errorCode = err.status.toString();
      if (err.error.message) {
        errorMessageDesc = err.error.message;
      }
      if (err.status === 401) {
        let isLogin = localStorage.getItem('token');
        if (!isLogin) {
          isLogin = sessionStorage.getItem('token');
        }
        if (isLogin) {
          this.router.navigate(['401']);
        } else {
          localStorage.removeItem('token');
          localStorage.removeItem('currentUser');
          localStorage.removeItem('p');
          localStorage.clear();
          sessionStorage.removeItem('token');
          sessionStorage.clear();
          let errmsg = err?.error?.message;
          if (!errmsg) {
            errmsg = "May be you changed password or system detected unusual activity. Please Login again, Thank You!"
          }
          this.snackBar.open(err.error, 'Dismiss', { duration: 3000, panelClass: 'snackbar-btn' });
        }
      }
    }
    const errorObject: ErrorMessageModule = {
      errorID: errorCode,
      errorMessage: errorMessageDesc,
      multipleMessage: []
    };
  }
  getText2ForKey(val:any){
    this.commonService.getText2ForKey(val);
  }
  removeFile(val:any){
    this.commonService.removeFile(val)
  }
  downloadFile(val:any, idx:any){
    this.commonService.downloadFile(val,idx);
  }
  uploadFile(event:any, name:any, subname:any){
    this.commonService.uploadFile(event, name, subname);
    this.isFileUploaded = false;
  }
}
// capImage() {
//   html2canvas(document.querySelector('#capture')).then(canvas => {
//     this.capturedImage = canvas.toDataURL();
//     localStorage.setItem('shareImgBase64', this.capturedImage);
//     // this.base64data.AddImagesResource(this.capturedImage);
//     // console.log('canvas.toDataURL() -->' + this.capturedImage);
//     canvas.toBlob(function (blob) {
//       const reader = new FileReader();
//       reader.readAsDataURL(blob);
//       reader.onloadend = function () {
//         const base64data = reader.result;
//         // console.log('Base64--> ' + base64data);
//       };
//     });
//     return this.capturedImage;


//   });
//   // this.openShareBS();
//   this.doShare();
// }
// doShare = async () => {
//   const navigator = window.navigator as any;

//   if ('canShare' in navigator) {
//     console.log('Went inside Canshare')
//     const imgBase64 = localStorage.getItem('shareImgBase64');
//     const share = async function (shareimg, shareurl, sharetitle, sharetext) {
//       try {
//         console.log('Went inside try');
//         const response = await fetch(shareimg);
//         const blob = await response.blob();
//         const file = new File([blob], imgBase64, { type: blob.type });

//         await navigator.share({
//           url: shareurl,
//           title: sharetitle,
//           text: sharetext,
//           files: [file]
//         });
//       } catch (err) {
//         console.log(err.name, err.message);
//       }
//     };

//   }
// }
export class classfied {
  subCategory!: string;
  cardClass!: Array<any>;

  constructor() {
    this.cardClass = new Array<any>();
  }
}
function uploadFile(event: Event | undefined, animate: (timings: string | number, styles?: import("@angular/animations").AnimationStyleMetadata | import("@angular/animations").AnimationKeyframesSequenceMetadata | null) => import("@angular/animations").AnimationAnimateMetadata) {
  throw new Error('Function not implemented.');
}

