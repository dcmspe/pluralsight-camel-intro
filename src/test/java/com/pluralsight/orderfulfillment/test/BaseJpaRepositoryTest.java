package com.pluralsight.orderfulfillment.test;

import javax.persistence.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.support.*;
import org.springframework.test.context.transaction.*;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.*;

import com.pluralsight.orderfulfillment.config.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { Application.class })
@WebAppConfiguration
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class,
      DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
@Disabled
public class BaseJpaRepositoryTest {

   @PersistenceContext
   protected EntityManager entityManager;

}
