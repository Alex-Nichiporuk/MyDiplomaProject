package com.alexd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Cj444 on 15.10.2016.
 */
@Entity
@Table(name = "driversdesc", schema = "mydb" )
public class DriversdescEntity {
    private int driverId;
    private long workTime;
    private int id;
    private int descId;
    private DriverEntity driverByDriverId;

    public DriversdescEntity() {
    }

    public DriversdescEntity(int driverId, long workTime,  int descId) {
        this.driverId = driverId;
        this.workTime = workTime;

        this.descId = descId;
    }

    public DriversdescEntity(int driverId, long workTime) {
        this.driverId = driverId;
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


    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Desc_id", nullable = true)
    public int getDescId() {
        return descId;
    }

    public void setDescId(int descId) {
        this.descId = descId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriversdescEntity that = (DriversdescEntity) o;

        if (driverId != that.driverId) return false;
        if (id != that.id) return false;



        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;

        result = 31 * result + id;

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
