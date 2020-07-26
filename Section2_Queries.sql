# 1. List all the products with cost above the average price of the products.
SELECT *
FROM northwind.products AS p
WHERE p.UnitPrice > (SELECT AVG(UnitPrice)
					 FROM northwind.products)
ORDER BY p.ProductID;
        

# 2. Give the identifier, name, and total sales of employees, ordered by the employee identifier for employees who have sold more than 70 different products.
SELECT e.EmployeeID, e.FirstName, SUM(od.UnitPrice) AS `Total Sales`
FROM northwind.employees AS e
INNER JOIN northwind.orders AS ord
ON e.EmployeeID = ord.EmployeeID
INNER JOIN northwind.ordersdetails AS od
ON od.OrderID = ord.OrderID
GROUP BY e.EmployeeID
HAVING count(DISTINCT od.ProductID) > 70
ORDER BY e.EmployeeID;


# 3. Identify the customers who have active orders.
SELECT DISTINCT cus.*
FROM northwind.customers AS cus
INNER JOIN northwind.customers AS cus1
ON cus.CustomerID = cus1.CustomerID
INNER JOIN northwind.orders AS o
ON cus1.CustomerID=o.CustomerID
WHERE isnull(o.ShippedDate)
ORDER BY cus.CustomerID;
                     
                     
# 4. Find the customer with maximum number of orders.
SELECT c.*, count(c.CustomerID) AS `Total Orders`
FROM northwind.customers AS c 
INNER JOIN northwind.orders as o
ON c.CustomerID=o.CustomerID
GROUP BY o.CustomerID
ORDER BY count(c.CustomerID) DESC LIMIT 1;


# 5. List all the employees who have sold at least one of the products ‘Gravad Lax’ or ‘Mishi Kobe Niku’.
SELECT DISTINCT emp.*
FROM northwind.employees AS emp
INNER JOIN northwind.orders AS o
ON emp.EmployeeID = o.EmployeeID
INNER JOIN northwind.ordersdetails AS od
ON o.OrderID = od.OrderID
INNER JOIN northwind.products as p
ON od.ProductID = p.ProductID
WHERE p.ProductName = 'Gravad Lax' OR p.ProductName = 'Mishi Kobe Niku'
ORDER BY emp.EmployeeID;
