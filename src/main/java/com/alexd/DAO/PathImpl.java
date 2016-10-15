package com.alexd.DAO;

import com.alexd.model.PathEntity;
import com.alexd.view.util.CheckCargoView;

import javax.persistence.EntityManager;
import java.util.ArrayList;

/**
 * Created by Cj444 on 13.10.2016.
 */
public interface PathImpl extends GenericDao<PathEntity> {
    ArrayList<CheckCargoView> checkCargo(EntityManager em, int path_id);
}
