package com.example.demo.repositories;

import com.example.demo.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Integer> {
    @Query(value = "select profile from Profile profile " +
            "join fetch profile.user user where " +
            "(:firstName is null or UPPER(profile.firstName) like CONCAT('%',UPPER(CAST(:firstName as text)),'%')) and " +
            "(:lastName is null or UPPER(profile.lastName) like CONCAT('%',UPPER(CAST(:lastName as text)),'%')) and " +
            "(:showNewOnly = false or (:showNewOnly = true and :showNewOnly = profile.isNew)) and " +
            "(:email is null or UPPER(user.email) like CONCAT('%',UPPER(CAST(:email as text)),'%')) and " +
            "((:hideDisabled = true and user.enabled = true) or :hideDisabled = false)",
    countQuery = "select count(profile) from Profile profile where " +
            "(:firstName is null or UPPER(profile.firstName) like CONCAT('%',UPPER(CAST(:firstName as text)),'%')) and " +
            "(:lastName is null or UPPER(profile.lastName) like CONCAT('%',UPPER(CAST(:lastName as text)),'%')) and " +
            "(:showNewOnly = false or (:showNewOnly = true and :showNewOnly = profile.isNew)) and " +
            "(:email is null or UPPER(user.email) like CONCAT('%',UPPER(CAST(:email as text)),'%')) and " +
            "((:hideDisabled = true and user.enabled = true) or :hideDisabled = false)")
    Page<Profile> findAllByFilter(Pageable page, String firstName, String lastName, String email, Boolean showNewOnly, Boolean hideDisabled);
}
