package com.example.FitnessApp.model.training;
import com.example.FitnessApp.model.exercise.StrengthExercise;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("STRENGTH")
@NoArgsConstructor
@Getter
public class StrengthTraining extends Training {
    private int weight;
    private int exercisesCount;
    private int sets;
    private int reps;
    @ManyToMany
    private Set<StrengthExercise> exercises;

    public StrengthTraining(LocalDate date, String title, Duration duration, int weight, int exercisesCount, int sets, int reps, Set<StrengthExercise> exercises) {
        super(date, title, duration);
        this.weight = weight;
        this.exercisesCount = exercisesCount;
        this.sets = sets;
        this.reps = reps;
        this.exercises = exercises;
    }
}