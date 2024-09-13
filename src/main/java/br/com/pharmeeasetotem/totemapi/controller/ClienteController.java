package br.com.pharmeeasetotem.totemapi.controller;

import br.com.pharmeeasetotem.totemapi.model.Cliente;
import br.com.pharmeeasetotem.totemapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos os clientes
    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "listarClientes";  // Nome do template Thymeleaf para listar os clientes
    }

    // Formulário para criar novo cliente
    @GetMapping("/novo")
    public String novoClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());  // Cria um objeto Cliente vazio
        return "formCliente";  // Nome do template Thymeleaf para o formulário de cliente
    }

    // Salvar novo cliente
    @PostMapping
    public String salvarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteRepository.save(cliente);  // Salva o cliente no banco de dados
        return "redirect:/clientes";  // Redireciona para a lista de clientes
    }

    // Editar cliente (carregar formulário com dados do cliente)
    @GetMapping("/editar/{id}")
    public String editarClienteForm(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteRepository.findById(String.valueOf(id)).orElseThrow(() ->
                new IllegalArgumentException("Cliente inválido: " + id));
        model.addAttribute("cliente", cliente);  // Adiciona o cliente encontrado ao modelo
        return "formCliente";  // Reutiliza o formulário de cliente para editar
    }

    // Atualizar cliente
    @PostMapping("/atualizar/{id}")
    public String atualizarCliente(@PathVariable("id") Long id, @ModelAttribute("cliente") Cliente clienteAtualizado) {
        clienteAtualizado.setId(id);  // Mantém o ID do cliente
        clienteRepository.save(clienteAtualizado);  // Atualiza o cliente no banco de dados
        return "redirect:/clientes";  // Redireciona para a lista de clientes
    }

    // Deletar cliente
    @GetMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable("id") Long id) {
        Cliente cliente = clienteRepository.findById(String.valueOf(id)).orElseThrow(() ->
                new IllegalArgumentException("Cliente inválido: " + id));
        clienteRepository.delete(cliente);  // Remove o cliente do banco de dados
        return "redirect:/clientes";  // Redireciona para a lista de clientes
    }
}
