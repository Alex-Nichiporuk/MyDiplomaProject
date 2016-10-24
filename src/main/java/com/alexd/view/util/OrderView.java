package com.alexd.view.util;

import com.alexd.model.OrdersEntity;

import java.sql.Timestamp;

/**
 * Created by Cj444 on 23.10.2016.
 */
public class OrderView {
    int id;
    boolean status;
    Timestamp begin;
    Timestamp end;

    public OrderView(OrdersEntity ordersEntity) {
        this.id = ordersEntity.getId();
        this.status = ordersEntity.getStatus();
        this.begin = ordersEntity.getTimeByTimeId().getBegin();
        this.end = ordersEntity.getTimeByTimeId().getEnd();
    }

    public int getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }

    public Timestamp getBegin() {
        return begin;
    }

    public Timestamp getEnd() {
        return end;
    }
}
