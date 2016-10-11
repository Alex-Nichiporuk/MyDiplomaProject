package com.alexd.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "map", schema = "mydb" )
public class MapEntity {
    private int id;
    private String city;
    private double latitude;
    private double longitude;
    private Collection<DriverEntity> driversById;
    private Collection<PointEntity> pointsById;
    private Collection<TruckEntity> trucksById;

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
    @Column(name = "City", nullable = false, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "Latitude", nullable = false, precision = 0)
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "Longitude", nullable = false, precision = 0)
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapEntity mapEntity = (MapEntity) o;

        if (id != mapEntity.id) return false;
        if (Double.compare(mapEntity.latitude, latitude) != 0) return false;
        if (Double.compare(mapEntity.longitude, longitude) != 0) return false;
        if (city != null ? !city.equals(mapEntity.city) : mapEntity.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "mapByMapId")
    public Collection<DriverEntity> getDriversById() {
        return driversById;
    }

    public void setDriversById(Collection<DriverEntity> driversById) {
        this.driversById = driversById;
    }

    @OneToMany(mappedBy = "mapByMapId")
    public Collection<PointEntity> getPointsById() {
        return pointsById;
    }

    public void setPointsById(Collection<PointEntity> pointsById) {
        this.pointsById = pointsById;
    }

    @OneToMany(mappedBy = "mapByMapId")
    public Collection<TruckEntity> getTrucksById() {
        return trucksById;
    }

    public void setTrucksById(Collection<TruckEntity> trucksById) {
        this.trucksById = trucksById;
    }
}
