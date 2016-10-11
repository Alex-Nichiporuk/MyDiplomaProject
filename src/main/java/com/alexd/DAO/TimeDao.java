package com.alexd.DAO;

import com.alexd.model.TimeEntity;
import com.sun.jmx.snmp.Timestamp;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class TimeDao extends GenericClass {


    TimeEntity e;
    public TimeDao() {
        super(TimeEntity.class);
    }



    private void setEntity(java.sql.Timestamp begin , java.sql.Timestamp end)
    {

        e = new TimeEntity();
        e.setBegin(begin);
        e.setEnd(end);

    }

    private void setEntity(int id, java.sql.Timestamp begin , java.sql.Timestamp end)
    {

        e = new TimeEntity();
        e.setBegin(begin);
        e.setEnd(end);
        e.setId(id);

    }

    public int addTime(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity(  begin ,  end);
        this.insert(e);
        return e.getId();
    }




    public void updateTime(int id, java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity( id ,begin ,   end);
        this.update(e);

    }


}
