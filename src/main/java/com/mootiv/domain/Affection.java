package com.mootiv.domain;

import com.mootiv.domain.muscle.Muscle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class Affection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToMany
    private Set<Muscle> musclesAffected;

    public void update(String name, String description, Set<Muscle> musclesAffected) {
        this.name = name;
        this.description = description;
        this.musclesAffected = musclesAffected;
    }

    public static Affection with(String name, String description, Set<Muscle> musclesAffected) {
        var affection = new Affection();
        affection.setName(name);
        affection.setDescription(description);
        affection.setMusclesAffected(musclesAffected);
        return affection;
    }

}
