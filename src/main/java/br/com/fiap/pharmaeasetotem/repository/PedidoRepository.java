package br.com.fiap.pharmaeasetotem.repository;

import br.com.fiap.pharmaeasetotem.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> { }