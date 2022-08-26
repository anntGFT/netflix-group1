package com.sinensia.netflix.models;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="title")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    private String name;
    private String date_added;
    private String release_year;
    private String rating;
    private String duration;
    private String description;
    private Float user_rating;
    private Integer num_ratings;
}
