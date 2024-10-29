package br.com.fiap.pharmaeasetotem.repository;

import br.com.fiap.pharmaeasetotem.model.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemedioRepository extends JpaRepository<Remedio, Long> { }