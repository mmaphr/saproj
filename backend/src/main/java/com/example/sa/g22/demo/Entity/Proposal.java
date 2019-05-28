package com.example.sa.g22.demo.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name="proposal")
public class Proposal {
    @Id
    @SequenceGenerator(name = "proposal_seq", sequenceName = "proposal_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proposal_seq")
    @Column(name = "PROPOSAL_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String UserOffer;
    private @NonNull String ItemOffer;
    private @NonNull String UserReceiver;
    private @NonNull String ItemReceiver;
    private @NonNull String ProposalOption;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "USER_ID", insertable = true)
    private User proposalUser;

    public Proposal(String userOffer, String itemOffer, String userReceiver, String itemReceiver, String proposalOption, User proposalUser) {
        UserOffer = userOffer;
        ItemOffer = itemOffer;
        UserReceiver = userReceiver;
        ItemReceiver = itemReceiver;
        ProposalOption = proposalOption;
        
        this.proposalUser = proposalUser;
    }

    public String getUserOffer() {
        return UserOffer;
    }

    public String getUserReceiver() {
        return UserReceiver;
    }
}
