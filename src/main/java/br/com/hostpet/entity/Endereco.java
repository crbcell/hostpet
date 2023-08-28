package br.com.hostpet.entity;

import br.com.hostpet.enums.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TIPO_ENDERECO")
    private TipoEndereco tipoEndereco;
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "NUMERO_ENDERECO")
    private int numeroEndereco;

    @OneToOne(mappedBy = "endereco")
    @JsonBackReference
    private PetTutor petTutor;
}
