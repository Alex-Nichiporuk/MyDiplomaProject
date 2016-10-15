package com.alexd.DAO;

import com.alexd.view.util.CargoWeightView;
import com.alexd.view.util.CheckCargoView;
import com.alexd.view.util.PointView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class PathDao extends GenericClass<PathEntity> implements PathImpl {
    public PathDao() {
        super(PathEntity.class);
    }



    private List<PointHasCargoEntity>checkCargoEntity(EntityManager em, int pathId)
    {

        String query = "SELECT p FROM PointHasCargoEntity AS p , PointEntity  AS po , PathEntity AS pe WHERE p.pointId = po.id AND po.pathId = pe.id AND pe.id="+pathId+" ORDER BY p.pointId , p.status DESC ";
        TypedQuery<PointHasCargoEntity> typedQuery = em.createQuery(query, PointHasCargoEntity.class);
        List<PointHasCargoEntity> result =  typedQuery.getResultList();
        return result;

    }



    public ArrayList<CheckCargoView> checkCargo(EntityManager em, int pathId)
    {
        List<PointHasCargoEntity> engine = checkCargoEntity(  em,   pathId);
        ArrayList<CheckCargoView> checkCargoViews = new ArrayList<CheckCargoView>();
        for(PointHasCargoEntity e : engine)
        {
            checkCargoViews.add(new CheckCargoView(e));
        }

        return checkCargoViews;

    }

    public ArrayList<CargoWeightView> checkWeight(EntityManager em, int pathId)
    {
        List<PointHasCargoEntity> engine = checkCargoEntity(  em,   pathId);
         ArrayList<CargoWeightView>cargoWeightViews = new ArrayList<CargoWeightView>();
        for(PointHasCargoEntity e : engine)
        {
            cargoWeightViews.add(new CargoWeightView(e));
        }
        return cargoWeightViews;

    }


    public ArrayList<PointView> pointAndCargo(int oder, EntityManager em)
    {
        String query = "SELECT p FROM PointHasCargoEntity AS p , PointEntity  AS po , PathEntity AS pe , OrdersEntity as o WHERE p.pointId = po.id AND po.pathId = pe.id AND pe.id=o.pathId AND o.id="+oder;
        TypedQuery<PointHasCargoEntity> typedQuery = em.createQuery(query, PointHasCargoEntity.class);
        List<PointHasCargoEntity> result =  typedQuery.getResultList();
        ArrayList<PointView> resultList = new ArrayList<PointView>();
        for(PointHasCargoEntity pointHasCargoEntity : result)
        {
            resultList.add(new PointView(pointHasCargoEntity.getPointByPointId().getMapByMapId().getCity(), pointHasCargoEntity.getCargoByCargoId().getName(),pointHasCargoEntity.getCargoByCargoId().getWeight(),pointHasCargoEntity.getStatus()));

        }
        return resultList;
    }




}
