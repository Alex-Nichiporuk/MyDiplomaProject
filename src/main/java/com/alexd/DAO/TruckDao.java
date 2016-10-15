package com.alexd.DAO;

import com.alexd.view.util.TruckView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cj444 on 10.10.2016.
 */
public class TruckDao extends GenericClass<TruckEntity> implements TruckImpl {

    public TruckDao() {
        super( TruckEntity.class);
    }


    public List<TruckEntity>selectAll(EntityManager em)
    {
        TypedQuery<TruckEntity> q = em.createQuery("select  t FROM TruckEntity as t" ,TruckEntity.class);
        List<TruckEntity> result =  q.getResultList();
        return result;

    }


    public ArrayList<TruckView>selectCheckedTrucks(EntityManager em, float weight)
    {

        String query = "SELECT t FROM TruckEntity AS t WHERE  t.status = true AND t.busyStatus = false AND t.size >="+weight;
        TypedQuery<TruckEntity> q = em.createQuery(query,TruckEntity.class);
        List<TruckEntity> result = q.getResultList();
        ArrayList<TruckView> truckResult = new ArrayList<TruckView>();
        for(TruckEntity a : result)
        {
            truckResult.add(new TruckView(a));
        }
return truckResult;
    }





}
