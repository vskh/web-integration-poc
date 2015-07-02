package poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import poc.data.receiver.config.ReceiverConfig;

/**
 * Hello world!
 *
 */
public class ReceiverApp
{
    private static final Logger logger = LoggerFactory.getLogger(ReceiverApp.class);

    public static void main(String[] args)
    {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(ReceiverConfig.class);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                ((ConfigurableApplicationContext) ctx).close();
                logger.info("Cache instance shut down");
            }
        });
    }
}
