package com.rank.SistemaRank.Person;

import org.springframework.stereotype.Service;

import java.util.List;

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


}
