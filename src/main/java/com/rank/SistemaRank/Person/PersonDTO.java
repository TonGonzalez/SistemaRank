package com.rank.SistemaRank.Person;

import com.rank.SistemaRank.Missions.MissionsModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonDTO {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private int age;
    private String rank;
    private MissionsModel missions;

}
