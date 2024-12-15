-- Lugares de entrenamiento para el estudiante con ID 1
INSERT INTO training_place (id, student_id, "name") VALUES (1, 1, 'Casa');
INSERT INTO training_place (id, student_id, "name") VALUES (2, 1, 'Gimnasio Fitness Pro');

-- Lugares de entrenamiento para el estudiante con ID 2
INSERT INTO training_place (id, student_id, "name") VALUES (3, 2, 'Casa');
INSERT INTO training_place (id, student_id, "name") VALUES (4, 2, 'Gimnasio PowerZone');

-- Lugares de entrenamiento para el estudiante con ID 3
INSERT INTO training_place (id, student_id, "name") VALUES (5, 3, 'Casa');
INSERT INTO training_place (id, student_id, "name") VALUES (6, 3, 'Gimnasio BodyTech');

ALTER SEQUENCE training_place_id_seq RESTART WITH 7;

-- Equipamientos para la "Casa" del estudiante con ID 1
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (1, 1);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (9, 1);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (21, 1);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (27, 1);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (29, 1);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (30, 1);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (42, 1);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (51, 1);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (73, 1);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (88, 1);

-- Equipamientos para el "Gimnasio" del estudiante con ID 1
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (1, 2);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (2, 2);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (3, 2);
-- Repetir para todos los equipos del 1 al 100...
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (100, 2);

-- Equipamientos para la "Casa" del estudiante con ID 2
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (1, 3);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (9, 3);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (21, 3);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (27, 3);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (29, 3);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (30, 3);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (42, 3);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (51, 3);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (73, 3);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (88, 3);

-- Equipamientos para el "Gimnasio" del estudiante con ID 2
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (1, 4);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (2, 4);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (3, 4);
-- Repetir para todos los equipos del 1 al 100...
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (100, 4);

-- Equipamientos para la "Casa" del estudiante con ID 3
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (1, 5);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (9, 5);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (21, 5);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (27, 5);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (29, 5);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (30, 5);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (42, 5);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (51, 5);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (73, 5);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (88, 5);

-- Equipamientos para el "Gimnasio" del estudiante con ID 3
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (1, 6);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (2, 6);
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (3, 6);
-- Repetir para todos los equipos del 1 al 100...
INSERT INTO training_place_equipments (equipments_id, training_place_id) VALUES (100, 6);