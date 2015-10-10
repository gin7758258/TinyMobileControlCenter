package me.antinomy.hibernate.entity;

import me.antinomy.util.DateUtil;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ginvan on 15/10/9.
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity {
    protected int id;
    protected String lastModifyModel;
    protected String lastModifyUser;
    protected Timestamp lastModifyDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lastModifyModel")
    public String getLastModifyModel() {
        return lastModifyModel;
    }

    public void setLastModifyModel(String lastModifyModel) {
        this.lastModifyModel = lastModifyModel;
    }

    @Basic
    @Column(name = "lastModifyUser")
    public String getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    @Basic
    @Column(name = "lastModifyDate")
    public Timestamp getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Timestamp lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public boolean exist() {
        return id > 0;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
