package poc.data.publisher.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.jms.ConnectionFactory;
import javax.jms.Topic;

/**
 * PublisherConfig <Description>
 *
 * @author vadya
 */
@Configuration
@ImportResource({"classpath:publisher-int-config.xml"})
@PropertySource("classpath:publisher.properties")
public class PublisherConfig {

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
