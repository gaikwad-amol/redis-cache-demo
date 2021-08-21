package com.amol.caching.rediscachedemo.service;

import com.amol.caching.rediscachedemo.Customer;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.amol.caching.rediscachedemo.config.CacheConfiguration.CUSTOMERS_CACHE;

@Service
public class CustomerService {

    @Cacheable(cacheNames = CUSTOMERS_CACHE)
    public Customer getById(String id) {
        System.out.println("invoking actual method for customer id: " + id);
        return new Customer("1", "Amol", 10000L);
    }

//    @CacheEvict(cacheNames = CUSTOMERS_CACHE, key = "#customer.id")
    @CachePut(cacheNames = CUSTOMERS_CACHE, key = "#customer.id")
    public Customer update(Customer customer) {
        System.out.println("updated the customer with id: " + customer.getId());
        return customer;
    }

    @CacheEvict(cacheNames = CUSTOMERS_CACHE, key = "#customer.id")
    public void delete(String id) {
    }
}
