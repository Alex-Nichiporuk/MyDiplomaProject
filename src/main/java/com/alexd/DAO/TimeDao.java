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

    public int addTime(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity(  begin ,  end);
        this.insert(e);
        return e.getId();
    }


    public void deleteTime(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity(  begin ,   end);
        this.delete(e);

    }

    public void updateTime(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity( begin ,   end);
        this.update(e);

    }

    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
