package com.tplink.iot.Utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class r0
{
  public static int a(Timestamp paramTimestamp)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(paramTimestamp.getTime()));
    return localCalendar.get(5);
  }
  
  public static int b(Timestamp paramTimestamp)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(paramTimestamp.getTime()));
    return localCalendar.get(2);
  }
  
  public static int c(Timestamp paramTimestamp)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(paramTimestamp.getTime()));
    return localCalendar.get(1);
  }
  
  public static boolean d(Timestamp paramTimestamp1, Timestamp paramTimestamp2)
  {
    long l1 = c(paramTimestamp1) - c(paramTimestamp2);
    long l2 = b(paramTimestamp1) - b(paramTimestamp2);
    long l3 = a(paramTimestamp1) - a(paramTimestamp2);
    return (l1 == 0L) && (l2 == 0L) && (l3 == 0L);
  }
  
  public static boolean e(Timestamp paramTimestamp)
  {
    return d(new Timestamp(System.currentTimeMillis()), paramTimestamp);
  }
  
  public static boolean f(Timestamp paramTimestamp)
  {
    Timestamp localTimestamp = new Timestamp(System.currentTimeMillis());
    long l1 = c(localTimestamp) - c(paramTimestamp);
    long l2 = b(localTimestamp) - b(paramTimestamp);
    long l3 = a(localTimestamp) - a(paramTimestamp);
    return (l1 == 0L) && (l2 == 0L) && (l3 == 1L);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\r0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */