package com.milind.assigment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class EmployeeTerritoriesId implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column
	private Integer employeeId;

	@NotNull
	@Column
	@Size(min = 20, max = 20)
	private String territoryId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public String getTerritoryId() {
		return territoryId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((territoryId == null) ? 0 : territoryId.hashCode());
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
		EmployeeTerritoriesId other = (EmployeeTerritoriesId) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (territoryId == null) {
			if (other.territoryId != null)
				return false;
		} else if (!territoryId.equals(other.territoryId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "employeeId=" + employeeId + ", territoryId=" + territoryId;
	}

}
