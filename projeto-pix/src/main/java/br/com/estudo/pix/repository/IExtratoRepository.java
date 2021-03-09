package br.com.estudo.pix.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudo.pix.model.Extrato;

@Repository
public interface IExtratoRepository extends JpaRepository<Extrato, Long> {
    
    Page<Extrato> findByContaNumConta(Pageable paginacao, String filtro);
    
}