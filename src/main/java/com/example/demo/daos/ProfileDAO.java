package com.example.demo.daos;

import com.example.demo.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDAO extends JpaRepository<Profile, Integer> {
}
