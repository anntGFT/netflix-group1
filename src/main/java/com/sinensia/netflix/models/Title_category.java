package com.sinensia.netflix.models;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="title_category")
public class Title_category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToMany
    @JoinColumn(name = "title_id")
    private Title title;

    @OneToMany
    @JoinColumn(name = "category_id")
    private Category category;
}
