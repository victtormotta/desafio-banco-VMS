package com.vms.desafiobanco.passos;

import com.vms.desafiobanco.model.Conta;
import com.vms.desafiobanco.model.Transferencia;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mota- on 10/10/2020
 * @project desafio-banco
 */
// stepData
public class DadosPassos {

    /*protected Response response;
    protected ValidatableResponse json;
    protected RequestSpecification request;*/

    private Conta contaTeste;
    private Integer numeroContaInicial;
    private Double limiteInicial;
    private Double depositoSolicitado;
    private Double saqueSolicitado;
    private Boolean isContaValida;
    private Boolean isDepositoValido;
    private Boolean isSaqueValido;
    private List<Conta> listaContasTeste = new ArrayList<>();;
    private Transferencia transferenciaSolicitada;
    private Boolean isTransferenciaValida;

    //  CriarContaPassos
    public Conta criarConta(List<Map<String, String>> valores){
        for (Map<String, String> dataRow : valores) {
            // checar se parametro de numero conta foi enviado ( casos de DepositoContaPassos e  SaqueContaPassos)
            if(dataRow.containsKey("Numero Conta")){
                Integer numeroConta = Integer.valueOf(dataRow.get("Numero Conta"));
                Double saldo = Double.valueOf(dataRow.get("Saldo"));
                contaTeste = new Conta(numeroConta, saldo, limiteInicial);
            } else{
                // executa o teste de criação de nova conta ( CriarContaPassos )
                String dono = dataRow.get("Nome");
                String cpf = dataRow.get("Cpf");
                Double saldo = Double.valueOf(dataRow.get("Saldo"));
                contaTeste = new Conta(dono, numeroContaInicial, cpf, limiteInicial ,saldo);
            }
        }
        return contaTeste;
    }

    public List<Conta> criarListaContas(List<Map<String, String>> valores){
        for (Map<String, String> dataRow : valores) {
            Integer numeroConta = Integer.valueOf(dataRow.get("Numero Conta"));
            Double saldo = Double.valueOf(dataRow.get("Saldo"));

            listaContasTeste.add(new Conta(numeroConta, saldo, limiteInicial));
        }
        return listaContasTeste;
    }

    public Transferencia criarTransferencia (List<Map<String, String>> valores) throws Throwable {
        for (Map<String, String> dataRow : valores) {
            // atribuir numero da conta retornado pela tabela a variável
            Integer numeroContaSolicitante = Integer.valueOf(dataRow.get("Conta do Solicitante"));
            Integer numeroContaBeneficiario = Integer.valueOf(dataRow.get("Conta do Beneficiário"));
            Double valor = Double.valueOf(dataRow.get("Valor"));

            Conta contaSolicitante = retornarContaPorNumero(numeroContaSolicitante, listaContasTeste);
            Conta contaBeneficiario = retornarContaPorNumero(numeroContaBeneficiario, listaContasTeste);

            transferenciaSolicitada = new Transferencia(contaSolicitante, contaBeneficiario, valor);
        }
        return transferenciaSolicitada;
    }

    // verificar se conta é válido
    public void validarNovaConta(){
        setContaValida(contaTeste.verificarConta());
    }

    // verificar se deposito é válido
    public void validarDeposito(){
        setDepositoValido(contaTeste.verificarDeposito(getDepositoSolicitado()));
    }

    // verificar se saque é válido
    public void validarSaque(){
        setSaqueValido(contaTeste.verificarSaque(getSaqueSolicitado()));
    }

    // verificar se transferencia é válido
    public void validarTransferencia(){
        setTransferenciaValida(transferenciaSolicitada.realizarTransferencia());
    }

    // retornar objeto conta passando numero como parametro
    public Conta retornarContaPorNumero(Integer numeroConta, List<Conta> listaContasTeste) throws Throwable {
        for (Conta conta : listaContasTeste) {
            if(numeroConta.equals(conta.getNumero())){
                return conta;
            }
        }
        return null;
    }

    public Conta getConta() {
        return contaTeste;
    }

    public void setConta(Conta conta) {
        this.contaTeste = conta;
    }

    public Double getLimiteInicial() {
        return limiteInicial;
    }

    public void setLimiteInicial(Double limiteInicial) {
        this.limiteInicial = limiteInicial;
    }

    public Integer getNumeroConta() {
        return numeroContaInicial;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroContaInicial = numeroConta;
    }

    public Double getDepositoSolicitado() {
        return depositoSolicitado;
    }

    public void setDepositoSolicitado(Double depositoSolicitado) {
        this.depositoSolicitado = depositoSolicitado;
    }

    public Boolean isContaValida() {
        return isContaValida;
    }

    public void setContaValida(Boolean contaValida) {
        isContaValida = contaValida;
    }

    public Boolean isDepositoValido() {
        return isDepositoValido;
    }

    public void setDepositoValido(Boolean depositoValido) {
        isDepositoValido = depositoValido;
    }

    public Double getSaqueSolicitado() {
        return saqueSolicitado;
    }

    public void setSaqueSolicitado(Double saqueSolicitado) {
        this.saqueSolicitado = saqueSolicitado;
    }

    public Boolean isSaqueValido() {
        return isSaqueValido;
    }

    public void setSaqueValido(Boolean saqueValido) {
        isSaqueValido = saqueValido;
    }

    public List<Conta> getListaContasTeste() {
        return listaContasTeste;
    }

    public void setListaContasTeste(List<Conta> listaContas) {
        this.listaContasTeste = listaContas;
    }

    public Transferencia getTransferenciaSolicitada() {
        return transferenciaSolicitada;
    }

    public void setTransferenciaSolicitada(Transferencia transferenciaSolicitada) {
        this.transferenciaSolicitada = transferenciaSolicitada;
    }

    public Boolean isTransferenciaValida() {
        return isTransferenciaValida;
    }

    public void setTransferenciaValida(Boolean transferenciaValida) {
        isTransferenciaValida = transferenciaValida;
    }
}