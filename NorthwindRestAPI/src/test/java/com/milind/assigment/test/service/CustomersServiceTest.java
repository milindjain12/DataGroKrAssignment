package com.milind.assigment.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.milind.assigment.dao.CustomersDAO;
import com.milind.assigment.domain.Customers;
import com.milind.assigment.domain.Employees;
import com.milind.assigment.domain.Orders;
import com.milind.assigment.domain.Shippers;
import com.milind.assigment.services.CustomersService;

@SpringBootTest
public class CustomersServiceTest {

	@Autowired
	CustomersService customersService;

	@MockBean
	CustomersDAO customersDAO;

	private static List<Customers> mockCustomerList;
	private static List<Orders> mockOrderList;

	@BeforeAll
	public static void initialiseMockCustomersList() {
		mockCustomerList = new ArrayList<>();
		Customers customer1 = makeCustomer("ALFKI", "Alfreds Futterkiste", "Maria Anders", "Sales Representative",
				"Obere Str. 57", "Berlin", null, "12209", "Germany", "030-0074321", "030-0076545");

		Customers customer2 = makeCustomer("ANATR", "Ana Trujillo Emparedados y helados", "Ana Trujillo", "Owner",
				"Avda. de la Constitución 2222", "México D.F.", null, "05021", "Mexico", "(5) 555-4729",
				"(5) 555-3745");
		mockCustomerList.add(customer1);
		mockCustomerList.add(customer2);
	}

	public static Customers initialiseMockCustomerWithOrders() {
		mockOrderList = new ArrayList<>();
		Employees employee = makeEmployee(6, "Suyama", "Michael", "Sales Representative", "Mr.",
				processDate("1963-07-01T18:30:00.000+00:00"), processDate("1993-10-16T18:30:00.000+00:00"),
				"Coventry HouseMiner Rd.", "London", null, "EC2 7JR", "UK", "(71) 555-7773", "428",
				"\"Michael is a graduate of Sussex University (MA economics 1983) and the University of California at Los Angeles (MBA marketing 1986).  He has also taken the courses \"\"Multi-Cultural Selling\"\" and \"\"Time Management for the Sales Professional.\"\"  He is fluent\"",
				null, "http://accweb/emmployees/davolio.bmp", 140000.0f);
		Shippers shipper = makeShipper(1, "Speedy Express", "(503) 555-9831");
		Customers customer = makeCustomer("ALFKI", "Alfreds Futterkiste", "Maria Anders", "Sales Representative",
				"Obere Str. 57", "Berlin", null, "12209", "Germany", "030-0074321", "030-0076545");
		Orders order = makeOrder(10643, customer, employee, processDate("1997-08-24T18:30:00.000+00:00"),
				processDate("1997-09-21T18:30:00.000+00:00"), processDate("1997-09-01T18:30:00.000+00:00"), shipper,
				29.46, "Alfreds Futterkiste", "Obere Str. 57", "Berlin", null, "12209", "Germany");
		mockOrderList.add(order);
		customer.setOrders(mockOrderList);
		return customer;
	}

	public static Customers makeCustomer(String customerId, String companyName, String contactName, String contactTitle,
			String address, String city, String region, String postalCode, String country, String phone, String fax) {
		Customers customer = new Customers();
		customer.setCustomerId(customerId);
		customer.setCompanyName(companyName);
		customer.setContactName(contactName);
		customer.setContactTitle(contactTitle);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setRegion(region);
		customer.setPostalCode(postalCode);
		customer.setCountry(country);
		customer.setPhone(phone);
		customer.setFax(fax);
		return customer;
	}

	public static Orders makeOrder(Integer orderId, Customers customer, Employees employee, ZonedDateTime orderDate,
			ZonedDateTime requiredDate, ZonedDateTime shippedDate, Shippers shipper, Double freight, String shipName,
			String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
		Orders order = new Orders();
		order.setOrderId(orderId);
		order.setCustomer(customer);
		order.setEmployee(employee);
		order.setOrderDate(orderDate);
		order.setRequiredDate(requiredDate);
		order.setShippedDate(shippedDate);
		order.setShipper(shipper);
		order.setFreight(freight);
		order.setShipName(shipName);
		order.setShipAddress(shipAddress);
		order.setShipCity(shipCity);
		order.setShipRegion(shipRegion);
		order.setShipPostalCode(shipPostalCode);
		order.setShipCountry(shipCountry);
		return order;
	}

	public static Employees makeEmployee(Integer employeeId, String lastName, String firstName, String title,
			String titleOfCourtesy, ZonedDateTime birthDate, ZonedDateTime hireDate, String address, String city,
			String region, String postalCode, String country, String homePhone, String extension, String notes,
			Employees reportsTo, String photoPath, Float salary) {
		Employees employee = new Employees();
		employee.setEmployeeId(employeeId);
		employee.setLastName(lastName);
		employee.setFirstName(firstName);
		employee.setTitle(title);
		employee.setTitleOfCourtesy(titleOfCourtesy);
		employee.setBirthDate(birthDate);
		employee.setHireDate(hireDate);
		employee.setAddress(address);
		employee.setCity(city);
		employee.setRegion(region);
		employee.setPostalCode(postalCode);
		employee.setCountry(country);
		employee.setHomePhone(homePhone);
		employee.setExtension(extension);
		employee.setNotes(notes);
		employee.setReportsTo(reportsTo);
		employee.setPhotoPath(photoPath);
		employee.setSalary(salary);
		return employee;
	}

	public static ZonedDateTime processDate(String date) {
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(date);
		return zonedDateTime;
	}

	public static Shippers makeShipper(Integer shipperId, String companyName, String phone) {
		Shippers shipper = new Shippers();
		shipper.setShipperId(shipperId);
		shipper.setCompanyName(companyName);
		shipper.setPhone(phone);
		return shipper;
	}

	@DisplayName("Test to save customer")
	@Test
	public void saveCustomerTest() {
		Customers customer = makeCustomer("ANTON", "Antonio Moreno Taquería", "Antonio Moreno", "Owner",
				"Mataderos  2312", "México D.F.", null, "05023", "Mexico", "(5) 555-3932", null);
		when(customersDAO.saveCustomerToDB(customer)).thenReturn(customer);
		Customers savedCus = customersService.saveCustomer(customer);
		assertTrue(savedCus.equals(customer));
	}

	@DisplayName("Test to update customer")
	@Test
	public void updateCustomerTest() {
		Customers origCus = mockCustomerList.get(0);
		Customers updatedCus = mockCustomerList.get(0);
		updatedCus.setCompanyName("XYZ");
		updatedCus.setContactTitle("Owner");
		when(customersDAO.getCustomerByIdForUpdate(origCus.getCustomerId())).thenReturn(origCus);
		when(customersDAO.updateCustomersInDB(updatedCus)).thenReturn(updatedCus);
		updatedCus = customersService.updateCustomer(updatedCus);
		assertEquals("XYZ", updatedCus.getCompanyName());
		assertEquals("Owner", updatedCus.getContactTitle());
	}

	@DisplayName("Test to get all customers for DB")
	@Test
	public void getAllCustomersTest() {
		when(customersDAO.getAllCustomersFromDB()).thenReturn(mockCustomerList);
		assertEquals(2, customersService.getAllCustomers().size());
	}

	@DisplayName("Test to get a customer using customerID from DB")
	@Test
	public void getCustomerByIdTest() {
		Customers cus = mockCustomerList.get(0);
		when(customersDAO.getCustomerByIdFromDB("ALFKI")).thenReturn(cus);
		assertEquals("ALFKI", customersService.getCustomerById("ALFKI").getCustomerId());
	}

	@DisplayName("Test to get order history of a customer")
	@Test
	public void getOrderHistoryOfCustomerTest() {
		Customers cus = CustomersServiceTest.initialiseMockCustomerWithOrders();
		when(customersDAO.getCustomerByIdFromDB("ALFKI")).thenReturn(cus);
		assertEquals(1, customersService.getOrderHistoryOfCustomer("ALFKI").getOrders().size());
	}

}
