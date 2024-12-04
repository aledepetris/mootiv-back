INSERT INTO exercise_type (id, name) VALUES
    (1, 'Fullbody'),
    (2, 'Push'),
    (3, 'Pull'),
    (4, 'Torso'),
    (5, 'Pierna'),
    (6, 'Musculo Aislado'),
    (7, 'Cardio');

-- Ajustar la secuencia exercise_type_id_seq al último ID
ALTER SEQUENCE exercise_type_id_seq RESTART WITH 8;