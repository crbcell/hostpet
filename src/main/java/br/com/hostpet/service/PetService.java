package br.com.hostpet.service;

import br.com.hostpet.dto.input.PetInputDto;
import br.com.hostpet.entity.Pet;
import br.com.hostpet.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {
    private static IPetRepository iPetRepository;
    @Autowired
    private static PetInputDto petInputDto;

    @Autowired
    public PetService(IPetRepository iPetRepository) {
        this.iPetRepository = iPetRepository;
    }

    private PetInputDto transformaParaObjeto(Pet pet) {
        //PetInputDto petDto = new PetInputDto();
        petInputDto.setNomePet(pet.getNomePet());
        petInputDto.setIdPetTutor(petInputDto.getIdPetTutor());
        //petDto.setPetTutor(pet.setPetTutor());
        return petInputDto;
    }
    /*private static List<Pet> transformaParaObjeto(List<PetOutputDto> petOutputDtos) {
        return petOutputDtos.stream()
                .map(dto -> new Pet(dto.getId(), dto.getNomePet(), dto.getIdPetTutor()))
                .collect(Collectors.toList());
    }*/


    public Pet salvar(Pet pet) {
        return iPetRepository.save(pet);
    }

    public List<PetInputDto> pegarTodosPets() {
        return iPetRepository
                .findAll()
                .stream()
                .map(this::transformaParaObjeto)
                .collect(Collectors.toList());
    }

    public List<Pet> listarPets() {
        return iPetRepository.findAll().stream().collect(Collectors.toList());
       // return iPetRepository.findAll().stream().collect(Collectors.toList());
        //exemplo de metodo que nao funciona sem convertPetDto
    }


    /*public List<Pet> listarPets() {
        return iPetRepository.findAll();
        //exemplo de metodo que nao funciona sem convertAniversarianteDto
    }*/

    /*public static List<PetOutputDto> listaPets(Pet pets){
        return iPetRepository.findAll(pets);
    }*/

    public List<Pet> listarPetsById(Long idTutor) {
        return iPetRepository.findAllById(Collections.singleton(idTutor)).stream().collect(Collectors.toList());
        //exemplo de metodo que nao funciona sem convertAniversarianteDto
    }

    public List<Pet> listaPetsId(Long idTutor) {
        return iPetRepository.findOwnPets(idTutor);
    }



}
