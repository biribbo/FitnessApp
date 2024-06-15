package com.example.FitnessApp.model.exercise;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@DiscriminatorValue("STRENGTH")
@NoArgsConstructor
public class StrengthExercise extends Exercise {
    private Muscle muscle;
    private int rpe;
    private int sets;
    private int reps;
    private float estimatedOneRepMax;

    public StrengthExercise(String name, String equipment, String instructions, Muscle muscle, int RPE, int sets, int reps, float estimatedOneRepMax) {
        super(name, equipment, instructions);
        this.muscle = muscle;
        this.rpe = RPE;
        this.sets = sets;
        this.reps = reps;
        this.estimatedOneRepMax = estimatedOneRepMax;
    }
}