package br.com.fiap.pharmaeasetotem.service;

import br.com.fiap.pharmaeasetotem.model.Pedido;
import br.com.fiap.pharmaeasetotem.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public void salvarPedidos(List<Pedido> pedidos) {
        pedidoRepository.saveAll(pedidos);
    }


}
