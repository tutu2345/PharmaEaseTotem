package br.com.fiap.pharmaeasetotem.repository;

import br.com.fiap.pharmaeasetotem.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> { }