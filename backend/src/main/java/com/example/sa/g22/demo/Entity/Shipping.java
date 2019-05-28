package com.example.sa.g22.demo.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="shipping")
public class Shipping {
    @Id
    @SequenceGenerator(name="shipping_seq",sequenceName="shipping_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shipping_seq")
    @Column(name ="SHIPPING_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String Shipper;
    private @NonNull String Receiver;
    private @NonNull Date Date;
    private @NonNull String Address;
    private @NonNull String Postcode;
    private @NonNull String TrackingNo;
    private @NonNull String Agency;

    @ManyToOne()
    @JoinColumn(name = "STATUS_ID", insertable = true)
    private ShippingStatus ShippingStatus;

    @ManyToOne()
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private Province ShippingProvince;

    @OneToOne()
    @JoinColumn(name="PROPOSAL_ID", insertable = true)
    private Proposal ShippingProposal;

    public Shipping(String shipper, String receiver, java.util.Date date, String address, String postcode, String trackingNo, String agency, com.example.sa.g22.demo.Entity.ShippingStatus shippingStatus, Province shippingProvince, Proposal shippingProposal) {
        Shipper = shipper;
        Receiver = receiver;
        Date = date;
        Address = address;
        Postcode = postcode;
        TrackingNo = trackingNo;
        Agency = agency;

        ShippingStatus = shippingStatus;
        ShippingProvince = shippingProvince;
        ShippingProposal = shippingProposal;
    }

    public com.example.sa.g22.demo.Entity.ShippingStatus getShippingStatus() {
        return ShippingStatus;
    }

    public Province getShippingProvince() {
        return ShippingProvince;
    }

    public Proposal getShippingProposal() {
        return ShippingProposal;
    }

    public void setShippingStatus(com.example.sa.g22.demo.Entity.ShippingStatus shippingStatus) {
        ShippingStatus = shippingStatus;
    }

    public void setShippingProvince(Province shippingProvince) {
        ShippingProvince = shippingProvince;
    }

    public void setShippingProposal(Proposal shippingProposal) {
        ShippingProposal = shippingProposal;
    }

    public Shipping() {}

    public void setShipper(String shipper) {
        Shipper = shipper;
    }

    public void setReceiver(String receiver) {
        Receiver = receiver;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public void setTrackingNo(String trackingNo) {
        TrackingNo = trackingNo;
    }

    public void setAgency(String agency) {
        Agency = agency;
    }

    public String getShipper() {
        return Shipper;
    }

    public String getReceiver() {
        return Receiver;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public String getAddress() {
        return Address;
    }

    public String getPostcode() {
        return Postcode;
    }

    public String getTrackingNo() {
        return TrackingNo;
    }

    public String getAgency() {
        return Agency;
    }
}
