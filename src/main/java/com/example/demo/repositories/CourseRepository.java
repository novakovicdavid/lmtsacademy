package com.example.demo.repositories;

import com.example.demo.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course,Integer> {

    Optional<Course> findFirstByIdLessThanOrderByIdDesc(int id);

    Optional<Course> findFirstByOrderByIdDesc();

    Optional<Course> findFirstByIdGreaterThanOrderByIdAsc(int id);

    Optional<Course> findFirstByOrderByIdAsc();

    Iterable<Course> findByWorkshop(boolean yes);
}
