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
    private void setEntity(int id , double length)
    {
        e.setLength(length);
        e.setId(id);
    }

    public int addPath(double length)
    {
        setEntity(   length);
        this.insert(e);
        return e.getId();
    }




    public void updatePath(int id ,double length)
    {
        setEntity(id ,length);
        this.update(e);

    }


}
