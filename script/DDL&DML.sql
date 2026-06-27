-- database: /SistemaGestionEstudiantil/dataBase/estudiante.sqlite

DROP TABLE IF EXISTS Student;

CREATE TABLE Student (
     IdStudent      INTEGER PRIMARY KEY AUTOINCREMENT
    ,Name           VARCHAR(50) NOT NULL
    ,LastName       VARCHAR(50) NOT NULL
    ,IdCard         VARCHAR(20) NOT NULL
    ,State          VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,CreationDate   DATETIME    NOT NULL DEFAULT (datetime('now','localtime'))
    ,ModifiedDate   DATETIME    NOT NULL DEFAULT (datetime('now','localtime'))
);

INSERT INTO Student (Name, LastName, IdCard, State) VALUES 
('Juan', 'Perez', '1712345678', 'A'),
('Ana', 'Lopez', '1787654321', 'A'),
('Pedro', 'Ruiz', '1700001111', 'A'),
('Maria', 'Gomez', '1722223333', 'A');

SELECT * FROM Student;