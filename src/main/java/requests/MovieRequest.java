package requests;

import enums.Genre;
import enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class MovieRequest {
    private String movieName;
    private Integer duration;
    private Genre genre;
    private Double rating;
    private Date releaseDate;
    private Language language;
}
