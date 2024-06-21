package org.myworkspace.MovieMania.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.myworkspace.MovieMania.Entities.enums.SeatType;
import org.springframework.util.CollectionUtils;
import org.myworkspace.MovieMania.Resources.ShowSeatResource;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "show_seats")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatType seatType;

    @Column(name = "is_booked", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at")
    @CreationTimestamp
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    private Show show;

    @ManyToOne
    @JsonIgnore
    private Ticket ticket;

    public static List<ShowSeatResource> toResource(List<ShowSeat> seats) {
        if (!CollectionUtils.isEmpty(seats)) {
            return seats.stream().map(ShowSeat::toResource).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public static ShowSeatResource toResource(ShowSeat seatsEntity) {
        return ShowSeatResource.builder()
                .id(seatsEntity.getId())
                .seatNumber(seatsEntity.getSeatNumber())
                .rate(seatsEntity.getRate())
                .seatType(seatsEntity.getSeatType())
                .booked(seatsEntity.isBooked())
                .bookedAt(seatsEntity.getBookedAt())
                .build();

    }

}
