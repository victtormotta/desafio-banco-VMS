package com.vms.desafiobanco.core.repository;

import com.vms.desafiobanco.model.Conta;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */
@Transactional(readOnly = false)
public interface TransferenciaRepository {

    Conta findByIdConta(Long id);

}
