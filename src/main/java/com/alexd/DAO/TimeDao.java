package com.alexd.DAO;

import com.alexd.model.TimeEntity;

/**
 * Created by Cj444 on 15.10.2016.
 */
public class TimeDao  extends GenericClass<TimeEntity>{


    public TimeDao() {
        super( TimeEntity.class);
    }





    public long getBeginTime(int id)
    {
        TimeEntity timeEntity = (TimeEntity)this.findById(id);
        return  timeEntity.getBegin().getTime();

    }

    public long getEndTime(int id)
    {
        TimeEntity timeEntity = (TimeEntity)this.findById(id);
        return  timeEntity.getEnd().getTime();

    }
}
