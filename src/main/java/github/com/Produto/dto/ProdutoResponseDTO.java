package github.com.Produto.dto;

import github.com.Produto.entity.Produto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        String imagens,
        Double preco,
        Integer estoque,
        Double avaliacao,
        Boolean ativo
) {
    public static ProdutoResponseDTO fromEntity(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getImagens(),
                produto.getPreco(),
                produto.getEstoque(),
                produto.getAvaliacao(),
                produto.getAtivo()
        );
    }
}
