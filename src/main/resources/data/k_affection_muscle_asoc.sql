-- Relacionar afecciones con músculos afectados en la tabla affection_muscles_affected
INSERT INTO affection_muscles_affected (affection_id, muscles_affected_id) VALUES
    -- Dolencias relacionadas con brazos
    (1, 1), -- Dolor-Molestia en Brazo Derecho -> Bíceps braquial
    (1, 2), -- Dolor-Molestia en Brazo Derecho -> Tríceps braquial
    (2, 1), -- Dolor-Molestia en Brazo Izquierdo -> Bíceps braquial
    (2, 2), -- Dolor-Molestia en Brazo Izquierdo -> Tríceps braquial

    -- Dolencias relacionadas con hombros
    (3, 4), -- Dolor-Molestia en Hombro Derecho -> Deltoides anterior
    (3, 5), -- Dolor-Molestia en Hombro Derecho -> Deltoides medio
    (4, 4), -- Dolor-Molestia en Hombro Izquierdo -> Deltoides anterior
    (4, 5), -- Dolor-Molestia en Hombro Izquierdo -> Deltoides medio
    (5, 4), -- Tendinitis de Hombro -> Deltoides anterior
    (5, 6), -- Tendinitis de Hombro -> Deltoides posterior
    (6, 4), -- Luxación de Hombro -> Deltoides anterior
    (6, 6), -- Luxación de Hombro -> Deltoides posterior

    -- Dolencias relacionadas con la espalda
    (7, 9), -- Dolor-Molestia Cervical -> Trapecio superior
    (7, 10), -- Dolor-Molestia Cervical -> Trapecio medio
    (8, 12), -- Dolor-Molestia Dorsal -> Dorsal ancho
    (8, 14), -- Dolor-Molestia Dorsal -> Romboides mayor
    (9, 20), -- Dolor-Molestia Lumbar -> Erector de la columna
    (10, 20), -- Hernia de Disco -> Erector de la columna
    (11, 20), -- Escoliosis Severa -> Erector de la columna

    -- Dolencias relacionadas con piernas
    (12, 21), -- Dolor-Molestia en Rodilla Derecha -> Cuádriceps femoral
    (12, 22), -- Dolor-Molestia en Rodilla Derecha -> Isquiotibiales
    (13, 21), -- Dolor-Molestia en Rodilla Izquierda -> Cuádriceps femoral
    (13, 22), -- Dolor-Molestia en Rodilla Izquierda -> Isquiotibiales
    (14, 21), -- Dolor-Molestia en Muslo Derecho -> Cuádriceps femoral
    (14, 22), -- Dolor-Molestia en Muslo Derecho -> Isquiotibiales
    (15, 21), -- Dolor-Molestia en Muslo Izquierdo -> Cuádriceps femoral
    (15, 22), -- Dolor-Molestia en Muslo Izquierdo -> Isquiotibiales
    (16, 23), -- Dolor-Molestia en Cadera -> Glúteo mayor
    (16, 24), -- Dolor-Molestia en Cadera -> Glúteo medio
    (17, 21), -- Bursitis de Rodilla -> Cuádriceps femoral
    (18, 23), -- Artritis de Cadera -> Glúteo mayor
    (18, 24), -- Artritis de Cadera -> Glúteo medio
    (19, 21), -- Lesión del Ligamento Cruzado Anterior (LCA) -> Cuádriceps femoral
    (20, 21), -- Condromalacia Rotuliana -> Cuádriceps femoral
    (20, 22), -- Condromalacia Rotuliana -> Isquiotibiales

    -- Dolencias relacionadas con muñecas y manos
    (21, 3), -- Dolor-Molestia en Muñeca Derecha -> Braquial anterior
    (22, 3), -- Dolor-Molestia en Muñeca Izquierda -> Braquial anterior
    (23, 1), -- Dolor-Molestia en Mano Derecha -> Bíceps braquial
    (24, 1), -- Dolor-Molestia en Mano Izquierda -> Bíceps braquial
    (25, 3), -- Fractura de Muñeca -> Braquial anterior

    -- Dolencias relacionadas con pies y tobillos
    (26, 27), -- Dolor-Molestia en Pie Derecho -> Gastrocnemio
    (27, 27), -- Dolor-Molestia en Pie Izquierdo -> Gastrocnemio
    (28, 28), -- Dolor-Molestia en Tobillo Derecho -> Tibial anterior
    (29, 28), -- Dolor-Molestia en Tobillo Izquierdo -> Tibial anterior
    (30, 27), -- Fascitis Plantar -> Gastrocnemio
    (31, 27), -- Espolón Calcáneo -> Gastrocnemio

    -- Dolencias relacionadas con abdomen
    (32, 16), -- Hernia Umbilical -> Recto abdominal
    (33, 16), -- Hernia Inguinal -> Recto abdominal
    (33, 19); -- Hernia Inguinal -> Transverso del abdomen