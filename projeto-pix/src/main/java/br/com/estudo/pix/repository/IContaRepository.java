package br.com.estudo.pix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.estudo.pix.model.Conta;

@Repository
public interface IContaRepository extends JpaRepository<Conta, Long>{

	@Query("SELECT c FROM Conta c WHERE UPPER(c.numConta) = UPPER(:numConta)")
	Optional<Conta> buscarNumeroConta(String numConta);

	Conta findByNumConta(String numConta);
    
}