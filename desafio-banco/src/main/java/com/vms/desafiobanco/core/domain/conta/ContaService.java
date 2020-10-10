package com.vms.desafiobanco.core.domain.conta;

import com.vms.desafiobanco.model.Conta;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */

public interface ContaService {

    Conta criar(Conta conta);

    boolean sacar(Conta conta);

    boolean depositar(Conta conta);
}
