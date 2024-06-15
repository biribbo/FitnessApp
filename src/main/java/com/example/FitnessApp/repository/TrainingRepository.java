package com.example.FitnessApp.repository;

import com.example.FitnessApp.model.training.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
    @Override
    @NonNull
    <S extends Training> S save(@NonNull S entity);

    @Override
    @NonNull
    List<Training> findAll();

    @Override
    @NonNull
    Optional<Training> findById(@NonNull Integer id);
}
