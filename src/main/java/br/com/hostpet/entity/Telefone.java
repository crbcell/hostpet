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
@Table(name = "tb_telefone")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @JsonIgnore
    private Long Id;
    @Column(name = "NUMERO_TELEFONE")
    private String numeroTelefone;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PET_TUTOR", referencedColumnName = "id")
    private PetTutor petTutor;

    /*@Column(name = "ID_PET_TUTOR")
    private long idPetTutor;*/
}
