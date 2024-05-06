package br.com.kentec.redetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kentec.redetec.domain.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
