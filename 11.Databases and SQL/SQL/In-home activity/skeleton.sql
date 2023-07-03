-- 1. Write a SQL query that outputs all information about all departments.
SELECT * FROM departments;
-- 2. Write a SQL query that outputs all department names.
SELECT (name) FROM departments;
-- 3. Write a SQL query that outputs first and last name of each employee, along with their salary.
SELECT first_name,last_name,salary from employees;
-- 4. Write a SQL query that outputs the full name of each employee.
SELECT concat(first_name, ' ',last_name) as full_name from employees;
-- 5. Write a SQL query to generate an email addresses for each employee.
-- Consider that the email domain is company.com. For example, John Doe's email would be "John.Doe@company.com". The produced column should be named "Full Email Addresses".
SELECT concat(first_name, '.', last_name, '@company.com') FROM employees;
-- 6. Write a SQL query to find all the different employee salaries.
SELECT DISTINCT salary from employees;
-- 7. Write a SQL query that outputs all information about the employees whose job title is "Sales Representative".
SELECT * FROM employees WHERE job_title = 'Sales Representative';
-- 8. Write an SQL query to find all employees who have a salary that is bigger than their manager's.
SELECT e.* from employees e INNER JOIN employees m ON e.manager_id = m.employee_id WHERE e.salary > m.salary;
-- 9. Write a SQL query to find the names of all employees whose first name starts with "SA".
SELECT * FROM employees WHERE first_name LIKE 'SA%';
-- 10. Write a SQL query to find the names of all employees whose last name contains "ei".
SELECT * FROM employees WHERE last_name LIKE '%ei%';
-- 11. Write a SQL query to find all employees whose salary is in the range [20000…30000].
SELECT * FROM employees WHERE salary BETWEEN 20000 AND 30000;
-- 12. Write a SQL query to find the names of all employees whose salary is 25000, 14000, 12500 or 23600.
SELECT * FROM employees WHERE salary IN (25000, 14000, 12500, 23600);
-- 13. Write a SQL query to find all employees that do not have manager.
SELECT * FROM employees WHERE manager_id IS NULL;
-- 14. Write a SQL query to find the names of all employees who were hired before their managers.
SELECT e.* FROM employees e INNER JOIN employees m ON e.manager_id = m.employee_id WHERE e.hire_date < m.hire_date;
-- 15. Write a SQL query to find all employees whose salary is more than 50000. Order them in decreasing order, based on their salary.
SELECT * FROM employees WHERE salary > 50000 ORDER BY salary DESC ;
-- 16. Write a SQL query to find the top 5 best paid employees.
SELECT * FROM employees WHERE salary > 50000 ORDER BY salary DESC LIMIT 5;
-- 17. Write a SQL query that outputs all employees along their address.
SELECT * FROM employees JOIN addresses a on employees.address_id = a.address_id;
-- 18. Write a SQL query to find all employees whose middle name is the same as the first letter of their town.
SELECT * FROM employees JOIN towns t on employees.address_id = t.town_id WHERE SUBSTRING(name,1,1) = SUBSTRING(employees.middle_name,1,1);
-- 19. Write a SQL query that outputs all employees (first and last name) that have a manager, along with their manager (first and last name).
SELECT e.first_name as employee_first_name, e.last_name as employee_last_name,
       e2.first_name as manager_first_name, e2.last_name as manager_last_name
FROM employees e
JOIN employees e2 on e.manager_id = e2.employee_id
WHERE e.manager_id IS NOT NULL;
-- 20. Write a SQL query that outputs all employees that have a manager (first and last name), along with their manager (first and last name) and the employee's address.
SELECT e.first_name as employee_first_name, e.last_name as employee_last_name,
       e2.first_name as manager_first_name, e2.last_name as manager_last_name,
       a.text as address
FROM employees e
         JOIN employees e2 on e.manager_id = e2.employee_id
         JOIN addresses a on e.address_id = a.address_id
WHERE e.manager_id IS NOT NULL;
-- 21. Write a SQL query to find all departments and all town names in a single column.
SELECT DISTINCT d.name FROM departments d
UNION
SELECT DISTINCT t.name  FROM towns t;
-- 22. Write a SQL query to find all employees and their manager, along with the employees that do not have manager.If they do not have a manager, output "n/a".
-- TODO
-- 23. Write a SQL query to find the names of all employees from the departments "Sales" AND "Finance" whose hire year is between 1995 and 2005.
SELECT e.first_name as employee_first_name, e.last_name as employee_last_name
FROM employees e JOIN departments d on e.department_id = d.department_id
WHERE d.name IN ('Sales');