package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mechanic")
public class MechanicEntity {
	@Id
	private Integer mechanicId;
	private String mechanicType;
	private Integer numberOfVehicles;
	public Integer getMechanicId() {
		return mechanicId;
	}
	public void setMechanicId(Integer mechanicId) {
		this.mechanicId = mechanicId;
	}
	public String getMechanicType() {
		return mechanicType;
	}
	public void setMechanicType(String mechanicType) {
		this.mechanicType = mechanicType;
	}
	public Integer getNumberOfVehicles() {
		return numberOfVehicles;
	}
	public void setNumberOfVehicles(Integer numberOfVehicles) {
		this.numberOfVehicles = numberOfVehicles;
	}
	@Override
	public String toString() {
		return "MechanicEntity [mechanicId=" + mechanicId + ", mechanicType=" + mechanicType + ", numberOfVehicles="
				+ numberOfVehicles + "]";
	}
	
}
