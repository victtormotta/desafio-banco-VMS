package com.vms.desafiobanco.core.application.conta.impl;

import com.vms.desafiobanco.core.application.conta.ContaFacade;
import com.vms.desafiobanco.core.domain.conta.ContaService;
import com.vms.desafiobanco.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author mota- on 10/9/2020
 * @project desafio-banco
 */
@Controller
@RestController
@RequestMapping("conta")
public class ContaFacadeImpl implements ContaFacade {

    @Autowired
    public ContaService contaService;

    //criar uma conta
    @Override
    @RequestMapping(method= RequestMethod.POST, path="salvar" )
    public ResponseEntity<?> salvar(@RequestBody Conta conta ){

//        return new ResponseEntity<>(HttpStatus.OK);
        Conta c = this.contaService.criar(conta);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //depositar em uma conta
    @Override
    @RequestMapping(method=RequestMethod.POST, path="depositar" )
    public ResponseEntity<?> depositar(@RequestBody Conta conta){

        this.contaService.depositar(conta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //sacar em uma conta
    @Override
    @RequestMapping(method=RequestMethod.POST, path="sacar" )
    public ResponseEntity<?> sacar(@RequestBody Conta conta){
        if (conta.getSaque() <= 0) {
            throw new IllegalArgumentException("valor incorreto");
        }
        this.contaService.sacar(conta);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
