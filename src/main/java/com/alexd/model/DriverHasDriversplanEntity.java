package com.alexd.model;

import javax.persistence.*;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "driver_has_driversplan", schema = "mydb", catalog = "")
public class DriverHasDriversplanEntity {
    private int driverId;
    private int driversPlanId;
    private int id;
    private DriverEntity driverByDriverId;
    private DriversplanEntity driversplanByDriversPlanId;

    @Basic
    @Column(name = "Driver_id", nullable = false)
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "DriversPlan_id", nullable = false)
    public int getDriversPlanId() {
        return driversPlanId;
    }

    public void setDriversPlanId(int driversPlanId) {
        this.driversPlanId = driversPlanId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverHasDriversplanEntity that = (DriverHasDriversplanEntity) o;

        if (driverId != that.driverId) return false;
        if (driversPlanId != that.driversPlanId) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + driversPlanId;
        result = 31 * result + id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Driver_id", insertable = false, updatable = false,referencedColumnName = "id", nullable = false)
    public DriverEntity getDriverByDriverId() {
        return driverByDriverId;
    }

    public void setDriverByDriverId(DriverEntity driverByDriverId) {
        this.driverByDriverId = driverByDriverId;
    }

    @ManyToOne
    @JoinColumn(name = "DriversPlan_id", insertable = false, updatable = false,referencedColumnName = "id", nullable = false)
    public DriversplanEntity getDriversplanByDriversPlanId() {
        return driversplanByDriversPlanId;
    }

    public void setDriversplanByDriversPlanId(DriversplanEntity driversplanByDriversPlanId) {
        this.driversplanByDriversPlanId = driversplanByDriversPlanId;
    }
}
