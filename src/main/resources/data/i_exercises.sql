-- Insertar los primeros 50 ejercicios en la tabla exercise
INSERT INTO exercise (id, is_for_time, is_total, name, description) VALUES
    (1, false, false, 'Sentadilla con Barra', 'Coloca la barra sobre los hombros y flexiona las rodillas bajando lentamente.'),
    (2, false, false, 'Sentadilla Libre', 'Baja lentamente manteniendo la espalda recta y las rodillas alineadas con los pies.'),
    (3, false, false, 'Peso Muerto', 'Levanta la barra desde el suelo manteniendo la espalda recta.'),
    (4, false, false, 'Press de Banca', 'Acostado en un banco, empuja la barra hacia arriba desde el pecho.'),
    (5, false, false, 'Press Militar', 'Levanta la barra por encima de la cabeza mientras estás de pie.'),
    (6, true, true, 'Plancha Abdominal', 'Mantén el cuerpo recto apoyándote en los antebrazos y las puntas de los pies.'),
    (7, false, false, 'Dominadas', 'Agarra la barra y sube el cuerpo hasta que el mentón pase la barra.'),
    (8, false, false, 'Flexiones de Pecho', 'Flexiona y extiende los brazos manteniendo el cuerpo recto.'),
    (9, false, true, 'Remo con Barra', 'Inclina el torso y lleva la barra hacia el abdomen.'),
    (10, false, true, 'Remo con Mancuernas', 'Inclina el torso y lleva las mancuernas hacia el abdomen.'),
    (11, false, false, 'Sentadilla Búlgara', 'Coloca un pie detrás en un banco y realiza sentadillas con la pierna delantera.'),
    (12, false, true, 'Zancadas', 'Da un paso adelante y flexiona ambas rodillas bajando el cuerpo.'),
    (13, true, false, 'Cuerda para Saltar', 'Salta repetidamente sobre la cuerda manteniendo un ritmo constante.'),
    (14, false, false, 'Press de Hombros con Mancuernas', 'Empuja las mancuernas hacia arriba desde los hombros.'),
    (15, false, false, 'Curl de Bíceps con Barra', 'Flexiona los codos para levantar la barra hacia el pecho.'),
    (16, false, true, 'Curl de Bíceps con Mancuernas', 'Flexiona los codos para levantar las mancuernas.'),
    (17, false, false, 'Extensiones de Tríceps con Mancuerna', 'Sujeta una mancuerna con ambas manos y extiende los brazos por encima de la cabeza.'),
    (18, false, false, 'Press Francés', 'Acostado en un banco, baja y sube la barra con un movimiento controlado.'),
    (19, false, true, 'Elevaciones Laterales', 'Levanta las mancuernas hacia los lados hasta que estén al nivel de los hombros.'),
    (20, false, true, 'Elevaciones Frontales', 'Levanta las mancuernas hacia adelante hasta el nivel de los hombros.'),
    (21, false, true, 'Remo al Mentón', 'Sujeta la barra y llévala hasta el nivel del mentón.'),
    (22, true, false, 'Mountain Climbers', 'Desde posición de plancha, alterna llevando las rodillas hacia el pecho rápidamente.'),
    (23, false, false, 'Press de Pecho Inclinado', 'Empuja la barra hacia arriba en un banco inclinado.'),
    (24, false, true, 'Pull Over', 'Acostado en un banco, lleva una mancuerna desde detrás de la cabeza hasta el pecho.'),
    (25, false, false, 'Peso Muerto Rumano', 'Levanta la barra manteniendo las piernas casi rectas y la espalda alineada.'),
    (26, true, false, 'Burpees', 'Desde posición de pie, baja a flexión, salta y vuelve a pie rápidamente.'),
    (27, false, false, 'Sentadilla Frontal', 'Sujeta la barra frente al pecho y realiza la sentadilla.'),
    (28, true, false, 'Skipping', 'Corre en el lugar levantando las rodillas lo más alto posible.'),
    (29, false, false, 'Hip Thrust', 'Apoya la espalda en un banco y empuja la cadera hacia arriba con una barra sobre las caderas.'),
    (30, false, false, 'Gemelos de Pie', 'Levántate sobre las puntas de los pies manteniendo el equilibrio.'),
    (31, false, false, 'Gemelos Sentado', 'Siéntate y levanta el peso sobre las puntas de los pies.'),
    (32, false, false, 'Abducción de Cadera', 'Usa una máquina para abrir las piernas hacia afuera.'),
    (33, false, false, 'Adducción de Cadera', 'Usa una máquina para cerrar las piernas hacia adentro.'),
    (34, false, false, 'Fondos de Tríceps en Paralelas', 'Baja el cuerpo flexionando los codos y sube extendiéndolos.'),
    (35, false, false, 'Fondos de Tríceps en Banco', 'Apoya las manos en un banco y baja el cuerpo flexionando los codos.'),
    (36, false, false, 'Jalón al Pecho', 'Tira de la barra de polea hacia el pecho manteniendo la espalda recta.'),
    (37, false, true, 'Pull Apart con Banda', 'Separa las manos estirando la banda elástica.'),
    (38, false, true, 'Pull Down con Banda', 'Tira de la banda hacia el pecho simulando un jalón.'),
    (39, false, true, 'Rotación de Tronco con Banda', 'Sujeta la banda y gira el torso hacia un lado.'),
    (40, true, false, 'Plancha Lateral', 'Apoya un brazo y un pie manteniendo el cuerpo en línea recta.'),
    (41, false, true, 'Patada de Tríceps', 'Extiende el codo hacia atrás sosteniendo una mancuerna.'),
    (42, false, true, 'Swing con Kettlebell', 'Baja el kettlebell entre las piernas y elévalo hasta el nivel de los hombros.'),
    (43, false, false, 'Press Inclinado con Mancuernas', 'Realiza un press de pecho en un banco inclinado con mancuernas.'),
    (44, false, false, 'Press de Pecho Declinado', 'Realiza un press de pecho en un banco declinado.'),
    (45, true, false, 'Sprint en Cinta', 'Corre a máxima velocidad en la cinta.'),
    (46, true, true, 'Escaladora', 'Simula subir escaleras manteniendo un ritmo constante.'),
    (47, true, false, 'Remo en Máquina', 'Tira del asa hacia el abdomen sentado en la máquina.'),
    (48, false, false, 'Sentadilla Hack', 'Realiza sentadillas usando una máquina Hack Squat.'),
    (49, false, false, 'Press de Piernas', 'Empuja el peso en la máquina de prensa de piernas.'),
    (50, false, false, 'Remo en Máquina Unilateral', 'Tira de las asas hacia el abdomen usando una máquina unilateral.'),
    (51, true, false, 'Shadow Boxing', 'Simula movimientos de boxeo frente a un espejo o en el aire por tiempo determinado.'),
    (52, false, true, 'Russian Twist', 'Siéntate y gira el torso hacia los lados sosteniendo un peso o sin él.'),
    (53, false, true, 'Elevación de Piernas', 'Acostado, eleva las piernas juntas hasta formar un ángulo de 90 grados.'),
    (54, true, false, 'Battle Rope', 'Agita las cuerdas de batalla de forma alterna o simultánea.'),
    (55, false, false, 'Dominadas con Peso', 'Realiza dominadas con peso añadido mediante un cinturón de lastre.'),
    (56, true, true, 'Escalador Cruzado', 'Desde posición de plancha, lleva la rodilla hacia el codo contrario alternando rápidamente.'),
    (57, false, true, 'Ab Wheel Rollout', 'Con una rueda abdominal, rueda hacia adelante manteniendo la espalda recta.'),
    (58, true, false, 'Skipping con Banda', 'Realiza saltos con una banda elástica colocada alrededor de los tobillos.'),
    (59, false, false, 'Press Inclinado con Barra', 'Realiza un press de pecho usando un banco inclinado y una barra.'),
    (60, true, false, 'Ciclismo Estático', 'Pedalea en una bicicleta estática durante un tiempo determinado.'),
    (61, false, false, 'Remo con Kettlebell', 'Inclina el torso y tira del kettlebell hacia el abdomen.'),
    (62, true, false, 'Sprints en el Lugar', 'Corre en el lugar levantando las rodillas rápidamente.'),
    (63, false, false, 'Sentadilla Overhead', 'Sostén la barra por encima de la cabeza mientras realizas una sentadilla.'),
    (64, false, true, 'Pullover con Kettlebell', 'Lleva el kettlebell desde detrás de la cabeza hacia el pecho acostado en un banco.'),
    (65, true, true, 'Golpes con Saco de Boxeo', 'Realiza combinaciones de golpes contra el saco durante un tiempo determinado.'),
    (66, false, true, 'Patada de Glúteo', 'Desde posición de cuatro apoyos, extiende la pierna hacia atrás.'),
    (67, false, false, 'Peso Muerto con Kettlebell', 'Levanta el kettlebell desde el suelo manteniendo la espalda recta.'),
    (68, true, true, 'Burpees con Saltos Laterales', 'Realiza un burpee y salta lateralmente antes de comenzar el siguiente.'),
    (69, true, false, 'Remo en Polea Baja', 'Tira de la polea baja hacia el abdomen sentado en la máquina.'),
    (70, false, false, 'Press Militar con Mancuernas', 'Levanta las mancuernas por encima de la cabeza mientras estás de pie.'),
    (71, true, false, 'Jumping Jacks', 'Abre y cierra los brazos y piernas saltando.'),
    (72, false, false, 'Remo Unilateral con Mancuerna', 'Inclina el torso y tira de una mancuerna hacia el abdomen.'),
    (73, false, true, 'Flexiones con Elevación de Piernas', 'Realiza flexiones levantando una pierna alternadamente.'),
    (74, false, false, 'Dominadas en Anillas', 'Realiza dominadas utilizando anillas de gimnasia.'),
    (75, true, false, 'Ski Erg', 'Simula un movimiento de esquí utilizando un ergómetro.'),
    (76, false, true, 'Zancadas con Peso', 'Realiza zancadas sosteniendo mancuernas o una barra.'),
    (77, false, true, 'Step Ups', 'Sube y baja de una plataforma alternando las piernas.'),
    (78, true, true, 'Battle Rope con Saltos', 'Agita las cuerdas de batalla mientras realizas saltos en el lugar.'),
    (79, false, false, 'Prensa de Piernas Unilateral', 'Empuja el peso en la máquina de prensa de piernas con una pierna.'),
    (80, false, false, 'Sentadilla con Pesas Rusas', 'Realiza sentadillas sosteniendo pesas rusas frente al pecho.'),
    (81, true, false, 'Sprint en Bicicleta Estática', 'Pedalea a máxima velocidad durante un tiempo determinado.'),
    (82, false, false, 'Press de Pecho en Máquina', 'Empuja el peso en una máquina de press de pecho.'),
    (83, false, false, 'Curl de Bíceps Martillo', 'Levanta las mancuernas con agarre neutro hasta los hombros.'),
    (84, false, true, 'Rotaciones de Cadera', 'Sujeta un peso y gira el torso llevando el peso hacia cada lado.'),
    (85, true, true, 'Jump Squats', 'Realiza sentadillas y salta explosivamente al levantarte.'),
    (86, false, true, 'Fondos de Tríceps en Paralelas con Peso', 'Realiza fondos en paralelas añadiendo peso.'),
    (87, false, true, 'Elevaciones de Cadera con Kettlebell', 'Levanta la cadera mientras sostienes un kettlebell sobre ella.'),
    (88, false, false, 'Peso Muerto con Bandas', 'Levanta la barra desde el suelo usando bandas elásticas como resistencia adicional.'),
    (89, false, true, 'Press Arnold', 'Realiza un press de hombros girando las mancuernas mientras las levantas.'),
    (90, false, true, 'Elevaciones Posteriores de Hombros', 'Inclina el torso y levanta las mancuernas hacia atrás.'),
    (91, false, false, 'Sentadilla Zercher', 'Sostén la barra en la curva de los codos y realiza una sentadilla.'),
    (92, false, true, 'Pull Apart con Banda', 'Separa las manos mientras estiras una banda elástica.'),
    (93, true, false, 'Salto a la Caja', 'Salta hacia una caja o plataforma y baja controladamente.'),
    (94, false, false, 'Good Morning', 'Inclina el torso hacia adelante con la barra sobre los hombros.'),
    (95, true, true, 'Lanzamiento de Balón Medicinal', 'Lanza un balón medicinal contra la pared o el suelo.'),
    (96, false, true, 'Curl Concentrado', 'Flexiona el brazo con una mancuerna mientras apoyas el codo en la pierna.'),
    (97, true, true, 'Salto en Escalera', 'Sube y baja rápidamente una escalera o plataforma.'),
    (98, true, true, 'Rodillo Abdominal', 'Usa una rueda abdominal para rodar hacia adelante y regresar.'),
    (99, false, true, 'Remo Gironda con Barra', 'Inclina el torso hacia adelante y tira de la barra hacia el abdomen.'),
    (100, false, true, 'Rotaciones con Polea', 'Gira el torso hacia los lados mientras tiras de una polea lateral.'),
    (101, false, true, 'Plank Shoulder Taps', 'Desde posición de plancha, toca con una mano el hombro opuesto alternadamente.'),
    (102, false, false, 'Sentadilla Pistol', 'Realiza una sentadilla completa con una sola pierna mientras la otra se mantiene extendida al frente.'),
    (103, false, false, 'Tijeras Abdominales', 'Acostado, eleva las piernas alternando un movimiento de tijera.'),
    (104, true, false, 'Boxing Combos', 'Realiza combinaciones de golpes con guantes de boxeo por tiempo determinado.'),
    (105, true, true, 'Salto de Lado a Lado', 'Salta lateralmente de un lado a otro sobre una línea o pequeño obstáculo.'),
    (106, true, false, 'Caminata del Oso', 'Camina a cuatro patas manteniendo las rodillas ligeramente por encima del suelo.'),
    (107, false, true, 'Step Lateral con Banda', 'Realiza pasos laterales con una banda de resistencia alrededor de las piernas.'),
    (108, true, true, 'Punch con Banda', 'Lanza golpes al frente mientras usas una banda elástica como resistencia.'),
    (109, false, true, 'Press de Hombros en Máquina', 'Levanta el peso hacia arriba usando una máquina de hombros.'),
    (110, true, false, 'Saltos con Rodillas al Pecho', 'Salta y lleva las rodillas hacia el pecho lo más alto posible.'),
    (111, false, false, 'Peso Muerto Sumo', 'Coloca los pies en posición amplia y levanta la barra desde el suelo.'),
    (112, false, true, 'Rotaciones Rusas con Balón Medicinal', 'Gira el torso hacia los lados mientras sostienes un balón medicinal.'),
    (113, true, true, 'Saltos Estrella', 'Realiza un salto extendiendo brazos y piernas hacia afuera en forma de estrella.'),
    (114, true, false, 'Crawl de Dragón', 'Camina a cuatro patas cruzando las manos y los pies en movimientos coordinados.'),
    (115, false, false, 'Press Declinado con Mancuernas', 'Realiza un press de pecho en banco declinado con mancuernas.'),
    (116, false, true, 'Estocadas Laterales con Mancuerna', 'Da un paso lateral sosteniendo una mancuerna y flexiona la rodilla de la pierna que pisa.'),
    (117, false, true, 'Elevaciones de Piernas con Banda', 'Desde posición de cuatro apoyos, eleva una pierna usando una banda de resistencia.'),
    (118, true, true, 'Battle Rope Alternado', 'Agita las cuerdas de batalla alternando los brazos rápidamente.'),
    (119, true, true, 'Golpe con Balón Medicinal', 'Golpea un balón medicinal contra el suelo de forma explosiva.'),
    (120, false, false, 'Press de Pecho con Pesas Rusas', 'Realiza un press de pecho usando pesas rusas.'),
    (121, true, false, 'Caminata con Peso', 'Carga un peso y camina una distancia o por tiempo determinado.'),
    (122, false, false, 'Sentadilla Zercher con Barra', 'Sujeta la barra en la curva de los codos mientras realizas una sentadilla.'),
    (123, false, true, 'Patada Lateral con Banda', 'Desde posición lateral, extiende una pierna hacia afuera usando una banda de resistencia.'),
    (124, false, false, 'Fondos en Anillas', 'Realiza fondos apoyándote en anillas suspendidas.'),
    (125, false, true, 'Crunch Abdominal con Banda', 'Realiza crunches mientras tiras de una banda elástica colocada detrás de la cabeza.'),
    (126, false, false, 'Peso Muerto Convencional', 'Levanta la barra desde el suelo manteniendo la espalda recta y los pies a la altura de los hombros.'),
    (127, true, false, 'Sprint con Resistencia', 'Corre a máxima velocidad usando una banda o trineo como resistencia.'),
    (128, true, true, 'Mountain Climbers con Banda', 'Realiza escaladores colocando una banda de resistencia en los pies.'),
    (129, true, true, 'Swing Ruso con Pesas Rusas', 'Lleva las pesas rusas hasta la altura del pecho con un movimiento controlado.'),
    (130, true, true, 'Escalador con Rotación', 'Realiza escaladores llevando las rodillas hacia el codo opuesto.'),
    (131, false, true, 'Remo con Polea Alta', 'Tira de la polea alta hacia el pecho con un agarre estrecho.'),
    (132, true, false, 'Crawl del Cocodrilo', 'Camina a cuatro patas arrastrando un peso.'),
    (133, false, false, 'Good Morning con Banda', 'Inclina el torso hacia adelante con una banda elástica alrededor de los hombros y los pies.'),
    (134, false, true, 'Press de Hombros Unilateral', 'Realiza un press de hombros usando una mancuerna con un brazo a la vez.'),
    (135, false, true, 'Rotación de Tronco con Disco', 'Gira el torso hacia los lados sosteniendo un disco frente al pecho.'),
    (136, true, true, 'Golpes Explosivos al Saco', 'Lanza golpes rápidos y potentes contra un saco de boxeo por tiempo determinado.'),
    (137, true, false, 'Battle Rope Saltando Lateralmente', 'Agita las cuerdas mientras saltas de lado a lado.'),
    (138, false, true, 'Step Back con Mancuerna', 'Da un paso hacia atrás sosteniendo una mancuerna en cada mano.'),
    (139, false, true, 'Curl con Bandas Elásticas', 'Flexiona los brazos usando una banda de resistencia para bíceps.'),
    (140, true, true, 'Burpees Explosivos', 'Realiza burpees añadiendo un salto explosivo al final.'),
    (141, false, false, 'Sentadilla con Chaleco Lastrado', 'Realiza sentadillas usando un chaleco con peso.'),
    (142, true, false, 'Sprint con Trineo', 'Empuja un trineo a máxima velocidad por tiempo determinado.'),
    (143, false, false, 'Press de Pecho en Cross Over', 'Empuja las poleas hacia adelante mientras estás de pie.'),
    (144, false, true, 'Remo con Disco', 'Inclina el torso hacia adelante y tira de un disco hacia el abdomen.'),
    (145, true, false, 'Carrera en Escalera', 'Sube y baja escaleras lo más rápido posible por tiempo determinado.'),
    (146, false, true, 'Jalón al Pecho con Banda', 'Realiza un jalón hacia el pecho usando una banda de resistencia.'),
    (147, false, true, 'Extensiones de Pierna en Máquina', 'Extiende las piernas hacia adelante en la máquina de cuádriceps.'),
    (148, false, false, 'Sentadilla Frontal con Mancuerna', 'Sostén una mancuerna frente al pecho mientras realizas sentadillas.'),
    (149, true, true, 'Slam con Disco de Goma', 'Golpea un disco de goma contra el suelo de forma explosiva.'),
    (150, true, false, 'Cuerda para Saltar Doble', 'Realiza saltos dobles consecutivos con la cuerda de saltar.');

ALTER SEQUENCE exercise_id_seq RESTART WITH 151;

-- Relacionar ejercicios con equipos en la tabla exercise_equipments
INSERT INTO exercise_equipments (exercise_id, equipments_id) VALUES
    (1, 3), -- Sentadilla con Barra -> Barra Recta
    --(2, NULL), -- Sentadilla Libre -> Sin Equipo
    (3, 3), -- Peso Muerto -> Barra Recta
    (4, 5), -- Press de Banca -> Banco Plano
    (4, 3), -- Press de Banca -> Barra Recta
    (5, 3), -- Press Militar -> Barra Recta
    --(6, NULL), -- Plancha Abdominal -> Sin Equipo
    (7, 54), -- Dominadas -> Barra de Dominadas
    --(8, NULL), -- Flexiones de Pecho -> Sin Equipo
    (9, 3), -- Remo con Barra -> Barra Recta
    (10, 9), -- Remo con Mancuernas -> Mancuernas
    (11, 5), -- Sentadilla Búlgara -> Banco Plano
    --(12, NULL), -- Zancadas -> Sin Equipo
    (13, 1), -- Cuerda para Saltar -> Soga de Saltar
    (14, 9), -- Press de Hombros con Mancuernas -> Mancuernas
    (15, 3), -- Curl de Bíceps con Barra -> Barra Recta
    (16, 9), -- Curl de Bíceps con Mancuernas -> Mancuernas
    (17, 9), -- Extensiones de Tríceps con Mancuerna -> Mancuernas
    (18, 3), -- Press Francés -> Barra Recta
    (19, 9), -- Elevaciones Laterales -> Mancuernas
    (20, 9), -- Elevaciones Frontales -> Mancuernas
    (21, 3), -- Remo al Mentón -> Barra Recta
    --(22, NULL), -- Mountain Climbers -> Sin Equipo
    (23, 5), -- Press de Pecho Inclinado -> Banco Inclinado
    (23, 3), -- Press de Pecho Inclinado -> Barra Recta
    (24, 9), -- Pull Over -> Mancuernas
    (25, 3), -- Peso Muerto Rumano -> Barra Recta
    --(26, NULL), -- Burpees -> Sin Equipo
    (27, 3), -- Sentadilla Frontal -> Barra Recta
    --(28, NULL), -- Skipping -> Sin Equipo
    (29, 43), -- Hip Thrust -> Máquina de Hip Thrust
    (30, 31), -- Gemelos de Pie -> Máquina de Gemelos
    (31, 31), -- Gemelos Sentado -> Máquina de Gemelos
    (32, 11), -- Abducción de Cadera -> Máquina de Cuádriceps
    (33, 11), -- Adducción de Cadera -> Máquina de Cuádriceps
    (34, 19), -- Fondos de Tríceps en Paralelas -> Barras Paralelas
    (35, 5), -- Fondos de Tríceps en Banco -> Banco Plano
    (36, 25), -- Jalón al Pecho -> Máquina de Polea Alta
    (37, 22), -- Pull Apart con Banda -> Banda Elástica
    (38, 22), -- Pull Down con Banda -> Banda Elástica
    (39, 22), -- Rotación de Tronco con Banda -> Banda Elástica
    --(40, NULL), -- Plancha Lateral -> Sin Equipo
    (41, 9), -- Patada de Tríceps -> Mancuernas
    (42, 29), -- Swing con Kettlebell -> Kettlebell
    (43, 5), -- Press Inclinado con Mancuernas -> Banco Inclinado
    (43, 9), -- Press Inclinado con Mancuernas -> Mancuernas
    (44, 5), -- Press de Pecho Declinado -> Banco Declinado
    (45, 33), -- Sprint en Cinta -> Cinta de Correr
    (46, 37), -- Escaladora -> Escaladora
    (47, 36), -- Remo en Máquina -> Máquina de Remo
    (48, 56), -- Sentadilla Hack -> Máquina Hack Squat
    (49, 10), -- Press de Piernas -> Máquina de Prensa de Piernas
    (50, 36), -- Remo en Máquina Unilateral -> Máquina de Remo
    --(51, NULL), -- Shadow Boxing -> Sin Equipo
    (52, 9), -- Russian Twist -> Mancuernas
    --(53, NULL), -- Elevación de Piernas -> Sin Equipo
    (54, 24), -- Battle Rope -> Cuerda para Batalla
    (55, 42), -- Dominadas con Peso -> Cinturón de Lastre
    --(56, NULL), -- Escalador Cruzado -> Sin Equipo
    (57, 21), -- Ab Wheel Rollout -> Rueda Abdominal
    (58, 22), -- Skipping con Banda -> Banda Elástica
    (59, 5), -- Press Inclinado con Barra -> Banco Inclinado
    (59, 3), -- Press Inclinado con Barra -> Barra Recta
    (60, 34), -- Ciclismo Estático -> Bicicleta Estática
    (61, 29), -- Remo con Kettlebell -> Kettlebell
    --(62, NULL), -- Sprints en el Lugar -> Sin Equipo
    (63, 3), -- Sentadilla Overhead -> Barra Recta
    (64, 29), -- Pullover con Kettlebell -> Kettlebell
    (65, 32), -- Golpes con Saco de Boxeo -> Saco de Boxeo
    --(66, NULL), -- Patada de Glúteo -> Sin Equipo
    (67, 29), -- Peso Muerto con Kettlebell -> Kettlebell
    --(68, NULL), -- Burpees con Saltos Laterales -> Sin Equipo
    (69, 26), -- Remo en Polea Baja -> Máquina de Polea Baja
    (70, 9), -- Press Militar con Mancuernas -> Mancuernas
    --(71, NULL), -- Jumping Jacks -> Sin Equipo
    (72, 9), -- Remo Unilateral con Mancuerna -> Mancuernas
    --(73, NULL), -- Flexiones con Elevación de Piernas -> Sin Equipo
    (74, 61), -- Dominadas en Anillas -> Anillas de Gimnasia
    (75, 67), -- Ski Erg -> Esquí Ergómetro
    (76, 9), -- Zancadas con Peso -> Mancuernas
    (77, 23), -- Step Ups -> Step Aeróbico
    (78, 24), -- Battle Rope con Saltos -> Cuerda para Batalla
    (79, 10), -- Prensa de Piernas Unilateral -> Máquina de Prensa de Piernas
    (80, 29), -- Sentadilla con Pesas Rusas -> Kettlebell
    (81, 34), -- Sprint en Bicicleta Estática -> Bicicleta Estática
    (82, 15), -- Press de Pecho en Máquina -> Máquina de Press de Pecho
    (83, 9), -- Curl de Bíceps Martillo -> Mancuernas
    (84, 9), -- Rotaciones de Cadera -> Mancuernas
    --(85, NULL), -- Jump Squats -> Sin Equipo
    (86, 42), -- Fondos de Tríceps en Paralelas con Peso -> Cinturón de Lastre
    (87, 29), -- Elevaciones de Cadera con Kettlebell -> Kettlebell
    (88, 3), -- Peso Muerto con Bandas -> Barra Recta
    (88, 22), -- Peso Muerto con Bandas -> Banda Elástica
    (89, 9), -- Press Arnold -> Mancuernas
    (90, 9), -- Elevaciones Posteriores de Hombros -> Mancuernas
    (91, 3), -- Sentadilla Zercher -> Barra Recta
    (92, 22), -- Pull Apart con Banda -> Banda Elástica
    (93, 45), -- Salto a la Caja -> Plataforma de Salto
    (94, 3), -- Good Morning -> Barra Recta
    (95, 70), -- Lanzamiento de Balón Medicinal -> Balón Medicinal
    (96, 9), -- Curl Concentrado -> Mancuernas
    --(97, NULL), -- Salto en Escalera -> Sin Equipo
    (98, 21), -- Rodillo Abdominal -> Rueda Abdominal
    (99, 3), -- Remo Gironda con Barra -> Barra Recta
    (100, 25), -- Rotaciones con Polea -> Máquina de Polea Alta
    --(101, NULL), -- Plank Shoulder Taps -> Sin Equipo
    --(102, NULL), -- Sentadilla Pistol -> Sin Equipo
    --(103, NULL), -- Tijeras Abdominales -> Sin Equipo
    (104, 32), -- Boxing Combos -> Saco de Boxeo
    --(105, NULL), -- Salto de Lado a Lado -> Sin Equipo
    --(106, NULL), -- Caminata del Oso -> Sin Equipo
    (107, 22), -- Step Lateral con Banda -> Banda Elástica
    (108, 22), -- Punch con Banda -> Banda Elástica
    (109, 16), -- Press de Hombros en Máquina -> Máquina de Press de Hombros
    --(110, NULL), -- Saltos con Rodillas al Pecho -> Sin Equipo
    (111, 3), -- Peso Muerto Sumo -> Barra Recta
    (112, 70), -- Rotaciones Rusas con Balón Medicinal -> Balón Medicinal
    --(113, NULL), -- Saltos Estrella -> Sin Equipo
    --(114, NULL), -- Crawl de Dragón -> Sin Equipo
    (115, 5), -- Press Declinado con Mancuernas -> Banco Declinado
    (115, 9), -- Press Declinado con Mancuernas -> Mancuernas
    (116, 9), -- Estocadas Laterales con Mancuerna -> Mancuernas
    (117, 22), -- Elevaciones de Piernas con Banda -> Banda Elástica
    (118, 24), -- Battle Rope Alternado -> Cuerda para Batalla
    (119, 70), -- Golpe con Balón Medicinal -> Balón Medicinal
    (120, 29), -- Press de Pecho con Pesas Rusas -> Pesas Rusas
    (121, 9), -- Caminata con Peso -> Mancuernas
    (122, 3), -- Sentadilla Zercher con Barra -> Barra Recta
    (123, 22), -- Patada Lateral con Banda -> Banda Elástica
    (124, 61), -- Fondos en Anillas -> Anillas de Gimnasia
    (125, 22), -- Crunch Abdominal con Banda -> Banda Elástica
    (126, 3), -- Peso Muerto Convencional -> Barra Recta
    (127, 42), -- Sprint con Resistencia -> Cinturón de Lastre
    (128, 22), -- Mountain Climbers con Banda -> Banda Elástica
    (129, 29), -- Swing Ruso con Pesas Rusas -> Pesas Rusas
    --(130, NULL), -- Escalador con Rotación -> Sin Equipo
    (131, 25), -- Remo con Polea Alta -> Máquina de Polea Alta
    (132, 3), -- Crawl del Cocodrilo -> Barra Recta
    (133, 22), -- Good Morning con Banda -> Banda Elástica
    (134, 9), -- Press de Hombros Unilateral -> Mancuernas
    (135, 41), -- Rotación de Tronco con Disco -> Discos Olímpicos
    (136, 32), -- Golpes Explosivos al Saco -> Saco de Boxeo
    (137, 24), -- Battle Rope Saltando Lateralmente -> Cuerda para Batalla
    (138, 9), -- Step Back con Mancuerna -> Mancuernas
    (139, 22), -- Curl con Bandas Elásticas -> Banda Elástica
    --(140, NULL), -- Burpees Explosivos -> Sin Equipo
    (141, 42), -- Sentadilla con Chaleco Lastrado -> Chaleco Lastrado
    (142, 53), -- Sprint con Trineo -> Trineo de Arrastre
    (143, 62), -- Press de Pecho en Cross Over -> Máquina de Cross Cable
    (144, 41), -- Remo con Disco -> Discos Olímpicos
    --(145, NULL), -- Carrera en Escalera -> Sin Equipo
    (146, 22), -- Jalón al Pecho con Banda -> Banda Elástica
    (147, 11), -- Extensiones de Pierna en Máquina -> Máquina de Cuádriceps
    (148, 9), -- Sentadilla Frontal con Mancuerna -> Mancuernas
    (149, 41), -- Slam con Disco de Goma -> Discos Olímpicos
    (150, 1); -- Cuerda para Saltar Doble -> Soga de Saltar


-- Asociacion ejercicios (1-150) con tipos de ejercicios
INSERT INTO exercise_exercises_type (exercise_id, exercises_type_id) VALUES
    (1, 1), -- Sentadilla con Barra -> Fullbody
    (1, 5), -- Sentadilla con Barra -> Pierna
    (2, 1), -- Sentadilla Libre -> Fullbody
    (2, 5), -- Sentadilla Libre -> Pierna
    (3, 1), -- Peso Muerto -> Fullbody
    (3, 5), -- Peso Muerto -> Pierna
    (4, 2), -- Press de Banca -> Push
    (4, 4), -- Press de Banca -> Torso
    (5, 2), -- Press Militar -> Push
    (5, 4), -- Press Militar -> Torso
    (6, 1), -- Plancha Abdominal -> Fullbody
    (6, 4), -- Plancha Abdominal -> Torso
    (7, 1), -- Dominadas -> Fullbody
    (7, 3), -- Dominadas -> Pull
    (8, 2), -- Flexiones de Pecho -> Push
    (8, 4), -- Flexiones de Pecho -> Torso
    (9, 3), -- Remo con Barra -> Pull
    (10, 3), -- Remo con Mancuernas -> Pull
    (11, 5), -- Sentadilla Búlgara -> Pierna
    (12, 5), -- Zancadas -> Pierna
    (13, 7), -- Cuerda para Saltar -> Cardio
    (13, 4), -- Cuerda para Saltar -> Torso
    (14, 2), -- Press de Hombros con Mancuernas -> Push
    (14, 4), -- Press de Hombros con Mancuernas -> Torso
    (15, 6), -- Curl de Bíceps con Barra -> Músculo Aislado
    (16, 6), -- Curl de Bíceps con Mancuernas -> Músculo Aislado
    (17, 2), -- Extensiones de Tríceps con Mancuerna -> Push
    (17, 6), -- Extensiones de Tríceps con Mancuerna -> Músculo Aislado
    (18, 2), -- Press Francés -> Push
    (19, 6), -- Elevaciones Laterales -> Músculo Aislado
    (19, 4), -- Elevaciones Laterales -> Torso
    (20, 6), -- Elevaciones Frontales -> Músculo Aislado
    (20, 4), -- Elevaciones Frontales -> Torso
    (21, 3), -- Remo al Mentón -> Pull
    (21, 4), -- Remo al Mentón -> Torso
    (22, 7), -- Mountain Climbers -> Cardio
    (22, 4), -- Mountain Climbers -> Torso
    (23, 3), -- Pull Over -> Pull
    (24, 4), -- Pull Over -> Torso
    (25, 5), -- Peso Muerto Rumano -> Pierna
    (26, 1), -- Burpees -> Fullbody
    (26, 7), -- Burpees -> Cardio
    (27, 5), -- Sentadilla Frontal -> Pierna
    (28, 7), -- Skipping -> Cardio
    (29, 5), -- Hip Thrust -> Pierna
    (30, 5), -- Gemelos de Pie -> Pierna
    (31, 5), -- Gemelos Sentado -> Pierna
    (32, 5), -- Abducción de Cadera -> Pierna
    (33, 5), -- Adducción de Cadera -> Pierna
    (34, 6), -- Fondos de Tríceps en Paralelas -> Músculo Aislado
    (34, 2), -- Fondos de Tríceps en Paralelas -> Push
    (35, 6), -- Fondos de Tríceps en Banco -> Músculo Aislado
    (36, 2), -- Jalón al Pecho -> Push
    (36, 3), -- Jalón al Pecho -> Pull
    (37, 4), -- Pull Apart con Banda -> Torso
    (38, 4), -- Pull Down con Banda -> Torso
    (39, 4), -- Rotación de Tronco con Banda -> Torso
    (40, 4), -- Plancha Lateral -> Torso
    (41, 6), -- Patada de Tríceps -> Músculo Aislado
    (42, 1), -- Swing con Kettlebell -> Fullbody
    (43, 2), -- Press Inclinado con Mancuernas -> Push
    (44, 2), -- Press de Pecho Declinado -> Push
    (45, 7), -- Sprint en Cinta -> Cardio
    (46, 7), -- Escaladora -> Cardio
    (47, 3), -- Remo en Máquina -> Pull
    (48, 5), -- Sentadilla Hack -> Pierna
    (49, 5), -- Press de Piernas -> Pierna
    (50, 3), -- Remo en Máquina Unilateral -> Pull
    (51, 7), -- Shadow Boxing -> Cardio
    (52, 4), -- Russian Twist -> Torso
    (53, 4), -- Elevación de Piernas -> Torso
    (54, 1), -- Battle Rope -> Fullbody
    (54, 7), -- Battle Rope -> Cardio
    (55, 1), -- Dominadas con Peso -> Fullbody
    (55, 3), -- Dominadas con Peso -> Pull
    (56, 7), -- Escalador Cruzado -> Cardio
    (56, 4), -- Escalador Cruzado -> Torso
    (57, 4), -- Ab Wheel Rollout -> Torso
    (58, 7), -- Skipping con Banda -> Cardio
    (59, 2), -- Press Inclinado con Barra -> Push
    (60, 7), -- Ciclismo Estático -> Cardio
    (61, 3), -- Remo con Kettlebell -> Pull
    (62, 7), -- Sprints en el Lugar -> Cardio
    (63, 5), -- Sentadilla Overhead -> Pierna
    (64, 3), -- Pullover con Kettlebell -> Pull
    (65, 7), -- Golpes con Saco de Boxeo -> Cardio
    (66, 5), -- Patada de Glúteo -> Pierna
    (67, 5), -- Peso Muerto con Kettlebell -> Pierna
    (68, 1), -- Burpees con Saltos Laterales -> Fullbody
    (68, 7), -- Burpees con Saltos Laterales -> Cardio
    (69, 3), -- Remo en Polea Baja -> Pull
    (70, 2), -- Press Militar con Mancuernas -> Push
    (71, 7), -- Jumping Jacks -> Cardio
    (72, 3), -- Remo Unilateral con Mancuerna -> Pull
    (73, 2), -- Flexiones con Elevación de Piernas -> Push
    (74, 3), -- Dominadas en Anillas -> Pull
    (75, 7), -- Ski Erg -> Cardio+
    (76, 5), -- Zancadas con Peso -> Pierna
    (77, 5), -- Step Ups -> Pierna
    (78, 1), -- Battle Rope con Saltos -> Fullbody
    (78, 7), -- Battle Rope con Saltos -> Cardio
    (79, 5), -- Prensa de Piernas Unilateral -> Pierna
    (80, 5), -- Sentadilla con Pesas Rusas -> Pierna
    (81, 7), -- Sprint en Bicicleta Estática -> Cardio
    (82, 2), -- Press de Pecho en Máquina -> Push
    (83, 6), -- Curl de Bíceps Martillo -> Músculo Aislado
    (84, 4), -- Rotaciones de Cadera -> Torso
    (85, 1), -- Jump Squats -> Fullbody
    (85, 5), -- Jump Squats -> Pierna
    (86, 6), -- Fondos de Tríceps en Paralelas con Peso -> Músculo Aislado
    (86, 2), -- Fondos de Tríceps en Paralelas con Peso -> Push
    (87, 5), -- Elevaciones de Cadera con Kettlebell -> Pierna
    (88, 5), -- Peso Muerto con Bandas -> Pierna
    (89, 4), -- Press Arnold -> Torso
    (89, 6), -- Press Arnold -> Músculo Aislado
    (90, 4), -- Elevaciones Posteriores de Hombros -> Torso
    (90, 6), -- Elevaciones Posteriores de Hombros -> Músculo Aislado
    (91, 5), -- Sentadilla Zercher -> Pierna
    (92, 4), -- Pull Apart con Banda -> Torso
    (93, 7), -- Salto a la Caja -> Cardio
    (93, 5), -- Salto a la Caja -> Pierna
    (94, 4), -- Good Morning -> Torso
    (95, 7), -- Lanzamiento de Balón Medicinal -> Cardio
    (95, 4), -- Lanzamiento de Balón Medicinal -> Torso
    (96, 6), -- Curl Concentrado -> Músculo Aislado
    (97, 7), -- Salto en Escalera -> Cardio
    (97, 5), -- Salto en Escalera -> Pierna
    (98, 4), -- Rodillo Abdominal -> Torso
    (99, 3), -- Remo Gironda con Barra -> Pull
    (100, 4), -- Rotaciones con Polea -> Torso
    (101, 4), -- Plank Shoulder Taps -> Torso
    (102, 5), -- Sentadilla Pistol -> Pierna
    (103, 4), -- Tijeras Abdominales -> Torso
    (104, 7), -- Boxing Combos -> Cardio
    (105, 7), -- Salto de Lado a Lado -> Cardio
    (105, 5), -- Salto de Lado a Lado -> Pierna
    (106, 1), -- Caminata del Oso -> Fullbody
    (107, 5), -- Step Lateral con Banda -> Pierna
    (108, 7), -- Punch con Banda -> Cardio
    (109, 2), -- Press de Hombros en Máquina -> Push
    (110, 7), -- Saltos con Rodillas al Pecho -> Cardio
    (111, 5), -- Peso Muerto Sumo -> Pierna
    (112, 4), -- Rotaciones Rusas con Balón Medicinal -> Torso
    (113, 7), -- Saltos Estrella -> Cardio
    (114, 1), -- Crawl de Dragón -> Fullbody
    (115, 2), -- Press Declinado con Mancuernas -> Push
    (116, 5), -- Estocadas Laterales con Mancuerna -> Pierna
    (117, 5), -- Elevaciones de Piernas con Banda -> Pierna
    (118, 1), -- Battle Rope Alternado -> Fullbody
    (118, 7), -- Battle Rope Alternado -> Cardio
    (119, 7), -- Golpe con Balón Medicinal -> Cardio
    (119, 4), -- Golpe con Balón Medicinal -> Torso
    (120, 2), -- Press de Pecho con Pesas Rusas -> Push
    (121, 1), -- Caminata con Peso -> Fullbody
    (122, 5), -- Sentadilla Zercher con Barra -> Pierna
    (123, 5), -- Patada Lateral con Banda -> Pierna
    (124, 6), -- Fondos en Anillas -> Músculo Aislado
    (124, 2), -- Fondos en Anillas -> Push
    (125, 4), -- Crunch Abdominal con Banda -> Torso
    (126, 5), -- Peso Muerto Convencional -> Pierna
    (127, 7), -- Sprint con Resistencia -> Cardio
    (128, 4), -- Mountain Climbers con Banda -> Torso
    (128, 7), -- Mountain Climbers con Banda -> Cardio
    (129, 1), -- Swing Ruso con Pesas Rusas -> Fullbody
    (130, 4), -- Escalador con Rotación -> Torso
    (131, 3), -- Remo con Polea Alta -> Pull
    (132, 1), -- Crawl del Cocodrilo -> Fullbody
    (133, 4), -- Good Morning con Banda -> Torso
    (134, 6), -- Press de Hombros Unilateral -> Músculo Aislado
    (135, 4), -- Rotación de Tronco con Disco -> Torso
    (136, 7), -- Golpes Explosivos al Saco -> Cardio
    (137, 1), -- Battle Rope Saltando Lateralmente -> Fullbody
    (137, 7), -- Battle Rope Saltando Lateralmente -> Cardio
    (138, 5), -- Step Back con Mancuerna -> Pierna
    (139, 6), -- Curl con Bandas Elásticas -> Músculo Aislado
    (140, 1), -- Burpees Explosivos -> Fullbody
    (140, 7), -- Burpees Explosivos -> Cardio
    (141, 5), -- Sentadilla con Chaleco Lastrado -> Pierna
    (142, 7), -- Sprint con Trineo -> Cardio
    (143, 2), -- Press de Pecho en Cross Over -> Push
    (144, 3), -- Remo con Disco -> Pull
    (145, 7), -- Carrera en Escalera -> Cardio
    (146, 6), -- Jalón al Pecho con Banda -> Músculo Aislado
    (147, 6), -- Extensiones de Pierna en Máquina -> Músculo Aislado
    (148, 5), -- Sentadilla Frontal con Mancuerna -> Pierna
    (149, 7), -- Slam con Disco de Goma -> Cardio
    (150, 7); -- Cuerda para Saltar Doble -> Cardio
