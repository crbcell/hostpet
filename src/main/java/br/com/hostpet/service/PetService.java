package br.com.hostpet.service;

import br.com.hostpet.dto.PetDto;
import br.com.hostpet.entity.Pet;
import br.com.hostpet.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {
    private final IPetRepository iPetRepository;

    @Autowired
    public PetService(IPetRepository iPetRepository) {
        this.iPetRepository = iPetRepository;
    }

    private PetDto transformePetObjetoEmDto(Pet pet) {
        PetDto petDto = new PetDto();
        petDto.setNomePet(pet.getNomePet());
        petDto.setPetTutor(pet.getPetTutor());
        return petDto;
    }

    public Pet salvar(Pet pet) {
        return iPetRepository.save(pet);
    }

    public List<PetDto> pegarTodosPets() {
        return iPetRepository
                .findAll()
                .stream()
                .map(this::transformePetObjetoEmDto)
                .collect(Collectors.toList());
    }

}
