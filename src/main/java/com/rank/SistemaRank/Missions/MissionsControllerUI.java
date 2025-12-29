package com.rank.SistemaRank.Missions;

import com.rank.SistemaRank.Person.PersonDTO;
import com.rank.SistemaRank.Person.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missions/ui")
public class MissionsControllerUI {

    private final MissionsService missionsService;

    public MissionsControllerUI(MissionsService missionsService){
        this.missionsService = missionsService;
    }

    @GetMapping("/list")
    public String listMissions(Model model){
        List<MissionsDTO> missions = missionsService.listMissions();
        model.addAttribute("missions", missions);
        return "listMissions";
    }

    @GetMapping("/delete/{id}")
    public String deleteID(@PathVariable Long id) {
        missionsService.deleteIDmission(id);
        return "redirect:/missions/ui/list";
    }

    @GetMapping("/list/{id}")
    public String listIDmissions(@PathVariable Long id, Model model){
        MissionsDTO missions = missionsService.listID(id);
        if (missions  != null){
            model.addAttribute("missions", missions);
            return "detailsMissions";

        }else {
            model.addAttribute("mensagem", "Missão não encontrado");
            return "listMissions";
        }
    }

    @GetMapping("/add")
    public String showFormAddMission(Model model) {
        model.addAttribute("missions", new MissionsDTO());
        return "addMissions";
    }

    @PostMapping("/save")
    public String saveMission(@ModelAttribute MissionsDTO missions, RedirectAttributes redirectAttributes) {
        missionsService.createMission(missions);
        redirectAttributes.addFlashAttribute("mensagem", "Missão cadastrada com sucesso!");
        return "redirect:/missions/ui/list";
    }


    @GetMapping("/update/{id}")
    public String updateMissions(@PathVariable Long id, Model model) {
        MissionsDTO missions = missionsService.listID(id);
        if (missions != null) {
            model.addAttribute("missions", missions);
            return "updateMissions";
        } else {
            model.addAttribute("message", "Missão não encontrado");
            return "listMissions";
        }
    }

    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute MissionsDTO missions, RedirectAttributes redirectAttributes) {
        MissionsDTO existingMission = missionsService.listID(missions.getId());

        if (existingMission != null) {
            missions.setPerson(existingMission.getPerson());
            missionsService.updateMission(missions.getId(), missions);
            redirectAttributes.addFlashAttribute("message", "Missão atualizada com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Missão não encontrado");
        }

        return "redirect:/missions/ui/list";
    }

}
