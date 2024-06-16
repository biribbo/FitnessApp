package com.example.FitnessApp.repository;

import com.example.FitnessApp.model.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    @Override
    @NonNull
    <S extends Exercise> S save(@NonNull S entity);

    @Override
    @NonNull
    Optional<Exercise> findById(@NonNull Integer id);
}
