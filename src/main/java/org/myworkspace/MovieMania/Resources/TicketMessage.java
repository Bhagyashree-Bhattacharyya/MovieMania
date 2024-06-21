package org.myworkspace.MovieMania.Resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myworkspace.MovieMania.Entities.Show;
import org.myworkspace.MovieMania.Entities.ShowSeat;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TicketMessage {

    private String  userName;
    private String  mobile;
    private String email;
    private Show show;
    private List<ShowSeat> seats;
}
