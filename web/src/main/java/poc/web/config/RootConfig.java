package poc.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import poc.data.receiver.config.ReceiverConfig;

/**
 * RootConfig <Description>
 *
 * @author vadya
 */
@Configuration
@ComponentScan({"poc.web.service"})
@Import({ReceiverConfig.class})
@ImportResource({"classpath:integration-config.xml"})
public class RootConfig {
}
