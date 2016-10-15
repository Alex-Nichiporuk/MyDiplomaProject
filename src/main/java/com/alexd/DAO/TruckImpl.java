package com.alexd.DAO;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Cj444 on 13.10.2016.
 */
public interface TruckImpl extends GenericDao<TruckEntity> {
     List<TruckEntity> selectAll(EntityManager em);
}
