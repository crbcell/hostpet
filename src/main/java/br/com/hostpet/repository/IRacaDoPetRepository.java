package br.com.hostpet.repository;

import br.com.hostpet.entity.RacaDoPet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRacaDoPetRepository extends JpaRepository<RacaDoPet, Long> {
}
