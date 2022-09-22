package com.sinensia.netflix.repository;

import com.sinensia.netflix.models.Actor;
import com.sinensia.netflix.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository <Director, Integer>{


}
