DELETE FROM exercise;

DROP TABLE IF EXISTS training_exercises;

ALTER TABLE exercise
    ADD COLUMN training_id INT NULL;

ALTER TABLE exercise
    ADD CONSTRAINT fk_training
        FOREIGN KEY (training_id)
            REFERENCES training (id)
            ON DELETE CASCADE;