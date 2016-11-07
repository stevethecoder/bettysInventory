package org.bettysinventory.repository;

import org.bettysinventory.beans.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
	
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

