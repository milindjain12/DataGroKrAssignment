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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CustomerDemgraphics")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "customerCustomerDemos" })
public class CustomerDemographics implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CustomerTypeID")
	@Size(min = 5, max = 10)
	private String customerTypeId;

	@Column(name = "CustomerDesc")
	private String customerDesc;

	@OneToMany(mappedBy = "customerDemographics", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CustomerCustomerDemo> customerCustomerDemos;

	public String getCustomerTypeId() {
		return customerTypeId;
	}

	public void setCustomerTypeId(String customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public String getCustomerDesc() {
		return customerDesc;
	}

	public void setCustomerDesc(String customerDesc) {
		this.customerDesc = customerDesc;
	}

	public List<CustomerCustomerDemo> getCustomerCustomerDemos() {
		return customerCustomerDemos;
	}

	public void setCustomerCustomerDemos(List<CustomerCustomerDemo> customerCustomerDemos) {
		this.customerCustomerDemos = customerCustomerDemos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerDesc == null) ? 0 : customerDesc.hashCode());
		result = prime * result + ((customerTypeId == null) ? 0 : customerTypeId.hashCode());
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
		CustomerDemographics other = (CustomerDemographics) obj;
		if (customerDesc == null) {
			if (other.customerDesc != null)
				return false;
		} else if (!customerDesc.equals(other.customerDesc))
			return false;
		if (customerTypeId == null) {
			if (other.customerTypeId != null)
				return false;
		} else if (!customerTypeId.equals(other.customerTypeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerDemographics [customerTypeId=" + customerTypeId + ", customerDesc=" + customerDesc + "]";
	}

}
