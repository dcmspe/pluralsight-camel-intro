package com.pluralsight.orderfulfillment.catalog;

import java.util.List;
import java.util.Set;

import com.pluralsight.orderfulfillment.order.OrderItemEntity;
import com.pluralsight.orderfulfillment.test.BaseJpaRepositoryTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CatalogItemRepositoryTest extends BaseJpaRepositoryTest {

   @Autowired
   private CatalogItemRepository catalogItemRepository;
   
   @BeforeEach
   public void setUp() throws Exception {
   }

   @AfterEach
   public void tearDown() throws Exception {
   }

   @Test
   public void testFindAllSuccess() {
      List<CatalogItemEntity> catalogItems = catalogItemRepository.findAll();
      Assertions.assertNotNull(catalogItems);
      Assertions.assertFalse(catalogItems.isEmpty());
   }

   @Test
   public void testOrderOrderItemsSuccess() {
      List<CatalogItemEntity> catalogItems = catalogItemRepository.findAll();
      Assertions.assertNotNull(catalogItems);
      Assertions.assertFalse(catalogItems.isEmpty());
      CatalogItemEntity catalogItem = catalogItems.get(0);
      Set<OrderItemEntity> orderItems = catalogItem.getOrderItems();
      Assertions.assertNotNull(orderItems);
      Assertions.assertFalse(orderItems.isEmpty());
   }
}
