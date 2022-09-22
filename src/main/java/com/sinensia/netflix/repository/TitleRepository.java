package com.sinensia.netflix.repository;

import com.sinensia.netflix.models.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository <Title, Integer>{

    

}
