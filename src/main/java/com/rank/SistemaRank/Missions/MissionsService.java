package com.rank.SistemaRank.Missions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionsService {



    private MissionsRepository missionsRepository;

    public MissionsService(MissionsRepository missionsRepository) {
        this.missionsRepository = missionsRepository;
    }

    //List all persons
    public List<MissionsModel> listMissions(){
        return missionsRepository.findAll();
    }

}
