-- Insertar tipos de entrenamiento en la tabla training_type
INSERT INTO training_type (id, name, description) VALUES
    (1, 'Fullbody', 'Entrenamiento diseñado para trabajar todos los grupos musculares en una sola sesión.'),
    (2, 'Push-Pull', 'Entrenamiento basado en dividir los ejercicios en movimientos de empuje (push) y tracción (pull).'),
    (3, 'Torso-Pierna', 'Entrenamiento que divide las sesiones en ejercicios para el torso y ejercicios para las piernas.'),
    (4, 'Musculo Aislado', 'Entrenamiento enfocado en trabajar un músculo específico por sesión.'),
    (5, 'Fullbody-Cardio', 'Entrenamiento que combina ejercicios de cuerpo completo y ejercicios cardiovasculares.');

-- Insertar relaciones en la tabla training_type_exercise_types con los nombres correctos de las columnas
-- Fullbody -> Ejercicios de tipo Fullbody
INSERT INTO training_type_exercise_types (training_type_id, exercise_types_id) VALUES
    (1, 1); -- Fullbody -> Fullbody

-- Push-Pull -> Ejercicios de tipo Push y Pull
INSERT INTO training_type_exercise_types (training_type_id, exercise_types_id) VALUES
    (2, 2), -- Push-Pull -> Push
    (2, 3); -- Push-Pull -> Pull

-- Torso-Pierna -> Ejercicios de tipo Torso y Pierna
INSERT INTO training_type_exercise_types (training_type_id, exercise_types_id) VALUES
    (3, 4), -- Torso-Pierna -> Torso
    (3, 5); -- Torso-Pierna -> Pierna

-- Músculos Aislados -> Ejercicios del tipo Aislado
INSERT INTO training_type_exercise_types (training_type_id, exercise_types_id) VALUES
    (4, 6); -- Músculos Aislados -> Musculo Aislado

-- Fullbody-Cardio -> Ejercicios de tipo Fullbody y Cardio
INSERT INTO training_type_exercise_types (training_type_id, exercise_types_id) VALUES
    (5, 1), -- Fullbody-Cardio -> Fullbody
    (5, 6); -- Fullbody-Cardio -> Cardio

-- Ajustar la secuencia de training_type_id al último ID
ALTER SEQUENCE training_type_id_seq RESTART WITH 6;