# DataGroKrAssignment
Rest API for Northwind database

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

1. Insert, update and select on customers
<b>Insert : BASE_URL+/customers</b>
<b>POST Request</b>
It should be accompanied with a JSON object in the body, similar to customer object structure.
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

<b>Update : BASE_URL+/customers</b>
<b>POST Request</b>
It should be accompanied with a JSON object in the body, similar to customer object structure.
For Eg. - Similar to the structure in insert mentioned above with updated values.

<b>Select All Customers : BASE_URL+/customers</b> 
<b>GET Request</b>
Nothing to be given in BODY of Request.

<b>Select Customer By ID : BASE_URL+/customers/{customerId}</b>
<b>GET Request</b>
For eg. http://localhost:8080/api/v1/customers/MIMEA

2. Insert, update and select on products
<b>Insert : BASE_URL+/products</b>
<b>POST Request</b>
It should be accompanied with a JSON object in the body, similar to products object structure.
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

<b>Update : BASE_URL+/products</b>
<b>POST Request</b>
It should be accompanied with a JSON object in the body, similar to products object structure.
For Eg. - Similar to the structure in insert mentioned above with updated values.

<b>Select All Products : BASE_URL+/products</b> 
<b>GET Request</b>
Nothing to be given in BODY of Request.

<b>Select Product By ID : BASE_URL+/products/{productId}</b>
<b>GET Request</b>
For eg. http://localhost:8080/api/v1/products/1

3. Order history of given customer
URL - BASE_URL+/customers/orders/{customerId}
<b>GET Request</b>
For eg. http://localhost:8080/api/v1/customers/orders/"MIMEA"

#### Note: You can also find the above specifications after deploying the rest api, just use the below links
For UI output
http://localhost:8080/api/v1/swagger-ui/index.html

For JSON Docs ouput
http://localhost:8080/api/v1/v2/api-docs
