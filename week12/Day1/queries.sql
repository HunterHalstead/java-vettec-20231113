# SELECT - used to select data from the database
/* SELECT * FROM world.city; */

#FROM - used to select data from a specific table
# Can either select specified column_names or * (to select all columns)
#WHERE - clause used to filter through records
/* SELECT * FROM world.city
WHERE CountryCode = 'AFG'; */

# AND, OR, NOT Operators 
/* SELECT * FROM world.city
WHERE CountryCode = 'AFG' AND Population < 200000; */

/* SELECT * FROM world.city
WHERE CountryCode = 'AFG' OR Population > 200000; */

/* SELECT * FROM world.city
WHERE NOT CountryCode = 'AFG'; */

# How to comment out code
/* Comment */
-- Comment --

# ORDER BY - used to sort the result in a ascending or descending order
/* SELECT * FROM world.city
ORDER BY Population DESC; */

# Built-IN Functions MIN and MAX
-- SELECT MIN(Population), MIN(ID), MIN(Name)
-- FROM world.city;
-- SELECT * FROM world.city; --

-- SELECT MAX(Population) AS SmallestPopulation
-- FROM world.city;

# LIKE - used to search for a specific pattern in a column
/*
	- LIKE '%aa' will return a column with the specified string of characters ending with that set of character
    - LIKE 'aa%' will return a column with the specified string of characters ending with that set of character
    - LIKE '%aa% will return a column with the specified string of characters anywhere in the string
*/
-- SELECT * FROM world.city
-- WHERE Name LIKE '%sam%';

# DATA TYPES
/*
	Numeric 
	- TINYINT: 1 byte = byte
    - SMALLINT: 2 bytes = short
    - MEDIUMINT: 3 bytes 
	- INTERGER (INT): 4 bytes = int
    - BIGINT: 8 bytes = long
    - DECIMAL (DEC)
    - DOUBLE PRECISION
    - FLOAT
    
    String and Characters
    - CHAR
    - VARCHAR(25)
    - BLOB
    - TEXT 
    - ENUM
    
    
    
*/





