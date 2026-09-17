package github.com.Produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import github.com.Produto.Eventos.ProdutoEventos;

@SpringBootApplication
public class ProdutoApplication implements CommandLineRunner {
	private final ProdutoEventos produtoEventos;

	public ProdutoApplication(ProdutoEventos produtoEventos) {
		this.produtoEventos = produtoEventos;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		produtoEventos.publicarEvento("Mensagem de teste");
		System.out.println("Evento publicado com sucesso.");
	}
}
