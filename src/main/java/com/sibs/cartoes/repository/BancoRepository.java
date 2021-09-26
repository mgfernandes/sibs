package com.sibs.cartoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sibs.cartoes.entity.Banco;
import com.sibs.cartoes.entity.Telefone;


@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {

	 @Query("SELECT b FROM Banco b where b.codigo = :codigo") 
	 Banco findBancoByCodigo(@Param("codigo") String codigo);
}
