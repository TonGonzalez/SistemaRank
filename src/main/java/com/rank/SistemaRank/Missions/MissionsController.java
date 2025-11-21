package com.rank.SistemaRank.Missions;

import com.rank.SistemaRank.Person.PersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createMission(@RequestBody MissionsDTO newMission){
        MissionsDTO mission = missionsService.createMission(newMission);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: "+mission.getName()+" (ID):"+mission.getId()
                        +" dificuldade: "+mission.getDifficulty());
    }

    //show all missions(READ)
    @GetMapping("/list")
    public ResponseEntity<List<MissionsDTO>> listMissions(){
        List<MissionsDTO> missions = missionsService.listMissions();
        return ResponseEntity.ok(missions);
    }

    //show mission for ID(READ)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listIDmission(@PathVariable Long id){
        MissionsDTO mission = missionsService.listID(id);
        if (mission  != null){
            return ResponseEntity.ok(mission);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário do ID: "+id+" não tem no sistema");
        }
    }
    //change data from Missions(UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMissionID(@PathVariable Long id, @RequestBody MissionsDTO updateMission){
        MissionsDTO mission = missionsService.updateMission(id, updateMission);
        if (mission !=null){
            return ResponseEntity.ok(mission);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário do ID: "+id+" não tem no sistema");
        }
    }

    //delete mission(DELETE)
    public ResponseEntity<String> deleteID(@PathVariable Long id){
        if (missionsService.listID(id) != null) {
            return ResponseEntity.ok("Missão do ID: "+id+" deletada com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão: "+id+" não foi localizada");
        }
    }

}
