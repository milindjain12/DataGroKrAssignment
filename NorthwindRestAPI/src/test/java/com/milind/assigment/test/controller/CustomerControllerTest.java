package com.milind.assigment.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.milind.assigment.controllers.CustomerController;
import com.milind.assigment.domain.Customers;
import com.milind.assigment.domain.Employees;
import com.milind.assigment.domain.Orders;
import com.milind.assigment.domain.Shippers;
import com.milind.assigment.services.CustomersService;
import com.milind.assigment.util.TestUtil;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	CustomersService customerService;

	private static final String URL = "/customers/";

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

	@DisplayName("Testing Controller for fetching customer by ID")
	@Test
	void getCustomerByIdTest() {
		Customers cus = mockCustomerList.get(0);
		when(customerService.getCustomerById("ALFKI")).thenReturn(cus);
		MvcResult result = null;
		try {
			result = mockMvc
					.perform(MockMvcRequestBuilders.get(URL + "ALFKI").contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON).content(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk()).andReturn();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		verify(customerService).getCustomerById("ALFKI");

		Customers resultCustomer = null;
		try {
			resultCustomer = TestUtil.convertJsonToCustomer(result.getResponse().getContentAsString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assertNotNull(resultCustomer);
		assertEquals("ALFKI", resultCustomer.getCustomerId());
	}

	@DisplayName("Testing controller for saving customer in DB")
	@Test
	void saveCustomer() {
		Customers customer = makeCustomer("ANTON", "Antonio Moreno Taquería", "Antonio Moreno", "Owner",
				"Mataderos  2312", "México D.F.", null, "05023", "Mexico", "(5) 555-3932", null);
		when(customerService.saveCustomer(customer)).thenReturn(customer);
		MvcResult result = null;
		try {
			result = mockMvc
					.perform(MockMvcRequestBuilders.post(URL).contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJson(customer)))
					.andReturn();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.CREATED.value(), status, "Incorrect Response Status");

		verify(customerService).saveCustomer(any(Customers.class));

		Customers resultCustomer = null;
		try {
			resultCustomer = TestUtil.convertJsonToCustomer(result.getResponse().getContentAsString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assertNotNull(resultCustomer);
		assertEquals("ANTON", resultCustomer.getCustomerId());
	}

	@DisplayName("Testing controller to update a customer in DB")
	@Test
	void updateCustomerTest() {
		Customers updatedCus = mockCustomerList.get(0);
		updatedCus.setCompanyName("XYZ");
		updatedCus.setContactTitle("Owner");
		when(customerService.updateCustomer(updatedCus)).thenReturn(updatedCus);
		MvcResult result = null;
		try {
			result = mockMvc
					.perform(MockMvcRequestBuilders.put(URL).contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJson(updatedCus)))
					.andReturn();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");

		verify(customerService).updateCustomer(any(Customers.class));

		Customers resultCustomer = null;
		try {
			resultCustomer = TestUtil.convertJsonToCustomer(result.getResponse().getContentAsString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assertNotNull(resultCustomer);
		assertEquals("XYZ", resultCustomer.getCompanyName());
		assertEquals("Owner", resultCustomer.getContactTitle());
	}

	@DisplayName("Testing Controller for fetching all orders of a customer from DB")
	@Test
	void getCustomerOrderHistory() {
		Customers cus = CustomerControllerTest.initialiseMockCustomerWithOrders();
		when(customerService.getOrderHistoryOfCustomer("ALFKI")).thenReturn(cus);
		MvcResult result = null;
		try {
			result = mockMvc
					.perform(MockMvcRequestBuilders.get(URL + "/orders/ALFKI").contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON).content(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk()).andReturn();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		verify(customerService).getOrderHistoryOfCustomer("ALFKI");
		List<Orders> resultOrders = null;
		try {
			resultOrders = TestUtil.convertListOfOrdersToJSON(result.getResponse().getContentAsString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assertEquals(1, resultOrders.size());
	}

	@DisplayName("Testing Controller for fetching all customers from DB")
	@Test
	void getAllCustomers() {
		when(customerService.getAllCustomers()).thenReturn(mockCustomerList);
		MvcResult result = null;
		try {
			result = mockMvc
					.perform(MockMvcRequestBuilders.get(URL).contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON).content(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk()).andReturn();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		verify(customerService).getAllCustomers();

		List<Customers> resultCustomers = null;
		try {
			resultCustomers = TestUtil.convertListOfCustomersToJSON(result.getResponse().getContentAsString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assertEquals(2, resultCustomers.size());
	}

}
