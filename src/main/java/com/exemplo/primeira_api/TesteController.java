package com.exemplo.primeira_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/teste")
    public String digaOla(){
        return "Olá, mundo!";
    }
}
