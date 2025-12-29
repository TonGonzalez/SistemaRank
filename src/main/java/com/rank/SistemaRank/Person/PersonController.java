package com.rank.SistemaRank.Person;

import com.rank.SistemaRank.Missions.MissionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final MissionsService missionsService;

    public PersonController(PersonService personService,
                            MissionsService missionsService) {
        this.personService = personService;
        this.missionsService = missionsService;
    }

    //Add person(CREATE)
    @PostMapping("/create")
    @Operation(summary = "Rota de Criação", description = "Essa rota permite criar novos usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Usuário criado"),
            @ApiResponse(responseCode = "400",description = "Erro de criação")
    })
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO person){
        PersonDTO newPerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso: "+ newPerson.getName()+" (ID): "+newPerson.getId());
    }

    //show all persons(READ)
    @GetMapping("/list")
    @Operation(summary = "Lista todos usuários", description = "Essa rota permite listar todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista encontrada"),
            @ApiResponse(responseCode = "400",description = "Lista não localizada")
    })
    public ResponseEntity<List<PersonDTO>>listPerson(){
        List<PersonDTO> persons = personService.listPersons();
        return ResponseEntity.ok(persons);
    }

    //show person for ID(READ)
    @GetMapping("/list/{id}")
    @Operation(summary = "Lista usuário por ID", description = "Essa rota permite listar o usuário pela ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Usuário encontrado"),
            @ApiResponse(responseCode = "400",description = "Usuário não localizado")
    })
    public ResponseEntity<?> listIDperson(@PathVariable Long id){
        PersonDTO person = personService.listID(id);
        if (person  != null){
            return ResponseEntity.ok(person);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário do ID: "+id+" não tem no sistema");
        }
    }

    //update person
    @PutMapping("/update/{id}")
    @Operation(summary = "Altera dados por ID", description = "Altera os dados de um usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Usuário atualizado"),
            @ApiResponse(responseCode = "400",description = "Erro na alteração")
    })
    public ResponseEntity<?> updatePersonID(
            @Parameter(description = "Usuário manda o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do usário a ser atualizado no corpo da requisição")
            @RequestBody PersonDTO updatePerson) {
        PersonDTO existingPerson = personService.listID(id);
        if (existingPerson == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário do ID: " + id + " não tem no sistema");
        } if (updatePerson.getMissions() == null) {
            updatePerson.setMissions(existingPerson.getMissions());
        }
        PersonDTO person = personService.updatePerson(id, updatePerson);
        return ResponseEntity.ok(person);
    }

    //delete person(DELETE)
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleta usuário por ID", description = "Deleta o usuário existente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Usuário deletado"),
            @ApiResponse(responseCode = "400",description = "Erro na exclusão")
    })
    public ResponseEntity<String> deleteID(@PathVariable Long id){
        if (personService.listID(id) != null) {
            return ResponseEntity.ok("Usuário do ID: "+id+" deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário: "+id+" não foi localizado");
        }
    }



}
