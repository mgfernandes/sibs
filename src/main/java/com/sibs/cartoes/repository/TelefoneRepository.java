package com.sibs.cartoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sibs.cartoes.entity.Telefone;


@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

	 @Query("SELECT t FROM Telefone t where t.numeroTelefone = :numero") 
	 Telefone findTelefoneByNumber(@Param("numero") String numero);
	 
}
