package com.portfolioapi.service;

import com.portfolioapi.entity.Experience;
import com.portfolioapi.entity.User;
import com.portfolioapi.repository.ExperienceRepository;
import com.portfolioapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Experience> getAllExperience(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return experienceRepository.findByUser(user);
    }

    public Experience saveExperience(Experience experience, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        experience.setUser(user);
        return experienceRepository.save(experience);
    }

    public Experience getExperienceById(Long id) {
        return experienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experience not found"));
    }

    public Experience updateExperience(Long id, Experience updated) {
        Experience existing = experienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experience not found"));

        existing.setCompany(updated.getCompany());
        existing.setPosition(updated.getPosition());
        existing.setStartDate(updated.getStartDate());
        existing.setEndDate(updated.getEndDate());
        existing.setDescription(updated.getDescription());

        return experienceRepository.save(existing);
    }

    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}
