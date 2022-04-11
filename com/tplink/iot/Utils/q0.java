package com.tplink.iot.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class q0
{
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(":00");
    String str = localStringBuilder.toString();
    if (paramInt < 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(0);
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return str;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    paramString = paramString.split(" ");
    if (paramString.length == 2)
    {
      paramString = paramString[1].split(":");
      if (paramString.length == 3)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString[0]);
        localStringBuilder.append(":");
        localStringBuilder.append(paramString[1]);
        return localStringBuilder.toString();
      }
    }
    return "";
  }
  
  public static long c()
  {
    return System.currentTimeMillis();
  }
  
  public static boolean d(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    boolean bool = true;
    if ((paramCalendar1.get(1) != paramCalendar2.get(1)) || (paramCalendar1.get(2) != paramCalendar2.get(2)) || (paramCalendar1.get(5) != paramCalendar2.get(5))) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean e(Date paramDate1, Date paramDate2)
  {
    return f(paramDate1, paramDate2, TimeZone.getDefault());
  }
  
  public static boolean f(Date paramDate1, Date paramDate2, TimeZone paramTimeZone)
  {
    Calendar localCalendar = Calendar.getInstance(paramTimeZone);
    localCalendar.setTime(paramDate1);
    paramDate1 = Calendar.getInstance(paramTimeZone);
    paramDate1.setTime(paramDate2);
    return d(localCalendar, paramDate1);
  }
  
  public static boolean g(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    boolean bool = true;
    if ((paramCalendar1.get(1) != paramCalendar2.get(1)) || (paramCalendar1.get(2) != paramCalendar2.get(2))) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean h(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate1);
    paramDate1 = Calendar.getInstance();
    paramDate1.setTime(paramDate2);
    return g(localCalendar, paramDate1);
  }
  
  public static boolean i(Date paramDate, TimeZone paramTimeZone)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    localSimpleDateFormat.setTimeZone(paramTimeZone);
    boolean bool = false;
    try
    {
      paramTimeZone = new java/util/Date;
      paramTimeZone.<init>();
      paramTimeZone = localSimpleDateFormat.parse(localSimpleDateFormat.format(paramTimeZone));
      paramDate = localSimpleDateFormat.parse(localSimpleDateFormat.format(paramDate));
      if ((paramTimeZone != null) && (paramDate != null))
      {
        long l1 = paramTimeZone.getTime();
        long l2 = paramDate.getTime();
        if (l1 - l2 == 86400000L) {
          bool = true;
        }
        return bool;
      }
    }
    catch (ParseException paramDate)
    {
      paramDate.printStackTrace();
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\q0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */