package com.milind.assigment.test.service;

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

import com.milind.assigment.domain.Categories;
import com.milind.assigment.domain.Products;
import com.milind.assigment.domain.Suppliers;
import com.milind.assigment.repositories.ProductsRepository;
import com.milind.assigment.services.ProductsService;

@SpringBootTest
public class ProductsServiceTest {

	@Autowired
	ProductsService productsService;

	@MockBean
	ProductsRepository productsRepository;
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

	@DisplayName("Test for saving product")
	@Test
	public void saveProductTest() {
		Suppliers supplier = makeSupplier(2, "New Orleans Cajun Delights", "Shelley Burke", "Order Administrator",
				"P.O. Box 78934", "New Orleans", "LA", "70117", "USA", "(100) 555-4822", null, "#CAJUN.HTM#\r");
		Categories category = makeCategory(2, "Condiments",
				"Sweet and savory sauces relishes spreads and seasonings\r");
		Products product = makeProduct(3, "Aniseed Syrup", supplier, category, "12 - 550 ml bottles", 10.0, 13, 70, 25,
				(byte) 0);
		when(productsRepository.save(product)).thenReturn(product);
		Products savedPro = productsService.saveProduct(product);
		assertTrue(savedPro.equals(product));
	}

	@DisplayName("Test for updating product")
	@Test
	public void updateProductTest() {
		Products origPro = mockProductList.get(1);
		Products updatedPro = mockProductList.get(1);
		updatedPro.setProductName("XYZ");
		updatedPro.setUnitsInStock(15);
		when(productsRepository.getOne(origPro.getProductId())).thenReturn(origPro);
		when(productsRepository.save(updatedPro)).thenReturn(updatedPro);
		updatedPro = productsService.updateProduct(updatedPro);
		assertEquals("XYZ", updatedPro.getProductName());
		assertEquals(15, updatedPro.getUnitsInStock());
	}

	@DisplayName("Test for getting all products from DB")
	@Test
	public void getAllProductsTest() {
		when(productsRepository.findAll()).thenReturn(mockProductList);
		assertEquals(2, productsService.getAllProducts().size());
	}

	@DisplayName("Test for getting a product with product id from DB")
	@Test
	public void getProductByIdTest() {
		Optional<Products> pro = Optional.of(mockProductList.get(0));
		when(productsRepository.findById(1)).thenReturn(pro);
		assertEquals(1, productsService.getProductById(1).getProductId());
	}

}
