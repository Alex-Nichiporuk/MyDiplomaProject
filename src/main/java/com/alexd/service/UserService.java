package com.alexd.service;

import com.alexd.DAO.GenericClass;
import com.alexd.DAO.UserDao;
import com.alexd.model.UserEntity;

/**
 * Created by Cj444 on 16.10.2016.
 */
public class UserService {





  public static   String checkUser(String login , String pass)
    {
        UserDao userDao = new UserDao();
        String answer = userDao.checkUser(login, pass);
         return answer;
    }

    public static   int  checkRole (String login)
    {
        UserDao userDao = new UserDao();
        int answer = userDao.checkRole(login);
        return answer;

    }

    public static int addUser(String login, String password , String name, String lastName, int roleId)
    {
        UserEntity userEntity = new UserEntity(login,password,name,lastName,roleId);
        UserDao userDao = new UserDao();
        userDao.insert(userEntity);
        return userEntity.getId();
    }
}
