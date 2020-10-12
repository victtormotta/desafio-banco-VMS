package com.vms.desafiobanco.core.application.transferencia.impl;

import com.vms.desafiobanco.core.application.conta.ContaFacade;
import com.vms.desafiobanco.core.application.transferencia.TransferenciaFacade;
import com.vms.desafiobanco.core.domain.conta.ContaService;
import com.vms.desafiobanco.core.domain.transferencia.TransferenciaService;
import com.vms.desafiobanco.core.domain.transferencia.impl.TransferenciaServiceImpl;
import com.vms.desafiobanco.model.Transferencia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("transferencia")
public class TransferenciaFacadeImpl implements TransferenciaFacade {

    private TransferenciaService transferenciaService = new TransferenciaServiceImpl();

    //transferir valor de uma conta para outra
    @Override
    @RequestMapping(method= RequestMethod.POST, path="salvar" )
    public ResponseEntity<?> transferir(Transferencia transferenciaSolicitada) {

        return retornarHttpStatus(this.transferenciaService.transferir(transferenciaSolicitada));
    }

    // método para retornar status http a partir das requesições
    public ResponseEntity<?> retornarHttpStatus(boolean isRequisicaoValida){
        if(isRequisicaoValida){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
