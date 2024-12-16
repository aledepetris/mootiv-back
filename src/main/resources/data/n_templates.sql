INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (1, 1, 12, 60, 3, 50.0, 'Manten la forma correcta');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (23, 2, 10, 90, 4, 70.0, 'Concentrate en la profundidad');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (45, 3, 8, 120, 5, 100.0, 'Usa un acompañante para seguridad');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (78, 4, 15, 60, 2, 30.0, 'Serie de calentamiento');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (34, 5, 6, 150, 4, 110.0, 'Manten la espalda recta');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (90, 6, 8, 90, 3, 80.0, 'Aumenta el peso si es posible');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (12, 7, 10, 60, 4, 55.0, 'Controla la velocidad del movimiento');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (67, 8, 5, 180, 5, 120.0, 'Esfuerzo maximo en esta serie');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (89, 9, 15, 45, 2, 25.0, 'Enfocate en la respiracion');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (54, 10, 12, 75, 3, 60.0, 'Manten una postura adecuada');

ALTER SEQUENCE exercise_routine_id_seq RESTART WITH 11;

-- Plantilla 1: Entrenamiento de Calentamiento con Planchas
INSERT INTO template_exercises (creation_date, id, "name", description)
VALUES ('2024-06-16', 1, 'Calentamiento con Planchas', 'Rutina de calentamiento enfocada en planchas para activar el core y los brazos.');

-- Plantilla 2: Entrenamiento de Calentamiento Basico
INSERT INTO template_exercises (creation_date, id, "name", description)
VALUES ('2024-06-16', 2, 'Calentamiento Basico', 'Ejercicios basicos para preparar el cuerpo antes del entrenamiento principal.');

ALTER SEQUENCE template_exercises_seq RESTART WITH 53;

-- Rutina 1
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (1, 1);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (2, 1);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (3, 1);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (4, 1);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (5, 1);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (6, 1);

-- Rutina 2
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (7, 2);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (8, 2);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (9, 2);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (10, 2);
