package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.core.application.conta.impl.ContaFacadeImpl;
import com.vms.desafiobanco.core.application.transferencia.TransferenciaFacade;
import com.vms.desafiobanco.core.application.transferencia.impl.TransferenciaFacadeImpl;
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

    private TransferenciaFacade transferenciaFacade;

    @Before
    public void criarMockTransferenciaBancoPassos(){
        transferenciaFacade = new TransferenciaFacadeImpl();
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
        setResponse(transferenciaFacade.transferir(getTransferenciaSolicitada()));
    }

    @Então("^deverá ser apresentada a mensagem \"([^\"]*)\"$")
    public void deveráSerApresentadaAMensagem(String message) throws Throwable {
        System.out.println(getResponse().toString());
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
        setResponse(null);
    }
}
