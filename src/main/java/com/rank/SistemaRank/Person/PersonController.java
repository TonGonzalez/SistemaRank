package com.rank.SistemaRank.Person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PersonController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Primeira mensagem na rota";
    }
}
