package com.sinensia.netflix.models;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @NotNull
    private String name;
}
