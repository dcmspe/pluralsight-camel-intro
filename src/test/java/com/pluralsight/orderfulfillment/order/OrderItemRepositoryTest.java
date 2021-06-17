package com.pluralsight.orderfulfillment.order;


import java.util.*;

import javax.inject.*;

import com.pluralsight.orderfulfillment.test.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderItemRepositoryTest extends BaseJpaRepositoryTest {

   @Inject
   private OrderItemRepository orderItemRepository;

   @BeforeEach
   public void setUp() throws Exception {
   }

   @AfterEach
   public void tearDown() throws Exception {
   }

   @Test
   public void test_findAllOrderItemsSuccess() throws Exception {
      List<OrderItemEntity> orderItems = orderItemRepository.findAll();
      Assertions.assertNotNull(orderItems);
      Assertions.assertFalse(orderItems.isEmpty());
   }

   @Test
   public void test_findOrderItemOrderCatalogItemSuccess() throws Exception {
      List<OrderItemEntity> orderItems = orderItemRepository.findAll();
      Assertions.assertNotNull(orderItems);
      Assertions.assertFalse(orderItems.isEmpty());
      OrderItemEntity orderItem = orderItems.get(0);
      Assertions.assertNotNull(orderItem.getOrder());
      Assertions.assertNotNull(orderItem.getCatalogItem());
   }

   @Test
   public void test_findByOrderIdSuccess() throws Exception {
      List<OrderItemEntity> orderItems = orderItemRepository.findByOrderId(1L);
      Assertions.assertNotNull(orderItems);
      Assertions.assertFalse(orderItems.isEmpty());
   }

   @Test
   public void test_() throws Exception {
      List<Long> orderIds = new ArrayList<Long>();
      orderIds.add(1L);
      orderIds.add(2L);
      orderIds.add(3L);
      orderIds.add(4L);
      int updateCount = orderItemRepository.updateStatus(
            OrderStatus.PROCESSING.getCode(),
            new Date(System.currentTimeMillis()), orderIds);
      Assertions.assertTrue(updateCount == 8);
   }
}
