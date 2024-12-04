-- Asociación ejercicios con músculos en la tabla exercise_muscle
INSERT INTO exercise_muscle (exercise_id, muscle_id) VALUES
    (1, 21), -- Sentadilla con Barra -> Cuádriceps femoral
    (1, 23), -- Sentadilla con Barra -> Glúteo mayor
    (2, 21), -- Sentadilla Libre -> Cuádriceps femoral
    (2, 23), -- Sentadilla Libre -> Glúteo mayor
    (3, 22), -- Peso Muerto -> Isquiotibiales
    (3, 23), -- Peso Muerto -> Glúteo mayor
    (4, 7), -- Press de Banca -> Pectoral mayor
    (4, 2), -- Press de Banca -> Tríceps braquial
    (4, 4), -- Press de Banca -> Deltoides anterior
    (5, 4), -- Press Militar -> Deltoides anterior
    (5, 2), -- Press Militar -> Tríceps braquial
    (6, 16), -- Plancha Abdominal -> Recto abdominal
    (6, 19), -- Plancha Abdominal -> Transverso del abdomen
    (7, 12), -- Dominadas -> Dorsal ancho
    (7, 1), -- Dominadas -> Bíceps braquial
    (8, 7), -- Flexiones de Pecho -> Pectoral mayor
    (8, 4), -- Flexiones de Pecho -> Deltoides anterior
    (9, 12), -- Remo con Barra -> Dorsal ancho
    (9, 14), -- Remo con Barra -> Romboides mayor
    (10, 12), -- Remo con Mancuernas -> Dorsal ancho
    (10, 1), -- Remo con Mancuernas -> Bíceps braquial
    (11, 21), -- Sentadilla Búlgara -> Cuádriceps femoral
    (11, 23), -- Sentadilla Búlgara -> Glúteo mayor
    (12, 21), -- Zancadas -> Cuádriceps femoral
    (12, 23), -- Zancadas -> Glúteo mayor
    (13, 21), -- Cuerda para Saltar -> Cuádriceps femoral
    (13, 16), -- Cuerda para Saltar -> Recto abdominal
    (14, 4), -- Press de Hombros con Mancuernas -> Deltoides anterior
    (14, 5), -- Press de Hombros con Mancuernas -> Deltoides medio
    (15, 1), -- Curl de Bíceps con Barra -> Bíceps braquial
    (16, 1), -- Curl de Bíceps con Mancuernas -> Bíceps braquial
    (17, 2), -- Extensiones de Tríceps con Mancuerna -> Tríceps braquial
    (18, 2), -- Press Francés -> Tríceps braquial
    (19, 5), -- Elevaciones Laterales -> Deltoides medio
    (20, 4), -- Elevaciones Frontales -> Deltoides anterior
    (21, 9), -- Remo al Mentón -> Trapecio superior
    (22, 16), -- Mountain Climbers -> Recto abdominal
    (23, 7), -- Press de Pecho Inclinado -> Pectoral mayor
    (23, 2), -- Press de Pecho Inclinado -> Tríceps braquial
    (24, 7), -- Pull Over -> Pectoral mayor
    (24, 12), -- Pull Over -> Dorsal ancho
    (25, 22), -- Peso Muerto Rumano -> Isquiotibiales
    (25, 23), -- Peso Muerto Rumano -> Glúteo mayor
    (26, 21), -- Burpees -> Cuádriceps femoral
    (26, 16), -- Burpees -> Recto abdominal
    (27, 21), -- Sentadilla Frontal -> Cuádriceps femoral
    (27, 23), -- Sentadilla Frontal -> Glúteo mayor
    (28, 21), -- Skipping -> Cuádriceps femoral
    (29, 23), -- Hip Thrust -> Glúteo mayor
    (29, 24), -- Hip Thrust -> Glúteo medio
    (30, 27), -- Gemelos de Pie -> Gastrocnemio
    (31, 27), -- Gemelos Sentado -> Gastrocnemio
    (32, 24), -- Abducción de Cadera -> Glúteo medio
    (33, 23), -- Adducción de Cadera -> Glúteo mayor
    (34, 2), -- Fondos de Tríceps en Paralelas -> Tríceps braquial
    (34, 4), -- Fondos de Tríceps en Paralelas -> Deltoides anterior
    (35, 2), -- Fondos de Tríceps en Banco -> Tríceps braquial
    (36, 12), -- Jalón al Pecho -> Dorsal ancho
    (36, 1), -- Jalón al Pecho -> Bíceps braquial
    (37, 17), -- Pull Apart con Banda -> Oblicuo externo
    (38, 12), -- Pull Down con Banda -> Dorsal ancho
    (39, 17), -- Rotación de Tronco con Banda -> Oblicuo externo
    (40, 16), -- Plancha Lateral -> Recto abdominal
    (41, 2), -- Patada de Tríceps -> Tríceps braquial
    (42, 23), -- Swing con Kettlebell -> Glúteo mayor
    (43, 7), -- Press Inclinado con Mancuernas -> Pectoral mayor
    (44, 7), -- Press de Pecho Declinado -> Pectoral mayor
    (45, 21), -- Sprint en Cinta -> Cuádriceps femoral
    (46, 21), -- Escaladora -> Cuádriceps femoral
    (47, 12), -- Remo en Máquina -> Dorsal ancho
    (48, 21), -- Sentadilla Hack -> Cuádriceps femoral
    (49, 21), -- Press de Piernas -> Cuádriceps femoral
    (50, 12), -- Remo en Máquina Unilateral -> Dorsal ancho
    (51, 16), -- Shadow Boxing -> Recto abdominal
    (51, 4), -- Shadow Boxing -> Deltoides anterior
    (52, 16), -- Russian Twist -> Recto abdominal
    (52, 17), -- Russian Twist -> Oblicuo externo
    (53, 16), -- Elevación de Piernas -> Recto abdominal
    (53, 19), -- Elevación de Piernas -> Transverso del abdomen
    (54, 12), -- Battle Rope -> Dorsal ancho
    (54, 21), -- Battle Rope -> Cuádriceps femoral
    (55, 12), -- Dominadas con Peso -> Dorsal ancho
    (55, 1), -- Dominadas con Peso -> Bíceps braquial
    (56, 16), -- Escalador Cruzado -> Recto abdominal
    (56, 17), -- Escalador Cruzado -> Oblicuo externo
    (57, 16), -- Ab Wheel Rollout -> Recto abdominal
    (57, 19), -- Ab Wheel Rollout -> Transverso del abdomen
    (58, 21), -- Skipping con Banda -> Cuádriceps femoral
    (59, 7), -- Press Inclinado con Barra -> Pectoral mayor
    (59, 4), -- Press Inclinado con Barra -> Deltoides anterior
    (60, 21), -- Ciclismo Estático -> Cuádriceps femoral
    (61, 12), -- Remo con Kettlebell -> Dorsal ancho
    (61, 1), -- Remo con Kettlebell -> Bíceps braquial
    (62, 21), -- Sprints en el Lugar -> Cuádriceps femoral
    (62, 16), -- Sprints en el Lugar -> Recto abdominal
    (63, 21), -- Sentadilla Overhead -> Cuádriceps femoral
    (63, 23), -- Sentadilla Overhead -> Glúteo mayor
    (64, 7), -- Pullover con Kettlebell -> Pectoral mayor
    (64, 12), -- Pullover con Kettlebell -> Dorsal ancho
    (65, 12), -- Golpes con Saco de Boxeo -> Dorsal ancho
    (65, 4), -- Golpes con Saco de Boxeo -> Deltoides anterior
    (66, 23), -- Patada de Glúteo -> Glúteo mayor
    (67, 22), -- Peso Muerto con Kettlebell -> Isquiotibiales
    (67, 23), -- Peso Muerto con Kettlebell -> Glúteo mayor
    (68, 21), -- Burpees con Saltos Laterales -> Cuádriceps femoral
    (68, 16), -- Burpees con Saltos Laterales -> Recto abdominal
    (69, 12), -- Remo en Polea Baja -> Dorsal ancho
    (69, 1), -- Remo en Polea Baja -> Bíceps braquial
    (70, 4), -- Press Militar con Mancuernas -> Deltoides anterior
    (70, 2), -- Press Militar con Mancuernas -> Tríceps braquial
    (71, 21), -- Jumping Jacks -> Cuádriceps femoral
    (71, 16), -- Jumping Jacks -> Recto abdominal
    (72, 12), -- Remo Unilateral con Mancuerna -> Dorsal ancho
    (72, 1), -- Remo Unilateral con Mancuerna -> Bíceps braquial
    (73, 7), -- Flexiones con Elevación de Piernas -> Pectoral mayor
    (73, 4), -- Flexiones con Elevación de Piernas -> Deltoides anterior
    (74, 12), -- Dominadas en Anillas -> Dorsal ancho
    (74, 1), -- Dominadas en Anillas -> Bíceps braquial
    (75, 21), -- Ski Erg -> Cuádriceps femoral
    (76, 21), -- Zancadas con Peso -> Cuádriceps femoral
    (76, 23), -- Zancadas con Peso -> Glúteo mayor
    (77, 21), -- Step Ups -> Cuádriceps femoral
    (77, 23), -- Step Ups -> Glúteo mayor
    (78, 12), -- Battle Rope con Saltos -> Dorsal ancho
    (78, 21), -- Battle Rope con Saltos -> Cuádriceps femoral
    (79, 21), -- Prensa de Piernas Unilateral -> Cuádriceps femoral
    (79, 23), -- Prensa de Piernas Unilateral -> Glúteo mayor
    (80, 21), -- Sentadilla con Pesas Rusas -> Cuádriceps femoral
    (80, 23), -- Sentadilla con Pesas Rusas -> Glúteo mayor
    (81, 21), -- Sprint en Bicicleta Estática -> Cuádriceps femoral
    (81, 16), -- Sprint en Bicicleta Estática -> Recto abdominal
    (82, 7), -- Press de Pecho en Máquina -> Pectoral mayor
    (83, 1), -- Curl de Bíceps Martillo -> Bíceps braquial
    (83, 3), -- Curl de Bíceps Martillo -> Braquial anterior
    (84, 16), -- Rotaciones de Cadera -> Recto abdominal
    (84, 17), -- Rotaciones de Cadera -> Oblicuo externo
    (85, 21), -- Jump Squats -> Cuádriceps femoral
    (85, 23), -- Jump Squats -> Glúteo mayor
    (86, 2), -- Fondos de Tríceps en Paralelas con Peso -> Tríceps braquial
    (86, 4), -- Fondos de Tríceps en Paralelas con Peso -> Deltoides anterior
    (87, 23), -- Elevaciones de Cadera con Kettlebell -> Glúteo mayor
    (87, 24), -- Elevaciones de Cadera con Kettlebell -> Glúteo medio
    (88, 22), -- Peso Muerto con Bandas -> Isquiotibiales
    (88, 23), -- Peso Muerto con Bandas -> Glúteo mayor
    (89, 4), -- Press Arnold -> Deltoides anterior
    (89, 5), -- Press Arnold -> Deltoides medio
    (90, 5), -- Elevaciones Posteriores de Hombros -> Deltoides medio
    (90, 6), -- Elevaciones Posteriores de Hombros -> Deltoides posterior
    (91, 21), -- Sentadilla Zercher -> Cuádriceps femoral
    (91, 23), -- Sentadilla Zercher -> Glúteo mayor
    (92, 17), -- Pull Apart con Banda -> Oblicuo externo
    (93, 21), -- Salto a la Caja -> Cuádriceps femoral
    (93, 23), -- Salto a la Caja -> Glúteo mayor
    (94, 20), -- Good Morning -> Erector de la columna
    (95, 16), -- Lanzamiento de Balón Medicinal -> Recto abdominal
    (95, 17), -- Lanzamiento de Balón Medicinal -> Oblicuo externo
    (96, 1), -- Curl Concentrado -> Bíceps braquial
    (97, 21), -- Salto en Escalera -> Cuádriceps femoral
    (98, 16), -- Rodillo Abdominal -> Recto abdominal
    (98, 19), -- Rodillo Abdominal -> Transverso del abdomen
    (99, 12), -- Remo Gironda con Barra -> Dorsal ancho
    (99, 1), -- Remo Gironda con Barra -> Bíceps braquial
    (100, 17), -- Rotaciones con Polea -> Oblicuo externo
    (101, 16), -- Plank Shoulder Taps -> Recto abdominal
    (101, 4), -- Plank Shoulder Taps -> Deltoides anterior
    (102, 21), -- Sentadilla Pistol -> Cuádriceps femoral
    (102, 23), -- Sentadilla Pistol -> Glúteo mayor
    (103, 16), -- Tijeras Abdominales -> Recto abdominal
    (103, 19), -- Tijeras Abdominales -> Transverso del abdomen
    (104, 4), -- Boxing Combos -> Deltoides anterior
    (104, 7), -- Boxing Combos -> Pectoral mayor
    (105, 21), -- Salto de Lado a Lado -> Cuádriceps femoral
    (105, 16), -- Salto de Lado a Lado -> Recto abdominal
    (106, 16), -- Caminata del Oso -> Recto abdominal
    (106, 19), -- Caminata del Oso -> Transverso del abdomen
    (107, 24), -- Step Lateral con Banda -> Glúteo medio
    (107, 23), -- Step Lateral con Banda -> Glúteo mayor
    (108, 4), -- Punch con Banda -> Deltoides anterior
    (108, 7), -- Punch con Banda -> Pectoral mayor
    (109, 4), -- Press de Hombros en Máquina -> Deltoides anterior
    (109, 5), -- Press de Hombros en Máquina -> Deltoides medio
    (110, 21), -- Saltos con Rodillas al Pecho -> Cuádriceps femoral
    (111, 22), -- Peso Muerto Sumo -> Isquiotibiales
    (111, 23), -- Peso Muerto Sumo -> Glúteo mayor
    (112, 16), -- Rotaciones Rusas con Balón Medicinal -> Recto abdominal
    (112, 17), -- Rotaciones Rusas con Balón Medicinal -> Oblicuo externo
    (113, 21), -- Saltos Estrella -> Cuádriceps femoral
    (113, 16), -- Saltos Estrella -> Recto abdominal
    (114, 16), -- Crawl de Dragón -> Recto abdominal
    (114, 19), -- Crawl de Dragón -> Transverso del abdomen
    (115, 7), -- Press Declinado con Mancuernas -> Pectoral mayor
    (115, 2), -- Press Declinado con Mancuernas -> Tríceps braquial
    (116, 24), -- Estocadas Laterales con Mancuerna -> Glúteo medio
    (116, 21), -- Estocadas Laterales con Mancuerna -> Cuádriceps femoral
    (117, 23), -- Elevaciones de Piernas con Banda -> Glúteo mayor
    (117, 24), -- Elevaciones de Piernas con Banda -> Glúteo medio
    (118, 12), -- Battle Rope Alternado -> Dorsal ancho
    (118, 21), -- Battle Rope Alternado -> Cuádriceps femoral
    (119, 16), -- Golpe con Balón Medicinal -> Recto abdominal
    (119, 17), -- Golpe con Balón Medicinal -> Oblicuo externo
    (120, 7), -- Press de Pecho con Pesas Rusas -> Pectoral mayor
    (120, 2), -- Press de Pecho con Pesas Rusas -> Tríceps braquial
    (121, 12), -- Caminata con Peso -> Dorsal ancho
    (121, 1), -- Caminata con Peso -> Bíceps braquial
    (122, 21), -- Sentadilla Zercher con Barra -> Cuádriceps femoral
    (122, 23), -- Sentadilla Zercher con Barra -> Glúteo mayor
    (123, 24), -- Patada Lateral con Banda -> Glúteo medio
    (123, 23), -- Patada Lateral con Banda -> Glúteo mayor
    (124, 2), -- Fondos en Anillas -> Tríceps braquial
    (124, 4), -- Fondos en Anillas -> Deltoides anterior
    (125, 16), -- Crunch Abdominal con Banda -> Recto abdominal
    (125, 19), -- Crunch Abdominal con Banda -> Transverso del abdomen
    (126, 22), -- Peso Muerto Convencional -> Isquiotibiales
    (126, 23), -- Peso Muerto Convencional -> Glúteo mayor
    (127, 21), -- Sprint con Resistencia -> Cuádriceps femoral
    (127, 16), -- Sprint con Resistencia -> Recto abdominal
    (128, 16), -- Mountain Climbers con Banda -> Recto abdominal
    (128, 17), -- Mountain Climbers con Banda -> Oblicuo externo
    (129, 23), -- Swing Ruso con Pesas Rusas -> Glúteo mayor
    (129, 24), -- Swing Ruso con Pesas Rusas -> Glúteo medio
    (130, 16), -- Escalador con Rotación -> Recto abdominal
    (130, 17), -- Escalador con Rotación -> Oblicuo externo
    (131, 12), -- Remo con Polea Alta -> Dorsal ancho
    (131, 1), -- Remo con Polea Alta -> Bíceps braquial
    (132, 16), -- Crawl del Cocodrilo -> Recto abdominal
    (132, 19), -- Crawl del Cocodrilo -> Transverso del abdomen
    (133, 20), -- Good Morning con Banda -> Erector de la columna
    (134, 4), -- Press de Hombros Unilateral -> Deltoides anterior
    (134, 5), -- Press de Hombros Unilateral -> Deltoides medio
    (135, 16), -- Rotación de Tronco con Disco -> Recto abdominal
    (135, 17), -- Rotación de Tronco con Disco -> Oblicuo externo
    (136, 12), -- Golpes Explosivos al Saco -> Dorsal ancho
    (136, 4), -- Golpes Explosivos al Saco -> Deltoides anterior
    (137, 12), -- Battle Rope Saltando Lateralmente -> Dorsal ancho
    (137, 21), -- Battle Rope Saltando Lateralmente -> Cuádriceps femoral
    (138, 21), -- Step Back con Mancuerna -> Cuádriceps femoral
    (138, 23), -- Step Back con Mancuerna -> Glúteo mayor
    (139, 1), -- Curl con Bandas Elásticas -> Bíceps braquial
    (139, 3), -- Curl con Bandas Elásticas -> Braquial anterior
    (140, 21), -- Burpees Explosivos -> Cuádriceps femoral
    (140, 16), -- Burpees Explosivos -> Recto abdominal
    (141, 21), -- Sentadilla con Chaleco Lastrado -> Cuádriceps femoral
    (141, 23), -- Sentadilla con Chaleco Lastrado -> Glúteo mayor
    (142, 21), -- Sprint con Trineo -> Cuádriceps femoral
    (142, 16), -- Sprint con Trineo -> Recto abdominal
    (143, 7), -- Press de Pecho en Cross Over -> Pectoral mayor
    (144, 12), -- Remo con Disco -> Dorsal ancho
    (144, 14), -- Remo con Disco -> Romboides mayor
    (145, 21), -- Carrera en Escalera -> Cuádriceps femoral
    (145, 16), -- Carrera en Escalera -> Recto abdominal
    (146, 12), -- Jalón al Pecho con Banda -> Dorsal ancho
    (147, 21), -- Extensiones de Pierna en Máquina -> Cuádriceps femoral
    (148, 21), -- Sentadilla Frontal con Mancuerna -> Cuádriceps femoral
    (148, 23), -- Sentadilla Frontal con Mancuerna -> Glúteo mayor
    (149, 23), -- Slam con Disco de Goma -> Glúteo mayor
    (149, 16), -- Slam con Disco de Goma -> Recto abdominal
    (150, 21); -- Cuerda para Saltar Doble -> Cuádriceps femoral