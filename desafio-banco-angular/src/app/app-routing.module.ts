import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CriarComponent} from './criar/criar.component';
import {DepositarComponent} from './depositar/depositar.component';
import {SacarComponent} from './sacar/sacar.component';
import {TransferirComponent} from './transferir/transferir.component';

const routes: Routes = [
  { path: 'criar', component: CriarComponent },
  { path: 'depositar', component: DepositarComponent },
  { path: 'sacar', component: SacarComponent },
  { path: 'transferir', component: TransferirComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
