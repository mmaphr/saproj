package com.example.sa.g22.demo.Repository;

import com.example.sa.g22.demo.Entity.ShippingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShippingStatusRepository extends JpaRepository<ShippingStatus,Long> {
    ShippingStatus findById(long id);
}

