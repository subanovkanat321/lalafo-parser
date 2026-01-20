package kg.lalafo.lalafo_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LalafoImage(
    @JsonProperty("original_url") String url
) {

}
