package com.example.demo.daos;

import com.example.demo.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDAO extends JpaRepository<Job, Integer> {
}
