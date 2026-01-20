package kg.lalafo.lalafo_service.service;

import kg.lalafo.lalafo_service.config.properties.LalafoApiProperties;
import kg.lalafo.lalafo_service.dto.AdDto;
import kg.lalafo.lalafo_service.dto.LalafoResponse;
import kg.lalafo.lalafo_service.mapper.AdMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LalafoService {

    private final RestTemplate restTemplate;

    private final LalafoApiProperties apiProperties;

    private final AdMapper adMapper;

    public LalafoService(RestTemplate restTemplate, LalafoApiProperties apiProperties, AdMapper adMapper) {
        this.restTemplate = restTemplate;
        this.apiProperties = apiProperties;
        this.adMapper = adMapper;
    }

    public List<AdDto> getAds() {
        String url = String.format("%s?expand=url&per-page=%d",
            apiProperties.getBaseUrl(),
            apiProperties.getItemsPerPage());

        HttpHeaders headers = new HttpHeaders();

        headers.set("accept-language", "ru,ru-RU;q=0.9,en-US;q=0.8,en;q=0.7");
        headers.set("language", "ru_RU");
        headers.set("authorization", "");

        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        headers.set("device", "pc");
        headers.set("country-id", "12");
        headers.set("accept", "application/json, text/plain, */*");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<LalafoResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            LalafoResponse.class
        );

        if (response.getBody() == null || response.getBody().items() == null) {
            return List.of();
        }

        return response.getBody().items().stream()
            .map(adMapper::toDto)
            .toList();
    }
}
