package com.alexd.util.man;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Cj444 on 23.10.2016.
 */
public class TimeUtil {
    public static Timestamp convertStringToTimestamp(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("dd/MM/yyyy");

            Date date = formatter.parse(str_date);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }


    public static Timestamp convertStringToTimestampMonth(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("MM/yyyy");

            Date date = formatter.parse(str_date);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }


    public static int getMonth(Timestamp a)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(a.getTime()));
      return  calendar.get(Calendar.MONTH);
    }
}
