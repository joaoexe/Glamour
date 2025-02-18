package com.pacote.joias.controller;

import com.pacote.joias.model.Pedido;
import com.pacote.joias.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loja/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}
