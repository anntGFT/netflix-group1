package com.sinensia.netflix.repository;

import com.sinensia.netflix.models.Actor;
import com.sinensia.netflix.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer>{


}
