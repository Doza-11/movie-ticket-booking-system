package services;

import convertor.TheaterConvertor;
import entities.Theater;
import exceptions.TheaterAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.TheaterRepository;
import requests.TheaterRequest;

public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(TheaterRequest theaterRequest) {
        Theater theaterByName = theaterRepository.findByAddress(theaterRequest.getTheaterAddress());

        if (theaterRepository.findByAddress(theaterRequest.getTheaterAddress()) != null) {
            throw new TheaterAlreadyExist();
        }

        Theater theater = TheaterConvertor.theaterDtoToTheater(theaterRequest);
        theaterRepository.save(theater);
        return "The theater has been added successfully";
    }
}
