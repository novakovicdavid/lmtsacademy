package com.example.demo.repositories;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {
    /* This one uses a JPQL */
    public List<Event> findByStartGreaterThanEqualAndFinishLessThanEqual(LocalDateTime start, LocalDateTime end);


    /* This one uses an @Query */
    @Query("select b from Event b where b.start >= ?1 and b.finish <= ?2")
    public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
