package kg.lalafo.lalafo_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LalafoResponse(
    List<LalafoItem> items
) {

}