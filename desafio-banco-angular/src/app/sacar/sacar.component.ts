import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-sacar',
  templateUrl: './sacar.component.html',
  styleUrls: ['./sacar.component.css']
})
export class SacarComponent implements OnInit {

  errorMessage;
  saqueInvalido = false;
  numero: number = 12345;
  saldo: number = 1000;
  saque: number = 0;
  limite: number = 500;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  handleSacar(): void {
    this.http.post<Conta>('http://localhost:8080/conta/sacar', {numero: this.numero, saldo: this.saldo, limite: this.limite,
      saque: this.saque}).subscribe({
      next: data => {
        this.saqueInvalido = false;
      },
      error: error => {
        this.saqueInvalido = true;
        this.errorMessage = error.status;
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
