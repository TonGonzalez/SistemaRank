package com.rank.SistemaRank.Person;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PersonController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Primeira mensagem na rota";
    }

    //Add person(CREATE)
    @PostMapping("/createPerson")
    public String createPerson(){
        return "Usuário criado";
    }

    //show all persons(READ)
    @GetMapping("/allPersons")
    public String showPersons(){
        return "Mostrar todos usuários";
    }

    //show person for ID(READ)
    @GetMapping("/IDperson")
    public String showIDPersons(){
        return "Mostrar usuário por ID";
    }

    //change data from Person(UPDATE)
    @PutMapping("/changeDataPerson")
    public String changeDataPerson(){
        return "Alterar informações do usuário";
    }

    //delete person(DELETE)
    @DeleteMapping("/deletePerson")
    public String deleteIDperson(){
        return "Usuário deletado pelo ID";
    }


}
