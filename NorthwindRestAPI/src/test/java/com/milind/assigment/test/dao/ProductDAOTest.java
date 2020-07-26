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

import com.milind.assigment.dao.ProductsDAO;
import com.milind.assigment.domain.Categories;
import com.milind.assigment.domain.Products;
import com.milind.assigment.domain.Suppliers;
import com.milind.assigment.repositories.ProductsRepository;

@SpringBootTest
public class ProductDAOTest {
	@Autowired
	private ProductsDAO productsDAO;

	@MockBean
	private ProductsRepository productsRepository;
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

	public static Suppliers makeSupplier(Integer supplierId, String companyName, String contactName, String contactTitle,
			String address, String city, String region, String postalCode, String country, String phone, String fax,
			String homePage) {
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

	@DisplayName("Test for fetching all products from DB")
	@Test
	public void getProductsTest() {
		when(productsRepository.findAll()).thenReturn(mockProductList);
		assertEquals(2, productsDAO.getAllProductsFromDB().size());
	}

	@DisplayName("Test for fetching product with some ID from DB")
	@Test
	public void getCustomerByIDTest() {
		Optional<Products> pro = Optional.of(mockProductList.get(0));
		when(productsRepository.findById(1)).thenReturn(pro);
		assertEquals(1, productsDAO.getProductByIdFromDB(1).getProductId());
	}

	@DisplayName("Test for fetching product with some ID from DB for update operation")
	@Test
	public void getProductByIDForUpdateTest() {
		Products pro = mockProductList.get(0);
		when(productsRepository.getOne(1)).thenReturn(pro);
		assertEquals(1, productsDAO.getProductByIdForUpdate(1).getProductId());
	}

	@DisplayName("Test for updating product")
	@Test
	public void getProductUpdateTest() {
		Products pro = mockProductList.get(1);
		pro.setProductName("XYZ");
		pro.setUnitsInStock(15);
		when(productsRepository.save(pro)).thenReturn(pro);
		Products updatePro = productsDAO.updateProductInDB(pro);
		assertEquals("XYZ", updatePro.getProductName());
		assertEquals(15, updatePro.getUnitsInStock());
	}

	@DisplayName("Test for saving product DB")
	@Test
	public void getProductCreateTest() {
		Suppliers supplier = makeSupplier(2, "New Orleans Cajun Delights", "Shelley Burke", "Order Administrator",
				"P.O. Box 78934", "New Orleans", "LA", "70117", "USA", "(100) 555-4822", null, "#CAJUN.HTM#\r");
		Categories category = makeCategory(2, "Condiments", "Sweet and savory sauces relishes spreads and seasonings\r");
 		Products product = makeProduct(3, "Aniseed Syrup", supplier, category, "12 - 550 ml bottles", 10.0, 13, 70, 25, (byte)0);
		when(productsRepository.save(product)).thenReturn(product);
		Products savedPro = productsDAO.saveProductToDB(product);
		assertTrue(savedPro.equals(product));
	}
}
