package br.com.hostpet.entity;

import br.com.hostpet.enums.TipoPet;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_raca_pet")
public class RacaDoPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column (name = "TIPO_PET")
    private TipoPet tipoPet;
    @Column(name = "RACA")
    private Long raca;
    @Column(columnDefinition = "TEXT", name = "DESCRICAO_RACA")
    private String descricaoDaRaca;
}
