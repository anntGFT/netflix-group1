package com.sinensia.netflix.repository;

import com.sinensia.netflix.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository <Actor, Integer>{


}
