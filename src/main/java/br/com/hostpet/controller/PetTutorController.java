package br.com.hostpet.controller;

import br.com.hostpet.dto.PetTutorDto;
import br.com.hostpet.entity.PetTutor;
import br.com.hostpet.service.PetTutorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/pet-tutor")
@RestController
public class PetTutorController {

    private final PetTutorService petTutorService;

    @Autowired
    public PetTutorController(PetTutorService petTutorService) {
        this.petTutorService = petTutorService;
    }

    //@Operation(summary = "Cadastrar aniversariante", description = "Endpoint para cadastrar um aniversariante")
    @PostMapping(value = "/add")
    public ResponseEntity<PetTutor> addPetTutor(@RequestBody PetTutorDto petTutorDto) {
        PetTutor petTutor = new PetTutor();
        BeanUtils.copyProperties(petTutorDto, petTutor);
        petTutorService.salvar(petTutor);
        return new ResponseEntity<>(petTutor, CREATED);
    }

    @GetMapping(value = "/todos-tutores")
    public List<PetTutorDto> listarTodosTutores(){
        return petTutorService.pegarTodosTutores();
    }

    @GetMapping(value = "/todos")
    public List<PetTutor> listaTudo(){
        return petTutorService.pegarTodos();
    }
}
