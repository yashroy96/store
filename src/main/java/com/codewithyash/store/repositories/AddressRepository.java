package com.codewithyash.store.repositories;

import com.codewithyash.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}