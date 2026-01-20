package kg.lalafo.lalafo_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LalafoItem(
    String title,
    String price,
    String city,
    String currency,
    @JsonProperty("created_time") Long createdTime,
    List<LalafoImage> images
) {

}
