SET FOREIGN_KEY_CHECKS = 0;

Use northwind;

# Loading data for Region Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/regions.csv'
INTO TABLE Region
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(RegionID, RegionDescription);

# Loading data for Territories Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/territories.csv'
INTO TABLE Territories
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(TerritoryID, TerritoryDescription, RegionID);

# Loading data for Employees Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/employees.csv'
INTO TABLE Employees
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(EmployeeID, LastName, FirstName, @Title, @TitleOfCourtesy, @BirthDate, @HireDate, @Address, @City, @Region, @PostalCode, @Country, @HomePhone, @Extension, Notes, @ReportsTo, @PhotoPath, @Salary)
SET 
	Title = NULLIF(@Title,'NULL'),
	TitleOfCourtesy = NULLIF(@TitleOfCourtesy,'NULL'),
    BirthDate = NULLIF(@BirthDate,'NULL'),
    HireDate = NULLIF(@HireDate,'NULL'),
    Address = NULLIF(@Address,'NULL'),
    City = NULLIF(@City,'NULL'),
    Region = NULLIF(@Region,'NULL'),
    PostalCode = NULLIF(@PostalCode,'NULL'),
    Country = NULLIF(@Country,'NULL'),
    HomePhone = NULLIF(@HomePhone,'NULL'),
    Extension = NULLIF(@Extension,'NULL'),
    ReportsTo = NULLIF(@ReportsTo,'NULL'),
    PhotoPath = NULLIF(@PhotoPath,'NULL'),
    Salary = NULLIF(@Salary,'NULL');


# Loading data for EmployeeTerritories Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/employee-territories.csv'
INTO TABLE EmployeeTerritories
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(EmployeeID, TerritoryID);

# Loading data for Shippers Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/shippers.csv'
INTO TABLE Shippers
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(ShipperID, CompanyName, @Phone)
SET Phone = NULLIF(@Phone, 'NULL');

# Loading data for Customers Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/customers.csv'
INTO TABLE Customers
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(CustomerID, CompanyName, @ContactName, @ContactTitle, @Address, @City, @Region, @PostalCode, @Country, @Phone, @Fax)
SET
	ContactName = NULLIF(@ContactName,'NULL'),
    ContactTitle = NULLIF(@ContactTitle,'NULL'),
	Address = NULLIF(@Address,'NULL'),
    City = NULLIF(@City,'NULL'),
    Region = NULLIF(@Region,'NULL'),
    PostalCode = NULLIF(@PostalCode,'NULL'),
    Country = NULLIF(@Country,'NULL'),
    Phone = NULLIF(@Phone,'NULL'),
    Fax = NULLIF(@Fax,'NULL');

# Loading data for Orders Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/orders.csv'
INTO TABLE Orders
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(OrderID, @CustomerID, @EmployeeID, @OrderDate, @RequiredDate, @ShippedDate, @ShipVia, @Freight, @ShipName, @ShipAddress, @ShipCity, @ShipRegion, @ShipPostalCode, @ShipCountry)
SET 
	CustomerID = NULLIF(@CustomerID,'NULL'),
	EmployeeID = NULLIF(@EmployeeID,'NULL'),
    OrderDate = NULLIF(@OrderDate,'NULL'),
    RequiredDate = NULLIF(@RequiredDate,'NULL'),
    ShippedDate = NULLIF(@ShippedDate,'NULL'),
    ShipVia = NULLIF(@ShipVia,'NULL'),
    Freight = NULLIF(@Freight,'NULL'),
    ShipName = NULLIF(@ShipName,'NULL'),
    ShipAddress = NULLIF(@ShipAddress,'NULL'),
	ShipCity = NULLIF(@ShipCity,'NULL'),
    ShipRegion = NULLIF(@ShipRegion,'NULL'),
    ShipPostalCode = NULLIF(@ShipPostalCode,'NULL'),
    ShipCountry = NULLIF(@ShipCountry,'NULL');

# Loading data for Categories Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/categories.csv'
INTO TABLE Categories
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(CategoryID, CategoryName, @Description)
SET Description = NULLIF(@Description,'NULL');

# Loading data for Suppliers Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/suppliers.csv'
INTO TABLE Suppliers
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(SupplierID, CompanyName, @ContactName, @ContactTitle, @Address, @City, @Region, @PostalCode, @Country, @Phone, @Fax, @HomePage)
SET
	ContactName = NULLIF(@ContactName,'NULL'),
    ContactTitle = NULLIF(@ContactTitle,'NULL'),
	Address = NULLIF(@Address,'NULL'),
    City = NULLIF(@City,'NULL'),
    Region = NULLIF(@Region,'NULL'),
    PostalCode = NULLIF(@PostalCode,'NULL'),
    Country = NULLIF(@Country,'NULL'),
    Phone = NULLIF(@Phone,'NULL'),
    Fax = NULLIF(@Fax,'NULL'),
	HomePage = NULLIF(@HomePage,'NULL');

# Loading data for Products Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/products.csv'
INTO TABLE Products
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(ProductID, ProductName, @SupplierID, @CategoryID, @QuantityPerUnit, @UnitPrice, @UnitsInStock, @UnitsOnOrder, @ReorderLevel, @Discontinued)
SET 
	SupplierID = NULLIF(@ShipVia,'NULL'),
	CategoryID = NULLIF(@CategoryID,'NULL'),
    QuantityPerUnit = NULLIF(@QuantityPerUnit,'NULL'), 
    UnitPrice = NULLIF(@UnitPrice,'NULL'), 
    UnitsInStock = NULLIF(@UnitsInStock,'NULL'), 
    UnitsOnOrder = NULLIF(@UnitsOnOrder,'NULL'), 
    ReorderLevel = NULLIF(@ReorderLevel,'NULL'),
    Discontinued = case @Discontinued when '0' then 0 when '1' then 1 end;

# Loading data for OrdersDetails Table
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/order-details.csv'
INTO TABLE OrdersDetails
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS
(OrderID, ProductID, UnitPrice, Quantity, Discount);

SET FOREIGN_KEY_CHECKS = 1;