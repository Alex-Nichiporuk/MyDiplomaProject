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

    private void setEntity(int id, String name , byte priv)
    {
        e = new RoleEntity();
        e.setName(name);
        e.setPriv(priv);
        e.setId(id);
    }

    public int addRole(String name , byte priv)
    {
        setEntity(   name ,   priv);
        this.insert(e);
        return e.getId();
    }




    public void updateRole(int id , String name , byte priv)
    {
        setEntity(id,  name ,   priv);
        this.update(e);

    }


}
