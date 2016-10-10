package com.alexd.model;

import javax.persistence.*;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "trucks_has_truck", schema = "mydb", catalog = "")
public class TrucksHasTruckEntity {
    private int trucksId;
    private String truckId;
    private int id;
    private TrucksEntity trucksByTrucksId;
    private TruckEntity truckByTruckId;

    @Basic
    @Column(name = "Trucks_id", nullable = false)
    public int getTrucksId() {
        return trucksId;
    }

    public void setTrucksId(int trucksId) {
        this.trucksId = trucksId;
    }

    @Basic
    @Column(name = "Truck_id", nullable = false, length = 7)
    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
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

        TrucksHasTruckEntity that = (TrucksHasTruckEntity) o;

        if (trucksId != that.trucksId) return false;
        if (id != that.id) return false;
        if (truckId != null ? !truckId.equals(that.truckId) : that.truckId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trucksId;
        result = 31 * result + (truckId != null ? truckId.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Trucks_id", insertable = false, updatable = false,referencedColumnName = "id", nullable = false)
    public TrucksEntity getTrucksByTrucksId() {
        return trucksByTrucksId;
    }

    public void setTrucksByTrucksId(TrucksEntity trucksByTrucksId) {
        this.trucksByTrucksId = trucksByTrucksId;
    }

    @ManyToOne
    @JoinColumn(name = "Truck_id",insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public TruckEntity getTruckByTruckId() {
        return truckByTruckId;
    }

    public void setTruckByTruckId(TruckEntity truckByTruckId) {
        this.truckByTruckId = truckByTruckId;
    }
}
