-- Insertar músculos individuales
INSERT INTO muscle (id, dtype, name) VALUES
    (1, 'SingleMuscle', 'Bíceps braquial'),
    (2, 'SingleMuscle', 'Tríceps braquial'),
    (3, 'SingleMuscle', 'Braquial anterior'),
    (4, 'SingleMuscle', 'Deltoides anterior'),
    (5, 'SingleMuscle', 'Deltoides medio'),
    (6, 'SingleMuscle', 'Deltoides posterior'),
    (7, 'SingleMuscle', 'Pectoral mayor'),
    (8, 'SingleMuscle', 'Pectoral menor'),
    (9, 'SingleMuscle', 'Trapecio superior'),
    (10, 'SingleMuscle', 'Trapecio medio'),
    (11, 'SingleMuscle', 'Trapecio inferior'),
    (12, 'SingleMuscle', 'Dorsal ancho'),
    (13, 'SingleMuscle', 'Elevador de la escápula'),
    (14, 'SingleMuscle', 'Romboides mayor'),
    (15, 'SingleMuscle', 'Romboides menor'),
    (16, 'SingleMuscle', 'Recto abdominal'),
    (17, 'SingleMuscle', 'Oblicuo externo'),
    (18, 'SingleMuscle', 'Oblicuo interno'),
    (19, 'SingleMuscle', 'Transverso del abdomen'),
    (20, 'SingleMuscle', 'Erector de la columna'),
    (21, 'SingleMuscle', 'Cuádriceps femoral'),
    (22, 'SingleMuscle', 'Isquiotibiales'),
    (23, 'SingleMuscle', 'Glúteo mayor'),
    (24, 'SingleMuscle', 'Glúteo medio'),
    (25, 'SingleMuscle', 'Glúteo menor');

-- Insertar grupos de músculos
INSERT INTO muscle (id, dtype, name) VALUES
    (26, 'MuscleGroup', 'Músculos del brazo'),
    (27, 'MuscleGroup', 'Músculos del hombro'),
    (28, 'MuscleGroup', 'Músculos del pecho'),
    (29, 'MuscleGroup', 'Músculos de la espalda'),
    (30, 'MuscleGroup', 'Músculos del abdomen'),
    (31, 'MuscleGroup', 'Músculos de la pierna'),
    (32, 'MuscleGroup', 'Músculos superiores'),
    (33, 'MuscleGroup', 'Músculos inferiores');

-- Asociaciones entre grupos y músculos individuales
INSERT INTO muscle_muscles (muscle_group_id, muscles_id) VALUES
    (26, 1), -- Músculos del brazo -> Bíceps braquial
    (26, 2), -- Músculos del brazo -> Tríceps braquial
    (26, 3), -- Músculos del brazo -> Braquial anterior
    (27, 4), -- Músculos del hombro -> Deltoides anterior
    (27, 5), -- Músculos del hombro -> Deltoides medio
    (27, 6), -- Músculos del hombro -> Deltoides posterior
    (28, 7), -- Músculos del pecho -> Pectoral mayor
    (28, 8), -- Músculos del pecho -> Pectoral menor
    (29, 9), -- Músculos de la espalda -> Trapecio superior
    (29, 10), -- Músculos de la espalda -> Trapecio medio
    (29, 11), -- Músculos de la espalda -> Trapecio inferior
    (29, 12), -- Músculos de la espalda -> Dorsal ancho
    (29, 13), -- Músculos de la espalda -> Elevador de la escápula
    (29, 14), -- Músculos de la espalda -> Romboides mayor
    (29, 15), -- Músculos de la espalda -> Romboides menor
    (29, 20), -- Músculos de la espalda -> Erector de la columna
    (30, 16), -- Músculos del abdomen -> Recto abdominal
    (30, 17), -- Músculos del abdomen -> Oblicuo externo
    (30, 18), -- Músculos del abdomen -> Oblicuo interno
    (30, 19), -- Músculos del abdomen -> Transverso del abdomen
    (31, 21), -- Músculos de la pierna -> Cuádriceps femoral
    (31, 22), -- Músculos de la pierna -> Isquiotibiales
    (31, 23), -- Músculos de la pierna -> Glúteo mayor
    (31, 24), -- Músculos de la pierna -> Glúteo medio
    (31, 25), -- Músculos de la pierna -> Glúteo menor
    (32, 26), -- Músculos superiores -> Músculos del brazo
    (32, 27), -- Músculos superiores -> Músculos del hombro
    (32, 28), -- Músculos superiores -> Músculos del pecho
    (32, 29), -- Músculos superiores -> Músculos de la espalda
    (33, 30), -- Músculos inferiores -> Músculos del abdomen
    (33, 31); -- Músculos inferiores -> Músculos de la pierna

-- Ajustar la secuencia muscle_id_seq al último ID
ALTER SEQUENCE muscle_id_seq RESTART WITH 34;