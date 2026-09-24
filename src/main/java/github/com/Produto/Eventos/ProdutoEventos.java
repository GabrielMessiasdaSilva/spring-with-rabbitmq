package github.com.Produto.Eventos;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import github.com.Produto.configuration.RabbitMQConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component 
public class ProdutoEventos {
    public final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public ProdutoEventos(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void publicarEvento(Object objeto) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(objeto);
            rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME, 
                RabbitMQConfig.ROUTING_KEY, 
                jsonMessage
            );
            System.out.println("[OK] Evento JSON enviado ao RabbitMQ: " + jsonMessage);
        } catch (Exception e) {
            System.err.println("[ERRO] Erro ao serializar objeto: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
