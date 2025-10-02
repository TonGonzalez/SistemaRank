package com.rank.SistemaRank.Missions;

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
    public String createMission(){
        return "Missão criada";
    }

    //show all missions(READ)
    @GetMapping("/list")
    public List<MissionsModel> listMissions(){
        return missionsService.listMissions();
    }

    //show mission for ID(READ)
    @GetMapping("/listID")
    public String showIDmissions(){
        return "Lista a missão por ID";
    }

    //change data from Missions(UPDATE)
    @PutMapping("/alter")
    public String changeDataMission(){
        return "Alterar informações da missão";
    }

    //delete mission(DELETE)
    @DeleteMapping("/delete")
    public String deleteIDmission(){
        return "Missão deletada pela ID";
    }




}
