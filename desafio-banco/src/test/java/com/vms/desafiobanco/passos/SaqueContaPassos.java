package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.model.Conta;
import cucumber.api.PendingException;
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
public class SaqueContaPassos {

    private Conta conta;
    private Boolean isSaqueValido;
    private Double limiteInicial = 500.00;
    private Double saqueSolicitado;

    @Dado("^que possuam as seguintes contas$")
    public void quePossuamAsSeguintesContas(List<Map<String, String>> contas) throws Throwable {
        for (Map<String, String> dataRow : contas) {
            Integer numeroConta = Integer.valueOf(dataRow.get("Numero Conta"));
            Double saldo = Double.valueOf(dataRow.get("Saldo"));
            conta = new Conta(numeroConta, saldo, limiteInicial);
        }
    }

    @Dado("^que seja solicitado um saque de \"([^\"]*)\"$")
    public void queSejaSolicitadoUmSaqueDe(String saque) throws Throwable {
        saqueSolicitado = Double.valueOf(saque);
        isSaqueValido = conta.verificarSaque(saqueSolicitado);
    }

    @Quando("^for executada a operação de saque$")
    public void forExecutadaAOperaçãoDeSaque() throws Throwable {
        if(isSaqueValido){
            conta.depositar(saqueSolicitado);
        }
    }

    @Então("^deverá ser exibida a seguinte mensagem \"([^\"]*)\"$")
    public void deveráSerExibidaASeguinteMensagem(String message) throws Throwable {
        Assertions.assertTrue(isSaqueValido, message);
    }

    @E("^o saldo da conta \"([^\"]*)\" será de \"([^\"]*)\"$")
    public void oSaldoDaContaSeráDe(String numeroConta, String saldoFinal) throws Throwable {
        System.out.println("E o saldo da conta " + conta.getNumero() + " deverá ser de " + conta.getSaldo());
    }
}
