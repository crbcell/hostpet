package br.com.hostpet.dto;

import br.com.hostpet.entity.Pet;
import br.com.hostpet.entity.PetTutor;
import lombok.Data;

@Data
public class PetDto {
    private Long id;
    private String nomePet;
    private PetTutor petTutor;

    private Pet transformePetDtoEmObjeto() {
        return new Pet(id, nomePet, petTutor);
    }
}
