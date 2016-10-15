package com.alexd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Cj444 on 15.10.2016.
 */
@Entity
@Table(name = "driversdesc", schema = "mydb", catalog = "")
public class DriversdescEntity {
    private int driverId;
    private long workTime;
    private int id;
    private Integer descId;
    private DriverEntity driverByDriverId;

    public DriversdescEntity() {
    }

    public DriversdescEntity(int driverId, long workTime, int id, Integer descId) {
        this.driverId = driverId;
        this.workTime = workTime;
        this.id = id;
        this.descId = descId;
    }

    @Basic
    @Column(name = "Driver_id", nullable = false)
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "WorkTime", nullable = false)
    public long getWorkTime() {
        return workTime;
    }

    public void setWorkTime(long workTime) {
        this.workTime = workTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Desc_id", nullable = true)
    public Integer getDescId() {
        return descId;
    }

    public void setDescId(Integer descId) {
        this.descId = descId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriversdescEntity that = (DriversdescEntity) o;

        if (driverId != that.driverId) return false;
        if (id != that.id) return false;

        if (descId != null ? !descId.equals(that.descId) : that.descId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;

        result = 31 * result + id;
        result = 31 * result + (descId != null ? descId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Driver_id", insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public DriverEntity getDriverByDriverId() {
        return driverByDriverId;
    }

    public void setDriverByDriverId(DriverEntity driverByDriverId) {
        this.driverByDriverId = driverByDriverId;
    }
}
