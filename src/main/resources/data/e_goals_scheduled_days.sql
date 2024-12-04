-- Insertar combinaciones de objetivos/metas con días de entrenamiento en la tabla schedule_goal
INSERT INTO schedule_goal (id, day_of_training, goal_id) VALUES
    (1, 2, 1), -- Fuerza y 2 Días
    (2, 3, 1), -- Fuerza y 3 Días
    (3, 4, 1), -- Fuerza y 4 Días
    (4, 4, 2), -- Hipertrofia y 4 Días
    (5, 5, 2), -- Hipertrofia y 5 Días
    (6, 2, 3), -- Bajar Peso y 2 Días
    (7, 3, 3); -- Bajar Peso y 3 Días

-- Ajustar la secuencia de schedule_goal_id al último ID
ALTER SEQUENCE schedule_goal_id_seq RESTART WITH 8;


INSERT INTO schedule_goal_training_types (schedule_goal_id, training_types_id) VALUES
    (1, 1), -- Fuerza y 2 Días -> Fullbody
    (2, 1), -- Fuerza y 3 Días -> Fullbody
    (3, 2), -- Fuerza y 4 Días -> Push-Pull
    (3, 3), -- Fuerza y 4 Días -> Torso-Pierna
    (4, 2), -- Hipertrofia y 4 Días -> Push-Pull
    (4, 3), -- Hipertrofia y 4 Días -> Torso-Pierna
    (5, 4), -- Hipertrofia y 5 Días -> Músculos Aislados
    (6, 1), -- Bajar Peso y 2 Días -> Fullbody
    (7, 5); -- Bajar Peso y 3 Días -> Fullbody-Cardio

