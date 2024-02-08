-- MySQL JOINS --

-- INNER JOIN --
-- Retrieves records that have matching values on both tables --

-- LEFT JOIN --
-- Retrieves all records from the left table and all matching values from the right tables, can have null values on right --

-- RIGHT JOIN --
-- Retrieves all records from the right table and any matching values from the left table, can have null values on left --

-- CROSS JOIN --
-- Retrieves all records from both tables --

-- Self Join --
-- A regular Join, but the table is joined with itself --

-- 1. Display the first and last name and address of each staff member --
SELECT first_name, last_name, address
FROM sakila.staff 
INNER JOIN sakila.address
ON staff.address_id = address.address_id;

-- 2. Return all the records from the address table and any matching records from the customer table --
-- Use a RIGHT JOIN on customers and address --
-- If a customers address_id does not match any address_id in the address table, NULL values will be returned for the customers --
SELECT c.first_name, c.last_name, ad.address, ad.postal_code
FROM sakila.customer c
RIGHT JOIN sakila.address ad
ON c.address_id = ad.address_id;

-- 3. Using a Right Join, Return all records from the customers table and any matching records from the address table --
SELECT c.first_name, c.last_name, ad.address, ad.postal_code
FROM sakila.address ad
RIGHT JOIN sakila.customer c
ON c.address_id = ad.address_id;

-- 4. Using a Left Join, return all records from the customer table and any matching records from the address table --
SELECT c.first_name, c.last_name, ad.address, ad.postal_code
FROM sakila.customer c
LEFT JOIN sakila.address ad
ON c.address_id = ad.address_id;

-- 5. Using a Left Join, return all records from the address table and any matching records from the customers table --
-- returns NULL values for customers--
SELECT c.first_name, c.last_name, ad.address, ad.postal_code
FROM sakila.address ad
LEFT JOIN sakila.customer c
ON c.address_id = ad.address_id;

-- 6. Use a CROSS JOIN to retrieve all the records from customer and address --
SELECT c.first_name, c.last_name, ad.address_id
FROM sakila.customer c
CROSS JOIN sakila.address ad
WHERE c.address_id = ad.address_id;

-- 7. use a Join to display the total amount rung up by each staff member in August of 2005 --
-- SUM() is an aggregate function that returns the sum of a numeric column --
-- GROUP BY is a statement to group rows that have the same values, often used with aggregate functions (COUNT(), MAX(), MIN(), SUM(), etc.) --
SELECT first_name as 'FIRST', last_name as 'LAST', SUM(amount) as 'Total Amount'
FROM sakila.staff
INNER JOIN sakila.payment
ON staff.staff_id = payment.staff_id AND payment_date LIKE '2005-08%'
GROUP BY first_name, last_name;

-- 8. List each film and the number of actors who are listed for the film --
SELECT title, COUNT(actor_id) as 'Actor Count'
FROM sakila.film_actor
INNER JOIN sakila.film
ON film_actor.film_id = film.film_id
GROUP BY title;

-- 9. How many copies of the film Hunchback Impossible exist in the inventory system?
-- As long as the value being passing in COUNT() is a PK or unique key
-- COUNT(film.film_id) works --
-- COUNT(inventory_id) works --
SELECT title, COUNT(title) as 'Copies Available'
FROM sakila.film
JOIN sakila.inventory
ON film.film_id = inventory.film_id
WHERE title = 'Hunchback Impossible'
GROUP BY title;

-- 10. List the total amount paid by each customer, list customers alphabetically by last name --
SELECT first_name, last_name, SUM(amount) as 'Total paid by each customer'
FROM sakila.customer 
INNER JOIN sakila.payment
ON payment.customer_id = customer.customer_id
GROUP BY first_name, last_name
ORDER BY last_name DESC;





