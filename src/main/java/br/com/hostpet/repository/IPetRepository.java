package br.com.hostpet.repository;

import br.com.hostpet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPetRepository extends JpaRepository<Pet, Long> {
    /*@Modifying
    @Query(
            value =
                    "insert into tb_pet (nome_pet, id_pet_tutor, id) values (:nome_pet, :id_pet_tutor, :id)",
            nativeQuery = true)
    Pet insertPet(@Param("nome_pet") String nome_pet, @Param("id_pet_tutor") Integer id_pet_tutor,
                  @Param("id") Integer id);*/
}
