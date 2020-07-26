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

/*
 * @author Milind Jain
 */

@Entity
@Table(name = "region")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "territories" })
public class Region implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RegionID")
	private Integer regionId;

	@NotNull(message = "Region Description field cannot NULL")
	@Column(name = "RegionDescription")
	@Size(min = 1, max = 50)
	private String regionDescription;

	@OneToMany(mappedBy = "region", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Territories> territories;

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionDescription() {
		return regionDescription;
	}

	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}

	public List<Territories> getTerritories() {
		return territories;
	}

	public void setTerritories(List<Territories> territories) {
		this.territories = territories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regionDescription == null) ? 0 : regionDescription.hashCode());
		result = prime * result + ((regionId == null) ? 0 : regionId.hashCode());
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
		Region other = (Region) obj;
		if (regionDescription == null) {
			if (other.regionDescription != null)
				return false;
		} else if (!regionDescription.equals(other.regionDescription))
			return false;
		if (regionId == null) {
			if (other.regionId != null)
				return false;
		} else if (!regionId.equals(other.regionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionDescription=" + regionDescription + "]";
	}

}
