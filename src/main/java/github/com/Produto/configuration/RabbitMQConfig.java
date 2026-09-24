package github.com.Produto.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "produto.exchange";
    public static final String QUEUE_NAME = "Meus-Produtos";
    public static final String ROUTING_KEY = "produto.key";

    @Bean
    public Exchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME, true, false);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Binding binding(Queue queue, Exchange directExchange) {
        return BindingBuilder.bind(queue)
                .to(directExchange)
                .with(ROUTING_KEY)
                .noargs();
    }
}
