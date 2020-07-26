package com.milind.assigment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class CustomerCustomerDemoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column
	@Size(min = 5, max = 5)
	private String customerId;

	@NotNull
	@Column(nullable = false)
	@Size(min = 10, max = 10)
	private String customerTypeId;

	public String getCustomerId() {
		return customerId;
	}

	public String getCustomerTypeId() {
		return customerTypeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
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
		CustomerCustomerDemoId other = (CustomerCustomerDemoId) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
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
		return "customerId=" + customerId + ", customerTypeId=" + customerTypeId;
	}

}
