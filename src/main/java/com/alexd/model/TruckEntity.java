package com.alexd.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cj444 on 15.10.2016.
 */
@Entity
@Table(name = "truck", schema = "mydb" )
public class TruckEntity {
    private String id;
    private float size;
    private boolean status;
    private Integer driverDesc;
    private int mapId;
    private boolean busyStatus;
    private Collection<OrdersEntity> ordersesById;
    private MapEntity mapByMapId;
    private Collection<TruckplanEntity> truckplenById;

    public TruckEntity() {
    }

    public TruckEntity(String id, float size, boolean status, Integer driverDesc, int mapId) {
        this.id = id;
        this.size = size;
        this.status = status;
        this.driverDesc = driverDesc;
        this.mapId = mapId;
        this.busyStatus = false;
    }

    @Id
    @Column(name = "id", nullable = false, length = 7)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Size", nullable = false, precision = 0)
    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
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
    @Column(name = "Driver_desc", nullable = true)
    public Integer getDriverDesc() {
        return driverDesc;
    }

    public void setDriverDesc(Integer driverDesc) {
        this.driverDesc = driverDesc;
    }

    @Basic
    @Column(name = "Map_id", nullable = false)
    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    @Basic
    @Column(name = "BusyStatus", nullable = false)
    public boolean getBusyStatus() {
        return busyStatus;
    }

    public void setBusyStatus(boolean busyStatus) {
        this.busyStatus = busyStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TruckEntity that = (TruckEntity) o;

        if (Double.compare(that.size, size) != 0) return false;
        if (status != that.status) return false;
        if (mapId != that.mapId) return false;
        if (busyStatus != that.busyStatus) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (driverDesc != null ? !driverDesc.equals(that.driverDesc) : that.driverDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(size);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result ;
        result = 31 * result + (driverDesc != null ? driverDesc.hashCode() : 0);
        result = 31 * result + mapId;
        result = 31 * result ;
        return result;
    }

    @OneToMany(mappedBy = "truckByTruckId")
    public Collection<OrdersEntity> getOrdersesById() {
        return ordersesById;
    }

    public void setOrdersesById(Collection<OrdersEntity> ordersesById) {
        this.ordersesById = ordersesById;
    }

    @ManyToOne
    @JoinColumn(name = "Map_id", insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public MapEntity getMapByMapId() {
        return mapByMapId;
    }

    public void setMapByMapId(MapEntity mapByMapId) {
        this.mapByMapId = mapByMapId;
    }

    @OneToMany(mappedBy = "truckByTruckId")
    public Collection<TruckplanEntity> getTruckplenById() {
        return truckplenById;
    }

    public void setTruckplenById(Collection<TruckplanEntity> truckplenById) {
        this.truckplenById = truckplenById;
    }
}
