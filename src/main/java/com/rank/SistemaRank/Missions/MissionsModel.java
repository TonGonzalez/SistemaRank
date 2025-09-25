package com.rank.SistemaRank.Missions;

import com.rank.SistemaRank.Person.PersonModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_missions")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "difficulty")
    private String difficulty;

    @OneToMany(mappedBy = "missions")
    private List<PersonModel> person;

}
