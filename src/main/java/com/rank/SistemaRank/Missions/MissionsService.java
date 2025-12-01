package com.rank.SistemaRank.Missions;

import com.rank.SistemaRank.Person.PersonDTO;
import com.rank.SistemaRank.Person.PersonModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionsService {



    private final MissionsRepository missionsRepository;
    private final MissionMapper missionMapper;

    public MissionsService(MissionsRepository missionsRepository, MissionMapper missionMapper) {
        this.missionsRepository = missionsRepository;
        this.missionMapper = missionMapper;
    }

    //List all Missions
    public List<MissionsDTO> listMissions(){
        List<MissionsModel> missions = missionsRepository.findAll();
        return missions.stream()
                .map(missionMapper::map)
                .collect(Collectors.toList());
    }

    public MissionsDTO listID(Long id){
        Optional<MissionsModel> missionID = missionsRepository.findById(id);
        return missionID.map(missionMapper::map).orElse(null);
    }

    public MissionsDTO createMission(MissionsDTO missionsDTO){
        MissionsModel mission = missionMapper.map(missionsDTO);
        mission = missionsRepository.save(mission);
        return missionMapper.map(mission);
    }

    public void deleteIDmission(Long id){
        missionsRepository.deleteById(id);
    }

    public MissionsDTO updateMission(Long id, MissionsDTO missionsDTO){
        Optional<MissionsModel> existingMission = missionsRepository.findById(id);
        if (existingMission.isPresent()){
            MissionsModel upMission = missionMapper.map(missionsDTO);
            upMission.setId(id);
            MissionsModel saveMission = missionsRepository.save(upMission);
            return missionMapper.map(saveMission);
        }
        return null;
    }


}
