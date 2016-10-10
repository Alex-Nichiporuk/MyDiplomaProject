package com.alexd.DAO;

import com.alexd.model.MapEntity;
import com.alexd.util.man.EntManager;

import javax.persistence.Query;
import java.sql.ResultSet;

/**
 * Created by Cj444 on 09.10.2016.
 */
public class MapDao extends GenericClass {

   public MapDao()
   {
       super(MapEntity.class);
   }







public boolean addCity(String name, float latitude, float longitude)
{
    try{

       MapEntity e = new MapEntity();
        e.setCity(name);
        e.setLatitude(latitude);
        e.setLongitude(longitude);
        this.beginTransaction();
        this.insert(e);
        this.commitTransaction();
    }
    catch (Exception e)
    {
    return false;
    }
    return true;


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




    public int findMaxId() {
        return 0;
    }

    @Override
    public Object findByMaxId() {
        return null;
    }
}
