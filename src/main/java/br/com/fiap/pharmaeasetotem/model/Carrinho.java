package br.com.fiap.pharmaeasetotem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "carrinho")
    private List<Pedido> pedidos;
    private double precoTotal;
    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;
}
