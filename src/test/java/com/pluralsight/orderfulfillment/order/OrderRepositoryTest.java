package com.pluralsight.orderfulfillment.order;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import com.pluralsight.orderfulfillment.test.*;

public class OrderRepositoryTest extends BaseJpaRepositoryTest {

   @Autowired
   private OrderRepository orderRepository;

   @BeforeEach
   public void setUp() throws Exception {
   }

   @AfterEach
   public void tearDown() throws Exception {
   }

   @Test
   public void test_findAllOrdersSuccess() throws Exception {
      Iterable<OrderEntity> orders = orderRepository.findAll();
      Assertions.assertNotNull(orders);
      Assertions.assertTrue(orders.iterator().hasNext());
   }

   @Test
   public void test_findOrderCustomerAndOrderItemsSuccess() throws Exception {
      Iterable<OrderEntity> orders = orderRepository.findAll();
      Assertions.assertNotNull(orders);
      Iterator<OrderEntity> iterator = orders.iterator();
      Assertions.assertTrue(iterator.hasNext());
      OrderEntity order = iterator.next();
      Assertions.assertNotNull(order.getCustomer());
      Set<OrderItemEntity> orderItems = order.getOrderItems();
      Assertions.assertNotNull(orderItems);
      Assertions.assertFalse(orderItems.isEmpty());
   }

   @Test
   public void test_findOrdersByOrderStatusOrderByTimeOrderPlacedAscSuccess()
         throws Exception {
      Iterable<OrderEntity> orders = orderRepository.findByStatus(
            OrderStatus.NEW.getCode(), PageRequest.of(0, 5));
      Assertions.assertNotNull(orders);
      Assertions.assertTrue(orders.iterator().hasNext());
   }

   @Test
   public void test_findOrdersByOrderStatusOrderByTimeOrderPlacedAscFailInvalidStatus()
         throws Exception {
      Iterable<OrderEntity> orders = orderRepository.findByStatus("whefiehwi",
            PageRequest.of(0, 5));
      Assertions.assertNotNull(orders);
      Assertions.assertFalse(orders.iterator().hasNext());
   }

   @Test
   public void test_updateStatusSuccess() throws Exception {
      List<Long> orderIds = new ArrayList<Long>();
      orderIds.add(1L);
      orderIds.add(2L);
      orderIds.add(3L);
      orderIds.add(4L);
      int count = orderRepository.updateStatus(
            OrderStatus.PROCESSING.getCode(),
            new Date(System.currentTimeMillis()), orderIds);
      Assertions.assertTrue(count == 4);
   }
}
