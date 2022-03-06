package laurens.poc.springusingredispub.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

@Slf4j
@RequiredArgsConstructor
public class ProductPublisher {

    private final RedisTemplate<?, ?> redisTemplate;
    private final ChannelTopic channelTopic;

    public void publishProductInfo(ProductData product){
        log.info("Publishing message: {}", product.toString());
        redisTemplate.convertAndSend(channelTopic.getTopic(), product);
    }

}
