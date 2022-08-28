package com.sinensia.netflix.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.netflix.models.Category;
import com.sinensia.netflix.repository.CategoryRepository;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping("/category/name/{name}")
    public List<Category> getCategoryByName(@PathVariable String name) {

        List<Category> categoryByName = categoryRepository.findAll().parallelStream()

            .filter(x -> x.getName().toUpperCase().contains(name.toUpperCase()))

            .collect(Collectors.toList());

        return categoryByName;

    }
    
}
