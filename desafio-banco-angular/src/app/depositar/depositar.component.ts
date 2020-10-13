import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-depositar',
  templateUrl: './depositar.component.html',
  styleUrls: ['./depositar.component.css']
})
export class DepositarComponent implements OnInit {

  message;
  depositoRealizado = false;
  depositoInvalido = false;
  numero: number;
  saldo: number;
  deposito: number;
  limite: number;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  handleDepositar(): void {
    this.http.post<Conta>('http://localhost:8080/conta/depositar', {numero: this.numero, saldo: this.saldo, limite: this.limite, deposito: this.deposito}).
    subscribe({
      next: data => {
        this.depositoInvalido = false;
        this.depositoRealizado = true;
        this.message = 'Depósito de ' + this.deposito + ' reais realizado com sucesso! Saldo final de R$' + (this.saldo + this.deposito) + ' reais.';
      },
      error: error => {
        this.depositoInvalido = true;
        this.depositoRealizado = false;
        this.message = 'Dados inválidos!';
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
