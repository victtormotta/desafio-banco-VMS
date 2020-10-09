package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.model.Conta;
import com.vms.desafiobanco.model.Transferencia;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mota- on 10/8/2020
 * @project desafio-banco
 */
public class TransferenciaBancoPassos {

    private List<Conta> listaContas = new ArrayList<>();;
    private Transferencia transferenciaSolicitada;
    private Boolean isTransferenciaValida;
    private Double limiteInicial = 500.00;
    private Double saqueSolicitado;

    @Before
    private void inicializarLista(){
        listaContas = null;
    }

    @Dado("^que existam as seguintes contas cadastradas$")
    public void queExistamAsSeguintesContasCadastradas(List<Map<String, String>> contas) throws Throwable {
        for (Map<String, String> dataRow : contas) {
            Integer numeroConta = Integer.valueOf(dataRow.get("Numero Conta"));
            Double saldo = Double.valueOf(dataRow.get("Saldo"));

            listaContas.add(new Conta(numeroConta, saldo, limiteInicial));
        }
    }

    @Dado("^que seja solicitada um transferência com as seguintes informações$")
    public void queSejaSolicitadaUmTransferênciaComAsSeguintesInformações(List<Map<String, String>> transferencias) throws Throwable {
        for (Map<String, String> dataRow : transferencias) {
            // atribuir numero da conta retornado pela tabela a variável
            Integer numeroContaSolicitante = Integer.valueOf(dataRow.get("Conta do Solicitante"));
            Integer numeroContaBeneficiario = Integer.valueOf(dataRow.get("Conta do Beneficiário"));

            Double valor = Double.valueOf(dataRow.get("Valor"));

            Conta contaSolicitante = retornarContaPorNumero(numeroContaSolicitante, listaContas);
            Conta contaBeneficiario = retornarContaPorNumero(numeroContaBeneficiario, listaContas);

            transferenciaSolicitada = new Transferencia(contaSolicitante, contaBeneficiario, valor);
        }
    }

    @Quando("^for executada a operação de transferência$")
    public void forExecutadaAOperaçãoDeTransferência() throws Throwable {
            isTransferenciaValida = transferenciaSolicitada.realizarTransferencia();
    }

    @Então("^deverá ser apresentada a mensagem \"([^\"]*)\"$")
    public void deveráSerApresentadaAMensagem(String message) throws Throwable {
        Assertions.assertTrue(isTransferenciaValida, message);
    }

    @E("^o saldo da conta \"([^\"]*)\" deve ser de \"([^\"]*)\"$")
    public void oSaldoDaContaDeveSerDe(String numero, String saldoFinal) throws Throwable {
        System.out.println("E o saldo da conta " + numero + " deverá ser de " + saldoFinal);
    }

    private Conta retornarContaPorNumero(Integer numeroConta, List<Conta> listaContas) throws Throwable {
        for (Conta conta : listaContas) {
            if(numeroConta.equals(conta.getNumero())){
                return conta;
            }
        }
        return null;
    }
}
