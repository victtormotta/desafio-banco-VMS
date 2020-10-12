import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-depositar',
  templateUrl: './depositar.component.html',
  styleUrls: ['./depositar.component.css']
})
export class DepositarComponent implements OnInit {

  response;
  errorMessage;
  depositoInvalido = false;
  numero: number = 12345;
  saldo: number = 0;
  deposito: number = 0;
  limite: number = 2000;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  handleDepositar(): void {
    this.http.post<Conta>('http://localhost:8080/conta/depositar', {numero: this.numero, saldo: this.saldo, limite: this.limite, deposito: this.deposito}).
    subscribe({
      next: data => {
        this.depositoInvalido = false;
      },
      error: error => {
        this.depositoInvalido = true;
        this.errorMessage = error.status;
        console.error('There was an error!', error);
      }
    });
  }
}

interface Conta {
  numero: number;
  saldo: number;
  deposito: number;
  limite: number;
}
