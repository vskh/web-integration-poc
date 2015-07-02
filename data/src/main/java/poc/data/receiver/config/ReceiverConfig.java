package poc.data.receiver.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.jms.ConnectionFactory;
import javax.jms.Topic;

/**
 * AppConfig <Description>
 *
 * @author vadya
 */
@Configuration
@ComponentScan({"poc.data.cache.hazelcast"})
@ImportResource({"classpath:receiver-int-config.xml", "classpath:store-backend-config.xml"})
@PropertySource("classpath:receiver.properties")
public class ReceiverConfig {
    @Value("${poc.cache.publisher.brokerURL}")
    private String amqBrokerURL;

    @Value("${poc.cache.publisher.topic}")
    private String amqTopic;

    @Bean
    static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(amqBrokerURL);

        return connectionFactory;
    }

    @Bean
    Topic publishDestination() {
        return new ActiveMQTopic(amqTopic);
    }
}
