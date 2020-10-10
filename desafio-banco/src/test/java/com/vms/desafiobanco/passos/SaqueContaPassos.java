package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.model.Conta;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

/**
 * @author mota- on 10/8/2020
 * @project desafio-banco
 */
public class SaqueContaPassos extends DadosPassos {

    @Before
    public void criarMockSaqueContaPassos(){
        setLimiteInicial(500.00);
        setDepositoValido(true);
    }

    @Dado("^que possuam as seguintes contas$")
    public void quePossuamAsSeguintesContas(List<Map<String, String>> contas) throws Throwable {
        criarConta(contas);
    }

    @Dado("^que seja solicitado um saque de \"([^\"]*)\"$")
    public void queSejaSolicitadoUmSaqueDe(String saque) throws Throwable {
        setSaqueSolicitado(Double.valueOf(saque));
        validarSaque();
    }

    @Quando("^for executada a operação de saque$")
    public void forExecutadaAOperaçãoDeSaque() throws Throwable {
        if(isSaqueValido()){
            getConta().sacar(getSaqueSolicitado());
        }
    }

    @Então("^deverá ser exibida a seguinte mensagem \"([^\"]*)\"$")
    public void deveráSerExibidaASeguinteMensagem(String message) throws Throwable {
        Assertions.assertTrue(isSaqueValido(), message);
    }

    @E("^o saldo da conta \"([^\"]*)\" será de \"([^\"]*)\"$")
    public void oSaldoDaContaSeráDe(String numeroConta, String saldoFinal) throws Throwable {
        System.out.println("E o saldo da conta " + numeroConta + " deverá ser de " + saldoFinal);
    }

    @After
    public void limparMockSaqueContaPassos(){
        setSaqueSolicitado(null);
        setLimiteInicial(null);
        setSaqueValido(null);
    }
}
