package com.example.demo.repositories;

import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course,Integer> {

    Optional<Course> findFirstByIdLessThanOrderByIdDesc(int id);

    Optional<Course> findFirstByOrderByIdDesc();

    Optional<Course> findFirstByIdGreaterThanOrderByIdAsc(int id);

    Optional<Course> findFirstByOrderByIdAsc();
@Query("select c from Course c where c.category = :category")
List<Course> findByCategory(String category);

    Iterable<Course> findByWorkshop(boolean b);

//    List<Course> findByCategory(String filter);
}
