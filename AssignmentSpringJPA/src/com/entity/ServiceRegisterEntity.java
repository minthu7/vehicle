package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ServiceRegister")
public class ServiceRegisterEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer serviceId;
	private String vehicleNo;
	private String vehicleType;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mechanicId")
	private MechanicEntity mechanicEntity;
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public MechanicEntity getMechanicEntity() {
		return mechanicEntity;
	}
	public void setMechanicEntity(MechanicEntity mechanicEntity) {
		this.mechanicEntity = mechanicEntity;
	}
	@Override
	public String toString() {
		return "ServiceRegisterEntity [serviceId=" + serviceId + ", vehicleNo=" + vehicleNo + ", vehicleType="
				+ vehicleType + ", mechanicEntity=" + mechanicEntity + "]";
	}
	
	
}
