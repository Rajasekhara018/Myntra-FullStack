
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MenComponent } from './men.component';
import { TshirtComponent } from './tshirt/tshirt.component';
import { CasualShirtsComponent } from './casual-shirts/casual-shirts.component';
import { FormalShirtsComponent } from './formal-shirts/formal-shirts.component';
import { SweatersComponent } from './sweaters/sweaters.component';
import { SweatShirtsComponent } from './sweat-shirts/sweat-shirts.component';
import { RainJacketsComponent } from './rain-jackets/rain-jackets.component';
import { JacketsComponent } from './jackets/jackets.component';
import { SuitsComponent } from './suits/suits.component';
import { BlazersCoatsComponent } from './blazers-coats/blazers-coats.component';
import { MaterialModule } from '../material/material/material.module';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { MenRoutingModule } from './men-routing.module';
import { MenLatestComponent } from './men-latest/men-latest.component';

@NgModule({
  declarations: [
    MenComponent,
    TshirtComponent,
    CasualShirtsComponent,
    FormalShirtsComponent,
    SweatShirtsComponent,
    SweatersComponent,
    JacketsComponent,
    RainJacketsComponent,
    BlazersCoatsComponent,
    SuitsComponent,
    MenLatestComponent
],
  imports: [
    CommonModule, FormsModule, ReactiveFormsModule,
    RouterModule,MaterialModule,CarouselModule,MenRoutingModule
  ]
})
export class MenModule { }
