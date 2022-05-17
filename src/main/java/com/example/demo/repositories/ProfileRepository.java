package com.example.demo.repositories;

import com.example.demo.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Integer> {
    @Query(value = "select profile from Profile profile where " +
            "(:firstName is null or UPPER(profile.firstName) like CONCAT('%',UPPER(:firstName),'%')) and " +
            "(:lastName is null or UPPER(profile.lastName) like CONCAT('%',UPPER(:lastName),'%')) and " +
            "(:isNew = false or (:isNew = true and :isNew = profile.isNew)) and " +
            "(:email is null or UPPER(profile.user.email) like CONCAT('%',UPPER(:email),'%'))")
    Page<Profile> findAllByFilter(Pageable page, String firstName, String lastName, String email, Boolean isNew);
}
