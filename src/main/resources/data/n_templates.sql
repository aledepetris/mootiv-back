INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (1, 1, 12, 60, 3, 50.0, 'Mantén la forma correcta');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (23, 2, 10, 90, 4, 70.0, 'Concéntrate en la profundidad');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (45, 3, 8, 120, 5, 100.0, 'Usa un acompañante para seguridad');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (78, 4, 15, 60, 2, 30.0, 'Serie de calentamiento');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (34, 5, 6, 150, 4, 110.0, 'Mantén la espalda recta');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (90, 6, 8, 90, 3, 80.0, 'Aumenta el peso si es posible');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (12, 7, 10, 60, 4, 55.0, 'Controla la velocidad del movimiento');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (67, 8, 5, 180, 5, 120.0, 'Esfuerzo máximo en esta serie');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (89, 9, 15, 45, 2, 25.0, 'Enfócate en la respiración');

INSERT INTO exercise_routine (exercise_id, id, repetitions, rest, "sets", weight, notes)
VALUES (54, 10, 12, 75, 3, 60.0, 'Mantén una postura adecuada');

ALTER SEQUENCE exercise_routine_id_seq RESTART WITH 11;


INSERT INTO template_exercises (creation_date, id, "name")
VALUES ('2024-06-16', 1, 'Rutina Fuerza Inicial');

INSERT INTO template_exercises (creation_date, id, "name")
VALUES ('2024-06-16', 2, 'Rutina Hipertrofia Básica');

INSERT INTO template_exercises (creation_date, id, "name")
VALUES ('2024-06-16', 3, 'Rutina Resistencia');

INSERT INTO template_exercises (creation_date, id, "name")
VALUES ('2024-06-16', 4, 'Rutina Avanzada Fuerza');

INSERT INTO template_exercises (creation_date, id, "name")
VALUES ('2024-06-16', 5, 'Rutina Full Body');

-- Rutina Fuerza Inicial
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (1, 1);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (2, 1);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (3, 1);

-- Rutina Hipertrofia Básica
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (4, 2);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (5, 2);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (6, 2);

-- Rutina Resistencia
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (7, 3);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (8, 3);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (9, 3);

-- Rutina Avanzada Fuerza
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (10, 4);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (9, 4);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (8, 4);

-- Rutina Full Body
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (7, 5);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (6, 5);
INSERT INTO template_exercises_exercises (exercises_id, template_exercises_id)
VALUES (5, 5);
