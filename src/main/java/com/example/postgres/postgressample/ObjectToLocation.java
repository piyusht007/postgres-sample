package com.example.postgres.postgressample;

import org.springframework.core.convert.converter.Converter;

public class ObjectToLocation implements Converter<Object[], Location> {
    @Override
    public Location convert(Object[] o) {
        final Location location = new Location();

        location.setLatitude(String.valueOf(o[0]));
        location.setLongitude(String.valueOf(o[1]));
        return location;
    }
}
