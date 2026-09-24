package github.com.Produto.controller;

import github.com.Produto.dto.ProdutoRequestDTO;
import github.com.Produto.dto.ProdutoResponseDTO;
import github.com.Produto.service.ProdutoService;
import github.com.Produto.Eventos.ProdutoEventos;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoEventos produtoEventos;

    public ProdutoController(ProdutoService produtoService, ProdutoEventos produtoEventos) {
        this.produtoService = produtoService;
        this.produtoEventos = produtoEventos;
    }

    @GetMapping
    public List<ProdutoResponseDTO> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ProdutoResponseDTO buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponseDTO criar(@Valid @RequestBody ProdutoRequestDTO dto) {
        return produtoService.criar(dto);
    }

    @PutMapping("/{id}")
    public ProdutoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoRequestDTO dto) {
        return produtoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }

    @PostMapping("/publicar-evento")
    @ResponseStatus(HttpStatus.OK)
    public String publicarEvento(@Valid @RequestBody ProdutoRequestDTO dto) {
        produtoEventos.publicarEvento(dto);
        return "Evento publicado com sucesso no RabbitMQ";
    }
}
