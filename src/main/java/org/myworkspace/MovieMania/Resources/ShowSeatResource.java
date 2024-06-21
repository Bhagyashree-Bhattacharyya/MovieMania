package org.myworkspace.MovieMania.Resources;

import lombok.*;
import org.myworkspace.MovieMania.Entities.enums.SeatType;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class ShowSeatResource {
    private long id;
    private String seatNumber;
    private int rate;
    private SeatType seatType;
    private boolean booked;
    private Date bookedAt;

}
