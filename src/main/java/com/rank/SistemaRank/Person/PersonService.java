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

    public PersonModel listID(Long id){
        Optional<PersonModel> personForId = personRepository.findById(id);
        return personForId.orElse(null);
    }

    public PersonModel createPerson(PersonModel newPerson){
        return personRepository.save(newPerson);
    }

    public void  deleteIDperson(Long id){
        personRepository.deleteById(id);
    }


}
