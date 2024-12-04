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
    (25, 'SingleMuscle', 'Glúteo menor'),
    (26, 'SingleMuscle', 'Sóleo'),
    (27, 'SingleMuscle', 'Gastrocnemio'),
    (28, 'SingleMuscle', 'Tibial anterior'),
    (29, 'SingleMuscle', 'Peroneo largo'),
    (30, 'SingleMuscle', 'Peroneo corto'),
    (31, 'SingleMuscle', 'Serrato anterior');

-- Insertar grupos de músculos
INSERT INTO muscle (id, dtype, name) VALUES
    (32, 'MuscleGroup', 'Músculos del brazo'),
    (33, 'MuscleGroup', 'Músculos del hombro'),
    (34, 'MuscleGroup', 'Músculos del pecho'),
    (35, 'MuscleGroup', 'Músculos de la espalda'),
    (36, 'MuscleGroup', 'Músculos del abdomen'),
    (37, 'MuscleGroup', 'Músculos de la pierna'),
    (38, 'MuscleGroup', 'Músculos superiores'),
    (39, 'MuscleGroup', 'Músculos inferiores');

-- Asociaciones entre grupos y músculos individuales
INSERT INTO muscle_muscles (muscle_group_id, muscles_id) VALUES
    (32, 1), -- Músculos del brazo -> Bíceps braquial
    (32, 2), -- Músculos del brazo -> Tríceps braquial
    (32, 3), -- Músculos del brazo -> Braquial anterior
    (33, 4), -- Músculos del hombro -> Deltoides anterior
    (33, 5), -- Músculos del hombro -> Deltoides medio
    (33, 6), -- Músculos del hombro -> Deltoides posterior
    (34, 7), -- Músculos del pecho -> Pectoral mayor
    (34, 8), -- Músculos del pecho -> Pectoral menor
    (35, 9), -- Músculos de la espalda -> Trapecio superior
    (35, 10), -- Músculos de la espalda -> Trapecio medio
    (35, 11), -- Músculos de la espalda -> Trapecio inferior
    (35, 12), -- Músculos de la espalda -> Dorsal ancho
    (35, 13), -- Músculos de la espalda -> Elevador de la escápula
    (35, 14), -- Músculos de la espalda -> Romboides mayor
    (35, 15), -- Músculos de la espalda -> Romboides menor
    (36, 16), -- Músculos del abdomen -> Recto abdominal
    (36, 17), -- Músculos del abdomen -> Oblicuo externo
    (36, 18), -- Músculos del abdomen -> Oblicuo interno
    (36, 19), -- Músculos del abdomen -> Transverso del abdomen
    (37, 21), -- Músculos de la pierna -> Cuádriceps femoral
    (37, 22), -- Músculos de la pierna -> Isquiotibiales
    (37, 23), -- Músculos de la pierna -> Glúteo mayor
    (37, 24), -- Músculos de la pierna -> Glúteo medio
    (37, 25), -- Músculos de la pierna -> Glúteo menor
    (38, 32), -- Músculos superiores -> Músculos del brazo
    (38, 33), -- Músculos superiores -> Músculos del hombro
    (38, 34), -- Músculos superiores -> Músculos del pecho
    (38, 35), -- Músculos superiores -> Músculos de la espalda
    (39, 36), -- Músculos inferiores -> Músculos del abdomen
    (39, 37); -- Músculos inferiores -> Músculos de la pierna

-- Ajustar la secuencia muscle_id_seq al último ID
ALTER SEQUENCE muscle_id_seq RESTART WITH 40;