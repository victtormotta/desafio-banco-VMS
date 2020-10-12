import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {JsonObject} from '@angular/compiler-cli/ngcc/src/packages/entry_point';

@Component({
  selector: 'app-transferir',
  templateUrl: './transferir.component.html',
  styleUrls: ['./transferir.component.css']
})
export class TransferirComponent implements OnInit {

  errorMessage;
  transferenciaInvalida = false;
  // conta Solicitante;
  donoSolicitante: string;
  cpfSolicitante: string;
  numeroSolicitante: number = 12345;
  saldoSolicitante: number = 1000;
  limiteSolicitante: number = 2000;
  // conta Beneficiario
  donoBeneficiario: string;
  cpfBeneficiario: string;
  numeroBeneficiario: number = 12345;
  saldoBeneficiario: number = 2500;
  limiteBeneficiario: number = 2000;
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
      },
      error: error => {
        this.transferenciaInvalida = true;
        this.errorMessage = error.status;
        console.error('There was an error!', error);
      }
    });
  }
}
