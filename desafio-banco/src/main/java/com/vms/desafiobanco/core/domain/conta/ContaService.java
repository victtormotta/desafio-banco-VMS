package com.vms.desafiobanco.core.domain.conta;

import com.vms.desafiobanco.model.Conta;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */

public interface ContaService {

    Conta criar(Conta conta);

    boolean verificar(Conta conta);

    boolean sacar(Conta conta);

    boolean verificarDeposito(Double quantidade, Double saldo, Double limite);

    boolean depositar(Conta conta);

    boolean verificarSaque(Double quantidade, Double saldo);
}
