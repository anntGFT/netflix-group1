package com.sinensia.netflix.models;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer id;
    @NotNull
    private String name;
}
