// import { FormControl, FormArray, ValidatorFn, FormGroup } from '@angular/forms';
// import { AbstractControl } from '@angular/forms';
// import { MatSnackBar } from '@angular/material/snack-bar';

// export class CustomValidator {

//   static minLength(formControl: FormControl): { [key: string]: any } {
//     if (formControl.value) {
//       if (formControl.value.length > 4) {
//         return null;
//       } else {
//         return { 'minlength': true };
//       }
//     }

//   }
//   static nameValidator(formControl: FormControl): { [key: string]: any } {
//     const namePattern = /^(i?)(^[a-zA-Z])((?![ .,'-]$)[a-zA-Z ]*)$/;
//     if (formControl.value) {
//       if (namePattern.test(formControl.value.trim())) {
//         if ((formControl.value.length > 40)) {
//           return { 'invalid length': true };
//         }
//         else
//           return null;
//       } else {
//         return { 'namePattern': true };
//       }

//     }
//   }

//   static onlyNameValidator(formControl: FormControl): { [key: string]: any } {
//     const namePattern = /^[a-zA-Z]+$/
//     if (formControl.value) {
//       if (namePattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'pattern': true };
//       }
//     }
//   }


//   static emailValidator(formControl: FormControl): { [key: string]: any } {
//     //  const emailPattern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//     const emailPattern = /^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$/;
//     if (formControl.value) {
//       if (emailPattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'pattern': true };
//       }
//     }

//   }

//   /*static checkboxValidator(formControl: FormControl): { [key: string]: any } {
//     //const emailPattern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//      if (formControl.valid) {
//        return{'agreedToTermsAndCondtions':true};


//        } else {
//          return {'agreedToTermsAndCondtions': false};
//        }


//    }*/
//   static numberValidator(formControl: FormControl): { [key: string]: any } {
//     const pattern = /^[0-9]+$/;
//     if (formControl.value) {
//       if (pattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'pattern': true };
//       }
//     }

//   }
//   static URLValidator(formControl: FormControl): { [key: string]: any } {
//     const urlPattern = /^((ftp|http|https):\/\/)?(www.)?(?!.*(ftp|http|https|www.))[a-zA-Z0-9_-][a-zA-Z0-9_-]+(\.[a-zA-Z][a-zA-Z]+)+((\/)[\w#]+)*(\/\w+\?[a-zA-Z0-9_]+=\w+(&[a-zA-Z0-9_]+=\w+)*)?$/;
//     if (formControl.value) {
//       if (urlPattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'pattern': true };
//       }
//     }

//   }

//   static PANValidator(formControl: FormControl): { [key: string]: any } {
//     const panPattern = /^([a-zA-Z]{5})(\d{4})([a-zA-Z]{1})$/;
//     if (formControl.value) {
//       if (panPattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'pattern': true };
//       }
//     }

//   }

//   static passwordValidator(formControl: FormControl): { [key: string]: any } {
//     // const passwordPattern = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
//     if (formControl.value) {
//       if ((formControl.value).search(/[A-Z]/) < 0) {
//         return { 'character': true };
//       }
//       if ((formControl.value).search(/[a-z]/) < 0) {
//         return { 'lowerCharacter': true };
//       }
//       if ((formControl.value).search(/[0-9]/) < 0) {
//         return { 'number': true };
//       }
//       if ((formControl.value).search(/[!@#$%^&*]/) < 0) {
//         return { 'symbol': true };
//       }
//       if ((formControl.value.length) < 8 || (formControl.value.length > 16)) {
//         return { 'invalid length': true };
//       }

//     }

//   }
//   static MatchPassword(AC: AbstractControl, ) {
//     let password = AC.get('password').value;
//     let confirmPassword = AC.get('confirmPassword').value;
//     if (password != confirmPassword) {
//       AC.get('confirmPassword').setErrors({ MatchPassword: true })

//     } else {
//       AC.get('confirmPassword').setErrors(null);
//       return null
//     }
//   }

//   static faxValidator(formControl: FormControl): { [key: string]: any } {
//     const namePattern = /^(\+?\d{1,}(\s?|\-?)\d*(\s?|\-?)\(?\d{2,}\)?(\s?|\-?)\d{3,}\s?\d{3,})$/;
//     if (formControl.value) {
//       if (namePattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'pattern': true };
//       }
//     }
//   }

//   static MatchAccountNumber(AC: AbstractControl) {
//     if (AC.value['confirmaccountNumber'] && AC.value['accountNumber']) {
//       let accountNumber = AC.get('accountNumber').value;
//       let confirmaccountNumber = AC.get('confirmaccountNumber').value;
//       if (accountNumber != confirmaccountNumber) {
//         AC.get('confirmaccountNumber').setErrors({ MatchAccountNumber: true });

//       } else {
//         AC.get('confirmaccountNumber').setErrors(null);
//         return null
//       }

//     }
//   }


//   static multipleCheckboxRequireOne(fa: FormArray) {
//     let valid = false;
//     for (let x = 0; x < fa.length; ++x) {
//       if (fa.at(x).value) {
//         valid = true;
//         break;
//       }
//     }
//     return valid ? null : {
//       multipleCheckboxRequireOne: true
//     };
//   }
//   static onlyNumberKey(event) {
//     return (event.charCode == 8 || event.charCode == 0) ? null : event.charCode >= 48 && event.charCode <= 57;
//   }
//   static phoneNumberValidator(formControl: FormControl): { [key: string]: any } {
//     // const passwordPattern = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
//     if (formControl.value) {
//       if (formControl.value.length != 10 || !parseInt(formControl.value)) {
//         return { 'invalid length': true };
//       }

//     }

//   }
//   static phoneNumberUsFormatValidator(formControl: FormControl): { [key: string]: any } {
//     // const passwordPattern = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
//     if (formControl.value) {
//       if (formControl.value.length != 14) {
//         return { 'invalidLength': true };
//       }

//     }

//   }

//   static spaceValidator(formControl: FormControl): { [key: string]: any } {
//     const pattern = /^[^.\s]/;

//     if (formControl.value) {
//       if (pattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'space pattern': true };
//       }
//     }

//   }

//   static EmailorPhoneValidator(formControl: FormControl): { [key: string]: any } {
//     const pattern = /^(?:\d{10}|\w.+@\w+\.\w{2,3})$/;

//     if (formControl.value) {
//       if (pattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'emailorphone pattern': true };
//       }
//     }

//   }


//   static noSpaceValidator(formControl: FormControl): { [key: string]: any } {
//     const pattern = /^\S*$/;

//     if (formControl.value) {
//       if (pattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'noSpacePattern': true };
//       }
//     }

//   }
//   static adharValidator(formControl: FormControl): { [key: string]: any } {
//     const pattern = /^[0-9 -]+$/;
//     if (formControl.value) {
//       if ((formControl.value.length) != 12) {
//         return { 'invalid length': true };
//       }
//       if (pattern.test(formControl.value)) {
//         return null;
//       }
//       else {
//         return { 'pattern': true };
//       }

//     }

//   }
//   static voterIdValidator(formControl: FormControl): { [key: string]: any } {
//     const namePattern = /^[a-zA-Z]{3}\d{7}$/;
//     if (formControl.value) {
//       if (namePattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'pattern': true };
//       }
//     }
//   }
//   static drivingLicenseValidator(formControl: FormControl): { [key: string]: any } {
//     const namePattern = /^([a-zA-Z]){2}([0-9]){13,14}$/;
//     if (formControl.value) {
//       if (namePattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'pattern': true };
//       }
//     }
//   }
//   static donationAmountValidator(formControl: FormControl): { [key: string]: any } {
//     if (formControl.value) {
//       if ((formControl.value) < environment.MIN_DONATION_AMOUNT) {
//         // ||(formControl.value) > environment.MAX_DONATION_AMOUNT
//         return { 'minDonation': true };
//       }
//       // if ((formControl.value) > environment.MAX_DONATION_AMOUNT) {
//       //   return { 'maxDonation': true };
//       // }
//     }
//   }
//   static currencyValidator(formControl: FormControl): { [key: string]: any } {
//     const currencyPattern = /^([1-9]\d*)(?:\.(?!.*000)\d+)?$/;
//     if (formControl.value) {
//       if (currencyPattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'currencyPattern': true };
//       }
//     }
//   }

//   static disabledDateValidator(minDate: Date): ValidatorFn {
//     return (formControl: AbstractControl): { [key: string]: any } | null => {
//       if (formControl.value) {
//         let fomControlDateValue = Math.round(new Date(formControl.value).getTime() / 60000);
//         let minimumDate = Math.round(new Date(minDate).getTime() / 60000);
//         if (fomControlDateValue >= minimumDate) {
//           return null;
//         } else {
//           return { 'disabledDatePattern': true };
//         }
//       }
//     };
//   }


//   static AtLeastOneFieldValidator(group: FormGroup): { [key: string]: any } {
//     let isAtLeastOne = false;
//     if (group && group.controls) {
//       for (const control in group.controls) {
//         if (group.controls.hasOwnProperty(control) && group.controls[control].valid && group.controls[control].value) {
//           isAtLeastOne = true;
//           break;
//         }
//       }
//     }
//     return isAtLeastOne ? null : { 'atLeastOne': true };
//   }

//   static validateAllFormFields(formGroup) {
//     Object.keys(formGroup.controls).forEach(controlName => {
//       const control = formGroup.get(controlName);
//       if (control instanceof FormControl) {
//         control.markAsTouched({ onlySelf: true });
//       } else if (control instanceof FormGroup || control instanceof FormArray) {
//         this.validateAllFormFields(control);
//       }
//     });
//   }

//   static hoursPerWeekValidator(formControl: FormControl): { [key: string]: any } {
//     if (formControl.value) {
//       if ((formControl.value) > environment.HOUR_PER_WEEK) {
//         return { 'maxHour': true };
//       } else {
//         return null;
//       }
//     }
//   }

//   static ageValidator(formControl: FormControl): { [key: string]: any } {
//     if (formControl.value) {
//       if (((formControl.value) < environment.MIN_AGE) || ((formControl.value) > environment.MAX_AGE)) {
//         return { 'ageInvalid': true };
//       } else {
//         return null;
//       }
//     }
//   }

//   static decimalNumberValidator(formControl: FormControl): { [key: string]: any } {
//     const currencyPattern = /^(?:\d*\.\d{1,2}|\d+)$/;
//     if (formControl.value) {
//       if (currencyPattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'decimalNumberPattern': true };
//       }
//     }
//   }
//   static alphaNumeric(formControl: FormControl): { [key: string]: any } {
//     const pattern = /^[a-z0-9]+$/i;
//     if (formControl.value) {
//       if (pattern.test(formControl.value)) {
//         return null;
//       } else {
//         return { 'alphaNumberPattern': true };
//       }
//     }
//   }
//   static remindDaysValidator(formControl: FormControl): { [key: string]: any } {
//     if (formControl.value) {
//       if (((formControl.value) < 1) || ((formControl.value) > 365)) {
//         return { 'remindDaysInvalid': true };
//       } else {
//         return null;
//       }
//     }
//   }
//   static remindDaysMonthlyValidator(formControl: FormControl): { [key: string]: any } {
//     if (formControl.value) {
//       if (((formControl.value) < 1) || ((formControl.value) > 30)) {
//         return { 'remindDaysMonthlyInvalid': true };
//       } else {
//         return null;
//       }
//     }
//   }
// }


