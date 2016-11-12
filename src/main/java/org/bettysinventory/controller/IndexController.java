package org.bettysinventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

//	@Autowired
//	private ProductImageRepository productImageRepo;
	
	@GetMapping("/products")
	public String index(Model model) {
		return "products";
	}

//	@GetMapping("/customers")
//	public String home(Model model) {
//		return "customers";
//	}
	
//	@GetMapping("/login")
//	public String login(Model model) {
//		return "login";
//	}




	}
		

	
	


