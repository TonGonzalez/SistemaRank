package com.rank.SistemaRank.Person;


import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonModel map(PersonDTO personDTO){
      PersonModel personModel = new PersonModel();
      personModel.setId(personDTO.getId());
      personModel.setName(personDTO.getName());
      personModel.setAge(personDTO.getAge());
      personModel.setCpf(personDTO.getCpf());
      personModel.setRank(personDTO.getRank());
      personModel.setMissions(personDTO.getMissions());

      return personModel;
    }

    public PersonDTO map(PersonModel personModel){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(personModel.getId());
        personDTO.setName(personModel.getName());
        personDTO.setAge(personModel.getAge());
        personDTO.setCpf(personModel.getCpf());
        personDTO.setRank(personModel.getRank());
        personDTO.setMissions(personModel.getMissions());

        return personDTO;
    }

}
