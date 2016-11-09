package org.bettysinventory.transaction;

import java.sql.SQLException;

import javax.transaction.Transaction;

import org.bettysinventory.repository.CustomerRepository;
import org.bettysinventory.repository.ProductRepository;
import org.bettysinventory.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepo;

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/transactions")
	public String findAllTransactions(Model model) throws SQLException {
		model.addAttribute("transactions", transactionRepo.findAll());
		return "transaction/transactions";
	}
	/*
	 * CREATE METHODS
	 */

	
	
	/*
	 * Edit Methods
	 */
//	@GetMapping("/transaction/{id}/edit")
//	public String transactionEdit(Model model, @PathVariable(name = "id") long id) {
//		model.addAttribute("id", id);
		//Transaction t = transactionRepo.findOne(id);
		//model.addAttribute("transaction", t);
//		model.addAttribute("customers", customerRepo.findAll());
//		model.addAttribute("products", productRepo.findAll());
//		return "transaction/transaction_edit";
//	}
	

	/*
	 * READ Methods
	 */
	
	

	/*
	 * DELETE Methods
	 */

}
