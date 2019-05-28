package com.example.sa.g22.demo.Repository;



import com.example.sa.g22.demo.Entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findById(long id);
//    Province findByProvincename(String provincename);
}
