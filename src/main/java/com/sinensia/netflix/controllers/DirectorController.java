package com.sinensia.netflix.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.netflix.models.Director;
import com.sinensia.netflix.repository.DirectorRepository;

@RestController
public class DirectorController {

    @Autowired
    DirectorRepository directorRepository;


    @GetMapping("/director/name/{name}")
    public List<Director> getCategoryByName(@PathVariable String name) {

        List<Director> directorByName = directorRepository.findAll().parallelStream()

            .filter(x -> x.getName().toUpperCase().contains(name.toUpperCase()))

            .collect(Collectors.toList());

        return directorByName;

    }
    
}
