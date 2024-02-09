-- 11. Display the most frequently rented movies in descending order --
-- SELECT title, COUNT(*) as 'Rental Count'
-- FROM sakila.rental
-- JOIN sakila.inventory
-- ON (rental.inventory_id = inventory.inventory_id)
-- JOIN sakila.film
-- ON (film.film_id = inventory.film_id)
-- GROUP BY film.title
-- ORDER BY COUNT(rental_id) DESC;

-- 12. Write a query to display how much business, in dollars, each store brought in --
-- Hunters Version --
-- SELECT staff_id as store_id, SUM(amount)
-- FROM sakila.payment
-- GROUP BY store_id;

-- SELECT store.store_id, SUM(amount)
-- FROM sakila.store
-- INNER JOIN sakila.staff
-- ON store.store_id = staff.store_id
-- INNER JOIN sakila.payment 
-- ON payment.staff_id = staff.staff_id
-- GROUP BY store.store_id;

-- 13. List the top five generes in gross revenue in descending order
--  SELECT name, SUM(amount)
--  FROM sakila.payment
--  JOIN sakila.rental
--  ON payment.rental_id = rental.rental_id
--  JOIN sakila.inventory
--  ON inventory.inventory_id = rental.inventory_id
--  JOIN sakila.film_category
--  ON film_category.film_id = inventory.film_id
--  JOIN sakila.category
--  ON film_category.category_id = category.category_id
--  GROUP BY category.name
--  ORDER BY SUM(amount) DESC LIMIT 5;

-- 15. You would like to have an easy way to view the top five generes by gross revenue --
-- VIEW - is a virtual table based on a result set --
-- CREATE VIEW top_revenues_by_genere AS
--  SELECT name, SUM(amount)
--  FROM sakila.payment
--  JOIN sakila.rental
--  ON payment.rental_id = rental.rental_id
--  JOIN sakila.inventory
--  ON inventory.inventory_id = rental.inventory_id
--  JOIN sakila.film_category
--  ON film_category.film_id = inventory.film_id
--  JOIN sakila.category
--  ON film_category.category_id = category.category_id
--  GROUP BY category.name
--  ORDER BY SUM(amount) DESC LIMIT 5;
 
-- How to display your VIEW --
--  SELECT * FROM top_revenues_by_genere
--  WHERE name = 'Sports';
 
-- How to delete your VIEW --
--  DROP VIEW top_revenues_by_genere;

