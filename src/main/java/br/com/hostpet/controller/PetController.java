package br.com.hostpet.controller;

import br.com.hostpet.dto.PetInputDto;
import br.com.hostpet.dto.PetOutputDto;
import br.com.hostpet.entity.Pet;
import br.com.hostpet.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public ResponseEntity<Pet> addPet(@RequestBody PetInputDto petInputDto) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petInputDto, pet);
        petService.salvar(pet);
        return new ResponseEntity<>(pet, CREATED);
    }

    /*@PostMapping(value = "/add")
    public ResponseEntity<PetOutputDto> createBirthdayPerson(@RequestBody PetInputDto dto) {
        petService.salvar(dto.transformaParaObjeto());
        return new ResponseEntity<>(petService.salvar(dto), CREATED);
    }
*/
    /*@PostMapping(value = "/add")
    public ResponseEntity<PetInputDto> createBirthdayPerson(@Valid @RequestBody Pet pet) {
        Pet pet = petService.salvar(petInputDto.transformaParaObjeto());
        return new ResponseEntity<>(PetOutputDto.transformaEmDTO(pet), CREATED);
    }*/

    @GetMapping(value = "/pet-todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PetOutputDto> pegarPets() {
        List<Pet> pet = this.petService.listarPets();
        return PetOutputDto.listaDePets(pet);
    }

    @GetMapping(value = "/pet-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PetOutputDto> listarPetsPorId(@PathVariable("id") Long id) {
        List<Pet> pet = this.petService.listarPetsById(id);
        return PetOutputDto.listaDePets(pet);
    }

    @GetMapping(value = "/pet-tutor/{idTutor}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PetOutputDto> listaPetsPorTutor(@PathVariable("idTutor") Long idTutor) {
        List<Pet> pet = this.petService.listaPetsId(idTutor);
        return PetOutputDto.listaDePets(pet);
    }


}
