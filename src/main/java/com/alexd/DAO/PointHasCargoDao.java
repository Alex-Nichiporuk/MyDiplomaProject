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

    private void setEntity(int id, int cargo_id, int point_id, byte status, Timestamp date)
    {
        e = new PointHasCargoEntity();
        e.setCargoId(cargo_id);
        e.setPointId(point_id);
        e.setStatus(status);
        e.setDate(date);
        e.setId(id);
    }

    public int addPointHasCargo(int cargo_id, int point_id, byte status, Timestamp date)
    {
        setEntity(   cargo_id,   point_id,   status,   date);
        this.insert(e);
        return e.getId();
    }




    public void updatePointHasCargo(int id, int cargo_id, int point_id, byte status, Timestamp date)
    {
        setEntity(  id, cargo_id,   point_id,   status,   date );
        this.update(e);

    }


}
