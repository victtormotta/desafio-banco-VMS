import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-criar',
  templateUrl: './criar.component.html',
  styleUrls: ['./criar.component.css']
})
export class CriarComponent implements OnInit {

  message;
  contaCriada = false;
  contaInvalida = false;
  dono: string;
  cpf: string;
  numero: number;
  saldo: number;
  limite: number;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  handleCriarConta(): void {
    this.http.post<Conta>('http://localhost:8080/conta/salvar', {dono: this.dono, cpf: this.cpf,
      numero: this.numero, saldo: this.saldo, limite: this.limite}).subscribe({
      next: data => {
        this.contaInvalida = false;
        this.contaCriada = true;
        this.message = 'Conta com número ' + this.numero + ' de dono ' + this.dono + ', com cpf de ' + this.cpf + ' criada.';
      },
      error: error => {
        this.contaInvalida = true;
        this.contaCriada = false;
        this.message = 'Dados inválidos!';
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
