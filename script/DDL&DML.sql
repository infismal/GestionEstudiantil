-- database: /SistemaGestionEstudiantil/dataBase/estudiante.sqlite

DROP TABLE IF EXISTS Student;

CREATE TABLE Student (
     IdStudent      INTEGER PRIMARY KEY
    ,Name           VARCHAR(50) NOT NULL
    ,LastName       VARCHAR(50) NOT NULL
    ,IdCard         INTEGER NOT NULL
    ,Career        VARCHAR(50) NOT NULL
    ,Faculty        VARCHAR(50) NOT NULL
    ,State          VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,CreationDate   DATETIME    NOT NULL DEFAULT (datetime('now','localtime'))
    ,ModifiedDate   DATETIME    NOT NULL DEFAULT (datetime('now','localtime'))
);

INSERT INTO Student (IdStudent,Name, LastName, IdCard, Career, Faculty, State) VALUES 
(20,'Juan', 'Perez', 1712345678, 'Ingeniería en Computación', 'Sistemas', 'A'),
(21,'Ana', 'Lopez', 1787654321, 'Ingeniería en Computación','Sistemas', 'A'),
(22,'Pedro', 'Ruiz', 1700001111, 'Redes y Telecomunicaciones','Sistemas', 'A'),
(23,'Maria', 'Gomez', 1722223333, 'Ingeniería de Software','Sistemas', 'A');

SELECT * FROM Student;