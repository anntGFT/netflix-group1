package com.sinensia.netflix.controllers;

public class RecomendationController {
    
    
    public List<Title> getBest(@RequestParam int limit) {
List<Title> title;
title = titleRepository.findAll();
return title.stream()
.sorted(Comparator.comparingDouble(Title::getUser_rating).reversed())
.limit(limit) .collect(Collectors.toList());
}
    

}
