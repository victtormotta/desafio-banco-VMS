import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-criar',
  templateUrl: './criar.component.html',
  styleUrls: ['./criar.component.css']
})
export class CriarComponent implements OnInit {

  response;
  errorMessage;
  contaInvalida = false;
  dono: string = '';
  cpf: string = '';
  numero: number = 12345;
  saldo: number = 0;
  limite: number = 2000;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  handleCriarConta(): void {
    this.http.post<Conta>('http://localhost:8080/conta/salvar', {dono: this.dono, cpf: this.cpf,
      numero: this.numero, saldo: this.saldo, limite: this.limite}).subscribe({
      next: data => {
        this.contaInvalida = false;
      },
      error: error => {
        this.contaInvalida = true;
        this.errorMessage = error.status;
        console.error('There was an error!', error);
      }
    });
  }
}

interface Conta {
  dono: string;
  cpf: string;
  numero: number;
  saldo: number;
  limite: number;
}
