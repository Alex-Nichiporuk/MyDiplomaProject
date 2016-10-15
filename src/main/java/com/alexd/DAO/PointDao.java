package com.alexd.DAO;

import com.alexd.model.PointEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class PointDao extends GenericClass<PointEntity> implements PointImpl {

    public PointDao() {
        super(PointEntity.class);
    }



}
