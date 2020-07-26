package com.milind.assigment.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "orderDetails" })
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;
	static Logger logger = LoggerFactory.getLogger(Products.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID")
	private Integer productId;

	@NotNull(message = "Product Name field cannot be NULL")
	@Column(name = "ProductName")
	@Size(min = 1, max = 40)
	private String productName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SupplierID")
	private Suppliers supplier;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CategoryID")
	private Categories category;

	@Column(name = "QuantityPerUnit")
	@Size(max = 20)
	private String quantityPerUnit;

	@Column(name = "UnitPrice", precision = 10, scale = 4)
	private Double unitPrice;

	@Column(name = "UnitsInStock")
	private Integer unitsInStock;

	@Column(name = "UnitsOnOrder")
	private Integer unitsOnOrder;

	@Column(name = "ReorderLevel")
	private Integer reorderLevel;

	@NotNull(message = "Discontinued cannot be NULL")
	@Column(name = "Discontinued")
	private Byte discontinued;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Suppliers getSupplier() {
		return supplier;
	}

	public void setSupplier(Suppliers supplier) {
		this.supplier = supplier;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Integer getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(Integer unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Byte getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Byte discontinued) {
		this.discontinued = discontinued;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public static Products copyValues(Products origProduct, Products product) {
		logger.info("Copying values of updated Product: " + product.toString() + " to Original product: "
				+ origProduct.toString());
		origProduct.setProductName(product.getProductName());
		origProduct.setSupplier(product.getSupplier());
		origProduct.setCategory(product.getCategory());
		origProduct.setQuantityPerUnit(product.getQuantityPerUnit());
		origProduct.setUnitPrice(product.getUnitPrice());
		origProduct.setUnitsInStock(product.getUnitsInStock());
		origProduct.setUnitsOnOrder(product.getUnitsOnOrder());
		origProduct.setReorderLevel(product.getReorderLevel());
		origProduct.setDiscontinued(product.getDiscontinued());
		return origProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((discontinued == null) ? 0 : discontinued.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((quantityPerUnit == null) ? 0 : quantityPerUnit.hashCode());
		result = prime * result + ((reorderLevel == null) ? 0 : reorderLevel.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		result = prime * result + ((unitsInStock == null) ? 0 : unitsInStock.hashCode());
		result = prime * result + ((unitsOnOrder == null) ? 0 : unitsOnOrder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (discontinued == null) {
			if (other.discontinued != null)
				return false;
		} else if (!discontinued.equals(other.discontinued))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (quantityPerUnit == null) {
			if (other.quantityPerUnit != null)
				return false;
		} else if (!quantityPerUnit.equals(other.quantityPerUnit))
			return false;
		if (reorderLevel == null) {
			if (other.reorderLevel != null)
				return false;
		} else if (!reorderLevel.equals(other.reorderLevel))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		if (unitsInStock == null) {
			if (other.unitsInStock != null)
				return false;
		} else if (!unitsInStock.equals(other.unitsInStock))
			return false;
		if (unitsOnOrder == null) {
			if (other.unitsOnOrder != null)
				return false;
		} else if (!unitsOnOrder.equals(other.unitsOnOrder))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", supplier="
				+ supplier.getSupplierId().intValue() + ", category=" + category.getCategoryId().intValue()
				+ ", quantityPerUnit=" + quantityPerUnit + ", unitPrice=" + unitPrice + ", unitsInStock=" + unitsInStock
				+ ", unitsOnOrder=" + unitsOnOrder + ", reorderLevel=" + reorderLevel + ", discontinued=" + discontinued
				+ "]";
	}

}
