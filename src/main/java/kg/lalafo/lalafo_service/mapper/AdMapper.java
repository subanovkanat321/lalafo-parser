package kg.lalafo.lalafo_service.mapper;

import kg.lalafo.lalafo_service.constants.AppConstants;
import kg.lalafo.lalafo_service.dto.AdDto;
import kg.lalafo.lalafo_service.dto.LalafoItem;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
public class AdMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(AppConstants.DATE_FORMAT);

    public AdDto toDto(LalafoItem item) {
        String photo = item.images() != null && !item.images().isEmpty()
            ? item.images().get(0).url()
            : "";

        LocalDateTime dateTime = LocalDateTime.ofInstant(
            Instant.ofEpochSecond(item.createdTime()),
            ZoneId.systemDefault()
        );

        String priceWithCurrency = item.price() + " " + (item.currency() != null ? item.currency() : AppConstants.DEFAULT_CURRENCY);

        return new AdDto(
            item.title(),
            priceWithCurrency,
            item.city(),
            photo,
            dateTime.format(FORMATTER)
        );
    }
}
