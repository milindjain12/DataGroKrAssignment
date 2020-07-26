package com.milind.assigment.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "territories")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employeeTerritories" })
public class Territories implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TerritoryID")
	@Size(min = 5, max = 20)
	private String territoryId;

	@NotNull(message = "Territory Description field cannot be NULL")
	@Column(name = "TerritoryDescription")
	@Size(min = 1, max = 50)
	private String territoryDescription;

	@NotNull(message = "Region ID field cannot be NULL")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "RegionID")
	private Region region;

	@OneToMany(mappedBy = "territory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EmployeeTerritories> employeeTerritories;

	public String getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(String territoryId) {
		this.territoryId = territoryId;
	}

	public String getTerritoryDescription() {
		return territoryDescription;
	}

	public void setTerritoryDescription(String territoryDescription) {
		this.territoryDescription = territoryDescription;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<EmployeeTerritories> getEmployeeTerritories() {
		return employeeTerritories;
	}

	public void setEmployeeTerritories(List<EmployeeTerritories> employeeTerritories) {
		this.employeeTerritories = employeeTerritories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((territoryDescription == null) ? 0 : territoryDescription.hashCode());
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
		Territories other = (Territories) obj;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (territoryDescription == null) {
			if (other.territoryDescription != null)
				return false;
		} else if (!territoryDescription.equals(other.territoryDescription))
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
		return "Territories [territoryId=" + territoryId + ", territoryDescription=" + territoryDescription
				+ ", region=" + region.getRegionId().intValue() + "]";
	}

}
