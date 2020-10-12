import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-criar',
  templateUrl: './criar.component.html',
  styleUrls: ['./criar.component.css']
})
export class CriarComponent implements OnInit {

  errorMessage = 'Dados inválidos!';
  contaInvalida = false;
  dono;
  cpf;
  numero;
  saldo;
  limite = 2000;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  handleCriarConta(): void {
    this.http.post<Conta>('http://localhost:8080/conta/salvar', {dono: this.dono, cpf: this.cpf,
      numero: this.numero, saldo: this.saldo, limite: this.limite}).subscribe(data => {
      this.dono = data.dono;
      this.cpf = data.cpf;
      this.numero = data.numero;
      this.saldo = data.saldo;
      this.limite = data.limite;
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
