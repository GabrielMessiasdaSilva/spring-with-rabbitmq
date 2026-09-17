package github.com.Produto.service;

import github.com.Produto.dto.ProdutoRequestDTO;
import github.com.Produto.dto.ProdutoResponseDTO;
import github.com.Produto.entity.Produto;
import github.com.Produto.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoResponseDTO> listarTodos() {
        return produtoRepository.findAll().stream()
                .map(ProdutoResponseDTO::fromEntity)
                .toList();
    }

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o id: " + id));
        return ProdutoResponseDTO.fromEntity(produto);
    }

    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {
        Produto produto = new Produto(
                dto.nome(),
                dto.descricao(),
                dto.imagens(),
                dto.preco(),
                dto.estoque(),
                dto.avaliacao(),
                dto.ativo() != null ? dto.ativo() : Boolean.TRUE
        );
        return ProdutoResponseDTO.fromEntity(produtoRepository.save(produto));
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o id: " + id));

        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setImagens(dto.imagens());
        produto.setPreco(dto.preco());
        produto.setEstoque(dto.estoque());
        produto.setAvaliacao(dto.avaliacao());
        produto.setAtivo(dto.ativo());

        return ProdutoResponseDTO.fromEntity(produtoRepository.save(produto));
    }

    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o id: " + id);
        }
        produtoRepository.deleteById(id);
    }
}
