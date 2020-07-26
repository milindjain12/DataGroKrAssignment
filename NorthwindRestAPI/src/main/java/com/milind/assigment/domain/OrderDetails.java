package com.milind.assigment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orderdetails")
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailsId orderDetailsId;

	@NotNull(message = "Order ID cannot NULL")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OrderID")
	private Orders order;

	@NotNull(message = "Product ID cannot NULL")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ProductID")
	private Products product;

	@NotNull(message = "Unit Price field cannot NULL")
	@Column(name = "UnitPrice", precision = 10, scale = 4)
	private Float unitPrice;

	@NotNull(message = "Quantity field cannot NULL")
	@Column(name = "Quantity")
	private Integer quantity;

	@NotNull(message = "Discount field cannot NULL")
	@Column(name = "Discount", precision = 8, scale = 0)
	private Double discount;

	public OrderDetailsId getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(OrderDetailsId orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((orderDetailsId == null) ? 0 : orderDetailsId.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		OrderDetails other = (OrderDetails) obj;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (orderDetailsId == null) {
			if (other.orderDetailsId != null)
				return false;
		} else if (!orderDetailsId.equals(other.orderDetailsId))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetails=" + orderDetailsId + ", unitPrice=" + unitPrice + ", quantity=" + quantity
				+ ", discount=" + discount + "]";
	}

}
