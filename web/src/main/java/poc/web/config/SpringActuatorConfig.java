package poc.web.config;

import org.springframework.boot.actuate.autoconfigure.beans.BeansEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration;
import org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Set;

/**
 * Use some nice stuff from Spring Boot.
 *
 * @author vadya
 */
@Configuration
@Import({
        EndpointAutoConfiguration.class,
        WebEndpointAutoConfiguration.class,
        WebMvcEndpointManagementContextConfiguration.class,
        HealthEndpointAutoConfiguration.class,
        InfoEndpointAutoConfiguration.class,
        BeansEndpointAutoConfiguration.class,
        EnvironmentEndpointAutoConfiguration.class,
        MappingsEndpointAutoConfiguration.class,
        MetricsAutoConfiguration.class,
        CompositeMeterRegistryAutoConfiguration.class,
        MetricsEndpointAutoConfiguration.class
})
public class SpringActuatorConfig {
    @Bean
    public WebEndpointProperties webEndpointProperties() {
        WebEndpointProperties properties = new WebEndpointProperties();
        properties.getExposure().setInclude(Set.of("health", "info", "beans", "mappings", "metrics", "env"));
        return properties;
    }
}
