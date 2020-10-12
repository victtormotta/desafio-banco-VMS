import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CriarComponent} from './criar/criar.component';

const routes: Routes = [
  { path: 'criar', component: CriarComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
