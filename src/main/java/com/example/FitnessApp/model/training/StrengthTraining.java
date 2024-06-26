package com.example.FitnessApp.model.training;
import com.example.FitnessApp.model.exercise.StrengthExercise;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("STRENGTH")
@NoArgsConstructor
@Getter
public class StrengthTraining extends Training {
    private double weight;
    private int exercisesCount;
    private int sets;
    private int reps;
    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training")
    private Set<StrengthExercise> exercises;

    public StrengthTraining(String user, LocalDate date, String title, Duration duration, double weight, int exercisesCount, int sets, int reps, Set<StrengthExercise> exercises) {
        super(date, title, duration, user);
        this.weight = weight;
        this.exercisesCount = exercisesCount;
        this.sets = sets;
        this.reps = reps;
        this.exercises = exercises;
    }
}