package com.sinensia.netflix.controllers;

import com.sinensia.netflix.models.Category;
import com.sinensia.netflix.models.Title;
import com.sinensia.netflix.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class RecomendationController {

    @Autowired
    TitleRepository titleRepository;
    @GetMapping("api/recommend/best")
    public List<Title> getBest(@RequestParam("top") int top) {

        List<Title> title;

        title = titleRepository.findAll();

        return title.stream()

                .sorted(Comparator.comparingDouble(Title::getUser_rating).reversed())

                .limit(top) .collect(Collectors.toList());
}
@GetMapping("api/recommend/category")
    public Map<Set<Category>, List<Title>> getTitlesByCategory(@RequestParam("top") int top){

        return titleRepository.findAll().stream()
                .sorted(Comparator.comparingDouble(Title::getUser_rating).reversed())
                .limit(top)
                .collect(Collectors.groupingBy(Title::getCategories));
    }

}
