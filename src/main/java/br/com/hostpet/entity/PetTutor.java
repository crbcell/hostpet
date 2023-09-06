package br.com.hostpet.entity;

import br.com.hostpet.enums.IdentidadeDeGenero;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "tb_pet_tutor")
public class PetTutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
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

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_telefone")
    private Telefone telefone;*/

    @JsonManagedReference
    @OneToMany(targetEntity = Pet.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pet_tutor")
    private List<Pet> petList;

    @JsonManagedReference
    @OneToMany(targetEntity = Telefone.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pet_tutor")
    private List<Telefone> telefoneList;


    public PetTutor() {
    }

  /*  public PetTutor(
            String primeiroNome,
            String ultimoNome,
            String nomeSocial,
            IdentidadeDeGenero genero,
            LocalDate dataAniversario,
            Endereco endereco,
            List<Pet> petList,
            List<Telefone> telefoneList) {
    }*/
}

/*
orphanRemoval = true: Esta opção especifica que,
        quando a referência de uma entidade a uma entidade é
        removida da coleção, a entidade órfã também deve ser removida
        do banco de dados*/
