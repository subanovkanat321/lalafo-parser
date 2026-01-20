package kg.lalafo.lalafo_service.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "lalafo.api")
public class LalafoApiProperties {

    private String baseUrl;

    private int itemsPerPage;

    public String getBaseUrl() {
        return baseUrl;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }
}
