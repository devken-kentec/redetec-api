package br.com.kentec.redetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kentec.redetec.domain.Humano;

public interface HumanoRepository extends JpaRepository<Humano, Long> {

}
