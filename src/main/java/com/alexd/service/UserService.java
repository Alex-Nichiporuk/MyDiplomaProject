package com.alexd.service;

import com.alexd.DAO.GenericClass;
import com.alexd.DAO.UserDao;
import com.alexd.model.UserEntity;

/**
 * Created by Cj444 on 16.10.2016.
 */
public class UserService {





  public     String checkUser(String login , String pass)
    {
        UserDao userDao = new UserDao();
        String answer = userDao.checkUser(login, pass);
         return answer;
    }

    public     int  checkRole (String login)
    {
        UserDao userDao = new UserDao();
        int answer = userDao.checkRole(login);
        return answer;

    }

    public     boolean  checkLogin (String login)
    {
        UserDao userDao = new UserDao();
        return userDao.checkLogin(login);


    }

    public   int addUser(String login, String password , String name, String lastName, int roleId)
    {
        UserEntity userEntity = new UserEntity(login,password,name,lastName,roleId);
        UserDao userDao = new UserDao();
        userDao.insert(userEntity);
        return userEntity.getId();
    }

    public   int addUser(String login, String password , String name, String lastName, int roleId, int driverId )
    {
        UserEntity userEntity = new UserEntity(login,password,name,lastName,roleId, driverId);
        UserDao userDao = new UserDao();
        userDao.insert(userEntity);
        return userEntity.getId();
    }

    public boolean delUser(int id)
    {
        try
        {
            UserDao userDao = new UserDao();
            userDao.delete(id);
            return true;

        }
        catch (Exception e)
        {
            return false;
        }
    }
}
