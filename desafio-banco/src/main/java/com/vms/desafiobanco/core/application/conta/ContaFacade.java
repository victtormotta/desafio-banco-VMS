package com.vms.desafiobanco.core.application.conta;

import com.vms.desafiobanco.model.Conta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */
public interface ContaFacade {

    ResponseEntity<?> salvar(@RequestBody Conta conta);

    ResponseEntity<?> depositar(@PathVariable double quantidade, @PathVariable Long id);

    ResponseEntity<?> sacar(@PathVariable double quantidade, @PathVariable Long id);
}
