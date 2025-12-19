package com.portfolioapi.controller;

import com.portfolioapi.entity.Education;
import com.portfolioapi.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping
    public List<Education> getAll(Principal principal) {
        return educationService.getAllEducation(principal.getName());
    }

    @PostMapping
    public Education create(@RequestBody Education education, Principal principal) {
        return educationService.saveEducation(education, principal.getName());
    }

    @GetMapping("/{id}")
    public Education getById(@PathVariable Long id) {
        return educationService.getEducationById(id);
    }

    @PutMapping("/{id}")
    public Education update(@PathVariable Long id, @RequestBody Education education) {
        return educationService.updateEducation(id, education);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }
}
