package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.model.Conta;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
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
public class DepositoContaPassos extends DadosPassos {

    @Before
    public void criarMockDepositoContaPassos(){
        setLimiteInicial(500.00);
        setDepositoValido(true);
    }

    @Dado("^que existam as seguintes contas$")
    public void queExistamAsSeguintesContas(List<Map<String, String>> valores) throws Throwable {
        criarConta(valores);
    }

    @E("^que seja solicitado um depósito de \"([^\"]*)\"$")
    public void queSejaSolicitadoUmDepósitoDe(String deposito) throws Throwable {
        setDepositoSolicitado(Double.valueOf(deposito));
        validarDeposito();
    }

    @Quando("^for executada a operação de depósito$")
    public void forExecutadaAOperaçãoDeDepósito() throws Throwable {
        if(isDepositoValido()){
            getConta().depositar(getDepositoSolicitado());
        }
    }

    @Entao("^deverá ser mostrada a seguinte mensagem \"([^\"]*)\"$")
    public void deveráSerMostradaASeguinteMensagem(String mensagem) throws Throwable {
        Assertions.assertFalse(isDepositoValido(), mensagem);
    }

    @E("^o saldo da conta \"([^\"]*)\" deverá ser de \"([^\"]*)\"$")
    public void oSaldoDaContaDeveráSerDe(String numero, String saldoFinal) throws Throwable {
        System.out.println("E o saldo da conta " + numero + " deverá ser de " + saldoFinal);
    }

    @After
    public void limparMockDepositoContaPassos(){
        setDepositoSolicitado(null);
        setLimiteInicial(null);
        setDepositoValido(null);
    }
}
