package br.gov.sp.fatec.projetointegrador.owner.repository;

import br.gov.sp.fatec.projetointegrador.owner.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    @Query("select count(o) from Owner o where o.name like :name and o.id <> :id")
    Long countByName(@Param("name") String name, @Param("id") Long id);
    @Query("SELECT o FROM Owner o WHERE o.name like :name")
    List<Owner> findAllByNome(@Param("name") String name);
}
