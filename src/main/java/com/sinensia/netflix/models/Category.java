package com.sinensia.netflix.models;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @NotNull
    private String name;
}
