package org.bettysinventory.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.bettysinventory.beans.Customer;
import org.bettysinventory.beans.ProductImage;
import org.bettysinventory.repository.CustomerRepository;
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
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;
	
//	@GetMapping("/login")
//	public String login(Model model) {
//		return "login";
//	}

	@GetMapping("/customerlist")
	public String home(Model model) {
		model.addAttribute("customers", customerRepo.findAll());
		return "customerlist";
	}
	
	@GetMapping("/customer/{id}")
	public String customer(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);
		Customer c = customerRepo.findOne(id);
		model.addAttribute("customer", c);
		return "customer_detail";
	}
	
	
	@GetMapping("customer/{id}/add")
	public String addCustomer(Model model) {
		model.addAttribute(new Customer());
		return "add_customer";
	}
	
//	@GetMapping("/customer/{id}/delete")
//    public String customerDelete(Model model, @PathVariable(name = "id") Integer id) {
//        model.addAttribute("id", id);
//        Customer c = customerRepo.findOne(id);
//        model.addAttribute("customer", c);
//        return "customer/customer_delete";    
//    }
//
//    @PostMapping("/customer/{id}/delete")
//    public String customerDeleteSave(@PathVariable(name = "id") Integer id, @ModelAttribute @Valid Customer customer,
//            BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("customer", customer);
//            return "customer/customers";
//        } else {
//            customerRepo.delete(customer);
//            return "redirect:/customer";
//        }
//    }
	
	@PostMapping("customer/{id}/add")
	public String addCustomer(@ModelAttribute @Valid Customer customer, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "add_customer";
		} else {
			customerRepo.save(customer);
			return "redirect:/customerlist";
		}
	}

}
	




