-- database: /SistemaGestionEstudiantil/dataBase/estudiante.sqlite

DROP TABLE IF EXISTS Student;

CREATE TABLE Student (
     IdStudent      INTEGER PRIMARY KEY AUTOINCREMENT
    ,Name           VARCHAR(50) NOT NULL
    ,LastName       VARCHAR(50) NOT NULL
    ,IdCard         INTEGER NOT NULL
    ,Carreer        VARCHAR(50) NOT NULL
    ,State          VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,CreationDate   DATETIME    NOT NULL DEFAULT (datetime('now','localtime'))
    ,ModifiedDate   DATETIME    NOT NULL DEFAULT (datetime('now','localtime'))
);

INSERT INTO Student (Name, LastName, IdCard, Carreer, State) VALUES 
('Juan', 'Perez', 1712345678, 'Ingeniería en Computación', 'A'),
('Ana', 'Lopez', 1787654321, 'Ingeniería en Computación', 'A'),
('Pedro', 'Ruiz', 1700001111, 'Redes y Telecomunicaciones', 'A'),
('Maria', 'Gomez', 1722223333, 'Ingeniería de Software', 'A');

SELECT * FROM Student;