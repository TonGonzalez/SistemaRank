package com.rank.SistemaRank.Person;
import com.rank.SistemaRank.Missions.MissionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/person/ui")
public class PersonControllerUI {
    private final PersonService personService;
    private final MissionsService missionsService;

    public PersonControllerUI(PersonService personService,
                              MissionsService missionsService) {
        this.personService = personService;
        this.missionsService = missionsService;
    }

    @GetMapping("/list")
    public String listPerson(Model model){
        List<PersonDTO> persons = personService.listPersons();
        model.addAttribute("persons", persons);
        return "listPerson";
    }

    @GetMapping("/delete/{id}")
    public String deleteID(@PathVariable Long id) {
        personService.deleteIDperson(id);
        return "redirect:/person/ui/list";
    }

    @GetMapping("/list/{id}")
    public String listIDperson(@PathVariable Long id, Model model){
        PersonDTO person = personService.listID(id);
        if (person  != null){
            model.addAttribute("person", person);
            return "detailsPerson";

        }else {
            model.addAttribute("mensagem", "Usuário não encontrado");
            return "listPerson";
        }
    }

    @GetMapping("/add")
    public String showFormAddUser(Model model) {
        model.addAttribute("person", new PersonDTO());
        return "addUser";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute PersonDTO person, RedirectAttributes redirectAttributes) {
        personService.createPerson(person);
        redirectAttributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
        return "redirect:/person/ui/list";
    }


    @GetMapping("/update/{id}")
    public String updatePerson(@PathVariable Long id, Model model) {

        PersonDTO person = personService.listID(id);
        if (person == null) {
            model.addAttribute("message", "Usuário não encontrado");
            return "listPerson";
        }

        model.addAttribute("person", person);
        model.addAttribute("missions", missionsService.listMissions());

        return "updatePerson";
    }


    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute PersonDTO person, RedirectAttributes redirectAttributes) {
        PersonDTO existingPerson = personService.listID(person.getId());

        if (existingPerson != null) {
            person.setMissions(existingPerson.getMissions());
            personService.updatePerson(person.getId(), person);
            redirectAttributes.addFlashAttribute("message", "Usuário atualizado com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Usuário não encontrado");
        }

        return "redirect:/person/ui/list";
    }




}
