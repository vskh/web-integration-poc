package poc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import poc.data.api.config.RESTConfig;

/**
 * WebConfig <Description>
 *
 * @author vadya
 */
@Configuration
//@EnableWebMvc
@Import({RESTConfig.class})
public class WebConfig extends DelegatingWebMvcConfiguration {

    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping mapping = super.requestMappingHandlerMapping();
        mapping.setRemoveSemicolonContent(false);
        return mapping;
    }
}
