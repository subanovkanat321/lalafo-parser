package kg.lalafo.lalafo_service.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record AdDto(
    String title,
    String price,
    String city,
    String imageUrl,
    String date
) {

}
