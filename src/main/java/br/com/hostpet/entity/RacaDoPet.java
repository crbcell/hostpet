package br.com.hostpet.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RacaDoPet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "RACA")
    private Long raca;
    @Column(columnDefinition = "TEXT", name = "DESCRICAO_RACA")
    private String descricaoDaRaca;
}
