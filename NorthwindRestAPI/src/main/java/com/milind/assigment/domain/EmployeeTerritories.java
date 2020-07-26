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
@Table(name = "employeeterritories")
public class EmployeeTerritories implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeeTerritoriesId employeeTerritoriesId;

	@NotNull(message = "Employee ID cannot be NULL")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EmployeeID")
	private Employees employee;

	@NotNull(message = "Territory ID cannot be NULL")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TerritoryID")
	private Territories territory;

	public EmployeeTerritoriesId getEmployeeTerritoriesId() {
		return employeeTerritoriesId;
	}

	public void setEmployeeTerritoriesId(EmployeeTerritoriesId employeeTerritoriesId) {
		this.employeeTerritoriesId = employeeTerritoriesId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Territories getTerritory() {
		return territory;
	}

	public void setTerritory(Territories territory) {
		this.territory = territory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((employeeTerritoriesId == null) ? 0 : employeeTerritoriesId.hashCode());
		result = prime * result + ((territory == null) ? 0 : territory.hashCode());
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
		EmployeeTerritories other = (EmployeeTerritories) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (employeeTerritoriesId == null) {
			if (other.employeeTerritoriesId != null)
				return false;
		} else if (!employeeTerritoriesId.equals(other.employeeTerritoriesId))
			return false;
		if (territory == null) {
			if (other.territory != null)
				return false;
		} else if (!territory.equals(other.territory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeTerritories [EmployeeTerritories=" + employeeTerritoriesId + "]";
	}

}
