-- Insertar datos en la tabla trainer
INSERT INTO trainer (id, dni, email, last_name, name, telephone, birthdate, active) VALUES
    (1, 30111222, 'juan.perez@example.com', 'Pérez', 'Juan', '+5491133344455', '1985-03-25', true),
    (2, 27123456, 'maria.gomez@example.com', 'Gómez', 'María', '+5491145567788', '1990-07-15', false);

-- Insertar datos en la tabla student
INSERT INTO student (id, dni, email, last_name, name, telephone, birthdate, start_date, trainer_id, active) VALUES
    (1, 40123456, 'alumno.uno@example.com', 'Fernández', 'Agustín', '+5491122233344', '2000-05-10', '2023-01-01', 1, true),
    (2, 40234567, 'alumno.dos@example.com', 'López', 'Juliana', '+5491123344455', '1999-09-20', '2023-02-15', 1, true),
    (3, 40345678, 'alumno.tres@example.com', 'Martínez', 'Lucía', '+5491124455566', '2001-12-25', '2023-03-10', 2, false);

-- Ajustar la secuencia de trainer_id al siguiente valor disponible
ALTER SEQUENCE trainer_seq RESTART WITH 3;

-- Ajustar la secuencia de student_id al siguiente valor disponible
ALTER SEQUENCE student_seq RESTART WITH 4;