package me.fabian.springbootcasbin;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author fabian
 * @date 2021-12-10 14:50
 */
@Configuration
public class jCasbinConfiguration {

    public final static String CASBIN_POLICY_TOPIC = "YOUR_CUSTOMER_TOPIC";

    public jCasbinConfiguration(
            RedisMessageListenerContainer redisMessageListenerContainer,
            MessageListenerAdapter listenerAdapter
            ) {
        redisMessageListenerContainer.removeMessageListener(listenerAdapter);
        redisMessageListenerContainer.addMessageListener(listenerAdapter, new ChannelTopic(CASBIN_POLICY_TOPIC));
    }
}
