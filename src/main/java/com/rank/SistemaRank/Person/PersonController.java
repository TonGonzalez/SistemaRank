package com.rank.SistemaRank.Person;

import com.rank.SistemaRank.Missions.MissionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final MissionsService missionsService;

    public PersonController(PersonService personService,
                            MissionsService missionsService) {
        this.personService = personService;
        this.missionsService = missionsService;
    }

    //Add person(CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO person){
        PersonDTO newPerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso: "+ newPerson.getName()+" (ID): "+newPerson.getId());
    }

    //show all persons(READ)
    @GetMapping("/list")
    public ResponseEntity<List<PersonDTO>>listPerson(){
        List<PersonDTO> persons = personService.listPersons();
        return ResponseEntity.ok(persons);
    }

    //show person for ID(READ)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listIDperson(@PathVariable Long id){
        PersonDTO person = personService.listID(id);
        if (person  != null){
            return ResponseEntity.ok(person);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário do ID: "+id+" não tem no sistema");
        }
    }

    //update person
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePersonID(@PathVariable Long id, @RequestBody PersonDTO updatePerson) {
        PersonDTO existingPerson = personService.listID(id);
        if (existingPerson == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário do ID: " + id + " não tem no sistema");
        } if (updatePerson.getMissions() == null) {
            updatePerson.setMissions(existingPerson.getMissions());
        }
        PersonDTO person = personService.updatePerson(id, updatePerson);
        return ResponseEntity.ok(person);
    }

    //delete person(DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteID(@PathVariable Long id){
        if (personService.listID(id) != null) {
            return ResponseEntity.ok("Usuário do ID: "+id+" deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário: "+id+" não foi localizado");
        }
    }



}
