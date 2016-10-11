package com.alexd.DAO;

import com.alexd.model.MapEntity;
import com.alexd.util.man.EntManager;

import javax.persistence.Query;
import java.sql.ResultSet;

/**
 * Created by Cj444 on 09.10.2016.
 */
public class MapDao extends GenericClass {

    MapEntity e;
   public MapDao()
   {
       super(MapEntity.class);
   }



    private void setEntity(String name, float latitude, float longitude)
    {
        e = new MapEntity();
        e.setCity(name);
        e.setLatitude(latitude);
        e.setLongitude(longitude);
    }

    private void setEntity(int id, String name, float latitude, float longitude)
    {
        e = new MapEntity();
        e.setCity(name);
        e.setLatitude(latitude);
        e.setLongitude(longitude);
        e.setId(id);
    }

    public int addMap(String name, float latitude, float longitude)
    {
        setEntity(  name,   latitude,   longitude);
        this.insert(e);
        return e.getId();
    }




    public void updateMap(int id, String name, float latitude, float longitude)
    {
        setEntity(id,  name,   latitude,   longitude);
        this.update(e);
    }


   public MapEntity findByName(String name)
   {
       String queryText = "SELECT *  FROM mydb.map WHERE City = '"+name+"';";
       Query query = EntManager.getManager().createNativeQuery(queryText);
       Object result = query.getSingleResult();

       Object [] resultMas = (Object[])result;
       MapEntity mapEntity = new MapEntity();
       mapEntity.setId((Integer)resultMas[0]);
       mapEntity.setLatitude((Float)resultMas[2]);
       mapEntity.setLongitude((Float)resultMas[3]);
        mapEntity.setCity(name);
       return mapEntity;
   }

}
