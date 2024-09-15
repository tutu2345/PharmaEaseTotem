package br.com.pharmeeasetotem.totemapi.controller;

import br.com.pharmeeasetotem.totemapi.DTO.ClienteDTO;
import br.com.pharmeeasetotem.totemapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Listar todos os clientes
    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodosClientes());
        return "listarClientes";  // Nome do template Thymeleaf para listar os clientes
    }

    // Formulário para criar novo cliente
    @GetMapping("/novo")
    public String novoClienteForm(Model model) {
        model.addAttribute("cliente", new ClienteDTO());  // Cria um objeto ClienteDTO vazio
        return "formCliente";  // Nome do template Thymeleaf para o formulário de cliente
    }

    // Salvar novo cliente (via Thymeleaf)
    @PostMapping
    public String salvarCliente(@ModelAttribute ClienteDTO clienteDTO) {
        clienteService.criarCliente(clienteDTO);  // Salva o cliente usando o DTO
        return "redirect:/clientes";  // Redireciona para a lista de clientes
    }

    // Salvar novo cliente (via JSON)
    @PostMapping("/json")
    public ResponseEntity<String> salvarClienteJson(@RequestBody ClienteDTO clienteDTO) {
        clienteService.criarCliente(clienteDTO);  // Salva o cliente usando o DTO
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente criado com sucesso");  // Retorna resposta de sucesso
    }

    // Editar cliente (carregar formulário com dados do cliente)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        ClienteDTO clienteDTO = clienteService.obterClientePorId(id);
        model.addAttribute("cliente", clienteDTO);
        return "formCliente";  // Usa o mesmo formulário para edição
    }

    // Atualizar cliente
    @PostMapping("/atualizar/{id}")
    public String atualizarCliente(@PathVariable Long id, @ModelAttribute ClienteDTO clienteDTO) {
        clienteService.atualizarCliente(id, clienteDTO);  // Atualiza o cliente no banco de dados usando o DTO
        return "redirect:/clientes";  // Redireciona para a lista de clientes
    }

    // Deletar cliente
    @GetMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);  // Remove o cliente do banco de dados
        return "redirect:/clientes";  // Redireciona para a lista de clientes
    }
}
