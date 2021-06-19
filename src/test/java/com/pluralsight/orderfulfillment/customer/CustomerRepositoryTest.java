package com.pluralsight.orderfulfillment.customer;

import java.util.*;


import com.pluralsight.orderfulfillment.order.OrderEntity;
import com.pluralsight.orderfulfillment.test.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRepositoryTest extends BaseJpaRepositoryTest {

   @Autowired
   private CustomerRepository customerRepository;

   @BeforeEach
   public void setUp() throws Exception {
   }

   @AfterEach
   public void tearDown() throws Exception {
   }

   @Test
   public void test_findAllCustomersSuccess() throws Exception {
      List<CustomerEntity> customers = customerRepository.findAll();
      Assertions.assertNotNull(customers);
      Assertions.assertFalse(customers.isEmpty());
   }
   
   @Test
   public void test_findCustomerOrdersSuccess() throws Exception {
      List<CustomerEntity> customers = customerRepository.findAll();
      Assertions.assertNotNull(customers);
      Assertions.assertFalse(customers.isEmpty());
      CustomerEntity customer = customers.get(0);
      Set<OrderEntity> orders = customer.getOrders();
      Assertions.assertNotNull(orders);
      Assertions.assertFalse(orders.isEmpty());
   }

}
