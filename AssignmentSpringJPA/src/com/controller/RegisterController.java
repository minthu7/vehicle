package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Mechanic;
import com.bean.ServiceRegister;
import com.entity.MechanicEntity;
import com.service.RegisterService;


@Controller
public class RegisterController {
	@Autowired
	RegisterService service;
	
	@RequestMapping("/home.htm")
	public ModelAndView displayHomePage() throws Exception {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("home");
		return mView;
	}
	
	@RequestMapping("/registerForServiceForm.htm")
	public ModelAndView displayRegisterForm(ModelMap map) throws Exception
	{
		ServiceRegister serviceRegister=new ServiceRegister();
		map.addAttribute(serviceRegister);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("registerForService");
		return mView;
	}
	@ModelAttribute("mechanicId")
	public Map<Integer, Integer> populatemechanicId() throws Exception {
		Map<Integer, Integer> MechanicIdMap = new HashMap<Integer, Integer>();
		List<Integer> allMechanicIds=service.getAllMechanic();
		System.out.println(allMechanicIds);
		for(Integer mechanicIds : allMechanicIds)
			{
			MechanicIdMap.put(mechanicIds,mechanicIds);
			}
		return MechanicIdMap;
		
	}
	@RequestMapping("registerForService")
	public  ModelAndView addServiceDetails(@ModelAttribute ServiceRegister serviceRegister) throws Exception
	{
		ModelAndView mView = new ModelAndView();
		try
		{
			
			Integer serviceId=service.registerForService(serviceRegister);
			mView.addObject("MESSAGE","Added Successfully, ServiceId:"+""+serviceId);
			mView.setViewName("registerForService");
		}
		catch(Exception e)
		{
			mView.addObject("MESSAGE","error:"+e.getMessage());
			mView.setViewName("registerForService");
		}
		return mView;
		
	}
	
	
	
	
	
}
