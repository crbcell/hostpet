package br.com.hostpet.repository;

import br.com.hostpet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepository extends JpaRepository<Pet, Long> {
}
