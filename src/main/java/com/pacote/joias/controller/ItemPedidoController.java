package com.pacote.joias.controller;

import com.pacote.joias.model.ItemPedido;
import com.pacote.joias.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loja/pedido-itens")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository ItemPedidoRepository;

    @GetMapping
    public List<ItemPedido> getAllPedidoItens() {
        return ItemPedidoRepository.findAll();
    }

    @PostMapping
    public ItemPedido createPedidoItem(@RequestBody ItemPedido pedidoItem) {
        return ItemPedidoRepository.save(pedidoItem);
    }

    @GetMapping("/{id}")
    public ItemPedido getPedidoItem(@PathVariable Long id) {
        return ItemPedidoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ItemPedido updatePedidoItem(@PathVariable Long id, @RequestBody ItemPedido ItemPedido) {
        ItemPedido.setId(id);
        return ItemPedidoRepository.save(ItemPedido);
    }

    @DeleteMapping("/{id}")
    public void deletePedidoItem(@PathVariable Long id) {
        ItemPedidoRepository.deleteById(id);
    }
}
