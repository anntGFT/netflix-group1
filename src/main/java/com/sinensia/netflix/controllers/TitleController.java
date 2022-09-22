package com.sinensia.netflix.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.netflix.models.Title;
import com.sinensia.netflix.repository.TitleRepository;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TitleController {

    @Autowired
    TitleRepository titleRepository;

    @GetMapping("/title/name/{name}")
    public List<Title> getTitleByName(@PathVariable String name) {

        List<Title> titleByName = titleRepository.findAll().parallelStream()

            .filter(x -> x.getName().toLowerCase().contains(name.toLowerCase()))

            .collect(Collectors.toList());

        return titleByName;

    }

    @GetMapping("/title/release/{year}")
    public List<Title> getTitleByReleaseYear(@PathVariable String year) {

        List<Title> titleByRelease = titleRepository.findAll().parallelStream()

            .filter(x -> x.getRelease_year().toLowerCase().contains(year.toLowerCase()))

            .collect(Collectors.toList());

        return titleByRelease;

    }

    @GetMapping("/title/description/{desc}")
    public List<Title> getTitleByDescriprion(@PathVariable String desc) {

        List<Title> titleByDescription = titleRepository.findAll().parallelStream()

            .filter(x -> x.getDescription().toLowerCase().contains(desc.toLowerCase()))

            .collect(Collectors.toList());

        return titleByDescription;

    }

    @GetMapping("/title/director/{director}")
    public List<Title> getTitleByDirector(@PathVariable String director) {

        List<Title> titleByDirector = titleRepository.findAll().parallelStream()

            .filter(x -> x.getDescription().toLowerCase().contains(director.toLowerCase()))

            .collect(Collectors.toList());

        return titleByDirector;

    }

    @GetMapping("/title/actor/{actor}")
    public List<Title> getTitleByActor(@PathVariable String actor) {

        List<Title> titleByActor = titleRepository.findAll().parallelStream()

            .filter(x -> x.getDescription().toLowerCase().contains(actor.toLowerCase()))

            .collect(Collectors.toList());

        return titleByActor;

    }

    @GetMapping("/title/category/{category}")
    public List<Title> getTitleByCategory(@PathVariable String category) {

        List<Title> titleByCategory = titleRepository.findAll().parallelStream()

            .filter(x -> x.getDescription().toLowerCase().contains(category.toLowerCase()))

            .collect(Collectors.toList());

        return titleByCategory;

    }
    
}
