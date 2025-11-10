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
    public PersonDTO createPerson(@RequestBody PersonDTO newPerson){
        return personService.createPerson(newPerson);
    }

    //show all persons(READ)
    @GetMapping("/list")
    public List<PersonDTO> listPerson(){
        return personService.listPersons();
    }

    //show person for ID(READ)
    @GetMapping("/list/{id}")
    public PersonDTO listIDperson(@PathVariable Long id){
        return personService.listID(id);
    }

    //update person
    @PutMapping("/update/{id}")
    public PersonDTO updatePersonID(@PathVariable Long id, @RequestBody PersonDTO updatePerson){
        return personService.updatePerson(id, updatePerson);
    }

    //delete person(DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteIDperson(@PathVariable Long id){
        personService.deleteIDperson(id);
    }

}
