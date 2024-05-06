package br.com.kentec.redetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kentec.redetec.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
