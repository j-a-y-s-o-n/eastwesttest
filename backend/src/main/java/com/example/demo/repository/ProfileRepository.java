package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{

    @Query("SELECT s FROM Profile s WHERE s.eMail = ?1")
    Optional<Profile> findProfileByEmail(String email);

    @Query("SELECT s FROM Profile s WHERE s.mobile = ?1")
    Optional<Profile> findProfileByMobile(String mobile);
}
