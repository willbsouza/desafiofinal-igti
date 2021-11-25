package igti.desafio.controller;

import igti.desafio.modelo.Pedido;
import igti.desafio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Transactional
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping("/pedidos")
    public Pedido realizarPedido(@RequestBody Pedido pedido) {

        pedido.setDataHora(LocalDateTime.now());
        pedido.setSituacao(Pedido.SITUACAO_AGUARDANDO);
        return pedidoRepository.save(pedido);
    }

    @GetMapping("/pedidos/{idPedido}")
    public Pedido obterPedido(@PathVariable Integer idPedido){
        return pedidoRepository.findById(idPedido).get();
    }

    @GetMapping("/pedidos")
    public List<Pedido> obterPedidos(){
        return pedidoRepository.findAll();
    }

    @PutMapping("/pedidos/{idPedido}")
    public Pedido atualizarPedido(@PathVariable Integer idPedido, @RequestBody Pedido pedido){
        return pedidoRepository.save(pedido);
    }
}
