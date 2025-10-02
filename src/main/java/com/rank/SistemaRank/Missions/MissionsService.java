package com.rank.SistemaRank.Missions;

import com.rank.SistemaRank.Person.PersonModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public MissionsModel missionID(Long id){
        Optional<MissionsModel> missionForId = missionsRepository.findById(id);
        return missionForId.orElse(null);
    }


}
