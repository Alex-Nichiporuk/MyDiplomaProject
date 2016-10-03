package com.alexd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Cj444 on 03.10.2016.
 */
@Entity
@Table(name = "paths", schema = "truck_app", catalog = "")
public class PathsEntity {
    private int pathId;

    @Id
    @Column(name = "PathId", nullable = false)
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

        PathsEntity that = (PathsEntity) o;

        if (pathId != that.pathId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return pathId;
    }
}
