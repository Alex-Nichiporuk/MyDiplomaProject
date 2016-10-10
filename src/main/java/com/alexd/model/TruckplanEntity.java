package com.alexd.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "truckplan", schema = "mydb", catalog = "")
public class TruckplanEntity {
    private int id;
    private Timestamp begin;
    private Timestamp end;
    private Collection<TruckHasTruckplanEntity> truckHasTruckplenById;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TruckplanEntity that = (TruckplanEntity) o;

        if (id != that.id) return false;
        if (begin != null ? !begin.equals(that.begin) : that.begin != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (begin != null ? begin.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "truckplanByTruckPlanId")
    public Collection<TruckHasTruckplanEntity> getTruckHasTruckplenById() {
        return truckHasTruckplenById;
    }

    public void setTruckHasTruckplenById(Collection<TruckHasTruckplanEntity> truckHasTruckplenById) {
        this.truckHasTruckplenById = truckHasTruckplenById;
    }
}
