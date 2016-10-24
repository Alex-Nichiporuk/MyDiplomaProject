package com.alexd.view.util;

import com.alexd.model.UserEntity;

/**
 * Created by Cj444 on 22.10.2016.
 */
public class UserView {
    private int id;
    private String login;
    private String password;
    private String name;
    private String lastName;

    private int driverId;

    public UserView(int id, String login, String password, String name, String lastName, int driverId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.driverId = driverId;
    }

    public UserView(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.login = userEntity.getLogin();
        this.password = userEntity.getPassword();
        this.name = userEntity.getName();
        this.lastName = userEntity.getLastName();

        this.driverId = userEntity.getDriverId();
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    public int getDriverId() {
        return driverId;
    }
}
