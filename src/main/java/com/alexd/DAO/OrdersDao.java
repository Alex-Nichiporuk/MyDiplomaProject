package com.alexd.DAO;

import com.alexd.model.OrdersEntity;
import com.alexd.view.util.CheckCargoView;
import com.alexd.view.util.ListToView;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class OrdersDao extends GenericClass {
    OrdersEntity e;
    public OrdersDao()
    {
        super(OrdersEntity.class);
    }

        private void setEntity(byte status, int path_id, int drivers_id , int trucks_id, int time_id) {
          e = new OrdersEntity();
            e.setPathId(path_id);
            e.setDriversId(drivers_id);
            e.setTrucksId(trucks_id);
            e.setTimeId(time_id);
            e.setStatus(status);
        }

    private void setEntity(int id, byte status, int path_id, int drivers_id , int trucks_id, int time_id) {
        e = new OrdersEntity();
        e.setPathId(path_id);
        e.setDriversId(drivers_id);
        e.setTrucksId(trucks_id);
        e.setTimeId(time_id);
        e.setStatus(status);
        e.setId(id);
    }

        public int addOrders(byte status, int path_id, int drivers_id , int trucks_id, int time_id)
        {
            setEntity(   status,   path_id,   drivers_id ,   trucks_id,   time_id);
            this.insert(e);
            return e.getId();
        }




        public void updateOrders(int id ,byte status, int path_id, int drivers_id , int trucks_id, int time_id)
        {
            setEntity( id, status,   path_id,   drivers_id ,   trucks_id,   time_id);
            this.update(e);

        }



public ArrayList<CheckCargoView> checkCargo(EntityManager em, int path_id)
{
    String query = "SELECT a.Cargo_id, a.Status, a.Point_id FROM point_has_cargo a JOIN point b JOIN path c ON c.id=b.Path_id AND b.id = a.Point_id WHERE c.id ="+path_id;
    Query resultQuery =  em.createNativeQuery(query);
    List<Object[]> a =  resultQuery.getResultList();

    return ListToView.listToCargoCheck(a);

}





}
