package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.model.Conta;
import cucumber.api.java.pt.*;
import org.junit.jupiter.api.Assertions;

/**
 * @author mota- on 10/8/2020
 * @project desafio-banco
 */
public class ContaTestePassos {
    private Conta conta;

    @Dado("^a conta criada para o dono \"(.*?)\" de numero (\\d+) com o limite (\\d+) e saldo (\\d+)$")
    public void aContaCriadaParaODonoDeNumeroNumeroComOLimiteLimiteESaldoSaldo(String dono, int numero, Double limite, Double saldo) throws Throwable {
        // Definição de conta
        conta = new Conta(dono, numero, limite, saldo);
    }

    @Quando("^o dono realiza o deposito no valor de (\\d+) na conta$")
    public void oDonoRealizaODepositoNoValorDeDepositoNaConta(Double valorDeposito) throws Throwable {
        Assertions.assertTrue(conta.depositar(valorDeposito),
                "O dono " + conta.getDono() + " não tem limite disponível na conta para este valor de deposito");
    }

    @E("^o dono realiza o primeiro saque no valor de (\\d+) na conta$")
    public void oDonoRealizaOPrimeiroSaqueNoValorDePrimeiro_saqueNaConta(Double valorSaque) throws Throwable {
        Assertions.assertTrue(conta.sacar(valorSaque),
                "O dono " + conta.getDono() + " não tem saldo disponível na conta para este valor de saque");
    }

    @E("^o dono realiza o segundo saque no valor de (\\d+) na conta$")
    public void oDonoRealizaOSegundoSaqueNoValorDeSegundo_saqueNaConta(Double valorSaque) throws Throwable {
        Assertions.assertTrue(conta.sacar(valorSaque),
                "O dono " + conta.getDono() + " não tem saldo disponível na conta para este valor de saque");
    }

    @Entao("^o dono tem o saldo no valor de (\\d+) na conta$")
    public void oDonoTemOSaldoNoValorDeSaldo_esperadoNaConta(Double saldoEsperado) throws Throwable {
        Assertions.assertEquals(saldoEsperado, conta.getSaldo(),
                "O dono " + conta.getDono() + " está com o saldo incorreto na conta");
    }
}
