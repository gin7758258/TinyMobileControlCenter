package me.antinomy.hibernate.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ginvan on 15/9/9.
 */
@Entity
@Table(name = "TMCC_COMPANY", schema = "", catalog = "tmcc")
public class TmCompanyEntity extends BaseEntity {
    private String name;
    private String address;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object clone() {
        return super.clone();
    }
}
