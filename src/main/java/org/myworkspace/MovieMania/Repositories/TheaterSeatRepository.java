package org.myworkspace.MovieMania.Repositories;

import org.myworkspace.MovieMania.Entities.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepository extends JpaRepository<TheaterSeat, Long> {

}
