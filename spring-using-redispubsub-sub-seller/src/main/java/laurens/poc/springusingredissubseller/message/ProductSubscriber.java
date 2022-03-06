package laurens.poc.springusingredissubseller.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductSubscriber implements MessageListener {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try{
            ProductData productData = objectMapper.readValue(message.getBody(), ProductData.class);
            log.info("Message received: {}", productData.toString());
        }catch (IOException ex){
            log.error("Error reading message {}", ex.getMessage());
        }
    }
}