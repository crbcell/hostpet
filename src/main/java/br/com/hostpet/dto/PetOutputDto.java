package br.com.hostpet.dto;

import br.com.hostpet.entity.Pet;
import br.com.hostpet.entity.PetTutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PetOutputDto {
    private Long id;
    private String nomePet;
    private Long idPetTutor;



    public PetOutputDto (Pet pet) {
        this.id = pet.getId();
        this.nomePet = pet.getNomePet();
        this.idPetTutor = pet.getPetTutor().getId();
        //return new PetOutputDto(nomePet, petTutor);
    }

    /*public PetOutputDto(String nomePet, PetTutor petTutor) {
    }*/

   /* public static PetOutputDto transformaEmDTO(Pet pet) {
        return new PetOutputDto(pet.getNomePet(), pet.getPetTutor());
    }*/

    public static List<PetOutputDto> listaDePets(List<Pet> pets){
        return pets.stream().map(PetOutputDto::new).collect(Collectors.toList());
    }


}


