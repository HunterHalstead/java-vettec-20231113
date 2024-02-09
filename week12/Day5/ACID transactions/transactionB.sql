-- Transaction B
START TRANSACTION; -- turns off autocommit
-- A new customer joining the bank!

INSERT INTO bank.`account` (customer_name, balance) 
VALUES ("Slim Jim", 1);

INSERT INTO bank.`account` (customer_name, balance) 
VALUES ("Black Jack", 3000000);

COMMIT; -- Saves the changes and turns auto-commit back on

-- ROLLBACK;