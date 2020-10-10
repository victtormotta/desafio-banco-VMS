package com.vms.desafiobanco.core.application.transferencia;

import com.vms.desafiobanco.model.Transferencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */
public interface TransferenciaFacade {

    public ResponseEntity<?> transferir(@RequestBody Transferencia transferenciaSolicitada);

}
