package com.vms.desafiobanco.core.domain.conta;

import com.vms.desafiobanco.model.Conta;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */

public interface ContaService {

    public Conta criar(Conta conta);

    public Boolean depositar(double quantidade, Long id);

    public Boolean sacar(double quantidade, Long id);

}
