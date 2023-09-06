package br.com.hostpet.dto.input;

import br.com.hostpet.entity.Endereco;
import br.com.hostpet.entity.Pet;
import br.com.hostpet.entity.PetTutor;
import br.com.hostpet.entity.Telefone;
import br.com.hostpet.enums.IdentidadeDeGenero;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PetTutorInputDto {
    private String primeiroNome;
    private String ultimoNome;
    private String nomeSocial;
    private IdentidadeDeGenero genero;
    private LocalDate dataAniversario;
    private Endereco endereco;
    private List<Pet> petList;
    private List<Telefone> telefoneList;

    public PetTutorInputDto(){}

    public PetTutorInputDto(PetTutor petTutor) {
        this.primeiroNome = petTutor.getPrimeiroNome();
        this.ultimoNome = petTutor.getUltimoNome();
        this.nomeSocial = petTutor.getNomeSocial();
        this.genero=petTutor.getGenero();
        this.dataAniversario = petTutor.getDataAniversario();
        this.endereco = petTutor.getEndereco();
        this.petList = petTutor.getPetList();
        this.telefoneList = petTutor.getTelefoneList();

    }

}
