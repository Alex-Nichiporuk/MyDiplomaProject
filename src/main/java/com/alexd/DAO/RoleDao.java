package com.alexd.DAO;

import com.alexd.model.RoleEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class RoleDao extends GenericClass {
    RoleEntity e;
    public RoleDao() {
        super(RoleEntity.class);
    }




    private void setEntity(String name , byte priv)
    {
        e = new RoleEntity();
        e.setName(name);
        e.setPriv(priv);
    }

    public int addRole(String name , byte priv)
    {
        setEntity(   name ,   priv);
        this.insert(e);
        return e.getId();
    }


    public void deleteRole(String name , byte priv)
    {
        setEntity(   name ,   priv);
        this.delete(e);

    }

    public void updateRole(String name , byte priv)
    {
        setEntity(  name ,   priv);
        this.update(e);

    }


    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
