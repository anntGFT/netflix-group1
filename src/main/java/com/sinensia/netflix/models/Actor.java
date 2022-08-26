package com.sinensia.netflix.models;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer id;
    @NotNull
    private String name;
}
