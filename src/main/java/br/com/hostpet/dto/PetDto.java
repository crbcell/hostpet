package br.com.hostpet.dto;

import br.com.hostpet.entity.Pet;
import lombok.Data;

@Data
public class PetDto {
    private Long id;
    private String nomePet;
    private Long idPetTutor;


    private Pet transformePetDtoEmObjeto() {
        return new Pet(id, nomePet, idPetTutor);
    }
}
