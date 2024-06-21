package org.myworkspace.MovieMania.Repositories;

import org.myworkspace.MovieMania.Entities.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

}
