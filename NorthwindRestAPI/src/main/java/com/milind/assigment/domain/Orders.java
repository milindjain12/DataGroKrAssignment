package com.milind.assigment.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "orderdetails" })
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	private Integer orderId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CustomerID")
	private Customers customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EmployeeID")
	private Employees employee;

	@Column(name = "OrderDate")
	private ZonedDateTime orderDate;

	@Column(name = "RequiredDate")
	private ZonedDateTime requiredDate;

	@Column(name = "ShippedDate")
	private ZonedDateTime shippedDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ShipVia")
	private Shippers shipper;

	@Column(name = "Freight", precision = 10, scale = 4)
	private Double freight;

	@Column(name = "ShipName")
	@Size(max = 40)
	private String shipName;

	@Column(name = "ShipAddress")
	@Size(max = 60)
	private String shipAddress;

	@Column(name = "ShipCity")
	@Size(max = 15)
	private String shipCity;

	@Column(name = "ShipRegion")
	@Size(max = 15)
	private String shipRegion;

	@Column(name = "ShipPostalCode")
	@Size(max = 10)
	private String shipPostalCode;

	@Column(name = "ShipCountry")
	@Size(max = 15)
	private String shipCountry;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderDetails> orderdetails;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public ZonedDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(ZonedDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public ZonedDateTime getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(ZonedDateTime requiredDate) {
		this.requiredDate = requiredDate;
	}

	public ZonedDateTime getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(ZonedDateTime shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Shippers getShipper() {
		return shipper;
	}

	public void setShipper(Shippers shipper) {
		this.shipper = shipper;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipRegion() {
		return shipRegion;
	}

	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}

	public String getShipPostalCode() {
		return shipPostalCode;
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public List<OrderDetails> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<OrderDetails> orderdetails) {
		this.orderdetails = orderdetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((freight == null) ? 0 : freight.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((requiredDate == null) ? 0 : requiredDate.hashCode());
		result = prime * result + ((shipAddress == null) ? 0 : shipAddress.hashCode());
		result = prime * result + ((shipCity == null) ? 0 : shipCity.hashCode());
		result = prime * result + ((shipCountry == null) ? 0 : shipCountry.hashCode());
		result = prime * result + ((shipName == null) ? 0 : shipName.hashCode());
		result = prime * result + ((shipPostalCode == null) ? 0 : shipPostalCode.hashCode());
		result = prime * result + ((shipRegion == null) ? 0 : shipRegion.hashCode());
		result = prime * result + ((shippedDate == null) ? 0 : shippedDate.hashCode());
		result = prime * result + ((shipper == null) ? 0 : shipper.hashCode());
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
		Orders other = (Orders) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (freight == null) {
			if (other.freight != null)
				return false;
		} else if (!freight.equals(other.freight))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (requiredDate == null) {
			if (other.requiredDate != null)
				return false;
		} else if (!requiredDate.equals(other.requiredDate))
			return false;
		if (shipAddress == null) {
			if (other.shipAddress != null)
				return false;
		} else if (!shipAddress.equals(other.shipAddress))
			return false;
		if (shipCity == null) {
			if (other.shipCity != null)
				return false;
		} else if (!shipCity.equals(other.shipCity))
			return false;
		if (shipCountry == null) {
			if (other.shipCountry != null)
				return false;
		} else if (!shipCountry.equals(other.shipCountry))
			return false;
		if (shipName == null) {
			if (other.shipName != null)
				return false;
		} else if (!shipName.equals(other.shipName))
			return false;
		if (shipPostalCode == null) {
			if (other.shipPostalCode != null)
				return false;
		} else if (!shipPostalCode.equals(other.shipPostalCode))
			return false;
		if (shipRegion == null) {
			if (other.shipRegion != null)
				return false;
		} else if (!shipRegion.equals(other.shipRegion))
			return false;
		if (shippedDate == null) {
			if (other.shippedDate != null)
				return false;
		} else if (!shippedDate.equals(other.shippedDate))
			return false;
		if (shipper == null) {
			if (other.shipper != null)
				return false;
		} else if (!shipper.equals(other.shipper))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customer=" + customer.getCustomerId() + ", employee="
				+ employee.getEmployeeId().intValue() + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", shipper=" + shipper.getShipperId().intValue() + ", freight="
				+ freight + ", shipName=" + shipName + ", shipAddress=" + shipAddress + ", shipCity=" + shipCity
				+ ", shipRegion=" + shipRegion + ", shipPostalCode=" + shipPostalCode + ", shipCountry=" + shipCountry
				+ "]";
	}

}
