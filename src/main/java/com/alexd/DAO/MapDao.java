package com.alexd.DAO;

import com.alexd.model.MapEntity;
import com.alexd.service.MapService;
import com.alexd.util.man.EntManager;
import com.sun.javafx.collections.MappingChange;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Cj444 on 16.10.2016.
 */
public class MapDao extends GenericClass<MapEntity> {

    public MapDao() {
        super( MapEntity.class);
    }

public int checkCity(String name)
{
    EntityManager em = EntManager.getManager().createEntityManager();
    String query = "SELECT m FROM MapEntity AS m WHERE m.city = '"+name+"'";
    TypedQuery<MapEntity>  typedQuery = em.createQuery(query, MapEntity.class);
    try {
        List<MapEntity> a = typedQuery.getResultList();
        return a.get(0).getId();
    }
    catch (Exception exc)
    {
        return -1;
    }


}

}
