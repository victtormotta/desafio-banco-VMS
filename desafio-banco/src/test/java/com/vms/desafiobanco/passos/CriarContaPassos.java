package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.core.application.conta.ContaFacade;
import com.vms.desafiobanco.core.application.conta.impl.ContaFacadeImpl;
import com.vms.desafiobanco.core.domain.conta.ContaService;
import com.vms.desafiobanco.model.Conta;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import cucumber.api.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

/**
 * @author mota- on 10/8/2020
 * @project desafio-banco
 */
public class CriarContaPassos extends ContaFacadeImpl {

    private Conta conta;
    private Boolean isContaValida;
    private Double limiteInicial = 50.0;
    private Integer numeroConta = 12345;

    @Dado("^que seja solicitada a criação de uma nova conta com os seguintes valores$")
    public void queSejaSolicitadaACriaçãoDeUmaNovaContaComOsSeguintesValores(List<Map<String, String>> valores) throws Throwable {

        /** https://stackoverflow.com/questions/53751940/how-to-convert-the-cucumber-data-table-in-the-examples-section-to-mapkey-value
            You can access the table directly as a List of Maps. Each item in the list represents one row of the data table which is provided as a map
            where the keys are the column headings and the values are the values from the data table.
         */
        for (Map<String, String> dataRow : valores) {
            String dono = dataRow.get("Nome");
            String cpf = dataRow.get("Cpf");
            Double saldo = Double.valueOf(dataRow.get("Saldo"));
            conta = new Conta(dono, numeroConta, cpf, limiteInicial ,saldo);
        }
    }

    @Quando("^for enviada a solicitação de criação de nova conta$")
    public void forEnviadaASolicitaçãoDeCriaçãoDeNovaConta() throws Throwable {
        isContaValida = validarNovaConta(conta);
        // chamar api
        salvar(conta);
    }

    @Então("^deverá ser apresentada a seguinte mensagem de erro \"([^\"]*)\"$")
    public void deveráSerApresentadaASeguinteMensagemDeErro(String mensagem) throws Throwable {
        Assertions.assertFalse(isContaValida, mensagem);
    }

    @Então("^deverá ser retornado o número da conta criada$")
    public void deveráSerRetornadoONúmeroDaContaCriada() throws Throwable {
        Assertions.assertTrue(isContaValida, "Número da conta: " + conta.getNumero());
    }

    @E("^deverá ser apresentada a seguinte mensagem \"([^\"]*)\"$")
    public void deveráSerApresentadaASeguinteMensagem(String mensagem) throws Throwable {
        Assertions.assertTrue(isContaValida, mensagem);
    }

    public boolean validarNovaConta(Conta conta){
        if(conta.getSaldo() < limiteInicial){
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
