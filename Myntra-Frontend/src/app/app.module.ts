import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AuthComponent } from './auth/auth.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { CartComponent } from './cart/cart.component';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { WomenComponent } from './women/women.component';
import { KidsComponent } from './kids/kids.component';
import { MenRoutingModule } from './men/men-routing.module';
import { AnimationComponent } from './animation/animation.component';
import { ReactiveFormComponent } from './auth/reactive-form/reactive-form.component';
import { GoogleLoginProvider, SocialAuthServiceConfig, SocialLoginModule } from '@abacritt/angularx-social-login';
import { SubscriptionsComponent } from './subscriptions/subscriptions.component';
import { SavedCardsComponent } from './saved-cards/saved-cards.component';
import { SavedUpiComponent } from './saved-upi/saved-upi.component';
import { BackButtonDisableModule } from 'angular-disable-browser-back-button';
import { UsersComponent } from './users/users.component';
import { AnimationMotionComponent } from './animation-motion/animation-motion.component';
import { FileUploadComponent } from './commonLibrary/file-upload/file-upload.component';
// clientId="256484117374-4jori5u11ocu6abl8tlqo5h6915pnnme.apps.googleusercontent.com"

@NgModule({
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  declarations: [
    AppComponent,
    AuthComponent,
    HomeComponent,
    HeaderComponent,
    CartComponent,
    WomenComponent,
    KidsComponent,
    AnimationComponent,
    ReactiveFormComponent,
    SubscriptionsComponent,
    SavedCardsComponent,
    SavedUpiComponent,
    UsersComponent,
    AnimationMotionComponent,
    FileUploadComponent,
  ],
  imports: [
    BackButtonDisableModule.forRoot({
      preserveScroll: true
    }),
    SocialLoginModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CarouselModule,
    MenRoutingModule 
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '256484117374-4jori5u11ocu6abl8tlqo5h6915pnnme.apps.googleusercontent.com'
            )
          }
        ],
        onError: (err) => {
          console.error(err);
        }
      } as SocialAuthServiceConfig,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
