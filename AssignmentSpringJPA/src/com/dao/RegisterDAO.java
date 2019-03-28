package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Mechanic;
import com.bean.ServiceRegister;
import com.entity.MechanicEntity;
import com.entity.ServiceRegisterEntity;

@Component
public class RegisterDAO {
@PersistenceContext
private EntityManager em;

public List<Integer> getAllMechanic() throws Exception {
	Query q=em.createQuery("SELECT m.mechanicId from MechanicEntity m");
	List<Integer> mechanic = q.getResultList();
	return mechanic;
}
public String getMechanicType(int mechanicId) throws Exception {
	Query q=em.createQuery("SELECT m.mechanicType from MechanicEntity m where m.mechanicId="+mechanicId);
	String mechanicType=(String) q.getSingleResult();
	return mechanicType;
}
@Transactional
public Integer registerForService(ServiceRegister serviceRegister) throws Exception {
	
	ServiceRegisterEntity serviceRegisterEntity=new ServiceRegisterEntity();
	serviceRegisterEntity.setVehicleNo(serviceRegister.getVehicleNo());
	serviceRegisterEntity.setVehicleType(serviceRegister.getVehicleType());
	MechanicEntity mechanicEntity=em.find(MechanicEntity.class, serviceRegister.getMechanicId());
	serviceRegisterEntity.setMechanicEntity(mechanicEntity);
	System.out.println(serviceRegisterEntity);
	em.persist(serviceRegisterEntity);
	mechanicEntity.setNumberOfVehicles(mechanicEntity.getNumberOfVehicles()+1);
	Integer serviceId=serviceRegisterEntity.getServiceId();
	return serviceId;
}
public List<ServiceRegister> getAllServiceDetails() throws Exception {
	Query q=em.createQuery("SELECT s from ServiceRegisterEntity s");
	List<ServiceRegister> serviceRegister = q.getResultList();
	System.out.println(serviceRegister);
	return serviceRegister;
}
}
