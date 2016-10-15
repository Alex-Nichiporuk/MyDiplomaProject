package com.alexd.model;

import javax.persistence.*;

/**
 * Created by Cj444 on 15.10.2016.
 */
@Entity
@Table(name = "orders", schema = "mydb", catalog = "")
public class OrdersEntity {
    private int id;
    private boolean status;
    private int pathId;
    private int timeId;
    private String truckId;
    private int driverDescId;
    private PathEntity pathByPathId;
    private TimeEntity timeByTimeId;
    private TruckEntity truckByTruckId;

    public OrdersEntity() {
    }

    public OrdersEntity(int id, boolean status, int pathId, int timeId, String truckId, int driverDescId) {
        this.id = id;
        this.status = status;
        this.pathId = pathId;
        this.timeId = timeId;
        this.truckId = truckId;
        this.driverDescId = driverDescId;
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
    @Column(name = "Status", nullable = false)
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
    @Column(name = "Truck_id", nullable = false, length = 7)
    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    @Basic
    @Column(name = "DriverDesc_id", nullable = false)
    public int getDriverDescId() {
        return driverDescId;
    }

    public void setDriverDescId(int driverDescId) {
        this.driverDescId = driverDescId;
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
        if (driverDescId != that.driverDescId) return false;
        if (truckId != null ? !truckId.equals(that.truckId) : that.truckId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result  ;
        result = 31 * result + pathId;
        result = 31 * result + timeId;
        result = 31 * result + (truckId != null ? truckId.hashCode() : 0);
        result = 31 * result + driverDescId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Path_id", insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public PathEntity getPathByPathId() {
        return pathByPathId;
    }

    public void setPathByPathId(PathEntity pathByPathId) {
        this.pathByPathId = pathByPathId;
    }

    @ManyToOne
    @JoinColumn(name = "Time_id",  insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public TimeEntity getTimeByTimeId() {
        return timeByTimeId;
    }

    public void setTimeByTimeId(TimeEntity timeByTimeId) {
        this.timeByTimeId = timeByTimeId;
    }

    @ManyToOne
    @JoinColumn(name = "Truck_id", insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public TruckEntity getTruckByTruckId() {
        return truckByTruckId;
    }

    public void setTruckByTruckId(TruckEntity truckByTruckId) {
        this.truckByTruckId = truckByTruckId;
    }
}
