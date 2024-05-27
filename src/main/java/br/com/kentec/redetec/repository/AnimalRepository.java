package br.com.kentec.redetec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.kentec.redetec.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
	@Query("SELECT a FROM Animal a WHERE a.status = 'ATIVO' ")
	List<Animal> selectAnimalComboBox();
}
