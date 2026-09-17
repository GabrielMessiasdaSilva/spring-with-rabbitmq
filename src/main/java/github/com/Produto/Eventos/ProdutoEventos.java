package github.com.Produto.Eventos;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Component 
public class ProdutoEventos {
    public final RabbitTemplate rabbitTemplate;

    public ProdutoEventos(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publicarEvento(String messagem) {
        rabbitTemplate.convertAndSend("Meus-Produtos", messagem);
    }
}
