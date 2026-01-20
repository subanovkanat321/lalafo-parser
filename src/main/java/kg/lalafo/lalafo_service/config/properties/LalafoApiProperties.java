package kg.lalafo.lalafo_service.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "lalafo.api")
public class LalafoApiProperties {

    private String baseUrl;

    private int itemsPerPage;
}
