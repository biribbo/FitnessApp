package com.example.FitnessApp.dto;

import com.example.FitnessApp.model.exercise.Cardio;
import com.example.FitnessApp.model.exercise.CardioExercise;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Getter
@NoArgsConstructor
public class CardioExerciseDTO {
    private int id;
    private String name;
    private String equipment;
    private double distance;
    private Duration duration;
    private double tempo;
    private String type;

    public CardioExercise toModel() {
        return new CardioExercise(name, equipment, distance, duration, tempo, Cardio.valueOf(type));
    }

    public CardioExerciseDTO(CardioExercise source) {
        this.id = source.getId();
        this.name = source.getName();
        this.equipment = source.getEquipment();
        this.distance = source.getDistance();
        this.duration = source.getDuration();
        this.tempo = source.getTempo();
        this.type = source.getType().name().toLowerCase();
    }

    public CardioExerciseDTO(String name, String equipment, double distance, Duration duration, double tempo, String type) {
        this.name = name;
        this.equipment = equipment;
        this.distance = distance;
        this.duration = duration;
        this.tempo = tempo;
        this.type = type;
    }
}