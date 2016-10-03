package com.alexd.model;

import javax.persistence.*;

/**
 * Created by Cj444 on 03.10.2016.
 */
@Entity
@Table(name = "trucks", schema = "truck_app", catalog = "")
public class TrucksEntity {
    private String truckId;
    private Double capacity;
    private Byte status;
    private MapEntity mapByCityId;
    private WorkplanEntity workplanByPlanId;

    @Id
    @Column(name = "TruckId", nullable = false, length = 7)
    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    @Basic
    @Column(name = "Capacity", nullable = true, precision = 0)
    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "Status", nullable = true)
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrucksEntity that = (TrucksEntity) o;

        if (truckId != null ? !truckId.equals(that.truckId) : that.truckId != null) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = truckId != null ? truckId.hashCode() : 0;
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CityId", referencedColumnName = "CityId")
    public MapEntity getMapByCityId() {
        return mapByCityId;
    }

    public void setMapByCityId(MapEntity mapByCityId) {
        this.mapByCityId = mapByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "PlanId", referencedColumnName = "PlanId")
    public WorkplanEntity getWorkplanByPlanId() {
        return workplanByPlanId;
    }

    public void setWorkplanByPlanId(WorkplanEntity workplanByPlanId) {
        this.workplanByPlanId = workplanByPlanId;
    }
}
