package com.rank.SistemaRank.Person;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    //List all persons
    public List<PersonDTO> listPersons(){
        List<PersonModel> persons = personRepository.findAll();
        return persons.stream()
                .map(personMapper::map)
                .collect(Collectors.toList());
    }

    //List person for id
    public PersonDTO listID(Long id){
        Optional<PersonModel> personForId = personRepository.findById(id);
        return personForId.map(personMapper::map).orElse(null);
    }

    //Create new person
    public PersonDTO createPerson(PersonDTO personDTO){
        PersonModel person = personMapper.map(personDTO);
        person = personRepository.save(person);
        return personMapper.map(person);
    }

    //Delete person
    public void  deleteIDperson(Long id){
        personRepository.deleteById(id);
    }

    //Update person
    public PersonDTO updatePerson(Long id, PersonDTO personDTO){
        Optional<PersonModel> existingUser = personRepository.findById(id);
        if (existingUser.isPresent()){
            PersonModel upPerson = personMapper.map(personDTO);
            upPerson.setId(id);
            PersonModel savePerson = personRepository.save(upPerson);
            return personMapper.map(savePerson);
        }
        return null;


    }


}
