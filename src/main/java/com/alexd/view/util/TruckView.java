package com.alexd.view.util;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class TruckView {
    String id;
    float size;
    boolean status;
    int driverdesc;
    int map_id;
    String city;
    boolean busyStatus;

    public TruckView(TruckEntity truckEntity)
    {
        id = truckEntity.getId();
        size = truckEntity.getSize();
        status = truckEntity.getStatus();
        busyStatus = truckEntity.getBusyStatus();
        driverdesc = truckEntity.getDriverdesc();
        map_id = truckEntity.getMapId();
        city = truckEntity.getMapByMapId().getCity();
    }

    public String getCity() {
        return city;
    }

    public String getId() {
        return id;
    }

    public float getSize() {
        return size;
    }

    public boolean getStatus() {
        return status;
    }

    public int getDriverdesc() {
        return driverdesc;
    }

    public int getMap_id() {
        return map_id;
    }


}
