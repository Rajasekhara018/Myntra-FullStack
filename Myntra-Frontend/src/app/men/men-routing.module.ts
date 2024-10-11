import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenComponent } from './men.component';
import { TshirtComponent } from './tshirt/tshirt.component';
import { FormalShirtsComponent } from './formal-shirts/formal-shirts.component';
import { CasualShirtsComponent } from './casual-shirts/casual-shirts.component';
import { SweatShirtsComponent } from './sweat-shirts/sweat-shirts.component';
import { SweatersComponent } from './sweaters/sweaters.component';
import { JacketsComponent } from './jackets/jackets.component';
import { BlazersCoatsComponent } from './blazers-coats/blazers-coats.component';
import { SuitsComponent } from './suits/suits.component';
import { RainJacketsComponent } from './rain-jackets/rain-jackets.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'menClothing' },
  {path:'menClothing', component:MenComponent},
  {path:'men-blazers-coats', component:BlazersCoatsComponent},
  {path:'men-casual-shirt', component:CasualShirtsComponent},
  {path:'men-formal-shirt', component:FormalShirtsComponent},
  {path:'men-jackets', component:JacketsComponent},
  {path:'men-rain-jackets', component:RainJacketsComponent},
  {path:'men-suits', component:SuitsComponent},
  {path:'men-sweat-shirt', component:SweatShirtsComponent},
  {path:'men-sweaters', component:SweatersComponent},
  {path:'men-tshirt', component:TshirtComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],

})
export class MenRoutingModule { }
