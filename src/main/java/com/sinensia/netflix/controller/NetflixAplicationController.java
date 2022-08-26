package com.sinensia.netflix.controller;

import com.sinensia.netflix.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface NetflixAplicationController extends JpaRepository <Actor, Integer>{

    @RestResource(path="Actor", rel="name")

}
