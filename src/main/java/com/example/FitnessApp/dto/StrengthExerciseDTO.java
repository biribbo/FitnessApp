package com.example.FitnessApp.dto;

import com.example.FitnessApp.model.exercise.Muscle;
import com.example.FitnessApp.model.exercise.StrengthExercise;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StrengthExerciseDTO {
    private int id;
    private String name;
    private String equipment;
    private String instructions;
    private String muscle;
    private int rpe;
    private int sets;
    private int reps;
    private float estimatedOneRepMax;

    public StrengthExercise toModel() {
        return new StrengthExercise(name, equipment, instructions, Muscle.valueOf(muscle), rpe, sets, reps, estimatedOneRepMax);
    }
    public StrengthExerciseDTO(StrengthExercise source) {
        this.id = source.getId();
        this.name = source.getName();
        this.equipment = source.getEquipment();
        this.instructions = source.getInstructions();
        this.muscle = source.getMuscle().name().toLowerCase();
        this.rpe = source.getRpe();
        this.sets = source.getSets();
        this.reps = source.getReps();
        this.estimatedOneRepMax = source.getEstimatedOneRepMax();
    }

    public StrengthExerciseDTO(String name, String equipment, String instructions, String muscle, int rpe, int sets, int reps, float estimatedOneRepMax) {
        this.name = name;
        this.equipment = equipment;
        this.instructions = instructions;
        this.muscle = muscle;
        this.rpe = rpe;
        this.sets = sets;
        this.reps = reps;
        this.estimatedOneRepMax = estimatedOneRepMax;
    }
}
