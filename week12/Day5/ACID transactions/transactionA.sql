-- Transaction A
START TRANSACTION; 

-- Generating a report for the bank on all accounts and the sum of money
SELECT * FROM account;

SELECT 
    SUM(balance), COUNT(id)
FROM
    account;
    
COMMIT;