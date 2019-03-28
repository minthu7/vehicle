package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bean.Mechanic;

import com.bean.ServiceRegister;
import com.dao.RegisterDAO;
import com.exception.InvalidTypeException;



@Component
public class RegisterService {

	@Autowired
	RegisterDAO dao;
	public Integer registerForService(ServiceRegister serviceRegister) throws Exception {
		String mechanicType=dao.getMechanicType(serviceRegister.getMechanicId());
		
		if(!mechanicType.equalsIgnoreCase(serviceRegister.getVehicleType()))
			 throw new InvalidTypeException();
		Integer id=dao.registerForService(serviceRegister);
		return id;
		
	}
	public List<Integer> getAllMechanic() throws Exception {
		return dao.getAllMechanic();

	}
	public List<ServiceRegister> getAllServiceDetails() throws Exception {
		List<ServiceRegister> serviceRegisterList = dao.getAllServiceDetails();
		return serviceRegisterList;
	}
}
