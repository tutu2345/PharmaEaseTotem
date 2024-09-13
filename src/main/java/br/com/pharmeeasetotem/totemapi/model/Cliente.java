package br.com.pharmeeasetotem.totemapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor // Gera um construtor sem parâmetros
@AllArgsConstructor // Gera um construtor com todos os parâmetros
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    // Você pode definir outros campos e métodos, se necessário
}
