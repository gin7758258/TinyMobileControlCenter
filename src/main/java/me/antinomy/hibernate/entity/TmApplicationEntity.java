package me.antinomy.hibernate.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by ginvan on 15/9/9.
 */
@Entity
@Table(name = "TMCC_APPLICATION", schema = "", catalog = "tmcc")
public class TmApplicationEntity extends BaseEntity {
    private String name;
    private int companyId;
    private int chargeUserId;
    private String appIconPath;
    private Integer supportPlatform;
    private BigInteger minSupportOs;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "companyId")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "chargeUserId")
    public int getChargeUserId() {
        return chargeUserId;
    }

    public void setChargeUserId(int chargeUserId) {
        this.chargeUserId = chargeUserId;
    }

    @Basic
    @Column(name = "appIconPath")
    public String getAppIconPath() {
        return appIconPath;
    }

    public void setAppIconPath(String appIconPath) {
        this.appIconPath = appIconPath;
    }

    @Basic
    @Column(name = "supportPlatform")
    public Integer getSupportPlatform() {
        return supportPlatform;
    }

    public void setSupportPlatform(Integer supportPlatform) {
        this.supportPlatform = supportPlatform;
    }

    @Basic
    @Column(name = "minSupportOS")
    public BigInteger getMinSupportOs() {
        return minSupportOs;
    }

    public void setMinSupportOs(BigInteger minSupportOs) {
        this.minSupportOs = minSupportOs;
    }

    public Object clone() {
        return super.clone();
    }
}
