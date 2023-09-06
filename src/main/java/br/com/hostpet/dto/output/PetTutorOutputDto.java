package br.com.hostpet.dto.output;

import br.com.hostpet.entity.Endereco;
import br.com.hostpet.entity.Pet;
import br.com.hostpet.entity.PetTutor;
import br.com.hostpet.entity.Telefone;
import br.com.hostpet.enums.IdentidadeDeGenero;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PetTutorOutputDto {
    private String primeiroNome;
    private String ultimoNome;
    private String nomeSocial;
    private IdentidadeDeGenero genero;
    private LocalDate dataAniversario;
    private String tipoEndereco;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String numeroEndereco;
    @JsonIgnore
    private Endereco endereco;
    private List<Pet> petList;
    private List<Telefone> telefoneList;




    public PetTutorOutputDto(){}

    public PetTutorOutputDto(PetTutor petTutor) {
        this.primeiroNome = petTutor.getPrimeiroNome();
        this.ultimoNome = petTutor.getUltimoNome();
        this.nomeSocial = petTutor.getNomeSocial();
        this.genero=petTutor.getGenero();
        this.dataAniversario = petTutor.getDataAniversario();
        this.tipoEndereco = String.valueOf(petTutor.getEndereco().getTipoEndereco());
        this.logradouro = petTutor.getEndereco().getLogradouro();
        this.bairro = petTutor.getEndereco().getBairro();
        this.complemento = petTutor.getEndereco().getComplemento();
        this.numeroEndereco = String.valueOf(petTutor.getEndereco().getNumeroEndereco());
        this.petList = petTutor.getPetList();
        this.telefoneList = petTutor.getTelefoneList();
    }
    public static List<PetTutorOutputDto> listaDePetTutors(List<PetTutor> petTutors){
        return petTutors.stream().map(PetTutorOutputDto::new).collect(Collectors.toList());
    }

}
