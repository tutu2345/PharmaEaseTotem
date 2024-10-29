package br.com.fiap.pharmaeasetotem;

import br.com.fiap.pharmaeasetotem.DTO.ClienteDTO;
import br.com.fiap.pharmaeasetotem.model.Carrinho;
import br.com.fiap.pharmaeasetotem.model.Cliente;
import br.com.fiap.pharmaeasetotem.model.Pedido;
import br.com.fiap.pharmaeasetotem.model.Remedio;
import br.com.fiap.pharmaeasetotem.service.CarrinhoService;
import br.com.fiap.pharmaeasetotem.service.ClienteService;
import br.com.fiap.pharmaeasetotem.service.PedidoService;
import br.com.fiap.pharmaeasetotem.service.RemedioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClienteService clienteService;
    private final RemedioService remedioService;
    private final CarrinhoService carrinhoService;
    private final PedidoService pedidoService;

    public DataLoader(ClienteService clienteService, RemedioService remedioService,
                      CarrinhoService carrinhoService, PedidoService pedidoService) {
        this.clienteService = clienteService;
        this.remedioService = remedioService;
        this.carrinhoService = carrinhoService;
        this.pedidoService = pedidoService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        ClienteDTO cliente1 = ClienteDTO.builder()
                .nome("Ana Souza")
                .email("ana.souza@example.com")
                .build();
        ClienteDTO cliente2 = ClienteDTO.builder()
                .nome("Carlos Oliveira")
                .email("carlos.oliveira@example.com")
                .build();
        ClienteDTO cliente3 = ClienteDTO.builder()
                .nome("Maria Santos")
                .email("maria.santos@example.com")
                .build();

        clienteService.criarCliente(cliente1);
        clienteService.criarCliente(cliente2);
        clienteService.criarCliente(cliente3);

        // Inserir remédios
        Remedio remedio1 = Remedio.builder()
                .nome("Paracetamol")
                .preco(12.50)
                .quantidade(100)
                .controlado(false)
                .build();
        Remedio remedio2 = Remedio.builder()
                .nome("Ibuprofeno")
                .preco(25.00)
                .quantidade(50)
                .controlado(false)
                .build();
        Remedio remedio3 = Remedio.builder()
                .nome("Diazepam")
                .preco(40.00)
                .quantidade(30)
                .controlado(true)
                .build();

        remedioService.criarRemedio(remedio1);
        remedioService.criarRemedio(remedio2);
        remedioService.criarRemedio(remedio3);
    }
}

