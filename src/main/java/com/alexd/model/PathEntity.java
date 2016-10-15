package com.alexd.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cj444 on 15.10.2016.
 */
@Entity
@Table(name = "path", schema = "mydb", catalog = "")
public class PathEntity {
    private int id;
    private double length;
    private Collection<OrdersEntity> ordersesById;
    private Collection<PointEntity> pointsById;

    public PathEntity() {
    }

    public PathEntity(int id) {
        this.id = id;
        this.length = 0;
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
    @Column(name = "Length", nullable = false, precision = 0)
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PathEntity that = (PathEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.length, length) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "pathByPathId")
    public Collection<OrdersEntity> getOrdersesById() {
        return ordersesById;
    }

    public void setOrdersesById(Collection<OrdersEntity> ordersesById) {
        this.ordersesById = ordersesById;
    }

    @OneToMany(mappedBy = "pathByPathId")
    public Collection<PointEntity> getPointsById() {
        return pointsById;
    }

    public void setPointsById(Collection<PointEntity> pointsById) {
        this.pointsById = pointsById;
    }
}
