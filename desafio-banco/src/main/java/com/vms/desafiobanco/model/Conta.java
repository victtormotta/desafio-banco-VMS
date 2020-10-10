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

    public Conta(){ }

    public Conta(String dono, int numero, String cpf, Double limite, Double saldo) {
        this.dono = dono;
        this.numero = numero;
        this.cpf = cpf;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Conta(String dono, int numero, Double limite, Double saldo) {
        this.dono = dono;
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Conta(String dono, String cpf, Double limite, Double saldo) {
        this.dono = dono;
        this.cpf = cpf;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Conta(String dono, String cpf, Double saldo) {
        this.dono = dono;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public Conta(int numero, Double saldo, Double limite) {
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
    }

    public boolean verificarSaque(Double valor) {
        if (saldo <= valor) {
            // Não pode sacar
            return false;
        } else {
            // Pode sacar
            return true;
        }
    }

    public boolean sacar(Double valor) {
        if (verificarSaque(valor)) {
            saldo = saldo - valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarDeposito(Double quantidade){
        if (limite <= quantidade + saldo) {
            // Não pode depositar
            return false;
        } else {
            // Pode depositar
            return true;
        }
    }

    public boolean depositar(Double quantidade) {
        if (verificarDeposito(quantidade)){
            saldo += quantidade;
            return true;
        } else {
            return false;
        }
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
}
