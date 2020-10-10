package com.vms.desafiobanco.core.application.transferencia.impl;

import com.vms.desafiobanco.core.application.transferencia.TransferenciaFacade;
import com.vms.desafiobanco.core.domain.transferencia.TransferenciaService;
import com.vms.desafiobanco.model.Transferencia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */
@Controller
@RestController
@RequestMapping("transferencia")
public class TransferenciaFacadeImpl implements TransferenciaFacade {

    private TransferenciaService transferenciaService;

    //transferir valor de uma conta para outra
    @Override
    @RequestMapping(method= RequestMethod.POST, path="salvar" )
    public ResponseEntity<?> transferir(Transferencia transferenciaSolicitada) {
        Transferencia transferencia = this.transferenciaService.salvar(transferenciaSolicitada);
        return new ResponseEntity<>(transferencia, HttpStatus.OK);
    }
}
