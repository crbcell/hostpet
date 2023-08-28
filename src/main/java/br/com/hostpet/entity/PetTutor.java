package br.com.hostpet.entity;

import br.com.hostpet.enums.IdentidadeDeGenero;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "tb_pet_tutor")
public class PetTutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PRIMEIRO_NOME")
    private String primeiroNome;
    @Column(name = "ULTIMO_NOME")
    private String ultimoNome;
    @Column(name = "NOME_SOCIAL")
    private String nomeSocial;

    @Column(name = "GENERO")
    private IdentidadeDeGenero genero;

    @Column(name = "DATA_ANIVERSARIO")
    private LocalDate dataAniversario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @JsonManagedReference
    @OneToMany(targetEntity = Pet.class, mappedBy = "petTutor", cascade = CascadeType.ALL)
    private List<Pet> petList;

    @JsonManagedReference
    @OneToMany(targetEntity = Telefone.class, mappedBy = "petTutor", cascade = CascadeType.ALL)
    private List<Telefone> telefoneList;

   

    public PetTutor() {
    }

    public PetTutor(String primeiroNome, String ultimoNome, String nomeSocial, IdentidadeDeGenero genero, LocalDate dataAniversario, Endereco endereco, List<Pet> petList, List<Telefone> telefoneList) {
    }
}

