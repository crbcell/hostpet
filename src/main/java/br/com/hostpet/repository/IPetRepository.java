package br.com.hostpet.repository;

import br.com.hostpet.dto.PetOutputDto;
import br.com.hostpet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPetRepository extends JpaRepository<Pet, Long> {

    @Query(value = "SELECT * FROM TB_PET WHERE id_pet_tutor = :idTutor", nativeQuery = true)
    List<Pet> findOwnPets(@Param("idTutor") Long id_pet_tutor);

    /*@Query(value = "SELECT * FROM TB_PET WHERE id_pet_tutor = :idTutor", nativeQuery = true)
    List<Pet> findOwnPets(@Param("idTutor") Long id_pet_tutor);*/
}
