package br.com.unicuritiba.arenaplanetaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.unicuritiba.arenaplanetaria.models.Planeta;

public interface PlanetaRepository extends 
	JpaRepository<Planeta, Long> {
	 
}
