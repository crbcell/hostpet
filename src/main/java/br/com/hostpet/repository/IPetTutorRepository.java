package br.com.hostpet.repository;

import br.com.hostpet.entity.PetTutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetTutorRepository extends JpaRepository<PetTutor, Long> {
}
