package com.alexd.DAO;

import com.alexd.model.UserEntity;
import com.alexd.util.man.EntManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Cj444 on 16.10.2016.
 */
public class UserDao extends GenericClass {
    public UserDao() {
        super( UserEntity.class);
    }

    public String checkUser(String login, String password)
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        String query="SELECT u FROM UserEntity AS u WHERE u.login = ? AND u.password = ?";
        TypedQuery<UserEntity> tQuery = em.createQuery(query, UserEntity.class);
        tQuery.setParameter(0, login);
        tQuery.setParameter(1,password);
        try{
         UserEntity result =   tQuery.getSingleResult();
            return result.getName();
        }
        catch (Exception exc)
        {
            return "error";
        }
    }


    public int checkRole(String login)
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        String query="SELECT u FROM UserEntity AS u WHERE u.login = ? ";
        TypedQuery<UserEntity> tQuery = em.createQuery(query, UserEntity.class);
        tQuery.setParameter(0, login);

        try{
            UserEntity result =   tQuery.getSingleResult();
            return result.getRoleId();
        }
        catch (Exception exc)
        {
            return -1;
        }
    }

    public boolean checkLogin(String login)
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        String query="SELECT u FROM UserEntity AS u WHERE u.login = ? ";
        TypedQuery<UserEntity> tQuery = em.createQuery(query, UserEntity.class);
        tQuery.setParameter(0, login);

        List<UserEntity> userEntities = tQuery.getResultList();
        if(userEntities.size()>0)
        {
            return false;
        }
        return true;
    }

    public boolean deleteDriver(int id)
    {

        try {
            UserEntity userEntity = getByDriverId(id);
            this.delete(userEntity.getId());
            return true;
        }
        catch (Exception e)
        {
            return false;
        }


    }

    public UserEntity getByDriverId(int id)
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        String query="SELECT u FROM UserEntity AS u WHERE u.driverId = ? ";
        TypedQuery<UserEntity> tQuery = em.createQuery(query, UserEntity.class);
        tQuery.setParameter(0, id);
        UserEntity userEntity = tQuery.getSingleResult();
        return userEntity;
    }

    public UserEntity getByDriverLogin(String login)
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        String query="SELECT u FROM UserEntity AS u WHERE u.login = ? ";
        TypedQuery<UserEntity> tQuery = em.createQuery(query, UserEntity.class);
        tQuery.setParameter(0, login);
        UserEntity userEntity = tQuery.getSingleResult();
        return userEntity;
    }





}
