package com.sinensia.netflix.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.sinensia.netflix.models.Actor;

public interface ActorRepository extends JpaRepository <Actor, Integer>{

    @RestResource(path="name", rel="name")
    List<Actor> findByNameContains(@Param("q") String name);

}
