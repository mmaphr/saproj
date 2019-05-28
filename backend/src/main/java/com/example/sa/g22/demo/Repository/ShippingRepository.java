package com.example.sa.g22.demo.Repository;

import com.example.sa.g22.demo.Entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    Shipping findById(long id);

}
