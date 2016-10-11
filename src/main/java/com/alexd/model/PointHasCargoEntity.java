package com.alexd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "point_has_cargo", schema = "mydb" )
public class PointHasCargoEntity {
    private int id;
    private int pointId;
    private int cargoId;
    private byte status;
    private Timestamp date;
    private PointEntity pointByPointId;
    private CargoEntity cargoByCargoId;

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
    @Column(name = "Point_id", nullable = false)
    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    @Basic
    @Column(name = "Cargo_id", nullable = false)
    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
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
    @Column(name = "Date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointHasCargoEntity that = (PointHasCargoEntity) o;

        if (id != that.id) return false;
        if (pointId != that.pointId) return false;
        if (cargoId != that.cargoId) return false;
        if (status != that.status) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pointId;
        result = 31 * result + cargoId;
        result = 31 * result + (int) status;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Point_id", insertable = false, updatable = false,referencedColumnName = "id", nullable = false)
    public PointEntity getPointByPointId() {
        return pointByPointId;
    }

    public void setPointByPointId(PointEntity pointByPointId) {
        this.pointByPointId = pointByPointId;
    }

    @ManyToOne
    @JoinColumn(name = "Cargo_id", insertable = false, updatable = false,referencedColumnName = "id", nullable = false)
    public CargoEntity getCargoByCargoId() {
        return cargoByCargoId;
    }

    public void setCargoByCargoId(CargoEntity cargoByCargoId) {
        this.cargoByCargoId = cargoByCargoId;
    }
}
