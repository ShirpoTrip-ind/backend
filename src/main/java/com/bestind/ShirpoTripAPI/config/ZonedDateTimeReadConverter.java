package com.bestind.ShirpoTripAPI.config;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@Component
@ReadingConverter
public class ZonedDateTimeReadConverter implements Converter<String, ZonedDateTime> {

    @Override
    public ZonedDateTime convert(@NonNull String date) {
        return ZonedDateTime.parse(date);
    }

}
