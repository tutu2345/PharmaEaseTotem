package br.com.fiap.pharmaeasetotem.repository;


import br.com.fiap.pharmaeasetotem.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> { }