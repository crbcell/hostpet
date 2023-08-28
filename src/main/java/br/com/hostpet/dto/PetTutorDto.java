package br.com.hostpet.dto;

import br.com.hostpet.entity.Endereco;
import br.com.hostpet.entity.Pet;
import br.com.hostpet.entity.PetTutor;
import br.com.hostpet.entity.Telefone;
import br.com.hostpet.enums.IdentidadeDeGenero;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PetTutorDto {
    private String primeiroNome;
    private String ultimoNome;
    private String nomeSocial;
    private IdentidadeDeGenero genero;
    private LocalDate dataAniversario;
    private Endereco endereco;
    private List<Pet> petList;
    private List<Telefone> telefoneList;

    public PetTutorDto() {
    }

    private PetTutor transformePetTutorDtoEmObjeto() {
        return new PetTutor(primeiroNome, ultimoNome, nomeSocial, genero, dataAniversario, endereco, petList, telefoneList);
    }

}
