package com.alexd.model;

import javax.persistence.*;

/**
 * Created by Cj444 on 03.10.2016.
 */
@Entity
@Table(name = "map", schema = "truck_app", catalog = "")
public class MapEntity {
    private int cityId;
    private String name;
    private Double xCoor;
    private Double yCoor;

    @Id
    @Column(name = "CityId", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "XCoor", nullable = true, precision = 0)
    public Double getxCoor() {
        return xCoor;
    }

    public void setxCoor(Double xCoor) {
        this.xCoor = xCoor;
    }

    @Basic
    @Column(name = "YCoor", nullable = true, precision = 0)
    public Double getyCoor() {
        return yCoor;
    }

    public void setyCoor(Double yCoor) {
        this.yCoor = yCoor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapEntity mapEntity = (MapEntity) o;

        if (cityId != mapEntity.cityId) return false;
        if (name != null ? !name.equals(mapEntity.name) : mapEntity.name != null) return false;
        if (xCoor != null ? !xCoor.equals(mapEntity.xCoor) : mapEntity.xCoor != null) return false;
        if (yCoor != null ? !yCoor.equals(mapEntity.yCoor) : mapEntity.yCoor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (xCoor != null ? xCoor.hashCode() : 0);
        result = 31 * result + (yCoor != null ? yCoor.hashCode() : 0);
        return result;
    }
}
