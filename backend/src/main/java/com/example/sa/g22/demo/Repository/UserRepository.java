package com.example.sa.g22.demo.Repository;



import com.example.sa.g22.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
}
