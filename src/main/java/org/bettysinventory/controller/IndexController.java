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

//	@Autowired
//	private ProductRepository productRepo;
//
//	@Autowired
//	private ProductImageRepository productImageRepo;
	
	@GetMapping("")
	public String index(Model model) {
		return "index";
	}

	@GetMapping(path = { "/home", "/", "" })
	public String home(Model model) {
//		model.addAttribute("products", productRepo.findAll());
		return "home";
	}
//	
//	@GetMapping("/product/{id}")
//	public String product(Model model, @PathVariable(name = "id") int id) {
//		model.addAttribute("id", id);
//		Product p = productRepo.findOne(id);
//		model.addAttribute("product", p);
//		
////		ProductImage i = productImageRepo.findByProductId(id);
////		model.addAttribute("productImage", i);
//		return "product_detail";
//	}
//	
////	@GetMapping("/delete_product/{id}")
////	public String delete_product(Model model, @PathVariable(name = "id") int id) {
////		model.addAttribute("id", id);
////		Product p = productRepo.findOne(id);
////		model.addAttribute("product", p);
//		
////		ProductImage i = productImageRepo.findByProductId(id);
////		model.addAttribute("productImage", i);
////		return "delete_product";
////	}
//	
//
//	@GetMapping("/product/{id}/edit")
//	public String productEdit(Model model, @PathVariable(name = "id") int id) {
//		model.addAttribute("id", id);
//		Product p = productRepo.findOne(id);
//		model.addAttribute("product", p);
//		return "product_edit";
//	}
//	
//	@GetMapping("product/{id}/add")
//	public String addProduct(Model model) {
//		model.addAttribute(new Product());
//		return "add_product";
//	}
//	
//	@GetMapping("product/{id}/delete_product")
//    public String deleteProduct(Model model, @PathVariable(name = "id") int id) {
//		Product p = productRepo.findOne(id);
//		model.addAttribute("product", p);
//        return "delete_product";    
//    }
//
//    @PostMapping("product/{id}/delete_product")
//    public String deleteProduct(@ModelAttribute @Valid Product product, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("product", product);
//            return "delete_product";
//        } else {
//            productRepo.delete(product);
//            return "redirect:/products";
//        }
//    }
//	
//	@PostMapping("product/{id}/add")
//	public String addProduct(@ModelAttribute @Valid Product product, BindingResult result, Model model) {
//
//		if (result.hasErrors()) {
//			model.addAttribute("product", product);
//			return "add_product";
//		} else {
//			productRepo.save(product);
//			return "redirect:/home";
//		}
//	}
//
//	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
//	
//	@PostMapping("/product/{id}/edit")
//	public String productEditSave(@PathVariable(name = "id") int id, @ModelAttribute @Valid Product product,
//			BindingResult result, Model model, @RequestParam("file") MultipartFile file,
//			@RequestParam(name = "removeImage", defaultValue = "false", required = false) boolean removeImage) {
//
//		if (result.hasErrors()) {
//			model.addAttribute("product", product);
//			return "product_edit";
//		} else {
//
//			if (removeImage) {
//				ProductImage image = productImageRepo.findByProductId(id);
//
//				if (image != null) {
//					productImageRepo.delete(image);
//					log.info("Image Removed " + id);
//				}
//
//			} else if (file != null && !file.isEmpty()) {
//				try {
//					ProductImage image = productImageRepo.findByProductId(id);
//
//					if (image == null) {
//						image = new ProductImage();
//						image.setProductId(id);
//					}
//					image.setContentType(file.getContentType());
//					image.setImage(file.getBytes());
//
//					productImageRepo.save(image);
//					
//				
//			
//			productRepo.save(product);
//			return "redirect:/product/" + product.getId();
//			
//			}
//				
	}
		

	
	


