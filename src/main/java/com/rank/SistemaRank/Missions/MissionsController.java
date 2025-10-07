package com.rank.SistemaRank.Missions;

import com.rank.SistemaRank.Person.PersonModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionsController {

    private MissionsService missionsService;

    public MissionsController(MissionsService missionsService) {
        this.missionsService = missionsService;
    }

    //Add mission(CREATE)
    @PostMapping("/create")
    public MissionsModel createMission(MissionsModel newMission){
        return missionsService.createMission(newMission);
    }

    //show all missions(READ)
    @GetMapping("/list")
    public List<MissionsModel> listMissions(){
        return missionsService.listMissions();
    }

    //show mission for ID(READ)
    @GetMapping("/list/{id}")
    public MissionsModel listIDmission(@PathVariable Long id){
        return missionsService.missionID(id);
    }

    //change data from Missions(UPDATE)
    @PutMapping("/alter")
    public String changeDataMission(){
        return "Alterar informações da missão";
    }

    //delete mission(DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteIDmission(@PathVariable Long id){
        missionsService.deleteIDmission(id);
    }




}
