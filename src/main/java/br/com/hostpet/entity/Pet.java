package br.com.hostpet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @JsonIgnore
    private Long id;
    @Column(name = "NOME_PET")
    private String nomePet;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pet_tutor", referencedColumnName = "id")
    private PetTutor petTutor;

    /*public Pet(Long id, String nomePet, Long idPetTutor) {
    }*/

    //private RacaDoPet racaDoPet;
}
