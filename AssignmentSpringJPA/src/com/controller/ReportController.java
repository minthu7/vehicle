package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bean.ServiceRegister;
import com.service.RegisterService;



@Controller
public class ReportController {

	@Autowired
	RegisterService service;
	
	@RequestMapping("/serviceReport.htm")
	public ModelAndView employeeReport() throws Exception {
		ModelAndView mView = new ModelAndView();
		try
		{
			List<ServiceRegister> serviceRegisterList=service.getAllServiceDetails();
			System.out.println(serviceRegisterList);
			mView.addObject("serviceRegisterList",serviceRegisterList);
			
		}
		catch(Exception e)
		{
			mView.addObject("MESSAGE","ERROR:"+e.getMessage());
			
		}
		mView.setViewName("/report");
		return mView;
	}

}
