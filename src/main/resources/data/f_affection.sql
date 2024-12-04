INSERT INTO affection (id, name, description) VALUES
    -- Dolencias relacionadas con brazos
    (1, 'Dolor-Molestia en Brazo Derecho', 'Molestia o dolor en el brazo derecho que limita ejercicios como curl de bíceps, extensiones de tríceps o levantamientos laterales con ese brazo.'),
    (2, 'Dolor-Molestia en Brazo Izquierdo', 'Molestia o dolor en el brazo izquierdo que limita ejercicios como curl de bíceps, extensiones de tríceps o levantamientos laterales con ese brazo.'),

    -- Dolencias relacionadas con hombros
    (3, 'Dolor-Molestia en Hombro Derecho', 'Molestia o dolor en el hombro derecho que limita ejercicios como press militar, levantamientos laterales y press de banca.'),
    (4, 'Dolor-Molestia en Hombro Izquierdo', 'Molestia o dolor en el hombro izquierdo que limita ejercicios como press militar, levantamientos laterales y press de banca.'),
    (5, 'Tendinitis de Hombro', 'Inflamación de los tendones del manguito rotador, que restringe ejercicios de levantamiento sobre la cabeza como press militar o dominadas.'),
    (6, 'Luxación de Hombro', 'Lesión recurrente que limita ejercicios de empuje como press de banca o press militar.'),

    -- Dolencias relacionadas con la espalda
    (7, 'Dolor-Molestia Cervical', 'Molestia en la zona cervical que limita ejercicios que generan tensión en el cuello, como encogimientos de hombros o remo con barra.'),
    (8, 'Dolor-Molestia Dorsal', 'Molestia en la parte media de la espalda que restringe ejercicios como peso muerto, remo o pull-ups.'),
    (9, 'Dolor-Molestia Lumbar', 'Dolor en la parte baja de la espalda que limita ejercicios como peso muerto, sentadillas profundas o movimientos de torsión.'),
    (10, 'Hernia de Disco', 'Afección de la columna vertebral que puede causar dolor intenso y limitar ejercicios de compresión o movimientos de torsión, como sentadillas pesadas o giros con resistencia.'),
    (11, 'Escoliosis Severa', 'Curvatura anormal de la columna vertebral que puede restringir ejercicios de carga axial como peso muerto o sentadillas pesadas.'),

    -- Dolencias relacionadas con piernas
    (12, 'Dolor-Molestia en Rodilla Derecha', 'Molestia o dolor en la rodilla derecha que restringe ejercicios de impacto o movimientos de flexión profunda, como sentadillas o estocadas.'),
    (13, 'Dolor-Molestia en Rodilla Izquierda', 'Molestia o dolor en la rodilla izquierda que restringe ejercicios de impacto o movimientos de flexión profunda, como sentadillas o estocadas.'),
    (14, 'Dolor-Molestia en Muslo Derecho', 'Molestia o dolor en el muslo derecho que limita ejercicios de fuerza como extensiones de pierna o sentadillas.'),
    (15, 'Dolor-Molestia en Muslo Izquierdo', 'Molestia o dolor en el muslo izquierdo que limita ejercicios de fuerza como extensiones de pierna o sentadillas.'),
    (16, 'Dolor-Molestia en Cadera', 'Molestia o dolor en la cadera que limita ejercicios de flexión profunda, como sentadillas o peso muerto.'),
    (17, 'Bursitis de Rodilla', 'Inflamación de la bursa en la rodilla, que dificulta ejercicios de impacto y movimientos repetitivos como correr o saltos.'),
    (18, 'Artritis de Cadera', 'Inflamación en la articulación de la cadera que limita ejercicios de flexión profunda como sentadillas o estocadas.'),
    (19, 'Lesión del Ligamento Cruzado Anterior (LCA)', 'Daño en la rodilla que limita ejercicios de impacto como correr, saltar o sentadillas profundas.'),
    (20, 'Condromalacia Rotuliana', 'Afección en el cartílago de la rodilla que limita movimientos de flexión profunda, como sentadillas o step-ups.'),

    -- Dolencias relacionadas con muñecas y manos
    (21, 'Dolor-Molestia en Muñeca Derecha', 'Molestia o dolor en la muñeca derecha que restringe ejercicios de soporte de peso en las manos, como flexiones o planchas.'),
    (22, 'Dolor-Molestia en Muñeca Izquierda', 'Molestia o dolor en la muñeca izquierda que restringe ejercicios de soporte de peso en las manos, como flexiones o planchas.'),
    (23, 'Dolor-Molestia en Mano Derecha', 'Molestia o dolor en la mano derecha que limita ejercicios de agarre, como remo con barra o curl de bíceps.'),
    (24, 'Dolor-Molestia en Mano Izquierda', 'Molestia o dolor en la mano izquierda que limita ejercicios de agarre, como remo con barra o curl de bíceps.'),
    (25, 'Fractura de Muñeca', 'Lesión ósea que impide realizar ejercicios que requieren soporte de peso en las manos, como flexiones, planchas o levantamiento de pesas.'),

    -- Dolencias relacionadas con pies y tobillos
    (26, 'Dolor-Molestia en Pie Derecho', 'Molestia o dolor en el pie derecho que limita ejercicios de soporte de peso, como estocadas o saltos.'),
    (27, 'Dolor-Molestia en Pie Izquierdo', 'Molestia o dolor en el pie izquierdo que limita ejercicios de soporte de peso, como estocadas o saltos.'),
    (28, 'Dolor-Molestia en Tobillo Derecho', 'Molestia o dolor en el tobillo derecho que restringe movimientos de impacto como correr o ejercicios pliométricos.'),
    (29, 'Dolor-Molestia en Tobillo Izquierdo', 'Molestia o dolor en el tobillo izquierdo que restringe movimientos de impacto como correr o ejercicios pliométricos.'),
    (30, 'Fascitis Plantar', 'Dolor en la planta del pie que restringe actividades como correr, saltar o ejercicios cardiovasculares de alto impacto.'),
    (31, 'Espolón Calcáneo', 'Dolor en el talón que limita actividades de alto impacto como correr o saltar.'),

    -- Dolencias relacionadas con abdomen
    (32, 'Hernia Umbilical', 'Protrusión del intestino a través del abdomen que limita ejercicios que generan presión intraabdominal, como peso muerto o abdominales.'),
    (33, 'Hernia Inguinal', 'Protrusión en la zona inguinal que limita ejercicios de esfuerzo abdominal o cargas pesadas.');

-- Ajustar la secuencia de affection_id al último ID
ALTER SEQUENCE affection_id_seq RESTART WITH 34;