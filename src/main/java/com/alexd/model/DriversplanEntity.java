package com.alexd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Cj444 on 15.10.2016.
 */
@Entity
@Table(name = "driversplan", schema = "mydb", catalog = "")
public class DriversplanEntity {
    private int id;
    private Timestamp driverDate;
    private long workTime;
    private Integer driverId;
    private DriverEntity driverByDriverId;

    public DriversplanEntity() {
    }

    public DriversplanEntity(  Timestamp driverDate, long workTime, Integer driverId) {
        this.id = id;
        this.driverDate = driverDate;
        this.workTime = workTime;
        this.driverId = driverId;
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
    @Column(name = "DriverDate", nullable = false)
    public Timestamp getDriverDate() {
        return driverDate;
    }

    public void setDriverDate(Timestamp driverDate) {
        this.driverDate = driverDate;
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
    @Column(name = "Driver_id", nullable = true)
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriversplanEntity that = (DriversplanEntity) o;

        if (id != that.id) return false;

        
        if (driverId != null ? !driverId.equals(that.driverId) : that.driverId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;

      
        result = 31 * result + (driverId != null ? driverId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Driver_id", insertable = false, updatable = false, referencedColumnName = "id")
    public DriverEntity getDriverByDriverId() {
        return driverByDriverId;
    }

    public void setDriverByDriverId(DriverEntity driverByDriverId) {
        this.driverByDriverId = driverByDriverId;
    }
}
