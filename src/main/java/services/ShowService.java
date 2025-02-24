package services;


import convertor.ShowConvertor;
import entities.*;
import enums.SeatType;
import exceptions.MovieDoesNotExists;
import exceptions.ShowDoesNotExists;
import exceptions.TheaterDoesNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.MovieRepository;
import repositories.ShowRepository;
import repositories.TheaterRepository;
import requests.ShowRequest;
import requests.ShowSeatRequest;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    public String addShow(ShowRequest showRequest) {
        Show show = ShowConvertor.showDtoToShow(showRequest);

        Optional<Movie> movieOpt = movieRepository.findById(showRequest.getMovieId());
        if (movieOpt.isEmpty()) {
            throw new MovieDoesNotExists();
        }

        Optional<Theater> theaterOpt = theaterRepository.findById(showRequest.getTheaterId());
        if (theaterOpt.isEmpty()) {
            throw new TheaterDoesNotExists();
        }

        Theater theater = theaterOpt.get();
        Movie movie = movieOpt.get();

        show.setMovie(movie);
        show.setTheater(theater);
        show = showRepository.save(show);

        movie.getShows().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show has been added Successfully";
    }

    public String associateSeat(ShowSeatRequest showSeatRequest) throws ShowDoesNotExists {

        Optional<Show> showOpt = showRepository.findById(showSeatRequest.getShowId());
        if(showOpt.isEmpty())
        {
            throw new ShowDoesNotExists();
        }

        Show show = showOpt.get();
        Theater theater = show.getTheater();

        List<ShowSeat> showSeatList = show.getShowSeatList();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        for(TheaterSeat theaterSeat : theaterSeatList)
        {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setPrice(showSeatRequest.getPriceOfClassicSeat());
            }
            else {
                showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());
            }

            showSeat.setShow(show);
            showSeat.setIsAvailable(true);
            showSeat.setIsFoodContains(false);

            showSeatList.add(showSeat);
        }
        showRepository.save(show);
        return "Show has been associated to the seat Successfully";
    }

}
