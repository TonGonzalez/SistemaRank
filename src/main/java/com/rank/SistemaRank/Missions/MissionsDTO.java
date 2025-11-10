package com.rank.SistemaRank.Missions;

import com.rank.SistemaRank.Person.PersonModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MissionsDTO {

    private Long id;
    private String name;
    private String difficulty;
    private List<PersonModel> person;

}
