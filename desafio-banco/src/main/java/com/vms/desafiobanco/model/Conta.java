package com.vms.desafiobanco.model;

import java.io.Serializable;

/**
 * @author mota- on 10/8/2020
 * @project desafio-banco
 */
public class Conta implements Serializable {

    private String dono;
    private Integer numero;
    private String cpf;
    private Double saldo;
    private Double limite;
    private Double deposito;
    private Double saque;

    public Conta(){ }

    public Conta(String dono, Integer numero, String cpf, Double saldo, Double limite, Double deposito, Double saque) {
        this.dono = dono;
        this.numero = numero;
        this.cpf = cpf;
        this.saldo = saldo;
        this.limite = limite;
        this.deposito = deposito;
        this.saque = saque;
    }

    public Conta(String dono,  int numero, String cpf, Double limite, Double saldo) {
        this.dono = dono;
        this.numero = numero;
        this.cpf = cpf;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Conta(int numero, Double saldo, Double limite) {
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public String getSaldoToString() {
        return String.valueOf(getSaldo());
    }

    public Double getDeposito() {
        return deposito;
    }

    public void setDeposito(Double deposito) {
        this.deposito = deposito;
    }

    public Double getSaque() {
        return saque;
    }

    public void setSaque(Double saque) {
        this.saque = saque;
    }
}
