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
    public MissionsDTO createMission(@RequestBody MissionsDTO newMission){
        return missionsService.createMission(newMission);
    }

    //show all missions(READ)
    @GetMapping("/list")
    public List<MissionsDTO> listMissions(){
        return missionsService.listMissions();
    }

    //show mission for ID(READ)
    @GetMapping("/list/{id}")
    public MissionsDTO listIDmission(@PathVariable Long id){
        return missionsService.listID(id);
    }

    //change data from Missions(UPDATE)
    @PutMapping("/update/{id}")
    public MissionsDTO updateMissionID(@PathVariable Long id, @RequestBody MissionsDTO updateMission){
        return missionsService.updateMission(id,updateMission);
    }

    //delete mission(DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteIDmission(@PathVariable Long id){
        missionsService.deleteIDmission(id);
    }




}
