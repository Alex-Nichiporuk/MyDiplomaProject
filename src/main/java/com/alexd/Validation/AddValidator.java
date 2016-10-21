package com.alexd.Validation;

import com.alexd.service.MapService;
import com.alexd.service.UserService;

/**
 * Created by Cj444 on 21.10.2016.
 */
public class AddValidator {

    public static int check(String name, String lastName, String city, String login, String password) {
        if (name.equals("")) {
            return 1;
        }
        if (lastName.equals("")) {
            return 2;
        }
        if (city.equals("")) {
            return 3;
        }
        if (login.equals("")) {
            return 4;
        }
        if (password.equals("")) {
            return 5;
        }

        MapService mapService = new MapService();
       int cityId = mapService.checkCity(city);
        if(cityId==-1)
        {
            return 6;

        }

        UserService userService = new UserService();
        if(!userService.checkLogin(login))
        {
            return 7;

        }


        return 0;
    }

}