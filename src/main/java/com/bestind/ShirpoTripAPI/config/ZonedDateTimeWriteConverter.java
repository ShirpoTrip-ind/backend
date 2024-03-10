package com.bestind.ShirpoTripAPI.config;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@Component
@WritingConverter
public class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, String> {

    @Override
    public String convert(ZonedDateTime zonedDateTime) {
        System.out.println("Writing Converter called");
        return zonedDateTime.toString();
    }

}

