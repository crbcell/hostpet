package br.com.hostpet.dto.input;

import br.com.hostpet.entity.Pet;
import br.com.hostpet.entity.PetTutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetInputDto {
    private String nomePet;
    private Long idPetTutor;
    private PetTutor petTutor;

    public PetInputDto(Pet pet){
        this.nomePet = pet.getNomePet();
        this.idPetTutor = pet.getPetTutor().getId();
    }


}
