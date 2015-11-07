package poc.web.config;

import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.HealthIndicatorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.PublicMetricsAutoConfiguration;
import org.springframework.boot.actuate.endpoint.*;
import org.springframework.boot.actuate.endpoint.mvc.EndpointHandlerMapping;
import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.boot.actuate.endpoint.mvc.MvcEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Use some nice stuff from Spring Boot.
 *
 * @author vadya
 */
@Configuration
@Import({
        EndpointAutoConfiguration.class,
        PublicMetricsAutoConfiguration.class,
        HealthIndicatorAutoConfiguration.class
})
public class SpringActuatorConfig {
    @Bean
    @Inject
    public EndpointHandlerMapping endpointHandlerMapping(Collection<? extends MvcEndpoint> endpoints) {
        return new EndpointHandlerMapping(endpoints);
    }

    @Bean
    @Inject
    public EndpointMvcAdapter healthMvcEndpoint(HealthEndpoint delegate) {
        return new EndpointMvcAdapter(delegate);
    }

    @Bean
    @Inject
    public EndpointMvcAdapter infoMvcEndPoint(InfoEndpoint delegate) {
        return new EndpointMvcAdapter(delegate);
    }

    @Bean
    @Inject
    public EndpointMvcAdapter beansEndPoint(BeansEndpoint delegate) {
        return new EndpointMvcAdapter(delegate);
    }

    @Bean
    @Inject
    public EndpointMvcAdapter requestMappingEndPoint(RequestMappingEndpoint delegate) {
        return new EndpointMvcAdapter(delegate);
    }

    @Bean
    @Inject
    public EndpointMvcAdapter metricsEndPoint(MetricsEndpoint delegate) {
        return new EndpointMvcAdapter(delegate);
    }

    @Bean
    @Inject
    public EndpointMvcAdapter environmentMvcEndpoint(EnvironmentEndpoint delegate) {
        return new EndpointMvcAdapter(delegate);
    }
}
