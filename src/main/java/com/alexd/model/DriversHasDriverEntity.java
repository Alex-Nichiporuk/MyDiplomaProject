package com.alexd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "drivers_has_driver", schema = "mydb" )
public class DriversHasDriverEntity {
    private int driversId;
    private int driverId;
    private Timestamp workTime;
    private int id;
    private DriversEntity driversByDriversId;
    private DriverEntity driverByDriverId;

    @Basic
    @Column(name = "Drivers_id", nullable = false)
    public int getDriversId() {
        return driversId;
    }

    public void setDriversId(int driversId) {
        this.driversId = driversId;
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
    public Timestamp getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Timestamp workTime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriversHasDriverEntity that = (DriversHasDriverEntity) o;

        if (driversId != that.driversId) return false;
        if (driverId != that.driverId) return false;
        if (id != that.id) return false;
        if (workTime != null ? !workTime.equals(that.workTime) : that.workTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driversId;
        result = 31 * result + driverId;
        result = 31 * result + (workTime != null ? workTime.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Drivers_id", insertable = false, updatable = false,referencedColumnName = "id", nullable = false)
    public DriversEntity getDriversByDriversId() {
        return driversByDriversId;
    }

    public void setDriversByDriversId(DriversEntity driversByDriversId) {
        this.driversByDriversId = driversByDriversId;
    }

    @ManyToOne
    @JoinColumn(name = "Driver_id",insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public DriverEntity getDriverByDriverId() {
        return driverByDriverId;
    }

    public void setDriverByDriverId(DriverEntity driverByDriverId) {
        this.driverByDriverId = driverByDriverId;
    }
}
