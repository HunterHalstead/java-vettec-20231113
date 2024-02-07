/*
DDL vs DML
	- subset of commands that are used to manage your database objects and data in an SQL database
    
DDL - Data Definition Language
	-> SQL commands that are used to create, drop, and modify database objects (not the data itself, but where the data sits)
		- CREATE - creates a new table
        - ALTER - used to modify the structure of an existing table
        - DROP - deletes a table and all of its data
        - TRUNCATE - removes all the data from the table, but keeps the table
       
-- creates a new table --
CREATE TABLE library_ms.library (
Library_ID INT NOT NULL AUTO_INCREMENT,
Name VARCHAR(45) NULL,
Location VARCHAR(45) NULL,
PRIMARY KEY(Library_ID)
);

-- creates a new table with a foreign key --
CREATE TABLE library_ms.book (
Book_ID INT NOT NULL AUTO_INCREMENT,
Book_Name VARCHAR(45) NULL,
Author VARCHAR(45) NULL,
ISBN VARCHAR(45) NULL,
Library_ID INT NULL,
PRIMARY KEY(Book_ID),
FOREIGN KEY(Library_ID) REFERENCES library_ms.library(Library_ID)
);

-- modifies a column in a table --
ALTER TABLE library_ms.book
CHANGE COLUMN Book_Name Title VARCHAR(45);
        
DML - Data Manipulation Language
	-> SQL commands that used to add, delete, and edit data found in tables
		- INSERT - adds new data table
        - UPDATE - modifies data of an existing table
        - DELETE - removes specified data from a table
        - SELECT - retireves data from one or more tables

-- inserts 1 row of data into a table --
INSERT INTO library_ms.library(Name, Location)
VALUES ('Piedmont Library', 'Georgia');

-- inserts multiple rows of data --
INSERT INTO library_ms.library(Name, Location)
VALUES ('Piedmont Library', 'Georgia'),
	('Memorial Library', 'Texas'),
    ('Little Free Library', 'Georgia'),
    ("Golden Gate Library", "California"),
    ('Willow Creeek Library', 'North Carolina'),
    ('The Library', 'South Carolina');
    
-- deletes a specific row --
DELETE FROM library_ms.library
WHERE Library_ID = 1;

-- deletes specified rows using a range --
DELETE FROM library_ms.library
WHERE Library_ID > 3 OR Library_ID = 1;

-- modifies the value of a specified row --
UPDATE library_ms.library
SET Name = 'Willow Creek Library'
WHERE Library_ID = 12;

-- modifies the value of a specified row using BETWEEN --
UPDATE library_ms.book
SET Author = 'Louisa May Alcott'
WHERE Book_ID BETWEEN 21 AND 22;

INSERT INTO library_ms.book (Title, Author, ISBN, Library_ID)
VALUE('Gone With The Wind', 'Margaret Mitchell', 'abc001001', 8),
('Gone With The Wind', 'Margaret Mitchell', 'abc001002', 12),
('The Color Purple', 'Marsha Norman', 'abc006121', 9),
('Cant Hurt Me', 'David Goggis', 'aec101101', 8),
('The Eye of the World', 'Robert Jordan', 'abc003291', 8),
('Guards! Guards!', 'Terry Pratchett', 'adc003441', 10),
('Little Woman', 'Lousia May Alcott', 'abd014021', 13),
('Little Woman', 'Lousia May Alcott', 'abd014022', 12),
('The Catch in the Rye', 'J. D. Salinger', 'abd023661', 9),
('The Scarlet Letter', 'Nathaniel Hawthrone', 'acd024021', 11),
('The Princess Bride', 'William Goldman', 'abd014451', 11),
("The Silmarilion", "J.R.R. Tolkein", 'abc001311', 12),
('The Fall of the House of Usher', 'Edgar Allen Poe', 'ace111431', 10),
('The Raven', 'Edgar Allen Poe', 'ace122431', 9 );

-- retrieve all the books by edgar allen poe --
SELECT * FROM library_ms.book
WHERE Author = 'Edgar Allen Poe';


-- when using UPDATE you can only make changes with a key unless you disable safe mode --
UPDATE library_ms.book
SET ISBN = 'bat123456'
WHERE Library_ID = 11;

UPDATE library_ms.book
SET ISBN = 'bat123456'
WHERE Title = 'The Raven'; -- this does NOT work --

-- can make changes using UPDATE because we modified ISBN to be a unique key --
-- ISBN is now a candidate key --
UPDATE library_ms.book
SET Title = 'Gone without the Wind'
WHERE ISBN = 'abc001001';

-- joins two tables togther and retrieves all the records from both --
SELECT *
FROM library_ms.library
INNER JOIN library_ms.book ON book.Library_ID = library.Library_ID;

*/
















