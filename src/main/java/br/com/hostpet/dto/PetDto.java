package br.com.hostpet.dto;

import br.com.hostpet.entity.Pet;
import br.com.hostpet.entity.PetTutor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PetDto {
    private String nomePet;
    private PetTutor petTutor;


    public PetDto() {

    }

    public Pet transformaEntityEmDto() {
        return new Pet(nomePet, petTutor);
    }
}
