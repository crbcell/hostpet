package br.com.hostpet.controller;

import br.com.hostpet.dto.PetDto;
import br.com.hostpet.entity.Pet;
import br.com.hostpet.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/pet")
@RestController
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Pet> addPet(@RequestBody PetDto petDto) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDto, pet);
        petService.salvar(pet);
        return new ResponseEntity<>(pet, CREATED);
    }

    @GetMapping(value = "/todos-pets")
    public List<PetDto> pegarTodosPets(){
        return petService.pegarTodosPets();
    }
}
