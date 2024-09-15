package br.com.pharmeeasetotem.totemapi.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // Adiciona o construtor padrão
@Builder
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;

    // Construtor parametrizado
    public ClienteDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
