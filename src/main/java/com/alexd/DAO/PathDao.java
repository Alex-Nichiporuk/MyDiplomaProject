package com.alexd.DAO;

import com.alexd.model.PathEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class PathDao extends GenericClass {

    PathEntity e;
    public PathDao() {
        super(PathEntity.class);
    }





    private void setEntity(double length)
    {
        e.setLength(length);
    }

    public int addPath(double length)
    {
        setEntity(   length);
        this.insert(e);
        return e.getId();
    }


    public void deletePath(double length)
    {
        setEntity(   length);
        this.delete(e);

    }

    public void updatePath(double length)
    {
        setEntity(length);
        this.update(e);

    }





    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
