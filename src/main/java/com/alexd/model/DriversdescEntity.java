package com.alexd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Cj444 on 03.10.2016.
 */
@Entity
@Table(name = "driversdesc", schema = "truck_app", catalog = "")
public class DriversdescEntity {
    private int descId;

    @Id
    @Column(name = "DescId", nullable = false)
    public int getDescId() {
        return descId;
    }

    public void setDescId(int descId) {
        this.descId = descId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriversdescEntity that = (DriversdescEntity) o;

        if (descId != that.descId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return descId;
    }
}
