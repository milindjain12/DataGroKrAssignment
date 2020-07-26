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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "shippers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "orders" })
public class Shippers implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShipperID")
	private Integer ShipperId;

	@NotNull(message = "Company name field cannot be NULL")
	@Column(name = "CompanyName")
	@Size(min = 1, max = 40)
	private String companyName;

	@Column(name = "Phone")
	@Size(max = 24)
	private String phone;

	@OneToMany(mappedBy = "shipper", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Orders> orders;

	public Integer getShipperId() {
		return ShipperId;
	}

	public void setShipperId(Integer shipperId) {
		ShipperId = shipperId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrder(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ShipperId == null) ? 0 : ShipperId.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Shippers other = (Shippers) obj;
		if (ShipperId == null) {
			if (other.ShipperId != null)
				return false;
		} else if (!ShipperId.equals(other.ShipperId))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shippers [ShipperId=" + ShipperId + ", companyName=" + companyName + ", phone=" + phone + "]";
	}

}
