package org.bettysinventory.controller;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private ProductImageRepository productImageRepo;
	
	@GetMapping("")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping(path = { "/home", "/", "" })
	public String home(Model model) {
		model.addAttribute("products", productRepo.findAll());
		return "home";
	}
	
	@GetMapping("/product/{id}")
	public String product(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		model.addAttribute("product", p);
		
		ProductImage i = productImageRepo.findByProductId(id);
		model.addAttribute("productImage", i);
		return "product_detail";
	}
	

	@GetMapping("/product/{id}/edit")
	public String productEdit(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		model.addAttribute("product", p);
		return "product_edit";
	}
	
	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute(new Product());
		return "add_product";
	}
	
	@GetMapping("/product/{id}/delete")
    public String productDelete(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("id", id);
        Product p = productRepo.findOne(id);
        model.addAttribute("product", p);
        return "product/product_delete";    
    }

    @PostMapping("/product/{id}/delete")
    public String productDeleteSave(@PathVariable(name = "id") Integer id, @ModelAttribute @Valid Product product,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            return "product/products";
        } else {
            productRepo.delete(product);
            return "redirect:/products";
        }
    }
	
	@PostMapping("/add")
	public String addProduct(@ModelAttribute @Valid Product product, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "add_product";
		} else {
			productRepo.save(product);
			return "redirect:/home";
		}
	}

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@PostMapping("/product/{id}/edit")
	public String productEditSave(@PathVariable(name = "id") int id, @ModelAttribute @Valid Product product,
			BindingResult result, Model model, @RequestParam("file") MultipartFile file,
			@RequestParam(name = "removeImage", defaultValue = "false", required = false) boolean removeImage) {

		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product_edit";
		} else {

			if (removeImage) {
				ProductImage image = productImageRepo.findByProductId(id);

				if (image != null) {
					productImageRepo.delete(image);
					log.info("Image Removed " + id);
				}

			} else if (file != null && !file.isEmpty()) {
				try {
					ProductImage image = productImageRepo.findByProductId(id);

					if (image == null) {
						image = new ProductImage();
						image.setProductId(id);
					}
					image.setContentType(file.getContentType());
					image.setImage(file.getBytes());

					productImageRepo.save(image);
					
				} catch (IOException e) {
					log.error("Failed to upload file", e);
				}
			}
			productRepo.save(product);
			return "redirect:/product/" + product.getId();
		}

	}
	
}

