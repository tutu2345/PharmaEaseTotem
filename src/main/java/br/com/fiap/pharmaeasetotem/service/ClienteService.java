package br.com.fiap.pharmaeasetotem.service;

import br.com.fiap.pharmaeasetotem.DTO.ClienteDTO;
import br.com.fiap.pharmaeasetotem.model.Cliente;
import br.com.fiap.pharmaeasetotem.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    // Verificar se o cliente existe pelo ID
    public Optional<ClienteDTO> verificarSeClienteExiste(Long id) {
        return clienteRepository.findById(String.valueOf(id))
                .map(this::toDTO);  // Converte para DTO
    }

    // Criar novo cliente
    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = toEntity(clienteDTO);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return toDTO(clienteSalvo);  // Retorna o DTO após salvar
    }

    // Listar todos os clientes
    public List<ClienteDTO> listarTodosClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(this::toDTO)  // Converte cada Cliente em ClienteDTO
                .toList();
    }

    // Atualizar cliente existente
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(String.valueOf(id));

        if (clienteExistente.isPresent()) {
            Cliente clienteAtualizado = clienteExistente.get();
            clienteAtualizado.setNome(clienteDTO.getNome());
            clienteAtualizado.setEmail(clienteDTO.getEmail());
            Cliente clienteSalvo = clienteRepository.save(clienteAtualizado);
            return toDTO(clienteSalvo);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
    }

    // Deletar cliente
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(String.valueOf(id));
    }

    // Converter entidade Cliente para DTO
    private ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

    // Converter DTO para entidade Cliente
    private Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        return cliente;
    }



    public ClienteDTO obterClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("Cliente inválido: " + id));
        return toDTO(cliente);  // Converte o Cliente em ClienteDTO
    }

}
