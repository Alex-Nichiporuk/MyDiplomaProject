package com.alexd.DAO;

import com.alexd.model.OrdersEntity;

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






}
