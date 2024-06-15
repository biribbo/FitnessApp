package com.example.FitnessApp.model.training;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.Duration;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "training_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String title;
    private Duration duration;

    public Training(LocalDate date, String title, Duration duration) {
        this.date = date;
        this.title = title;
        this.duration = duration;
    }
}