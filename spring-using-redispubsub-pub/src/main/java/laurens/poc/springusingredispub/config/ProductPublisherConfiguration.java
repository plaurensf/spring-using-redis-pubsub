package laurens.poc.springusingredispub.config;

import laurens.poc.springusingredispub.message.ProductData;
import laurens.poc.springusingredispub.message.ProductPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
@RequiredArgsConstructor
public class ProductPublisherConfiguration {

    @Value("${application.redis.topic}")
    private String topic;

    private final RedisTemplate<?,?> redisTemplate;

    @Bean
    ProductPublisher productPublisher(){
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(ProductData.class));
        return new ProductPublisher(redisTemplate, topic());
    }

    @Bean
    ChannelTopic topic(){
        return new ChannelTopic(topic);
    }

}
