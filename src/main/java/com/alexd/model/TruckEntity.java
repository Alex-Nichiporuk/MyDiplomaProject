package com.alexd.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "truck", schema = "mydb", catalog = "")
public class TruckEntity {
    private String id;
    private float size;
    private byte status;
    private Integer driverDesc;
    private int mapId;
    private Collection<DriversEntity> driversesById;
    private MapEntity mapByMapId;
    private Collection<TruckHasTruckplanEntity> truckHasTruckplenById;
    private Collection<TrucksHasTruckEntity> trucksHasTrucksById;

    @Id
    @Column(name = "id", nullable = false, length = 7)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Size", nullable = false)
    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TruckEntity that = (TruckEntity) o;

        if (size != that.size) return false;
        if (status != that.status) return false;
        if (mapId != that.mapId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (driverDesc != null ? !driverDesc.equals(that.driverDesc) : that.driverDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (int)size;
        result = 31 * result + (int) status;
        result = 31 * result + (driverDesc != null ? driverDesc.hashCode() : 0);
        result = 31 * result + mapId;
        return result;
    }

    @OneToMany(mappedBy = "truckByTruckId")
    public Collection<DriversEntity> getDriversesById() {
        return driversesById;
    }

    public void setDriversesById(Collection<DriversEntity> driversesById) {
        this.driversesById = driversesById;
    }

    @ManyToOne
    @JoinColumn(name = "Map_id",insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public MapEntity getMapByMapId() {
        return mapByMapId;
    }

    public void setMapByMapId(MapEntity mapByMapId) {
        this.mapByMapId = mapByMapId;
    }

    @OneToMany(mappedBy = "truckByTruckId")
    public Collection<TruckHasTruckplanEntity> getTruckHasTruckplenById() {
        return truckHasTruckplenById;
    }

    public void setTruckHasTruckplenById(Collection<TruckHasTruckplanEntity> truckHasTruckplenById) {
        this.truckHasTruckplenById = truckHasTruckplenById;
    }

    @OneToMany(mappedBy = "truckByTruckId")
    public Collection<TrucksHasTruckEntity> getTrucksHasTrucksById() {
        return trucksHasTrucksById;
    }

    public void setTrucksHasTrucksById(Collection<TrucksHasTruckEntity> trucksHasTrucksById) {
        this.trucksHasTrucksById = trucksHasTrucksById;
    }
}
