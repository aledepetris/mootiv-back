-- Insertar datos en la tabla trainer
INSERT INTO trainer (id, dni, email, last_name, name, telephone, birthdate, alt_img) VALUES
    (1, 30111222, 'juan.perez@example.com', 'Pérez', 'Juan', '+5491133344455', '1985-03-25', 'https://www.catholicsingles.com/wp-content/uploads/2020/06/blog-header-3.png'),
    (2, 27123456, 'maria.gomez@example.com', 'Gómez', 'María', '+5491145567788', '1990-07-15', 'https://imgcdn.stablediffusionweb.com/2024/6/12/4d688bcf-f53b-42b6-a98d-3254619f3b58.jpg');

-- Insertar datos en la tabla student
INSERT INTO student (id, dni, email, last_name, name, telephone, birthdate, start_date, trainer_id, alt_img) VALUES
    (1, 40123456, 'alumno.uno@example.com', 'Fernández', 'Agustín', '+5491122233344', '2000-05-10', '2023-01-01', 1, 'https://images.ctfassets.net/h6goo9gw1hh6/2sNZtFAWOdP1lmQ33VwRN3/24e953b920a9cd0ff2e1d587742a2472/1-intro-photo-final.jpg'),
    (2, 40234567, 'alumno.dos@example.com', 'López', 'Juliana', '+5491123344455', '1999-09-20', '2023-02-15', 1, 'https://www.perfocal.com/blog/content/images/size/w960/2021/01/Perfocal_17-11-2019_TYWFAQ_100_standard-3.jpg'),
    (3, 40345678, 'alumno.tres@example.com', 'Martínez', 'Lucía', '+5491124455566', '2001-12-25', '2023-03-10', 2, 'https://www.artofher.com/wp-content/uploads/2022/01/professionalheadshotsphotographyforpeopleinDenver.jpg');

-- Ajustar la secuencia de trainer_id al siguiente valor disponible
ALTER SEQUENCE trainer_id_seq RESTART WITH 3;

-- Ajustar la secuencia de student_id al siguiente valor disponible
ALTER SEQUENCE student_id_seq RESTART WITH 4;