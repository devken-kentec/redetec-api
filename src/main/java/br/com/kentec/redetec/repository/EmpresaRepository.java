package br.com.kentec.redetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.redetec.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
