package com.sinensia.netflix.models;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
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

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "title_director",
        joinColumns = { @JoinColumn(name = "title_id") },
        inverseJoinColumns = { @JoinColumn(name = "director_id") })
    private Set<Director> directors = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "title_actor",
        joinColumns = { @JoinColumn(name = "title_id") },
        inverseJoinColumns = { @JoinColumn(name = "actor_id") })
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "title_category",
        joinColumns = { @JoinColumn(name = "title_id") },
        inverseJoinColumns = { @JoinColumn(name = "category_id") })
    private Set<Category> categories = new HashSet<>();
}
