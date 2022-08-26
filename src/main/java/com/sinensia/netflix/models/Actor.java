package com.sinensia.netflix.models;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
}
