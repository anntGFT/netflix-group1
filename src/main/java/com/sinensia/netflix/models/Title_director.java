package com.sinensia.netflix.models;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="title_director")
public class Title_director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @OneToMany
    @JoinColumn(name = "title_id")
    private Title title;

    @OneToMany
    @JoinColumn(name = "director_id")
    private Director director;
}
