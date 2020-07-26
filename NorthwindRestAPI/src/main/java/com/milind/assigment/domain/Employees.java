package com.milind.assigment.domain;

/** Represents an entity for employee.
 * @author Milind Jain
 * @version 1.0
*/

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employees")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employees", "employeeTerritories", "orders" })
public class Employees implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeID")
	private Integer employeeId;

	@NotNull(message = "Last Name cannot NULL")
	@Column(name = "LastName")
	@Size(min = 1, max = 20)
	private String lastName;

	@NotNull(message = "First Name cannot NULL")
	@Column(name = "FirstName")
	@Size(min = 1, max = 10)
	private String firstName;

	@Column(name = "Title")
	@Size(max = 30)
	private String title;

	@Column(name = "TitleOfCourtesy", length = 25)
	@Size(max = 25)
	private String titleOfCourtesy;

	@Column(name = "BirthDate")
	private ZonedDateTime birthDate;

	@Column(name = "HireDate")
	private ZonedDateTime hireDate;

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

	@Column(name = "HomePhone")
	@Size(max = 24)
	private String homePhone;

	@Column(name = "Extension")
	@Size(max = 4)
	private String extension;

	@NotNull(message = "Notes Field cannot NULL")
	@Column(name = "Notes")
	private String notes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ReportsTo")
	private Employees reportsTo;

	@OneToMany(mappedBy = "reportsTo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Employees> employees;

	@Column(name = "PhotoPath")
	@Size(max = 255)
	private String photoPath;

	@Column(name = "Salary")
	private Float salary;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EmployeeTerritories> employeeTerritories;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Orders> orders;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleOfCourtesy() {
		return titleOfCourtesy;
	}

	public void setTitleOfCourtesy(String titleOfCourtesy) {
		this.titleOfCourtesy = titleOfCourtesy;
	}

	public ZonedDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(ZonedDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public ZonedDateTime getHireDate() {
		return hireDate;
	}

	public void setHireDate(ZonedDateTime hireDate) {
		this.hireDate = hireDate;
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

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Employees getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(Employees reportsTo) {
		this.reportsTo = reportsTo;
	}

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public List<EmployeeTerritories> getEmployeeTerritories() {
		return employeeTerritories;
	}

	public void setEmployeeTerritories(List<EmployeeTerritories> employeeTerritories) {
		this.employeeTerritories = employeeTerritories;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((photoPath == null) ? 0 : photoPath.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((reportsTo == null) ? 0 : reportsTo.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((titleOfCourtesy == null) ? 0 : titleOfCourtesy.hashCode());
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
		Employees other = (Employees) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (photoPath == null) {
			if (other.photoPath != null)
				return false;
		} else if (!photoPath.equals(other.photoPath))
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
		if (reportsTo == null) {
			if (other.reportsTo != null)
				return false;
		} else if (!reportsTo.equals(other.reportsTo))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (titleOfCourtesy == null) {
			if (other.titleOfCourtesy != null)
				return false;
		} else if (!titleOfCourtesy.equals(other.titleOfCourtesy))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", title=" + title + ", titleOfCourtesy=" + titleOfCourtesy + ", birthDate=" + birthDate
				+ ", hireDate=" + hireDate + ", address=" + address + ", city=" + city + ", region=" + region
				+ ", postalCode=" + postalCode + ", country=" + country + ", homePhone=" + homePhone + ", extension="
				+ extension + ", notes=" + notes + ", reportsTo=" + reportsTo.employeeId.intValue() + ", photoPath="
				+ photoPath + ", salary=" + salary + "]";
	}

}
