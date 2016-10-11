package com.alexd.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "trucks", schema = "mydb" )
public class TrucksEntity {
    private int id;
    private int countTrucks;
    private int size;
    private Collection<OrdersEntity> ordersById;
    private Collection<TrucksHasTruckEntity> trucksHasTrucksById;

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
    @Column(name = "CountTrucks", nullable = false)
    public int getCountTrucks() {
        return countTrucks;
    }

    public void setCountTrucks(int countTrucks) {
        this.countTrucks = countTrucks;
    }

    @Basic
    @Column(name = "Size", nullable = false)
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrucksEntity that = (TrucksEntity) o;

        if (id != that.id) return false;
        if (countTrucks != that.countTrucks) return false;
        if (size != that.size) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + countTrucks;
        result = 31 * result + size;
        return result;
    }

    @OneToMany(mappedBy = "trucksByTrucksId")
    public Collection<OrdersEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrdersEntity> ordersById) {
        this.ordersById = ordersById;
    }

    @OneToMany(mappedBy = "trucksByTrucksId")
    public Collection<TrucksHasTruckEntity> getTrucksHasTrucksById() {
        return trucksHasTrucksById;
    }

    public void setTrucksHasTrucksById(Collection<TrucksHasTruckEntity> trucksHasTrucksById) {
        this.trucksHasTrucksById = trucksHasTrucksById;
    }
}
