package com.example.FitnessApp.dto;

import com.example.FitnessApp.model.exercise.Muscle;
import com.example.FitnessApp.model.exercise.StrengthExercise;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class StrengthExerciseDTO {
    private int id;
    private String name;
    private String equipment;
    private String muscle;
    private int rpe;
    private int sets;
    private int reps;
    private double weight;
    @Setter
    private double estimatedOneRepMax;

    public StrengthExercise toModel() {
        return new StrengthExercise(name, equipment, Muscle.valueOf(muscle), rpe, sets, reps, weight, estimatedOneRepMax);
    }

    public StrengthExerciseDTO(StrengthExercise source) {
        this.id = source.getId();
        this.name = source.getName();
        this.equipment = source.getEquipment();
        this.muscle = source.getMuscle().name().toLowerCase();
        this.rpe = source.getRpe();
        this.sets = source.getSets();
        this.reps = source.getReps();
        this.weight = source.getWeight();
        this.estimatedOneRepMax = source.getEstimatedOneRepMax();
    }

    public StrengthExerciseDTO(String name, String equipment, String muscle, int rpe, int sets, int reps, double weight) {
        this.name = name;
        this.equipment = equipment;
        this.muscle = muscle;
        this.rpe = rpe;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }
}
