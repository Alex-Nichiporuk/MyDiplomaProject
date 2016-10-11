package com.alexd.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cj444 on 09.10.2016.
 */
@Entity
@Table(name = "point", schema = "mydb" )
public class PointEntity {
    private int id;
    private int mapId;
    private int pathId;
    private MapEntity mapByMapId;
    private PathEntity pathByPathId;
    private Collection<PointHasCargoEntity> pointHasCargosById;

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
    @Column(name = "Map_id", nullable = false)
    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    @Basic
    @Column(name = "Path_id", nullable = false)
    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointEntity that = (PointEntity) o;

        if (id != that.id) return false;
        if (mapId != that.mapId) return false;
        if (pathId != that.pathId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + mapId;
        result = 31 * result + pathId;
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

    @ManyToOne
    @JoinColumn(name = "Path_id", insertable = false, updatable = false,referencedColumnName = "id", nullable = false)
    public PathEntity getPathByPathId() {
        return pathByPathId;
    }

    public void setPathByPathId(PathEntity pathByPathId) {
        this.pathByPathId = pathByPathId;
    }

    @OneToMany(mappedBy = "pointByPointId")
    public Collection<PointHasCargoEntity> getPointHasCargosById() {
        return pointHasCargosById;
    }

    public void setPointHasCargosById(Collection<PointHasCargoEntity> pointHasCargosById) {
        this.pointHasCargosById = pointHasCargosById;
    }
}
