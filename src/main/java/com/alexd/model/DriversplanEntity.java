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
    private Timestamp begin;
    private Timestamp end;
    private Integer driverId;
    private DriverEntity driverByDriverId;

    public DriversplanEntity() {
    }

    public DriversplanEntity(int id, Timestamp begin, Timestamp end, Integer driverId) {
        this.id = id;
        this.begin = begin;
        this.end = end;
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
    @Column(name = "Begin", nullable = false)
    public Timestamp getBegin() {
        return begin;
    }

    public void setBegin(Timestamp begin) {
        this.begin = begin;
    }

    @Basic
    @Column(name = "End", nullable = false)
    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
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
        if (begin != null ? !begin.equals(that.begin) : that.begin != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;
        if (driverId != null ? !driverId.equals(that.driverId) : that.driverId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (begin != null ? begin.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
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
