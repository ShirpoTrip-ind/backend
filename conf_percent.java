import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Bean
    MeterRegistryCustomizer<?> metricsCommonTags() {
        return registry -> registry.config()
                .commonTags("success_rate_threshold", "80");
    }
}