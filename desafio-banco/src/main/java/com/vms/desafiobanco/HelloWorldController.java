package com.vms.desafiobanco;

/**
 * @author mota- on 10/7/2020
 * @project desafio-banco
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HelloWorldController {
    // api simples com retorno hello world para teste inicial
    //GET
    // URI - /hello-world
    // method - "Hello World"
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
