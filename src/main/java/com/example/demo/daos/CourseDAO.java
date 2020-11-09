package com.example.demo.daos;

import com.example.demo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course, Integer> {
}
