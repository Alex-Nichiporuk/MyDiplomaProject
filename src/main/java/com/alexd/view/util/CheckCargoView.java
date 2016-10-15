package com.alexd.view.util;

/**
 * Created by Cj444 on 12.10.2016.
 */
public class CheckCargoView {
int cargoId;
    boolean status;
    int pointId;
    int check;

    public CheckCargoView(PointHasCargoEntity pointHasCargoEntity) {
        this.cargoId = pointHasCargoEntity.getCargoId();
        this.status = pointHasCargoEntity.getStatus();
        this.pointId = pointHasCargoEntity.getPointId();
        this.check=0;
    }

    public int getCargo_id() {
        return cargoId;
    }
    public boolean isStatus() {
        return status;
    }
    public int getPoint_id() {
        return pointId;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckCargoView that = (CheckCargoView) o;

        if (cargoId != that.cargoId) return false;
        if (pointId != that.pointId) return false;
        if (status != that.status) return false;
        if (check != that.check) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;

        result = cargoId;
        result = 31 * result + pointId;
         int temp =   status==true?1:0;
        result = 31 * result + temp;
        return result;
    }

}
