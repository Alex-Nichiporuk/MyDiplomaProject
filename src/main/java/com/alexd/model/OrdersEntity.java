package com.alexd.model;

import org.hibernate.mapping.*;
import org.hibernate.mapping.ForeignKey;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "orders", schema = "mydb", catalog = "")
public class OrdersEntity {
    private int id;
    private byte status;
    private int pathId;
    private int timeId;
    private int driversId;
    private int trucksId;
    private PathEntity pathByPathId;
    private TimeEntity timeByTimeId;
    private DriversEntity driversByDriversId;
    private TrucksEntity trucksByTrucksId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Path_id", nullable = false)
    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    @Basic
    @Column(name = "Time_id", nullable = false)
    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    @Basic
    @Column(name = "Drivers_id", nullable = false)
    public int getDriversId() {
        return driversId;
    }

    public void setDriversId(int driversId) {
        this.driversId = driversId;
    }

    @Basic
    @Column(name = "Trucks_id", nullable = false)
    public int getTrucksId() {
        return trucksId;
    }

    public void setTrucksId(int trucksId) {
        this.trucksId = trucksId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (pathId != that.pathId) return false;
        if (timeId != that.timeId) return false;
        if (driversId != that.driversId) return false;
        if (trucksId != that.trucksId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) status;
        result = 31 * result + pathId;
        result = 31 * result + timeId;
        result = 31 * result + driversId;
        result = 31 * result + trucksId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Path_id",insertable = false, updatable = false,referencedColumnName = "id", nullable = false)
    public PathEntity getPathByPathId() {
        return pathByPathId;
    }
    public void setPathByPathId(PathEntity pathByPathId) {
        this.pathByPathId = pathByPathId;
    }

    @ManyToOne
    @JoinColumn(name = "Time_id", insertable = false, updatable = false,referencedColumnName = "id", nullable = false)
    public TimeEntity getTimeByTimeId() {
        return timeByTimeId;
    }
    public void setTimeByTimeId(TimeEntity timeByTimeId) {
        this.timeByTimeId = timeByTimeId;
    }

    @ManyToOne
    @JoinColumn(name = "Drivers_id",insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public DriversEntity getDriversByDriversId() {
        return driversByDriversId;
    }
    public void setDriversByDriversId(DriversEntity driversByDriversId) {
        this.driversByDriversId = driversByDriversId;
    }

    @ManyToOne
    @JoinColumn(name = "Trucks_id", insertable = false, updatable = false , referencedColumnName = "id"   , nullable = false)
    public TrucksEntity getTrucksByTrucksId() {
        return trucksByTrucksId;
    }

    public void setTrucksByTrucksId(TrucksEntity trucksByTrucksId) {
        this.trucksByTrucksId = trucksByTrucksId;
    }
}
