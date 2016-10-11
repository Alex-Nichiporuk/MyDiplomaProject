package com.alexd.DAO;

import com.alexd.model.PointHasCargoEntity;

import java.sql.Timestamp;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class PointHasCargoDao extends GenericClass {
    PointHasCargoEntity e;

    public PointHasCargoDao() {
        super(PointHasCargoEntity.class);
    }





    private void setEntity(int cargo_id, int point_id, byte status, Timestamp date)
    {
        e = new PointHasCargoEntity();
        e.setCargoId(cargo_id);
        e.setPointId(point_id);
        e.setStatus(status);
        e.setDate(date);
    }

    public int addPointHasCargo(int cargo_id, int point_id, byte status, Timestamp date)
    {
        setEntity(   cargo_id,   point_id,   status,   date);
        this.insert(e);
        return e.getId();
    }


    public void deletePointHasCargo(int cargo_id, int point_id, byte status, Timestamp date)
    {
        setEntity(   cargo_id,   point_id,   status,   date);
        this.delete(e);

    }

    public void updatePointHasCargo(int cargo_id, int point_id, byte status, Timestamp date)
    {
        setEntity(   cargo_id,   point_id,   status,   date );
        this.update(e);

    }

    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
