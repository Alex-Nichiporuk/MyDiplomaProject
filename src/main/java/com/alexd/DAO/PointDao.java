package com.alexd.DAO;

import com.alexd.model.PointEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class PointDao extends GenericClass {
    PointEntity e;
    public PointDao() {
        super(PointEntity.class);
    }



    private void setEntity(int map_id , int path_id)
    {
        e = new PointEntity();
        e.setMapId(map_id);
        e.setPathId(path_id);

    }

    public int addPoint(int map_id , int path_id)
    {
        setEntity(   map_id ,   path_id);
        this.insert(e);
        return e.getId();
    }


    public void deletePoint(int map_id , int path_id)
    {
        setEntity(   map_id ,   path_id);
        this.delete(e);

    }

    public void updatePoint(int map_id , int path_id)
    {
        setEntity(  map_id ,   path_id);
        this.update(e);

    }

    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
