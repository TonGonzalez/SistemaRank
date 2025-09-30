package com.rank.SistemaRank.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissionsController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Primeira mensagem na rota";
    }

    //Add mission(CREATE)
    @PostMapping("/createMission")
    public String createMission(){
        return "Missão criada";
    }

    //show all missions(READ)
    @GetMapping("/allMissions")
    public String showMissions(){
        return "Mostrar todas missões";
    }

    //show mission for ID(READ)
    @GetMapping("/all")
    public String showIDmissions(){
        return "Mostrar missão por ID";
    }

    //change data from Missions(UPDATE)
    @PutMapping("/changeDataMission")
    public String changeDataMission(){
        return "Alterar informações da missão por ID";
    }

    //delete mission(DELETE)
    @DeleteMapping("/deleteMission")
    public String deleteIDmission(){
        return "Missão deletada pela ID";
    }




}
