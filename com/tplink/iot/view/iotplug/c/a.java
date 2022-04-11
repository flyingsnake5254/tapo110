package com.tplink.iot.view.iotplug.c;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class a
{
  public static int a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    return localCalendar.get(11) * 60 + localCalendar.get(12);
  }
  
  public static String b(long paramLong)
  {
    return new SimpleDateFormat("dd/MM/yyyy").format(new Date(paramLong));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */