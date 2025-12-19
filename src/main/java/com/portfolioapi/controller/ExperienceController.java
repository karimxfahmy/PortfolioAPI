package com.portfolioapi.controller;

import com.portfolioapi.entity.Experience;
import com.portfolioapi.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping
    public List<Experience> getAll(Principal principal) {
        return experienceService.getAllExperience(principal.getName());
    }

    @PostMapping
    public Experience create(@RequestBody Experience experience, Principal principal) {
        return experienceService.saveExperience(experience, principal.getName());
    }

    @GetMapping("/{id}")
    public Experience getById(@PathVariable Long id) {
        return experienceService.getExperienceById(id);
    }

    @PutMapping("/{id}")
    public Experience update(@PathVariable Long id, @RequestBody Experience experience) {
        return experienceService.updateExperience(id, experience);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        experienceService.deleteExperience(id);
    }
}
