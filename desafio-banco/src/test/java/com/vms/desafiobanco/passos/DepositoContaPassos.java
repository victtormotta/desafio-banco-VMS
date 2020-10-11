package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.core.application.conta.ContaFacade;
import com.vms.desafiobanco.core.application.conta.impl.ContaFacadeImpl;
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

    private ContaFacade contaFacade;

    @Before
    public void criarMockDepositoContaPassos(){
        contaFacade = new ContaFacadeImpl();
        setLimiteInicial(2000.00);
    }

    @Dado("^que existam as seguintes contas$")
    public void queExistamAsSeguintesContas(List<Map<String, String>> valores) throws Throwable {
        criarConta(valores);
    }

    @E("^que seja solicitado um depósito de \"([^\"]*)\"$")
    public void queSejaSolicitadoUmDepósitoDe(String deposito) throws Throwable {
        getConta().setDeposito(Double.valueOf(deposito));

        verificarDepositoValidoTeste(contaFacade.verificarDeposito(getConta()).getStatusCodeValue());
    }

    @Quando("^for executada a operação de depósito$")
    public void forExecutadaAOperaçãoDeDepósito() throws Throwable {
        if(isDepositoValido()){
//            getConta().depositar(getDepositoSolicitado());
            setResponse(contaFacade.depositar(getConta()));
        } /*else {
            setResponse(contaFacade.depositar(getDepositoSolicitado(), getConta()));
        }*/
    }

    @Entao("^deverá ser mostrada a seguinte mensagem \"([^\"]*)\"$")
    public void deveráSerMostradaASeguinteMensagem(String mensagem) throws Throwable {
        System.out.println(getResponse().toString());
        Assertions.assertTrue(isDepositoValido(), mensagem);
    }

    @E("^o saldo da conta \"([^\"]*)\" deverá ser de \"([^\"]*)\"$")
    public void oSaldoDaContaDeveráSerDe(String numero, String saldoFinal) throws Throwable {
        System.out.println("E o saldo da conta " + numero + " deverá ser de " + saldoFinal);
    }

    @After
    public void limparMockDepositoContaPassos(){
        setLimiteInicial(null);
        setDepositoValido(null);
        setResponse(null);
    }
}
