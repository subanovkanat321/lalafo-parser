package kg.lalafo.lalafo_service.service;

import kg.lalafo.lalafo_service.config.properties.LalafoApiProperties;
import kg.lalafo.lalafo_service.dto.AdDto;
import kg.lalafo.lalafo_service.dto.LalafoResponse;
import kg.lalafo.lalafo_service.mapper.AdMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LalafoService {

    private final RestTemplate restTemplate;

    private final LalafoApiProperties apiProperties;

    private final AdMapper adMapper;

    public List<AdDto> getAds() {
        String url = String.format("%s?expand=url&per-page=%d", apiProperties.getBaseUrl(), apiProperties.getItemsPerPage());

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
        headers.set("device", "pc");
        headers.set("country-id", "12");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<LalafoResponse> lalafoAdsResponse = restTemplate.exchange(
            url, HttpMethod.GET, entity, LalafoResponse.class
        );

        return lalafoAdsResponse.getBody().items().stream()
            .map(adMapper::toDto)
            .toList();
    }
}
