package convertor;

import entities.Theater;
import requests.TheaterRequest;

public class TheaterConvertor {
    public static Theater theaterDtoToTheater(TheaterRequest theaterRequest) {
        Theater theater = Theater.builder()
                .name(theaterRequest.getTheaterName())
                .address(theaterRequest.getTheaterAddress())
                .build();
        return theater;
    }
}


