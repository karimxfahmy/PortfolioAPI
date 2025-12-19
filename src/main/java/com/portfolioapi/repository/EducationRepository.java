package com.portfolioapi.repository;

import com.portfolioapi.entity.Education;
import com.portfolioapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByUser(User user);
}
