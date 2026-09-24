package github.com.Produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ProdutoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("[OK] Aplicacao Produto iniciada na porta 8081");
	}
}
