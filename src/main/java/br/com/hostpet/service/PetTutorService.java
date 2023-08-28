package br.com.hostpet.service;

import br.com.hostpet.dto.PetTutorDto;
import br.com.hostpet.entity.PetTutor;
import br.com.hostpet.repository.IPetTutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetTutorService {
    private final IPetTutorRepository iPetTutorRepository;

    @Autowired
    public PetTutorService(IPetTutorRepository iPetTutorRepository) {
        this.iPetTutorRepository = iPetTutorRepository;
    }


    private PetTutorDto transformePetTutorObjetoEmDto(PetTutor petTutor) {
        PetTutorDto petTutorDto = new PetTutorDto();
        petTutorDto.setPrimeiroNome(petTutor.getPrimeiroNome());
        petTutorDto.setUltimoNome(petTutor.getUltimoNome());
        petTutorDto.setNomeSocial(petTutor.getNomeSocial());
        petTutorDto.setGenero(petTutor.getGenero());
        petTutorDto.setDataAniversario(petTutor.getDataAniversario());
        //petTutorDto.setEndereco(petTutor.getEndereco());
        /*petTutorDto.setPetList(petTutor.getPetList());
        petTutorDto.setTelefoneList(petTutor.getTelefoneList());*/
        return petTutorDto;
    }


    public PetTutor salvar(PetTutor petTutor) {
        return iPetTutorRepository.save(petTutor);
    }


    public List<PetTutorDto> pegarTodosTutores() {
        return iPetTutorRepository
                .findAll()
                .stream()
                .map(this::transformePetTutorObjetoEmDto)
                .collect(Collectors.toList());
    }

    public List<PetTutor> pegarTodos() {
        return iPetTutorRepository.findAll();
    }
}
