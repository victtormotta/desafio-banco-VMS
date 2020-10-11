package com.vms.desafiobanco.core.application.conta.impl;

import com.vms.desafiobanco.core.application.conta.ContaFacade;
import com.vms.desafiobanco.core.domain.conta.ContaService;
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
public class ContaFacadeImpl implements ContaFacade {

    public ContaService contaService = new ContaServiceImpl();

    //criar uma conta
    @Override
    @RequestMapping(method= RequestMethod.POST, path="salvar" )
    public ResponseEntity<?> salvar(@RequestBody Conta conta ){

//        return new ResponseEntity<>(HttpStatus.OK);
        Conta c = this.contaService.criar(conta);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //verificar se conta é válida
    @Override
    @RequestMapping(method= RequestMethod.POST, path="verificar" )
    public ResponseEntity<?> verificar(@RequestBody Conta conta ){

        return retornarHttpStatus(this.contaService.verificar(conta));
    }

    //depositar em uma conta
    @Override
    @RequestMapping(method=RequestMethod.POST, path="depositar" )
    public ResponseEntity<?> depositar(@RequestBody Conta conta){

        this.contaService.depositar(conta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //verificar se deposito é válida
    @Override
    @RequestMapping(method= RequestMethod.POST, path="verificar/deposito" )
    public ResponseEntity<?> verificarDeposito(@RequestBody Conta conta ){
        // passando quantidade do depósito, saldo e limite
        return retornarHttpStatus(this.contaService.verificarDeposito(conta.getDeposito(), conta.getSaldo(), conta.getLimite()));
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

    //verificar se saque é válido
    @Override
    @RequestMapping(method= RequestMethod.POST, path="verificar/saque" )
    public ResponseEntity<?> verificarSaque(@RequestBody Conta conta ){
        // passando quantidade do saque e saldo
        return retornarHttpStatus(this.contaService.verificarSaque(conta.getSaque(), conta.getSaldo()));
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
