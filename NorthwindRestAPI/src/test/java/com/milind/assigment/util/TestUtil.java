package com.milind.assigment.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.milind.assigment.domain.Customers;
import com.milind.assigment.domain.Orders;
import com.milind.assigment.domain.Products;

public class TestUtil {

	public static String convertObjectToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objMap = new ObjectMapper();
		String jsonStr = objMap.writeValueAsString(obj);
		return jsonStr;
	}

	public static Customers convertJsonToCustomer(String jsonStr) {
		ObjectMapper objMap = new ObjectMapper();
		Customers cus = null;
		try {
			cus = objMap.readValue(jsonStr, Customers.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cus;
	}

	public static Products convertJsonToProduct(String jsonStr) {
		ObjectMapper objMap = new ObjectMapper();
		Products pro = null;
		try {
			pro = objMap.readValue(jsonStr, Products.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro;
	}

	@SuppressWarnings("unchecked")
	public static List<Customers> convertListOfCustomersToJSON(String jsonStr) {
		ObjectMapper objMap = new ObjectMapper();
		List<Customers> objs = null;
		try {
			objs = objMap.readValue(jsonStr, List.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	@SuppressWarnings("unchecked")
	public static List<Orders> convertListOfOrdersToJSON(String jsonStr) {
		ObjectMapper objMap = new ObjectMapper();
		List<Orders> objs = null;
		try {
			objs = objMap.readValue(jsonStr, List.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	@SuppressWarnings("unchecked")
	public static List<Products> convertListOfProductsToJSON(String jsonStr) {
		ObjectMapper objMap = new ObjectMapper();
		List<Products> objs = null;
		try {
			objs = objMap.readValue(jsonStr, List.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}
}
