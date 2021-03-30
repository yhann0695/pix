package br.com.estudo.pix.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudo.pix.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

//	Conta findByNumConta(String numeroConta);

//	Como não está sendo usado comentado
//	Page<Conta> findByNumContaContainsIgnoreCase(Pageable paginacao, String filtro);
    
}