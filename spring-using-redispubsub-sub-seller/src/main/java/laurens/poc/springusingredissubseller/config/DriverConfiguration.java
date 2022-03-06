package laurens.poc.springusingredissubseller.config;

import laurens.poc.springusingredissubseller.message.ProductSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
@RequiredArgsConstructor
public class DriverConfiguration {

    @Value("${spring.application.redis.topic}")
    private String topic;

    private final RedisConnectionFactory redisConnectionFactory;

    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.addMessageListener(messageListener(), topic());
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }

    @Bean
    MessageListenerAdapter messageListener(){
        return new MessageListenerAdapter(new ProductSubscriber());
    }

    @Bean
    ChannelTopic topic(){
        return new ChannelTopic(topic);
    }

}
