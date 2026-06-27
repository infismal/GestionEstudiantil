-- database: /SistemaGestionEstudiantil/dataBase/estudiante.sqlite

DROP TABLE IF EXISTS Student;

CREATE TABLE Student (
     IdStudent      INTEGER PRIMARY KEY AUTOINCREMENT
    ,Name           VARCHAR(50) NOT NULL
    ,LastName       VARCHAR(50) NOT NULL
    ,IdCard         INTEGER NOT NULL
    ,Program        VARCHAR(50) NOT NULL
    ,Faculty        VARCHAR(50) NOT NULL
    ,State          VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,CreationDate   DATETIME    NOT NULL DEFAULT (datetime('now','localtime'))
    ,ModifiedDate   DATETIME    NOT NULL DEFAULT (datetime('now','localtime'))
);

INSERT INTO Student (Name, LastName, IdCard, Program, Faculty, State) VALUES 
('Juan', 'Perez', 1712345678, 'Ingeniería en Computación', 'Sistemas', 'A'),
('Ana', 'Lopez', 1787654321, 'Ingeniería en Computación','Sistemas', 'A'),
('Pedro', 'Ruiz', 1700001111, 'Redes y Telecomunicaciones','Sistemas', 'A'),
('Maria', 'Gomez', 1722223333, 'Ingeniería de Software','Sistemas', 'A');

SELECT * FROM Student;