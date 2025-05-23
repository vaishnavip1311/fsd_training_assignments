package com.ecom.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecom.model.Customer;
import com.ecom.service.CustomerService;

public class CustomerServiceTest {
	
	private CustomerService service;
	
	@BeforeEach
    public void init() {
        service = new CustomerService();
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(301, "Vaishnavi", "vaish@gmail.com");
        assertDoesNotThrow(() -> service.addCustomer(customer));
    }

}
