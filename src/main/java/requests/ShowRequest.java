package requests;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class ShowRequest {

    private Time showStartTime;
    private Date showDate;
    private Integer theaterId;
    private Integer movieId;
}
