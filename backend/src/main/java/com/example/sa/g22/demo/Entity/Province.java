package com.example.sa.g22.demo.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Data
@Entity
@Table(name="province")
public class Province {
    @Id
    @SequenceGenerator(name="province_seq",sequenceName="province_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="province_seq")
    @Column(name="PROVINCE_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String Provincename;

    public Province(String provincename) {
        Provincename = provincename;
    }

    public String getProvincename() {
        return Provincename;
    }

    public void setProvincename(String provincename) {
        Provincename = provincename;
    }
}
