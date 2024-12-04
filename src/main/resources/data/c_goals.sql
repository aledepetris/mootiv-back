INSERT INTO goal (id, name, description) VALUES
    (1, 'Fuerza', 'Objetivo centrado en aumentar la fuerza máxima mediante ejercicios de alta intensidad y baja repetición.'),
    (2, 'Hipertrofia', 'Meta orientada al crecimiento muscular mediante entrenamientos con repeticiones moderadas y alta carga progresiva.'),
    (3, 'Bajar Peso', 'Objetivo enfocado en la pérdida de grasa corporal mediante ejercicios aeróbicos y entrenamiento funcional.');

ALTER SEQUENCE goal_id_seq RESTART WITH 4;
