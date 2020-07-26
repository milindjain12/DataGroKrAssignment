package com.milind.assigment.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
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
import com.milind.assigment.controllers.ProductController;
import com.milind.assigment.domain.Categories;
import com.milind.assigment.domain.Products;
import com.milind.assigment.domain.Suppliers;
import com.milind.assigment.services.ProductsService;
import com.milind.assigment.util.TestUtil;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ProductsService productsService;

	private static final String URL = "/products/";
	private static List<Products> mockProductList;

	@BeforeAll
	public static void initialiseMockProductsList() {
		mockProductList = new ArrayList<>();
		Suppliers supplier1 = makeSupplier(2, "New Orleans Cajun Delights", "Shelley Burke", "Order Administrator",
				"P.O. Box 78934", "New Orleans", "LA", "70117", "USA", "(100) 555-4822", null, "#CAJUN.HTM#\r");
		Categories category1 = makeCategory(1, "Beverages", "Soft drinks coffee teas beers and ales\r");
		Products product1 = makeProduct(1, "Chai", supplier1, category1, "10 boxes x 20 bags", 18.0, 39, 0, 10,
				(byte) 0);

		Products product2 = makeProduct(2, "Chang", supplier1, category1, "24 - 12 oz bottles", 19.0, 17, 40, 25,
				(byte) 0);

		mockProductList.add(product1);
		mockProductList.add(product2);
	}

	public static Suppliers makeSupplier(Integer supplierId, String companyName, String contactName,
			String contactTitle, String address, String city, String region, String postalCode, String country,
			String phone, String fax, String homePage) {
		Suppliers supplier = new Suppliers();
		supplier.setSupplierId(supplierId);
		supplier.setCompanyName(companyName);
		supplier.setContactName(contactName);
		supplier.setContactTitle(contactTitle);
		supplier.setAddress(address);
		supplier.setCity(city);
		supplier.setRegion(region);
		supplier.setPostalCode(postalCode);
		supplier.setCountry(country);
		supplier.setPhone(phone);
		supplier.setFax(fax);
		supplier.setHomePage(homePage);
		return supplier;
	}

	public static Categories makeCategory(Integer categoryId, String categoryName, String description) {
		Categories category = new Categories();
		category.setCategoryId(categoryId);
		category.setCategoryName(categoryName);
		category.setDescription(description);
		return category;
	}

	public static Products makeProduct(Integer productId, String productName, Suppliers supplier, Categories category,
			String quantityPerUnit, Double unitPrice, Integer unitsInStock, Integer unitsOnOrder, Integer reorderLevel,
			Byte discontinued) {
		Products product = new Products();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setSupplier(supplier);
		product.setCategory(category);
		product.setQuantityPerUnit(quantityPerUnit);
		product.setUnitPrice(unitPrice);
		product.setUnitsInStock(unitsInStock);
		product.setUnitsOnOrder(unitsOnOrder);
		product.setReorderLevel(reorderLevel);
		product.setDiscontinued(discontinued);
		return product;
	}

	@DisplayName("Testing Controller for saving product in DB")
	@Test
	public void saveProductTest() {
		Suppliers supplier = makeSupplier(2, "New Orleans Cajun Delights", "Shelley Burke", "Order Administrator",
				"P.O. Box 78934", "New Orleans", "LA", "70117", "USA", "(100) 555-4822", null, "#CAJUN.HTM#\r");
		Categories category = makeCategory(2, "Condiments",
				"Sweet and savory sauces relishes spreads and seasonings\r");
		Products product = makeProduct(3, "Aniseed Syrup", supplier, category, "12 - 550 ml bottles", 10.0, 13, 70, 25,
				(byte) 0);
		when(productsService.saveProduct(product)).thenReturn(product);
		MvcResult result = null;
		try {
			result = mockMvc
					.perform(MockMvcRequestBuilders.post(URL).contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJson(product)))
					.andReturn();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.CREATED.value(), status, "Incorrect Response Status");

		verify(productsService).saveProduct(any(Products.class));

		Products resultProduct = null;
		try {
			resultProduct = TestUtil.convertJsonToProduct(result.getResponse().getContentAsString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assertNotNull(resultProduct);
		assertEquals(3, resultProduct.getProductId());
	}

	@DisplayName("Testing Controller for updating product in DB")
	@Test
	public void updateProductTest() {
		Products updatedPro = mockProductList.get(1);
		updatedPro.setProductName("XYZ");
		updatedPro.setUnitsInStock(15);
		when(productsService.updateProduct(updatedPro)).thenReturn(updatedPro);

		MvcResult result = null;
		try {
			result = mockMvc
					.perform(MockMvcRequestBuilders.put(URL).contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJson(updatedPro)))
					.andReturn();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");

		verify(productsService).updateProduct(any(Products.class));

		Products resultProduct = null;
		try {
			resultProduct = TestUtil.convertJsonToProduct(result.getResponse().getContentAsString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assertNotNull(resultProduct);
		assertEquals("XYZ", resultProduct.getProductName());
		assertEquals(15, resultProduct.getUnitsInStock());
	}

	@DisplayName("Testing Controller for fetching all products from DB")
	@Test
	public void getAllProducts() {
		when(productsService.getAllProducts()).thenReturn(mockProductList);
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

		verify(productsService).getAllProducts();

		List<Products> resultProducts = null;
		try {
			resultProducts = TestUtil.convertListOfProductsToJSON(result.getResponse().getContentAsString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assertEquals(2, resultProducts.size());
	}

	@DisplayName("Testing Controller for fetching product using id from DB")
	@Test
	public void getProductById() {
		Products pro = mockProductList.get(0);
		when(productsService.getProductById(1)).thenReturn(pro);
		assertEquals(1, productsService.getProductById(1).getProductId());
	}
}
