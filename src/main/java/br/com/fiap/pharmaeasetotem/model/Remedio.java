package br.com.fiap.pharmaeasetotem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Remedio")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private boolean controlado;
}