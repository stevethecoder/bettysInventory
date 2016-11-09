package org.bettysinventory.controller;

import javax.validation.Valid;

import org.bettysinventory.beans.Product;
import org.bettysinventory.beans.ProductImage;
import org.bettysinventory.repository.ProductImageRepository;
import org.bettysinventory.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {

	@Autowired
	private ProductImageRepository productImageRepo;
	
//	@GetMapping("/products")
//	public String index(Model model) {
//		return "products";
//	}

//	@GetMapping("/customers")
//	public String home(Model model) {
//		return "customers";
//	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}




	}
		

	
	


