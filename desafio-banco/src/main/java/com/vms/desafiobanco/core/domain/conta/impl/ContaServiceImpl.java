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

    static Double SALDO_INICIAL_OBRIGATORIO = 50.00;
    static Double LIMITE_CONTA = 2000.00;
    static Double LIMITE_SAQUE_POR_OPERACAO = 500.00;

    @Override
    public boolean criar(Conta conta) {
        return verificar(conta);
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
        Double limiteConta = LIMITE_CONTA;
        Double quantidade = conta.getDeposito();

        if (verificarDeposito(quantidade, saldoConta, limiteConta)){
            saldoConta += quantidade;
            return true;
        } else {
            return false;
        }
    }

    // verificar se saque é válido
    @Override
    public boolean verificarSaque(Double quantidade, Double saldo) {
        if(quantidade > LIMITE_SAQUE_POR_OPERACAO){
            // Não pode sacar
            return false;
        }
        if (saldo <= quantidade) {
            // Não pode sacar
            return false;
        } else {
            // Pode sacar
            return true;
        }
    }

    // verificar se deposito é válido
    @Override
    public boolean verificarDeposito(Double quantidade, Double saldo, Double limite){
        if (limite <= quantidade + saldo) {
            // Não pode depositar
            return false;
        } else {
            // Pode depositar
            return true;
        }
    }

    // verificar se conta é válida
    @Override
    public boolean verificar(Conta conta){
        if(conta.getSaldo() < SALDO_INICIAL_OBRIGATORIO){
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
