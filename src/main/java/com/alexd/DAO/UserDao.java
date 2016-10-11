package com.alexd.DAO;

import com.alexd.model.UserEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class UserDao extends GenericClass {
    UserEntity e;
    public UserDao() {
        super(UserEntity.class);
    }




    private void setEntity(String login, String password, String name, String lastname, int role)
    {
        e = new UserEntity();
        e.setName(name);
        e.setLastName(lastname);
        e.setLogin(login);
        e.setPassword(password);
        e.setRoleId(role);
    }

    public int addUser(String login, String password, String name, String lastname, int role)
    {
        setEntity(   login,   password,   name,   lastname,   role);
        this.insert(e);
        return e.getId();
    }


    public void deleteUser(String login, String password, String name, String lastname, int role)
    {
        setEntity(  login,   password,   name,   lastname,   role);
        this.delete(e);

    }

    public void updateUser(String login, String password, String name, String lastname, int role)
    {
        setEntity(   login,   password,   name,   lastname,   role);
        this.update(e);

    }

    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}


