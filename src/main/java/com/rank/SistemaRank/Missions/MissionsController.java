package com.rank.SistemaRank.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missions")
public class MissionsController {

    //Add mission(CREATE)
    @PostMapping("/create")
    public String createMission(){
        return "Missão criada";
    }

    //show all missions(READ)
    @GetMapping("/list")
    public String showMissions(){
        return "Listar todas missões";
    }

    //show mission for ID(READ)
    @GetMapping("/listID")
    public String showIDmissions(){
        return "Lista a missão por ID";
    }

    //change data from Missions(UPDATE)
    @PutMapping("/alter")
    public String changeDataMission(){
        return "Alterar informações da missão por ID";
    }

    //delete mission(DELETE)
    @DeleteMapping("/delete")
    public String deleteIDmission(){
        return "Missão deletada pela ID";
    }




}
