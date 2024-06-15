package com.example.FitnessApp.model.exercise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorColumn(name = "exercise_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String equipment;
    private String instructions;

    public Exercise(String name, String equipment, String instructions) {
        this.name = name;
        this.equipment = equipment;
        this.instructions = instructions;
    }
}
