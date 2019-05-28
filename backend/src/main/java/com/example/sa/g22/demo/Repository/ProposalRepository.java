package com.example.sa.g22.demo.Repository;



import com.example.sa.g22.demo.Entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    Proposal findById(long id);
}
