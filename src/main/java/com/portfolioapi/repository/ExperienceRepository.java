package com.portfolioapi.repository;

import com.portfolioapi.entity.Experience;
import com.portfolioapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByUser(User user);
}
