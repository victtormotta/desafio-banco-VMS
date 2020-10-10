package com.vms.desafiobanco.passos;

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
public class TransferenciaBancoPassos extends DadosPassos {

    @Before
    public void criarMockTransferenciaBancoPassos(){
        setLimiteInicial(500.00);
//        setTransferenciaValida(true);
    }

    @Dado("^que existam as seguintes contas cadastradas$")
    public void queExistamAsSeguintesContasCadastradas(List<Map<String, String>> valores) throws Throwable {
        criarListaContas(valores);
    }

    @Dado("^que seja solicitada um transferência com as seguintes informações$")
    public void queSejaSolicitadaUmTransferênciaComAsSeguintesInformações(List<Map<String, String>> valores) throws Throwable {
        criarTransferencia(valores);
    }

    @Quando("^for executada a operação de transferência$")
    public void forExecutadaAOperaçãoDeTransferência() throws Throwable {
        validarTransferencia();
    }

    @Então("^deverá ser apresentada a mensagem \"([^\"]*)\"$")
    public void deveráSerApresentadaAMensagem(String message) throws Throwable {
        Assertions.assertTrue(isTransferenciaValida(), message);
    }

    @E("^o saldo da conta \"([^\"]*)\" deve ser de \"([^\"]*)\"$")
    public void oSaldoDaContaDeveSerDe(String numero, String saldoFinal) throws Throwable {
        System.out.println("E o saldo da conta " + numero + " deverá ser de " + saldoFinal);
    }

    @After
    public void limparMockTransferenciaBancoPassos(){
        setTransferenciaSolicitada(null);
        setTransferenciaValida(null);
        setLimiteInicial(null);
        setListaContasTeste(null);
    }
}
