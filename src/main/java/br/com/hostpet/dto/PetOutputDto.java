package br.com.hostpet.dto;

import br.com.hostpet.entity.Pet;
import br.com.hostpet.entity.PetTutor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class PetOutputDto {
   // private Long id;
    private String nomePet;
    private PetTutor idPetTutor;



    public PetOutputDto(String nomePet, PetTutor petTutor) {
    }


    public static PetOutputDto transformaEmDTO(Pet pet) {
        return new PetOutputDto(pet.getNomePet(), pet.getPetTutor());
    }
}
