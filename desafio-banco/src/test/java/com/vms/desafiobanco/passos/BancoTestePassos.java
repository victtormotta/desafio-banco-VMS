package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.model.Banco;
import com.vms.desafiobanco.model.Conta;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author mota- on 10/8/2020
 * @project desafio-banco
 */
public class BancoTestePassos {

    private Banco banco;
    private int totalContas;
    private Double totalDinheiro;

//    @Dado("^que as contas sao do \"(.*?)\"$")
//    public void que_as_contas_sao_do(String nome, List<Conta> listaDeContas) throws Throwable {
//        // Definição do banco e associando as contas
//        banco = new Banco(nome, listaDeContas);
//
//    }

    @Dado("^que as contas sao do \"([^\"]*)\"$")
    public void queAsContasSaoDo(String nome, List<Conta> listaDeContas) throws Throwable {
        // Definição do banco e associando as contas
        banco = new Banco(nome, listaDeContas);
    }

//    @Dado("^o calculo do total de contas criadas$")
//    public void o_calculo_do_total_de_contas_criadas() throws Throwable {
//        totalContas = banco.getListaDeContas().size();
//    }

    @Dado("^o calculo do total de contas criadas$")
    public void oCalculoDoTotalDeContasCriadas() throws Throwable {
        totalContas = banco.getListaDeContas().size();
    }

//    @Entao("^o total de contas e (\\d+)$")
//    public void o_total_de_contas_e(int totalContasEsperado) throws Throwable {
//        Assertions.assertEquals(totalContasEsperado, totalContas,
//                "O cálculo do total de contas está incorreto");
//    }

    @Entao("^o total de contas e (\\d+)$")
    public void oTotalDeContasE(int totalContasEsperado) throws Throwable{
        Assertions.assertEquals(totalContasEsperado, totalContas,
                "O cálculo do total de contas está incorreto");
    }

//    @Dado("^o calculo do total de dinheiro$")
//    public void o_calculo_do_total_de_dinheiro() throws Throwable {
//        totalDinheiro = banco.getListaDeContas().stream().mapToDouble
//                //(c -> c.getSaldo()).sum();
//                (Conta::getSaldo).sum();
//    }

    @Dado("^o calculo do total de dinheiro$")
    public void oCalculoDoTotalDeDinheiro() throws Throwable  {
        totalDinheiro = banco.getListaDeContas().stream().mapToDouble
                (Conta::getSaldo).sum();
    }

//    @Entao("^o total de dinheiro no banco e (\\d+)$")
//    public void o_total_de_dinheiro_no_banco_e(Double totalDinheiroEsperado)
//            throws Throwable {
//
//        Assertions.assertEquals(totalDinheiroEsperado, totalDinheiro,
//                "O cálculo do total de dinheiro no banco " + banco.getNome() + " está incorreto");
//    }

    @Entao("^o total de dinheiro no banco e (\\d+)$")
    public void oTotalDeDinheiroNoBancoE(Double totalDinheiroEsperado) throws Throwable {
                Assertions.assertEquals(totalDinheiroEsperado, totalDinheiro,
                "O cálculo do total de dinheiro no banco " + banco.getNome() + " está incorreto");
    }
}
