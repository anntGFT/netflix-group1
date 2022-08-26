package com.sinensia.netflix.repository;

import com.sinensia.netflix.models.Actor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface ActorRepository extends JpaRepository <Actor, String>{

    @RestResource(path="/actors", rel="actors")
    List<Actor> findByNameContains(@Param("q") String name);

}
