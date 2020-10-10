package com.vms.desafiobanco.core.controller;

import com.vms.desafiobanco.core.domain.conta.impl.ContaServiceImpl;
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
public class ContaController {
//    @Autowired
//    private ContaServiceImpl contaServiceImpl;
//
//    //salva uma conta
//    @RequestMapping(method= RequestMethod.POST, path="salvar" )
//    public ResponseEntity<?> salvar(@RequestBody Conta conta ){
//
//
//        Conta c = this.contaServiceImpl.criar(conta);
//        return new ResponseEntity<>(c, HttpStatus.OK);
//    }
//    //realiza um deposito em uma determinada conta
//    @RequestMapping(method=RequestMethod.PUT, path="depositar/{quantidade}/{id}" )
//    public ResponseEntity<?> depositar(@PathVariable double quantidade, @PathVariable Long id){
//
//        this.contaServiceImpl.deposita(quantidade, id);
//        return new ResponseEntity<>( HttpStatus.OK);
//    }
//    //realiza um saque em uma conta
//    @RequestMapping(method=RequestMethod.PUT, path="sacar/{quantidade}/{id}" )
//    public ResponseEntity<?> sacar(@PathVariable double quantidade, @PathVariable Long id){
//        if (quantidade <= 0) {
//            throw new ExceptionCustom("valor incorreto");
//        }
//        this.contaServiceImpl.sacar(quantidade, id);
//        return new ResponseEntity<>( HttpStatus.OK);
//    }
}
