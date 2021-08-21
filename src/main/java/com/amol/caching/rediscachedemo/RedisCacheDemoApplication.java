package com.amol.caching.rediscachedemo;

import com.amol.caching.rediscachedemo.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RedisCacheDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RedisCacheDemoApplication.class, args);
		CustomerService bean = context.getBean(CustomerService.class);
		Customer customer = bean.getById("1");
		customer = bean.getById("1");
		customer.setName("Amol2");
		bean.update(customer);
		//bean.delete("1");
	}

}
