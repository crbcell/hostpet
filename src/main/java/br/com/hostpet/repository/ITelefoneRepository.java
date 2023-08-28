package br.com.hostpet.repository;

import br.com.hostpet.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITelefoneRepository extends JpaRepository<Telefone, Long> {
}
