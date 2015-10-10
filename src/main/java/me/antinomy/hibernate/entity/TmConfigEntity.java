package me.antinomy.hibernate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by ginvan on 15/9/9.
 */
@Entity
@Table(name = "TMCC_CONFIGURE", schema = "", catalog = "tmcc")
public class TmConfigEntity extends BaseEntity {
    private String version;
    private Time workStartTime;
    private Time workEndTime;

    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "workStartTime")
    public Time getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(Time workStartTime) {
        this.workStartTime = workStartTime;
    }

    @Basic
    @Column(name = "workEndTime")
    public Time getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Time workEndTime) {
        this.workEndTime = workEndTime;
    }
}
