package com.example.demo.repositories;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {


    @Query("SELECT b fROM Event b WHERE " +
            "(:start IS NULL OR b.start >= :start) AND "+
            "(:finish IS NULL OR b.finish <= :finish)")
//    public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);

    List<Event> findByFilter(@Param("start") LocalDateTime start,
                             @Param("finish") LocalDateTime finish);
}
