import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-sacar',
  templateUrl: './sacar.component.html',
  styleUrls: ['./sacar.component.css']
})
export class SacarComponent implements OnInit {

  message;
  saqueInvalido = false;
  saqueRealizado = false;
  numero: number;
  saldo: number;
  saque: number;
  limite: number;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  handleSacar(): void {
    this.http.post<Conta>('http://localhost:8080/conta/sacar', {numero: this.numero, saldo: this.saldo, limite: this.limite,
      saque: this.saque}).subscribe({
      next: data => {
        this.saqueRealizado = true;
        this.saqueInvalido = false;
        this.message = 'Saque de ' + this.saque + ' reais realizado. Saldo final de R$' + (this.saldo - this.saque);
      },
      error: error => {
        this.saqueInvalido = true;
        this.saqueRealizado = false;
        this.message = 'Dados inválidos!';
        console.error('There was an error!', error);
      }
    });
  }

}

interface Conta {
  numero: number;
  saldo: number;
  saque: number;
  limite: number;
}
