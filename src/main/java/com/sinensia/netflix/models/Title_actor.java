package com.sinensia.netflix.models;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="title_actor")
public class Title_actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @OneToMany
    @JoinColumn(name = "title_id")
    private Title title;

    @OneToMany
    @JoinColumn(name = "actor_id")
    private Actor actor;
}
