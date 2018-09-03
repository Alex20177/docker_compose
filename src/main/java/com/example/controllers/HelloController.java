package com.example.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Customer;
import com.example.entities.CustomerRepository;

@Controller
public class HelloController {
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}//Close indexPage
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		
		List<Customer> customers=(List<Customer>) customerRepository.findAll();
		
		for (Customer customer : customers) {
			log.info(customer.toString());
		}//Close for
		
		model.addAttribute("customers", customers);
		return "hello";
		
	}//Close hello method.

}//Close HelloController class.
