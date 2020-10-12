package com.vms.desafiobanco.core.controller;

/**
 * @author mota- on 10/7/2020
 * @project desafio-banco
 */

import com.vms.desafiobanco.view.managedbean.HelloWorldBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class HelloWorldController {
    // api simples com retorno hello world para teste inicial
    //GET
    // URI - /hello-world
    // method - "Hello World"
//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    // hello-world-bean
    // criando url com path variable para retornar o que for escrito na url como variavel;
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable  String name){
        return new HelloWorldBean(String.format("Hello World,  %s", name));
    }



}
