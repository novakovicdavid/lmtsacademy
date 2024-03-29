package com.example.demo.repositories;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {


    @Query("SELECT b fROM Event b WHERE " +
            "(cast(:start as date) IS NULL OR :start <= b.start) AND " +
            "(cast(:finish as date) IS NULL OR :finish >= b.finish) AND " +
            "(:employeeId IS NULL OR :employeeId = b.employee.id) AND " +
            "(:profileId IS NULL OR :profileId = b.profile.id)" )
    List<Event> findByFilter(@Param("employeeId") Integer employeeId,
                             @Param("start") LocalDateTime start,
                             @Param("finish") LocalDateTime finish,
                             @Param("profileId") Integer profileId);
}
