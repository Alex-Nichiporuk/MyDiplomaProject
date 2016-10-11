package com.alexd.view.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class ListToView {


    public static ArrayList<DriverView> listToDriverList(List<Object[]> a)
    {
        ArrayList<DriverView> result = new ArrayList<DriverView>();
        for(Object[] b : a) {
            result.add(new DriverView());
            result.get(result.size()-1).setId((Integer)b[0]);
            result.get(result.size()-1).setCity_id((Integer)b[1]);
            result.get(result.size()-1).setName((String)b[2]);
            result.get(result.size()-1).setLastname((String)b[3]);
            result.get(result.size()-1).setTruck((String)b[4]);
            result.get(result.size()-1).setTime((Timestamp) b[5]);
            result.get(result.size()-1).setCity((String) b[6]);
            result.get(result.size()-1).setStatus((Integer)b[7]);


        }
        return result;
    }

    public static ArrayList<TruckView> listToTruckList(List<Object[]> a)
    {
        ArrayList<TruckView> result = new ArrayList<TruckView>();
        for(Object[] b : a) {
            result.add(new TruckView());
            result.get(result.size()-1).setId((String) b[0]);
            result.get(result.size()-1).setSize((Float)b[1]);
            result.get(result.size()-1).setStatus((Boolean) b[2]);
           // result.get(result.size()-1).setDriverdesc((Integer) b[3]);
            result.get(result.size()-1).setMap_id((Integer) b[4]);
            result.get(result.size()-1).setCity((String) b[5]);

        }
        return result;
    }


}
