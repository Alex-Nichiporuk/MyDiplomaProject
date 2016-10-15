package com.alexd.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Cj444 on 15.10.2016.
 */
@Entity
@Table(name = "driver", schema = "mydb", catalog = "")
public class DriverEntity {
    private int id;
    private String name;
    private String lastName;
    private int status;
    private String currentTruck;
    private long timeStatus;
    private int mapId;
    private MapEntity mapByMapId;
    private Collection<DriversdescEntity> driversdescsById;
    private Collection<DriversplanEntity> driversplenById;

    public DriverEntity() {
    }

    public DriverEntity(String name, String lastName,   int mapId) {

        this.name = name;
        this.lastName = lastName;
        this.status = 0;
        this.currentTruck = null;
        this.timeStatus = 0;
        this.mapId = mapId;
    }

    public DriverEntity(int id, String name, String lastName,   int mapId) {

        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.status = 0;
        this.currentTruck = null;
        this.timeStatus = 0;
        this.mapId = mapId;
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
    @Column(name = "Name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "LastName", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Current_truck", nullable = true, length = 7)
    public String getCurrentTruck() {
        return currentTruck;
    }

    public void setCurrentTruck(String currentTruck) {
        this.currentTruck = currentTruck;
    }

    @Basic
    @Column(name = "Time_status", nullable = false)
    public long getTimeStatus() {
        return timeStatus;
    }

    public void setTimeStatus(long timeStatus) {
        this.timeStatus = timeStatus;
    }

    @Basic
    @Column(name = "Map_id", nullable = false)
    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverEntity that = (DriverEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (mapId != that.mapId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (currentTruck != null ? !currentTruck.equals(that.currentTruck) : that.currentTruck != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (currentTruck != null ? currentTruck.hashCode() : 0);

        result = 31 * result + mapId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Map_id", insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    public MapEntity getMapByMapId() {
        return mapByMapId;
    }

    public void setMapByMapId(MapEntity mapByMapId) {
        this.mapByMapId = mapByMapId;
    }

    @OneToMany(mappedBy = "driverByDriverId")
    public Collection<DriversdescEntity> getDriversdescsById() {
        return driversdescsById;
    }

    public void setDriversdescsById(Collection<DriversdescEntity> driversdescsById) {
        this.driversdescsById = driversdescsById;
    }

    @OneToMany(mappedBy = "driverByDriverId")
    public Collection<DriversplanEntity> getDriversplenById() {
        return driversplenById;
    }

    public void setDriversplenById(Collection<DriversplanEntity> driversplenById) {
        this.driversplenById = driversplenById;
    }
}
