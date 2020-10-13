import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {JsonObject} from '@angular/compiler-cli/ngcc/src/packages/entry_point';

@Component({
  selector: 'app-transferir',
  templateUrl: './transferir.component.html',
  styleUrls: ['./transferir.component.css']
})
export class TransferirComponent implements OnInit {

  message;
  transferenciaInvalida = false;
  transferenciaRealizada = false;
  // conta Solicitante;
  donoSolicitante: string;
  cpfSolicitante: string;
  numeroSolicitante: number;
  saldoSolicitante: number;
  limiteSolicitante: number;
  // conta Beneficiario
  donoBeneficiario: string;
  cpfBeneficiario: string;
  numeroBeneficiario: number;
  saldoBeneficiario: number;
  limiteBeneficiario: number;
  valor: number;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  handleTransferir(): void {
    this.http.post<any>('http://localhost:8080/transferencia/salvar', {
      contaSolicitante: {
        dono: this.donoSolicitante,
        numero: this.numeroSolicitante,
        cpf: this.cpfSolicitante,
        saldo: this.saldoSolicitante,
        limite: this.limiteSolicitante
      },
      contaBeneficiario: {
        dono: this.donoBeneficiario,
        numero: this.numeroBeneficiario,
        cpf: this.cpfBeneficiario,
        saldo: this.saldoBeneficiario,
        limite: this.limiteBeneficiario
      },
      valor : this.valor
    }).subscribe({
      next: data => {
        this.transferenciaInvalida = false;
        this.transferenciaRealizada = true;
        this.message = 'Conta de número ' + this.numeroSolicitante  + ' realizou transferência de R$' + this.valor +
        ' reais para conta de número ' + this.numeroBeneficiario;
      },
      error: error => {
        this.transferenciaInvalida = true;
        this.transferenciaRealizada = false;
        this.message = 'Dados inválidos!';
        console.error('There was an error!', error);
      }
    });
  }
}
