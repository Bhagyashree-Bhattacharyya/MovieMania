package org.myworkspace.MovieMania.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.CollectionUtils;
import org.myworkspace.MovieMania.Resources.TicketResource;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Entity
@EntityListeners(value = { AuditingEntityListener.class })
@Table(name = "tickets")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "alloted_seats", nullable = false)
    private String allottedSeats;

    @Column(name = "amount", nullable = false)
    private double amount;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at", nullable = false)
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private Show show;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeat> seats;


    public static List<TicketResource> toResource(List<Ticket> tickets){
        if(CollectionUtils.isEmpty(tickets))
            return new ArrayList<>();
        return tickets.stream().map(Ticket::toResource).collect(Collectors.toList());
    }

    public static Ticket toEntity(TicketResource ticketResource) {
        return Ticket.builder()
                .allottedSeats(ticketResource.getAllottedSeats())
                .amount(ticketResource.getAmount())
                .build();

    }

    public static TicketResource toResource(Ticket ticketEntity) {
        return TicketResource.builder()
                .id(ticketEntity.getId())
                .allottedSeats(ticketEntity.getAllottedSeats())
                .amount(ticketEntity.getAmount())
                .bookedAt(ticketEntity.getBookedAt())
                .build();
    }

}
