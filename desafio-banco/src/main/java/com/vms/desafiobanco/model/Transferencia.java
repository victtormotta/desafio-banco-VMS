package com.vms.desafiobanco.model;

/**
 * @author mota- on 10/8/2020
 * @project desafio-banco
 */
public class Transferencia {

    private Conta contaSolicitante;
    private Conta contaBeneficiario;
    private Double valor;

    public Transferencia(){}

    public Transferencia(Conta contaSolicitante, Conta contaBeneficiario, Double valor) {
        this.contaSolicitante = contaSolicitante;
        this.contaBeneficiario = contaBeneficiario;
        this.valor = valor;
    }

    public Conta getContaSolicitante() {
        return contaSolicitante;
    }

    public void setContaSolicitante(Conta contaSolicitante) {
        this.contaSolicitante = contaSolicitante;
    }

    public Conta getContaBeneficiario() {
        return contaBeneficiario;
    }

    public void setContaBeneficiario(Conta contaBeneficiario) {
        this.contaBeneficiario = contaBeneficiario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
