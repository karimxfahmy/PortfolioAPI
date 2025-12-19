package com.portfolioapi.service;

import com.portfolioapi.entity.Education;
import com.portfolioapi.entity.User;
import com.portfolioapi.repository.EducationRepository;
import com.portfolioapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Education> getAllEducation(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return educationRepository.findByUser(user);
    }

    public Education saveEducation(Education education, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        education.setUser(user);
        return educationRepository.save(education);
    }

    public Education getEducationById(Long id) {
        return educationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Education not found"));
    }

    public Education updateEducation(Long id, Education updated) {
        Education existing = educationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Education not found"));

        existing.setInstitution(updated.getInstitution());
        existing.setDegree(updated.getDegree());
        existing.setField(updated.getField());
        existing.setStartDate(updated.getStartDate());
        existing.setEndDate(updated.getEndDate());

        return educationRepository.save(existing);
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}
