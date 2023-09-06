package br.com.hostpet.service;

import br.com.hostpet.dto.input.PetTutorInputDto;
import br.com.hostpet.dto.output.PetTutorOutputDto;
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


    private PetTutorInputDto transformePetTutorObjetoEmDto(PetTutor petTutor) {
        PetTutorInputDto petTutorDto = new PetTutorInputDto(petTutor);
        petTutorDto.setPrimeiroNome(petTutor.getPrimeiroNome());
        petTutorDto.setUltimoNome(petTutor.getUltimoNome());
        petTutorDto.setNomeSocial(petTutor.getNomeSocial());
        petTutorDto.setGenero(petTutor.getGenero());
        petTutorDto.setDataAniversario(petTutor.getDataAniversario());
        petTutorDto.setEndereco(petTutor.getEndereco());
        petTutorDto.setPetList(petTutor.getPetList());
        petTutorDto.setTelefoneList(petTutor.getTelefoneList());
        return petTutorDto;
    }

    public PetTutor salvar(PetTutor petTutor) {
        return iPetTutorRepository.save(petTutor);
    }


    /*public List<PetTutorInputDto> pegarTodosTutores() {
        return iPetTutorRepository
                .findAll()
                .stream()
                .map(this::transformePetTutorObjetoEmDto)
                .collect(Collectors.toList());
    }
*/
    public List<PetTutor> pegarTodos() {
        return iPetTutorRepository.findAll();
    }

    public List<PetTutor> listarPetTutors() {
        return iPetTutorRepository.findAll().stream().collect(Collectors.toList());
        // return iPetRepository.findAll().stream().collect(Collectors.toList());
        //exemplo de metodo que nao funciona sem convertPetDto
    }
}
