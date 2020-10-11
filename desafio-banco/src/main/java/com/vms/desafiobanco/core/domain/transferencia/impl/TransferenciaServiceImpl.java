package com.vms.desafiobanco.core.domain.transferencia.impl;

import com.vms.desafiobanco.core.application.conta.ContaFacade;
import com.vms.desafiobanco.core.domain.conta.ContaService;
import com.vms.desafiobanco.core.domain.conta.impl.ContaServiceImpl;
import com.vms.desafiobanco.core.domain.transferencia.TransferenciaService;
import com.vms.desafiobanco.model.Conta;
import com.vms.desafiobanco.model.Transferencia;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */
@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private ContaService contaService = new ContaServiceImpl();

    @Override
    public boolean transferir(Transferencia transferencia) {

        // atribuindo os valores de saque e deposito às contas correspondentes
        transferencia.getContaSolicitante().setSaque(transferencia.getValor());
        transferencia.getContaBeneficiario().setDeposito(transferencia.getValor());

        if(verificarLimiteTransferencia(transferencia.getValor())){
            // realizando a transferência
            if(contaService.sacar(transferencia.getContaSolicitante())){
                contaService.depositar(transferencia.getContaBeneficiario());
                return true;
            } else {
                return false;
            }
        } else{
            return false;
        }
    }

    public boolean verificarLimiteTransferencia(Double valor){
        return valor <= 500;
    }
}
