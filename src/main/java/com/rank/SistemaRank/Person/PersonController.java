package com.rank.SistemaRank.Person;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    //Add person(CREATE)
    @PostMapping("/create")
    public String createPerson(){
        return "Usuário criado";
    }

    //show all persons(READ)
    @GetMapping("/list")
    public String showPersons(){
        return "Mostrar todos usuários";
    }

    //show person for ID(READ)
    @GetMapping("/listID")
    public String showIDPersons(){
        return "Mostrar usuário por ID";
    }

    //change data from Person(UPDATE)
    @PutMapping("/alter")
    public String changeDataPerson(){
        return "Alterar informações do usuário";
    }

    //delete person(DELETE)
    @DeleteMapping("/delete")
    public String deleteIDperson(){
        return "Usuário deletado pelo ID";
    }


}
