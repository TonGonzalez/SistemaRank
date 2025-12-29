package com.rank.SistemaRank.Person;

import com.rank.SistemaRank.Missions.MissionsModel;
import com.rank.SistemaRank.Missions.MissionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final MissionsRepository missionsRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository,
                         MissionsRepository missionsRepository,
                         PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.missionsRepository = missionsRepository;
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
    @Transactional
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        Optional<PersonModel> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            return null;
        }
        PersonModel person = optionalPerson.get();
        // Atualiza campos simples
        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setEmail(personDTO.getEmail());
        person.setAge(personDTO.getAge());
        person.setRank(personDTO.getRank());
        //Atualiza missão
        if (personDTO.getMissions() != null && personDTO.getMissions().getId() != null) {
            MissionsModel mission = missionsRepository
                    .findById(personDTO.getMissions().getId())
                    .orElse(null);
            person.setMissions(mission);
        }
        PersonModel savedPerson = personRepository.save(person);
        return personMapper.map(savedPerson);
    }



}
