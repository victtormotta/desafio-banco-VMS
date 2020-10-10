package com.vms.desafiobanco.core.domain.conta.impl;

import com.vms.desafiobanco.core.domain.conta.ContaService;
import com.vms.desafiobanco.model.Conta;
import org.springframework.stereotype.Service;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */
@Service
public class ContaServiceImpl implements ContaService {

    private Double limiteInicial = 500.00;
    private Double depositoSolicitado;

    @Override
    public Conta criar(Conta conta) {
        /*if(verificarConta(conta)){
            return conta;
        }*/
        return conta;
    }

    @Override
    public Boolean depositar(double quantidade, Long id) {
        /*if (verificarDeposito(quantidade)){
            saldo += quantidade;
            return true;
        } else {
            return false;
        }*/
        return true;
    }

    @Override
    public Boolean sacar(double quantidade, Long id) {
        return true;
    }

/*    public boolean verificarConta(Conta conta){

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
//            saldo = saldo - valor;
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
    }*/
}
