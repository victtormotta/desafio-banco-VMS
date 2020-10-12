import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CriarComponent } from './criar/criar.component';
import { DepositarComponent } from './depositar/depositar.component';
import { SacarComponent } from './sacar/sacar.component';
import { TransferirComponent } from './transferir/transferir.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CriarComponent,
    DepositarComponent,
    SacarComponent,
    TransferirComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
