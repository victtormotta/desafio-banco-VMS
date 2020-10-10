package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.core.application.conta.ContaFacade;
import com.vms.desafiobanco.core.application.conta.impl.ContaFacadeImpl;
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
public class CriarContaPassos extends DadosPassos {

    private ContaFacade contaFacade;

    @Before
    public void criarMockCriarContaPassos(){
        contaFacade = new ContaFacadeImpl();
        setLimiteInicial(50.0);
        setNumeroConta(12345);
        setContaValida(true);
    }

    @Dado("^que seja solicitada a criação de uma nova conta com os seguintes valores$")
    public void queSejaSolicitadaACriaçãoDeUmaNovaContaComOsSeguintesValores(List<Map<String, String>> valores) throws Throwable {
        criarConta(valores);
    }

    @Quando("^for enviada a solicitação de criação de nova conta$")
    public void forEnviadaASolicitaçãoDeCriaçãoDeNovaConta() throws Throwable {
        validarNovaConta();
        // chamar api e atribuir a variavel
        setResponse(contaFacade.salvar(getConta()));
    }

    @Então("^deverá ser apresentada a seguinte mensagem de erro \"([^\"]*)\"$")
    public void deveráSerApresentadaASeguinteMensagemDeErro(String mensagem) throws Throwable {
        System.out.println(getResponse().toString());
        Assertions.assertFalse(isContaValida(), mensagem);
    }

    @Então("^deverá ser retornado o número da conta criada$")
    public void deveráSerRetornadoONúmeroDaContaCriada() throws Throwable {
        System.out.println(getResponse().toString());
        Assertions.assertTrue(isContaValida(), "Número da conta: " + getConta().getNumero());
    }

    @E("^deverá ser apresentada a seguinte mensagem \"([^\"]*)\"$")
    public void deveráSerApresentadaASeguinteMensagem(String mensagem) throws Throwable {
        System.out.println(getResponse().toString());
        Assertions.assertTrue(isContaValida(), mensagem);
    }

    @After
    public void limparMockCriarContaPassos(){
        setLimiteInicial(null);
        setNumeroConta(null);
        setContaValida(null);
        setResponse(null);
    }
}
