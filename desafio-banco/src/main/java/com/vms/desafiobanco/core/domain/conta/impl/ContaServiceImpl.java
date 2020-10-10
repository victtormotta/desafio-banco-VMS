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

    @Override
    public Conta criar(Conta conta) {
        if(verificarConta(conta)){
            return conta;
        }
        return conta;
    }

    @Override
    public boolean sacar(Conta conta) {
        Double saldoConta = conta.getSaldo();
        Double quantidade = conta.getSaque();

        if (verificarSaque(quantidade, saldoConta)) {
            saldoConta = saldoConta - quantidade;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean depositar(Conta conta) {
        Double saldoConta = conta.getSaldo();
        Double limiteConta = conta.getLimite();
        Double quantidade = conta.getDeposito();

        if (verificarDeposito(quantidade, saldoConta, limiteConta)){
            saldoConta += quantidade;
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarSaque(Double quantidade, Double saldo) {
        if (saldo <= quantidade) {
            // Não pode sacar
            return false;
        } else {
            // Pode sacar
            return true;
        }
    }

    public boolean verificarDeposito(Double quantidade, Double saldo, Double limite){
        if (limite <= quantidade + saldo) {
            // Não pode depositar
            return false;
        } else {
            // Pode depositar
            return true;
        }
    }

    public boolean verificarConta(Conta conta){
        if(conta.getSaldo() < conta.getLimite()){
            return false;
        }
        if(conta.getCpf().equals("")){
            return false;
        }
        if(conta.getCpf().equals("111111111111")){
            return false;
        }
        else{
            return true;
        }
    }
}
