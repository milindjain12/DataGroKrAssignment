# DataGroKrAssignment
Rest API for Northwind database

# Section 1
1.<b>DDL_Statements.sql</b><br>
File contains the DDL queries for creation of table in the northwind database.

2.<b>Loading_data.sql</b><br>
File contains script for loading data from .csv files.
<br><b>Note: </b> Please change the .csv file locations according to your local environment in this file.

# Section 2
<b>Section2_Queries.sql</b><br>
This contains below five queries:<br>
1. List all the products with cost above the average price of the products.
2. Give the identifier, name, and total sales of employees, ordered by the employee identifier for employees who have sold more than 70 different products.
3. Identify the customers who have active orders.
4. Find the customer with maximum number of orders.
5. List all the employees who have sold at least one of the products ‘Gravad Lax’ or ‘Mishi Kobe Niku’.

# Section 3

## Environment Setup
1. Install Spring Tool Suite 4 using the link <a href="https://spring.io/tools">Download</a>
2. Download the Source code from the repository.
3. Using STS4 import the code using maven and specify the pom.xml file.
4. It will download all the dependencies required for the API.
5. Open application.properties and change the MySql Database Credentials(Username and Password).
6. Run as SpringBoot App.
7. API should run.

## API Specification

BASE_URL = http://localhost:8080/api/v1

1. Insert, update and select on customers<br>
<b>Insert : BASE_URL+/customers</b><br>
<b>POST Request</b><br>
It should be accompanied with a JSON object in the body, similar to customer object structure.<br>
For eg.
{
    "customerId": "MIMEA",
    "companyName": "Milind Jain and Mehul Associates",
    "contactName": "Milind Jain",
    "contactTitle": "Co-Owner",
    "address": "71/48 Near K.V. No 5 Madhyam Marg Mansarovar",
    "city": "Jaipur",
    "region": "Rajasthan",
    "postalCode": "302020",
    "country": "India",
    "phone": "91-8947082516",
    "fax": "91-8947082516"
}

<b>Update : BASE_URL+/customers</b><br>
<b>POST Request</b><br>
It should be accompanied with a JSON object in the body, similar to customer object structure.
For Eg. - Similar to the structure in insert mentioned above with updated values.

<b>Select All Customers : BASE_URL+/customers</b><br>
<b>GET Request</b><br>
Nothing to be given in BODY of Request.

<b>Select Customer By ID : BASE_URL+/customers/{customerId}</b><br>
<b>GET Request</b><br>
For eg. http://localhost:8080/api/v1/customers/MIMEA

2. Insert, update and select on products<br>
<b>Insert : BASE_URL+/products</b><br>
<b>POST Request</b><br>
It should be accompanied with a JSON object in the body, similar to products object structure.<br>
For eg.
{
        "productId": 1,
        "productName": "Chai",
        "supplier": {
            "supplierId": 2,
            "companyName": "New Orleans Cajun Delights",
            "contactName": "Shelley Burke",
            "contactTitle": "Order Administrator",
            "address": "P.O. Box 78934",
            "city": "New Orleans",
            "region": "LA",
            "postalCode": "70117",
            "country": "USA",
            "phone": "(100) 555-4822",
            "fax": null,
            "homePage": "#CAJUN.HTM#\r"
        },
        "category": {
            "categoryId": 1,
            "categoryName": "Beverages",
            "description": "Soft drinks coffee teas beers and ales\r"
        },
        "quantityPerUnit": "10 boxes x 20 bags",
        "unitPrice": 18.0,
        "unitsInStock": 39,
        "unitsOnOrder": 0,
        "reorderLevel": 10,
        "discontinued": 0
 }

<b>Update : BASE_URL+/products</b><br>
<b>POST Request</b><br>
It should be accompanied with a JSON object in the body, similar to products object structure.<br>
For Eg. - Similar to the structure in insert mentioned above with updated values.<br>

<b>Select All Products : BASE_URL+/products</b><br>
<b>GET Request</b><br>
Nothing to be given in BODY of Request.<br>

<b>Select Product By ID : BASE_URL+/products/{productId}</b><br>
<b>GET Request</b><br>
For eg. http://localhost:8080/api/v1/products/1<br>

3. Order history of given customer<br>
URL - BASE_URL+/customers/orders/{customerId}<br>
<b>GET Request</b>
For eg. http://localhost:8080/api/v1/customers/orders/"MIMEA"

#### Note: You can also find the above specifications after deploying the rest api, just use the below links
For UI output
http://localhost:8080/api/v1/swagger-ui/index.html <br>

For JSON Docs ouput
http://localhost:8080/api/v1/v2/api-docs
