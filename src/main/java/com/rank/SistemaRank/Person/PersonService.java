package com.rank.SistemaRank.Person;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {


    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //List all persons
    public List<PersonModel> listPersons(){
        return personRepository.findAll();
    }

    //List person for id
    public PersonModel listID(Long id){
        Optional<PersonModel> personForId = personRepository.findById(id);
        return personForId.orElse(null);
    }

    //Create new person
    public PersonModel createPerson(PersonModel newPerson){
        return personRepository.save(newPerson);
    }

    //Delete person
    public void  deleteIDperson(Long id){
        personRepository.deleteById(id);
    }

    //Update person
    public PersonModel updatePerson(Long id, PersonModel upPerson){
        if (personRepository.existsById(id)){
            upPerson.setId(id);
            return personRepository.save(upPerson);
        }
        return null;
    }


}
