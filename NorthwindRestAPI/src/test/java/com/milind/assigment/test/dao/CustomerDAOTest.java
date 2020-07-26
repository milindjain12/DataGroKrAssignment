package com.milind.assigment.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.milind.assigment.dao.CustomersDAO;
import com.milind.assigment.domain.Customers;
import com.milind.assigment.repositories.CustomersRepository;

@SpringBootTest
public class CustomerDAOTest {

	@Autowired
	private CustomersDAO customerDAO;

	@MockBean
	private CustomersRepository customersRepository;
	private static List<Customers> mockCustomerList;

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

	@DisplayName("Test for fetching all customers from DB")
	@Test
	public void getCustomersTest() {
		when(customersRepository.findAll()).thenReturn(mockCustomerList);
		assertEquals(2, customerDAO.getAllCustomersFromDB().size());
	}

	@DisplayName("Test for fetching customer with some ID from DB")
	@Test
	public void getCustomerByIDTest() {
		Optional<Customers> cus = Optional.of(mockCustomerList.get(0));
		when(customersRepository.findById("ALFKI")).thenReturn(cus);
		assertEquals("ALFKI", customerDAO.getCustomerByIdFromDB("ALFKI").getCustomerId());
	}

	@DisplayName("Test for fetching customer with some ID from DB for update operation")
	@Test
	public void getCustomerByIDForUpdateTest() {
		Customers cus = mockCustomerList.get(0);
		when(customersRepository.getOne("ALFKI")).thenReturn(cus);
		assertEquals("ALFKI", customerDAO.getCustomerByIdForUpdate("ALFKI").getCustomerId());
	}

	@DisplayName("Test for updating customer")
	@Test
	public void getCustomerUpdateTest() {
		Customers cus = mockCustomerList.get(0);
		cus.setCompanyName("XYZ");
		cus.setContactTitle("Owner");
		when(customersRepository.save(cus)).thenReturn(cus);
		Customers updatedCus = customerDAO.updateCustomersInDB(cus);
		assertEquals("XYZ", updatedCus.getCompanyName());
		assertEquals("Owner", updatedCus.getContactTitle());
	}

	@DisplayName("Test for saving customerin DB")
	@Test
	public void getCustomerCreateTest() {
		Customers customer = makeCustomer("ANTON", "Antonio Moreno Taquería", "Antonio Moreno", "Owner",
				"Mataderos  2312", "México D.F.", null, "05023", "Mexico", "(5) 555-3932", null);
		when(customersRepository.save(customer)).thenReturn(customer);
		Customers savedCus = customerDAO.saveCustomerToDB(customer);
		assertTrue(savedCus.equals(customer));
	}
}
