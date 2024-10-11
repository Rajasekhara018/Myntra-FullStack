import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.scss']
})
export class ReactiveFormComponent implements OnInit {

  authForm!:FormGroup;

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


  createReactiveForm(){
    this.authForm = new FormGroup({
      firstName: new FormControl('',Validators.compose([Validators.required])),
      lastName: new FormControl('',Validators.compose([Validators.required])),
      password: new FormControl('',Validators.compose([Validators.required]))
    });
  }
  
  // this.addVolunteerForm = new FormGroup({
  //   firstName: new FormControl("", Validators.compose([Validators.required, CustomValidator.nameValidator])),
  //   lastName: new FormControl("", Validators.compose([Validators.required, CustomValidator.nameValidator])),
  //   age: new FormControl("", Validators.compose([Validators.min(1), Validators.max(100)])),
  //   gender: new FormControl("Male"),
  //   email: new FormControl("", Validators.compose([Validators.required, CustomValidator.emailValidator])),
  //   dateofbirth: new FormControl(""),
  //   phoneNumber: new FormControl("", Validators.compose([Validators.required, CustomValidator.phoneNumberUsFormatValidator])),
  //   roles: new FormControl(""),
  //   country: new FormControl(""),
  //   state: new FormControl(""),
  //   city: new FormControl(""),
  //   availabledate: new FormControl(""),
  //   zipCode: new FormControl(""),
  //   emergencycontactName: new FormControl("", Validators.compose([Validators.required, CustomValidator.nameValidator])),
  //   relationship: new FormControl("", Validators.compose([Validators.min(1), Validators.max(100)])),
  //   emergencyphoneNumber: new FormControl("", Validators.compose([Validators.required, CustomValidator.phoneNumberUsFormatValidator])),
}
