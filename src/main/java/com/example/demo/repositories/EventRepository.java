package com.example.demo.repositories;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {


    @Query("SELECT b fROM Event b WHERE " +
//            "(:start IS NULL OR :start <= b.start) AND " +
//            "(:finish IS NULL OR :finish >= b.finish) AND " +
            "(:employeeId IS NULL OR :employeeId = b.employee.id)")
//    public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);

//    List<Event> findByFilter(@Param("start") LocalDateTime start,
//                             @Param("finish") LocalDateTime finish,
//                             @Param("employeeId") Integer employeeId);
    List<Event> findByFilter(
                             @Param("employeeId") Integer employeeId);
}
