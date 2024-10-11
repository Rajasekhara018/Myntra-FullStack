import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { CartComponent } from './cart/cart.component';
import { WomenComponent } from './women/women.component';
import { KidsComponent } from './kids/kids.component';
import { RouteGuard } from './auth/route.guard';
import { SavedCardsComponent } from './saved-cards/saved-cards.component';
import { SavedUpiComponent } from './saved-upi/saved-upi.component';
import { SubscriptionsComponent } from './subscriptions/subscriptions.component';
import { UsersComponent } from './users/users.component';
import { AnimationMotionComponent } from './animation-motion/animation-motion.component';

const routes: Routes = [
  // {path:'', component:AnimationMotionComponent},
  {path:'', component:AuthComponent},
  {path:'register', component:AuthComponent},
  {path:'men', loadChildren: () => import('./men/men.module').then(m => m.MenModule), canActivate: [RouteGuard] },
  {path:'women', component:WomenComponent, canActivate: [RouteGuard]},
  {path:'kids', component:KidsComponent, canActivate: [RouteGuard]},
  {path:'cart', component:CartComponent, canActivate: [RouteGuard]},
  {path:'subscription', component:SubscriptionsComponent, canActivate: [RouteGuard]},
  {path:'savedCard', component:SavedCardsComponent, canActivate: [RouteGuard]},
  {path:'savedUpi', component:SavedUpiComponent, canActivate: [RouteGuard]},
  {path:'users', component:UsersComponent, canActivate: [RouteGuard]},
  { path: '**', redirectTo: 'register', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
