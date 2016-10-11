package com.alexd.model;

import javax.persistence.*;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "truck_has_truckplan", schema = "mydb" )
public class TruckHasTruckplanEntity {
    private String truckId;
    private int truckPlanId;
    private int id;
    private TruckEntity truckByTruckId;
    private TruckplanEntity truckplanByTruckPlanId;

    @Basic
    @Column(name = "Truck_id", nullable = false, length = 7)
    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    @Basic
    @Column(name = "TruckPlan_id", nullable = false)
    public int getTruckPlanId() {
        return truckPlanId;
    }

    public void setTruckPlanId(int truckPlanId) {
        this.truckPlanId = truckPlanId;
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

        TruckHasTruckplanEntity that = (TruckHasTruckplanEntity) o;

        if (truckPlanId != that.truckPlanId) return false;
        if (id != that.id) return false;
        if (truckId != null ? !truckId.equals(that.truckId) : that.truckId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = truckId != null ? truckId.hashCode() : 0;
        result = 31 * result + truckPlanId;
        result = 31 * result + id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Truck_id",insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public TruckEntity getTruckByTruckId() {
        return truckByTruckId;
    }

    public void setTruckByTruckId(TruckEntity truckByTruckId) {
        this.truckByTruckId = truckByTruckId;
    }

    @ManyToOne
    @JoinColumn(name = "TruckPlan_id",insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public TruckplanEntity getTruckplanByTruckPlanId() {
        return truckplanByTruckPlanId;
    }

    public void setTruckplanByTruckPlanId(TruckplanEntity truckplanByTruckPlanId) {
        this.truckplanByTruckPlanId = truckplanByTruckPlanId;
    }
}
