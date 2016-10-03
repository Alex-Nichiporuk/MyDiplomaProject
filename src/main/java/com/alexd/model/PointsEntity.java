package com.alexd.model;

import javax.persistence.*;

/**
 * Created by Cj444 on 03.10.2016.
 */
@Entity
@Table(name = "points", schema = "truck_app", catalog = "")
public class PointsEntity {
    private int pointId;
    private String status;
    private MapEntity mapByCityId;
    private CargoEntity cargoByCargoid;
    private PathsEntity pathsByPathId;

    @Id
    @Column(name = "PointId", nullable = false)
    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    @Basic
    @Column(name = "Status", nullable = true, length = 3)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointsEntity that = (PointsEntity) o;

        if (pointId != that.pointId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pointId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CityId", referencedColumnName = "CityId")
    public MapEntity getMapByCityId() {
        return mapByCityId;
    }

    public void setMapByCityId(MapEntity mapByCityId) {
        this.mapByCityId = mapByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "Cargoid", referencedColumnName = "CargoId")
    public CargoEntity getCargoByCargoid() {
        return cargoByCargoid;
    }

    public void setCargoByCargoid(CargoEntity cargoByCargoid) {
        this.cargoByCargoid = cargoByCargoid;
    }

    @ManyToOne
    @JoinColumn(name = "PathId", referencedColumnName = "PathId")
    public PathsEntity getPathsByPathId() {
        return pathsByPathId;
    }

    public void setPathsByPathId(PathsEntity pathsByPathId) {
        this.pathsByPathId = pathsByPathId;
    }
}
