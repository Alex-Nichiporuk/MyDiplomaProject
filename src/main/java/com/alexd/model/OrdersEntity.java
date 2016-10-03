package com.alexd.model;

import javax.persistence.*;

/**
 * Created by Cj444 on 03.10.2016.
 */
@Entity
@Table(name = "orders", schema = "truck_app", catalog = "")
public class OrdersEntity {
    private int orderId;
    private Byte status;
    private DriversdescEntity driversdescByDescId;

    @Id
    @Column(name = "OrderId", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

        OrdersEntity that = (OrdersEntity) o;

        if (orderId != that.orderId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DescId", referencedColumnName = "DescId")
    public DriversdescEntity getDriversdescByDescId() {
        return driversdescByDescId;
    }

    public void setDriversdescByDescId(DriversdescEntity driversdescByDescId) {
        this.driversdescByDescId = driversdescByDescId;
    }
}
