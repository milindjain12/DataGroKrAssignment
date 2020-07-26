package com.milind.assigment.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "orders", "customerCustomerDemos" })
public class Customers implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CustomerID")
	@Size(min = 5, max = 5)
	private String customerId;

	@NotNull(message = "Company Name cannot NULL")
	@Column(name = "CompanyName")
	@Size(min = 1, max = 40)
	private String companyName;

	@Column(name = "ContactName")
	@Size(max = 30)
	private String contactName;

	@Column(name = "ContactTitle")
	@Size(max = 30)
	private String contactTitle;

	@Column(name = "Address")
	@Size(max = 60)
	private String address;

	@Column(name = "City")
	@Size(max = 15)
	private String city;

	@Column(name = "Region")
	@Size(max = 15)
	private String region;

	@Column(name = "PostalCode")
	@Size(max = 10)
	private String postalCode;

	@Column(name = "Country")
	@Size(max = 15)
	private String country;

	@Column(name = "Phone")
	@Size(max = 24)
	private String phone;

	@Column(name = "Fax")
	@Size(max = 24)
	private String fax;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Orders> orders;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CustomerCustomerDemo> customerCustomerDemos;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<CustomerCustomerDemo> getCustomerCustomerDemos() {
		return customerCustomerDemos;
	}

	public void setCustomerCustomerDemos(List<CustomerCustomerDemo> customerCustomerDemos) {
		this.customerCustomerDemos = customerCustomerDemos;
	}
	
	public static Customers copyValues(Customers origCustomers, Customers customer) {
		origCustomers.setCompanyName(customer.getCompanyName());
		origCustomers.setContactName(customer.getContactName());
		origCustomers.setContactTitle(customer.getContactTitle());
		origCustomers.setAddress(customer.getAddress());
		origCustomers.setCity(customer.getCity());
		origCustomers.setRegion(customer.getRegion());
		origCustomers.setPostalCode(customer.getPostalCode());
		origCustomers.setCountry(customer.getCountry());
		origCustomers.setPhone(customer.getPhone());
		origCustomers.setFax(customer.getFax());
		return origCustomers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((contactTitle == null) ? 0 : contactTitle.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
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
		Customers other = (Customers) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (contactTitle == null) {
			if (other.contactTitle != null)
				return false;
		} else if (!contactTitle.equals(other.contactTitle))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", companyName=" + companyName + ", contactName=" + contactName
				+ ", contactTitle=" + contactTitle + ", address=" + address + ", city=" + city + ", region=" + region
				+ ", postalCode=" + postalCode + ", country=" + country + ", phone=" + phone + ", fax=" + fax + "]";
	}

}
