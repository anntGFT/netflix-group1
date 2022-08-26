package com.sinensia.netflix.models;

import java.util.*;

import javax.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
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

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String date_added;
    @NotNull
    private String release_year;
    @NotNull
    private String rating;
    @NotNull
    private String duration;
    @NotNull
    private String description;

    @Max(10)
    @Min(0)
    private Float user_rating;

    @Positive
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
