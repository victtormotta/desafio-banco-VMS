package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.model.Conta;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

/**
 * @author mota- on 10/8/2020
 * @project desafio-banco
 */
public class DepositoContaPassos {

    private Conta conta;
    private Boolean isDepositoValido;
    private Double limiteInicial = 500.00;
    private Double depositoSolicitado;

    @Dado("^que existam as seguintes contas$")
    public void queExistamAsSeguintesContas(List<Map<String, String>> contas) throws Throwable{
        for (Map<String, String> dataRow : contas) {
            Integer numeroConta = Integer.valueOf(dataRow.get("Numero Conta"));
            Double saldo = Double.valueOf(dataRow.get("Saldo"));
            conta = new Conta(numeroConta, saldo, limiteInicial);
        }
    }

    @E("^que seja solicitado um depósito de \"([^\"]*)\"$")
    public void queSejaSolicitadoUmDepósitoDe(String deposito) throws Throwable {
        depositoSolicitado = Double.valueOf(deposito);
        isDepositoValido = conta.verificarDeposito(depositoSolicitado);
    }

    @Quando("^for executada a operação de depósito$")
    public void forExecutadaAOperaçãoDeDepósito() throws Throwable {
        if(isDepositoValido){
            conta.depositar(depositoSolicitado);
        }
    }

    @Entao("^deverá ser apresentada a seguinte mensagem  \"([^\"]*)\"$")
    public void deveráSerApresentadaASeguinteMensagem(String mensagem) throws Throwable {
        Assertions.assertFalse(isDepositoValido, mensagem);
    }

    @E("^o saldo da conta \"([^\"]*)\" deverá ser de \"([^\"]*)\"$")
    public void oSaldoDaContaDeveráSerDe(String numero, String saldoFinal) throws Throwable {
        System.out.println("E o saldo da conta " + conta.getNumero() + " deverá ser de " + conta.getSaldo());
    }
}
