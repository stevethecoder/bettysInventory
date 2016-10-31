package org.bettysinventory.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.bettysinventory.beans.Product;
import org.bettysinventory.repository.ProductRepository;
import org.elevenfifty.java301.beans.User;
import org.elevenfifty.java301.beans.UserImage;
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
	
	@GetMapping("")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/product/{id}")
	public String product(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		model.addAttribute("product", p);
		return "product_detail";
	}
	

	@GetMapping("/product/{id}/edit")
	public String productEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		model.addAttribute("product", p);
		return "product_edit";
	}

	@PostMapping("/product/{id}/edit")
	public String productEditSave(@PathVariable(name = "id") int id, @ModelAttribute @Valid Product product,
			BindingResult result, Model model, @RequestParam("file") MultipartFile file,
			@RequestParam(name = "removeImage", defaultValue = "false", required = false) boolean removeImage) {

		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product_edit";
		} else {

			if (removeImage) {
				ProductImage image = productImageRepo.findByUserId(id);

				if (image != null) {
					productImageRepo.delete(image);
					log.info("Image Removed " + id);
				}

			} else if (file != null && !file.isEmpty()) {
				try {
					ProductImage image = productImageRepo.findByUserId(id);

					if (image == null) {
						image = new UserImage();
						image.setUserId(id);
					}
					image.setContentType(file.getContentType());
					image.setImage(file.getBytes());

					userImageRepo.save(image);
					
				} catch (IOException e) {
					log.error("Failed to upload file", e);
				}
			}
			userRepo.save(user);
			return "redirect:/user/" + user.getId();
		}

	}
}
