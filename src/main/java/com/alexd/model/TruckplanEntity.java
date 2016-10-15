package com.alexd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Cj444 on 15.10.2016.
 */
@Entity
@Table(name = "truckplan", schema = "mydb", catalog = "")
public class TruckplanEntity {
    private int id;
    private Timestamp begin;
    private Timestamp end;
    private String truckId;
    private TruckEntity truckByTruckId;

    public TruckplanEntity() {
    }

    public TruckplanEntity(int id, Timestamp begin, Timestamp end, String truckId) {
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.truckId = truckId;
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
    @Column(name = "Begin", nullable = false)
    public Timestamp getBegin() {
        return begin;
    }

    public void setBegin(Timestamp begin) {
        this.begin = begin;
    }

    @Basic
    @Column(name = "End", nullable = false)
    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    @Basic
    @Column(name = "Truck_id", nullable = true, length = 7)
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

        TruckplanEntity that = (TruckplanEntity) o;

        if (id != that.id) return false;
        if (begin != null ? !begin.equals(that.begin) : that.begin != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;
        if (truckId != null ? !truckId.equals(that.truckId) : that.truckId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (begin != null ? begin.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (truckId != null ? truckId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Truck_id",insertable = false, updatable = false, referencedColumnName = "id")
    public TruckEntity getTruckByTruckId() {
        return truckByTruckId;
    }

    public void setTruckByTruckId(TruckEntity truckByTruckId) {
        this.truckByTruckId = truckByTruckId;
    }
}
