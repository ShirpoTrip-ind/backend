@Configuration
public class RateLimitingConfig extends Bucket4jSpringBootConfiguration {

    @Override
    public List<Bucket4jConfigurer> cors() {
        return List.of(Bucket4jConfigurer.classicRules()
                .addLimit(Bandwidth.classic(10, Refill.intervally(10, Duration.ofSeconds(10))))
                .forUri("/api/limited"));
    }
}

@SpringBootApplication
@EnableRateLimiting
public class YourApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}