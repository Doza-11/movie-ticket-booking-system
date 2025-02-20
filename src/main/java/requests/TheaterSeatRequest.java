package requests;

import lombok.Data;

@Data
public class TheaterSeatRequest {
    private String theaterAddress;
    private Integer noOfSeatsInRow;
    private Integer noOfPremiumSeats;
    private Integer noOfClassicSeats;
}
