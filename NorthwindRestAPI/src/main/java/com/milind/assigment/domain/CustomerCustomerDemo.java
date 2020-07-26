package com.milind.assigment.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CustomerCustomerDemo")
public class CustomerCustomerDemo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerCustomerDemoId customerCustomerDemoId;

	@NotNull(message = "Customer ID cannot be NULL")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CustomerID")
	private Customers customer;

	@NotNull(message = "Customer Type ID cannot be NULL")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CustomerTypeID")
	private CustomerDemographics customerDemographics;

	public CustomerCustomerDemoId getCustomerCustomerDemoId() {
		return customerCustomerDemoId;
	}

	public void setCustomerCustomerDemoId(CustomerCustomerDemoId customerCustomerDemoId) {
		this.customerCustomerDemoId = customerCustomerDemoId;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public CustomerDemographics getCustomerDemographics() {
		return customerDemographics;
	}

	public void setCustomerDemographics(CustomerDemographics customerDemographics) {
		this.customerDemographics = customerDemographics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((customerCustomerDemoId == null) ? 0 : customerCustomerDemoId.hashCode());
		result = prime * result + ((customerDemographics == null) ? 0 : customerDemographics.hashCode());
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
		CustomerCustomerDemo other = (CustomerCustomerDemo) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (customerCustomerDemoId == null) {
			if (other.customerCustomerDemoId != null)
				return false;
		} else if (!customerCustomerDemoId.equals(other.customerCustomerDemoId))
			return false;
		if (customerDemographics == null) {
			if (other.customerDemographics != null)
				return false;
		} else if (!customerDemographics.equals(other.customerDemographics))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerCustomerDemo [customerCustomerDemo=" + customerCustomerDemoId + "]";
	}

}
