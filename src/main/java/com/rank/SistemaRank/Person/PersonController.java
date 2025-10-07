package com.rank.SistemaRank.Person;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //Add person(CREATE)
    @PostMapping("/create")
    public PersonModel createPerson(@RequestBody PersonModel newPerson){
        return personService.createPerson(newPerson);
    }

    //show all persons(READ)
    @GetMapping("/list")
    public List<PersonModel> listPerson(){
        return personService.listPersons();
    }

    //show person for ID(READ)
    @GetMapping("/list/{id}")
    public PersonModel listIDperson(@PathVariable Long id){
        return personService.listID(id);
    }

    //change data from Person(UPDATE)
    @PutMapping("/alter")
    public String changeDataPerson(){
        return "Alterar informações do usuário";
    }

    //delete person(DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteIDperson(@PathVariable Long id){
        personService.deleteIDperson(id);
    }


}
