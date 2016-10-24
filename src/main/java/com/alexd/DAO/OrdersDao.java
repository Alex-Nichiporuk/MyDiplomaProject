package com.alexd.DAO;

import com.alexd.model.OrdersEntity;
import com.alexd.model.TimeEntity;
import com.alexd.util.man.EntManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class OrdersDao extends GenericClass {

    public OrdersDao()
    {
        super(OrdersEntity.class);
    }

public List<OrdersEntity> getAll()
{
    EntityManager em = EntManager.getManager().createEntityManager();
    String query = "SELECT d FROM OrdersEntity AS d";
    TypedQuery<OrdersEntity> q = em.createQuery( query ,OrdersEntity.class);


    return q.getResultList();
}


}
