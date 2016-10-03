package com.alexd.util;

/**
 * Created by Cj444 on 02.10.2016.
 */


        import org.hibernate.SessionFactory;
        import org.hibernate.cfg.Configuration;

public class HibernateFactory {
private static SessionFactory sessionFactory = null;
    static {
          sessionFactory = new Configuration().configure().buildSessionFactory();
    }


    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
