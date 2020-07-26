# creating the database
CREATE DATABASE Northwind;
Use Northwind;

# creating Region Table
CREATE TABLE Region (
	RegionID INT(11) AUTO_INCREMENT PRIMARY KEY, 
	RegionDescription VARCHAR(50) NOT NULL
);

# creating Territories Table
CREATE TABLE Territories (
	TerritoryID VARCHAR(20) PRIMARY KEY,
	TerritoryDescription VARCHAR(50) NOT NULL,
	RegionID INT(11) NOT NULL,
	CONSTRAINT fk_region_0 FOREIGN KEY (RegionID) REFERENCES Region(RegionID)
);

# creating Employees Table
CREATE TABLE Employees (
	EmployeeID INT(11) AUTO_INCREMENT PRIMARY KEY,
	LastName VARCHAR(20) NOT NULL,
	FirstName VARCHAR(10) NOT NULL,
	Title VARCHAR(30),
	TitleOfCourtesy VARCHAR(25),
	BirthDate DATETIME,
	HireDate DATETIME,
	Address VARCHAR(60),
	City VARCHAR(15),
	Region VARCHAR(15),
	PostalCode VARCHAR(10),
	Country VARCHAR(15),
	HomePhone VARCHAR(24),
	Extension VARCHAR(4),
	Notes MEDIUMTEXT NOT NULL,
	ReportsTo INT(11),
	PhotoPath VARCHAR(255),
	Salary FLOAT,
	CONSTRAINT fk_employees_0 FOREIGN KEY (ReportsTo) REFERENCES Employees(EmployeeID)
);

# creating EmployeeTerritories Table
CREATE TABLE EmployeeTerritories (
	EmployeeID INT(11),
	TerritoryID VARCHAR(20),
	CONSTRAINT pk_employeeterritories_0 PRIMARY KEY(EmployeeID, TerritoryID),
    CONSTRAINT fk_employees_1 FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
    CONSTRAINT fk_territories_1 FOREIGN KEY (TerritoryID) REFERENCES Territories(TerritoryID)
);

# creating Shippers Table
CREATE TABLE Shippers (
	ShipperID INT(11) AUTO_INCREMENT PRIMARY KEY,
	CompanyName VARCHAR(40) NOT NULL,
	Phone VARCHAR(24)
);

# creating Customers Table
CREATE TABLE Customers (
	CustomerID VARCHAR(5) PRIMARY KEY,
	CompanyName VARCHAR(40) NOT NULL,
	ContactName VARCHAR(30),
	ContactTitle VARCHAR(30),
	Address VARCHAR(60),
	City VARCHAR(15),
	Region VARCHAR(15),
	PostalCode VARCHAR(10),
	Country VARCHAR(15),
	Phone VARCHAR(24),
	Fax VARCHAR(24)
);

# creating CustomerDemographics table
CREATE TABLE CustomerDemographics (
	CustomerTypeID VARCHAR(10) PRIMARY KEY,
	CustomerDesc MEDIUMTEXT
);

#creating CustomerCustomerDemo Table
CREATE TABLE CustomerCustomerDemo (
	CustomerID VARCHAR(5),
	CustomerTypeID VARCHAR(10),
	CONSTRAINT pk_customercustomerdemo_0 PRIMARY KEY(CustomerID, CustomerTypeID),
	CONSTRAINT fk_customer_0 FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
	CONSTRAINT fk_customerdemographics_0 FOREIGN KEY (CustomerTypeID) REFERENCES CustomerDemographics(CustomerTypeID)
);

# creating Orders Table
CREATE TABLE Orders (
	OrderID INT(11) AUTO_INCREMENT PRIMARY KEY,
	CustomerID VARCHAR(5),
	EmployeeID INT(11),
	OrderDate DATETIME,
	RequiredDate DATETIME,
	ShippedDate DATETIME,
	ShipVia INT(11),
	Freight DECIMAL(10, 4),
	ShipName VARCHAR(40),
	ShipAddress VARCHAR(60),
	ShipCity VARCHAR(15),
	ShipRegion VARCHAR(15),
	ShipPostalCode VARCHAR(10),
	ShipCountry VARCHAR(15),
	CONSTRAINT fk_customer_1 FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
	CONSTRAINT fk_employees_2 FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
    CONSTRAINT fk_shippers_0 FOREIGN KEY (ShipVia) REFERENCES Shippers(ShipperID)
);

# creating Categories Table
CREATE TABLE Categories (
	CategoryID INT(11) AUTO_INCREMENT PRIMARY KEY,
	CategoryName VARCHAR(15) NOT NULL,
	Description MEDIUMTEXT
);

# creating Suppliers Table
CREATE TABLE Suppliers (
	SupplierID INT(11) AUTO_INCREMENT PRIMARY KEY,
	CompanyName VARCHAR(40) NOT NULL,
	ContactName VARCHAR(30),
	ContactTitle VARCHAR(30),
	Address VARCHAR(60),
	City VARCHAR(15),
	Region VARCHAR(15),
	PostalCode VARCHAR(10),
	Country VARCHAR(15),
	Phone VARCHAR(24),
	Fax VARCHAR(24),
	HomePage MEDIUMTEXT
);

# creating Products Table
CREATE TABLE Products (
	ProductID INT(11) AUTO_INCREMENT PRIMARY KEY,
	ProductName VARCHAR(40) NOT NULL,
	SupplierID INT(11),
	CategoryID INT(11),
	QuantityPerUnit VARCHAR(20),
	UnitPrice DECIMAL(10, 4),
	UnitsInStock SMALLINT(2),
	UnitsOnOrder SMALLINT(2),
	ReorderLevel SMALLINT(2),
	Discontinued BIT(1) NOT NULL,
	CONSTRAINT fk_suppliers_0 FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID),
	CONSTRAINT fk_categories_0 FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

# creating OrderDetails Table
CREATE TABLE OrdersDetails (
	OrderID INT(11),
	ProductID INT(11),
	UnitPrice DECIMAL(10, 4) NOT NULL,
	Quantity SMALLINT(2) NOT NULL,
	Discount DOUBLE(8, 0) NOT NULL,
	CONSTRAINT pk_orderdetails_0 PRIMARY KEY(OrderID, ProductID),
	CONSTRAINT fk_orders_0 FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
	CONSTRAINT fk_products_0 FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

