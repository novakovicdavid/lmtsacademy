package com.example.demo.repositories;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {


    @Query("select b from Event b where b.start >= ?1 and b.finish <= ?2")
//    public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);

    List<Event> findByFilter(@Param("start") LocalDateTime start,
                             @Param("finish") LocalDateTime finish);
}
