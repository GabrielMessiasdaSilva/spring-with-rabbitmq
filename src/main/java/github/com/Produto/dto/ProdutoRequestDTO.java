package github.com.Produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoRequestDTO(
        @NotBlank(message = "Nome é obrigatório") String nome,
        String descricao,
        String imagens,
        @NotNull(message = "Preço é obrigatório") @PositiveOrZero(message = "Preço não pode ser negativo") Double preco,
        @NotNull(message = "Estoque é obrigatório") @PositiveOrZero(message = "Estoque não pode ser negativo") Integer estoque,
        Double avaliacao,
        Boolean ativo
) {
}
