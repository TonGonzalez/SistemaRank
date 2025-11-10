package com.rank.SistemaRank.Missions;


import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    public MissionsModel map(MissionsDTO missionsDTO){
        MissionsModel missionsModel = new MissionsModel();
        missionsModel.setId(missionsDTO.getId());
        missionsModel.setName(missionsDTO.getName());
        missionsModel.setDifficulty(missionsDTO.getDifficulty());
        missionsModel.setPerson(missionsDTO.getPerson());

        return missionsModel;
    }

    public MissionsDTO map(MissionsModel missionsModel){
        MissionsDTO missionsDTO = new MissionsDTO();
        missionsDTO.setId(missionsModel.getId());
        missionsDTO.setName(missionsModel.getName());
        missionsDTO.setDifficulty(missionsModel.getDifficulty());
        missionsDTO.setPerson(missionsModel.getPerson());

        return missionsDTO;
    }

}
