package com.alexd.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "drivers", schema = "mydb", catalog = "")
public class DriversEntity {
    private int id;
    private Integer size;
    private String truckId;
    private TruckEntity truckByTruckId;
    private Collection<DriversHasDriverEntity> driversHasDriversById;
    private Collection<OrdersEntity> ordersById;

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
    @Column(name = "Size", nullable = true)
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

   @Basic
    @Column(name = "Truck_id", nullable = false, length = 7)
    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriversEntity that = (DriversEntity) o;

        if (id != that.id) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (truckId != null ? !truckId.equals(that.truckId) : that.truckId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (truckId != null ? truckId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Truck_id", insertable = false, updatable = false,referencedColumnName = "id", nullable = false)
    public TruckEntity getTruckByTruckId() {
        return truckByTruckId;
    }

    public void setTruckByTruckId(TruckEntity truckByTruckId) {
        this.truckByTruckId = truckByTruckId;
    }

    @OneToMany(mappedBy = "driversByDriversId")
    public Collection<DriversHasDriverEntity> getDriversHasDriversById() {
        return driversHasDriversById;
    }

    public void setDriversHasDriversById(Collection<DriversHasDriverEntity> driversHasDriversById) {
        this.driversHasDriversById = driversHasDriversById;
    }

    @OneToMany(mappedBy = "driversByDriversId")
    public Collection<OrdersEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrdersEntity> ordersById) {
        this.ordersById = ordersById;
    }
}
