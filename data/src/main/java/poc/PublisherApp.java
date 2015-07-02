package poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import poc.data.domain.Alert;
import poc.data.publisher.config.PublisherConfig;
import poc.data.publisher.service.CachePublisher;

import java.util.Random;

/**
 * USED FOR TESTING ONLY
 *
 */
@Deprecated
public class PublisherApp
{
    private static final Logger logger = LoggerFactory.getLogger(PublisherApp.class);

    public static void main(String[] args)
    {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(PublisherConfig.class);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                ((ConfigurableApplicationContext) ctx).close();
                logger.info("Cache shut down");
            }
        });

        CachePublisher<Alert> publisher = (CachePublisher<Alert>)ctx.getBean("integrationCachePublisher");

        Random r = new Random();
        String[] environments = new String[]{"DEV", "UAT", "PROD", "DR"};
        for (int i = 0; i < 1000; ++i) {
            publisher.publish(new Alert(i, "test" + i, "localhost", environments[r.nextInt(4)], r.nextInt(2), "myView" + i % 10));
        }
    }
}
