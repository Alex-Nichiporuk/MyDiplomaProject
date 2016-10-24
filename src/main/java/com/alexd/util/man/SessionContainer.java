package com.alexd.util.man;

import com.alexd.view.util.TruckView;
import com.alexd.view.util.UserView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Cj444 on 22.10.2016.
 */
public class SessionContainer {
    UserView currentUser;
    UserView editUser;

    TruckView editTruck;

    String updateUser;
    String order;


    HashMap<Integer, String> cargosId = new HashMap<Integer, String>();
    String currentPoint;

    public String getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(String currentPoint) {
        this.currentPoint = currentPoint;
    }

    public static SessionContainer get(HttpSession session) {
        SessionContainer sessionContainer = (SessionContainer)session.getAttribute("userContainer");
        if (sessionContainer == null) {
            sessionContainer = new SessionContainer();
            session.setAttribute("userContainer", sessionContainer);
        }
        return sessionContainer;
    }

    public  HashMap<Integer, String> getCargosId() {
        return cargosId;
    }

    public void setCargosId( HashMap<Integer, String>  cargosId) {
        this.cargosId = cargosId;
    }

    public TruckView getEditTruck() {
        return editTruck;
    }

    public void setEditTruck(TruckView editTruck) {
        this.editTruck = editTruck;
    }

    public UserView getEditUser() {
        return editUser;
    }

    public void setEditUser(UserView editUser) {
        this.editUser = editUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public UserView getCurrentUser() {
        return currentUser;
    }


    public String getUpdateUser() {
        return updateUser;
    }

    public String getOrder() {
        return order;
    }
}
