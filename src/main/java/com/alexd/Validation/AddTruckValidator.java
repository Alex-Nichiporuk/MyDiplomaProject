package com.alexd.Validation;

import com.alexd.model.TruckEntity;
import com.alexd.service.MapService;
import com.alexd.service.TruckService;
import com.alexd.service.UserService;

/**
 * Created by Cj444 on 23.10.2016.
 */
public class AddTruckValidator {
    public static int check(String number, String size, String city, String desc) {
        if (number.equals("")) {
            return 1;
        }
        if (size.equals("")) {
            return 2;
        }
        if (city.equals("")) {
            return 3;
        }
        if (desc.equals("")) {
            return 4;
        }


        MapService mapService = new MapService();
        int cityId = mapService.checkCity(city);
        if(cityId==-1)
        {
            return 6;

        }

        TruckService truckService = new TruckService();
        if(!truckService.checkTruckNumber(number))
        {
            return 7;

        }


        return 0;
    }


    public static int checkWithStatus(String number, String size, String city, String desc, String status) {
        if (number.equals("")) {
            return 1;
        }
        if (size.equals("")) {
            return 2;
        }
        if (city.equals("")) {
            return 3;
        }
        if (desc.equals("")) {
            return 4;
        }


        MapService mapService = new MapService();
        int cityId = mapService.checkCity(city);
        if(cityId==-1)
        {
            return 6;

        }

        TruckService truckService = new TruckService();
        if(!truckService.checkTruckNumber(number))
        {
            return 7;

        }

        if(status.equals(""))
        {
            return 8;
        }

        if(!status.equals("ok")||!status.equals("broke"))
        {
            return 9;
        }

        return 0;
    }
}
