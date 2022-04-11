package com.tplink.iot.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

public class o0
{
  private static Calendar a = ;
  
  public static String a(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, true);
  }
  
  public static String b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i = paramInt / 60 % 24;
    int j = paramInt % 60;
    boolean bool = p(paramContext);
    Object localObject1 = "";
    Object localObject2;
    if (bool)
    {
      paramContext = new java/lang/StringBuilder;
      if (i < 10)
      {
        paramContext.<init>();
        paramContext.append("0");
      }
      else
      {
        paramContext.<init>();
        paramContext.append("");
      }
      paramContext.append(i);
      paramContext = paramContext.toString();
      localObject2 = new java/lang/StringBuilder;
      if (j < 10)
      {
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("0");
      }
      else
      {
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("");
      }
      ((StringBuilder)localObject2).append(j);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append((String)localObject2);
      return ((StringBuilder)localObject1).toString();
    }
    paramInt = 12;
    if ((i >= 0) && (i < 12)) {
      localObject2 = com.tplink.iot.widget.h.c()[0];
    } else {
      localObject2 = com.tplink.iot.widget.h.c()[1];
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    i %= 12;
    if (i != 0) {
      paramInt = i;
    }
    ((StringBuilder)localObject3).append(paramInt);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new java/lang/StringBuilder;
    if (j < 10)
    {
      ((StringBuilder)localObject4).<init>();
      ((StringBuilder)localObject4).append("0");
    }
    else
    {
      ((StringBuilder)localObject4).<init>();
      ((StringBuilder)localObject4).append("");
    }
    ((StringBuilder)localObject4).append(j);
    localObject4 = ((StringBuilder)localObject4).toString();
    if (paramBoolean) {
      localObject1 = " ";
    }
    if (q(paramContext))
    {
      paramContext = new StringBuilder();
      paramContext.append((String)localObject2);
      paramContext.append((String)localObject1);
      paramContext.append((String)localObject3);
      paramContext.append(":");
      paramContext.append((String)localObject4);
      return paramContext.toString();
    }
    paramContext = new StringBuilder();
    paramContext.append((String)localObject3);
    paramContext.append(":");
    paramContext.append((String)localObject4);
    paramContext.append((String)localObject1);
    paramContext.append((String)localObject2);
    return paramContext.toString();
  }
  
  public static String c(Context paramContext, int paramInt, RuleTimeType paramRuleTimeType)
  {
    if (paramRuleTimeType == RuleTimeType.SUNRISE) {
      return paramContext.getResources().getString(2131954168);
    }
    if (paramRuleTimeType == RuleTimeType.SUNSET) {
      return paramContext.getResources().getString(2131954171);
    }
    return b(paramContext, paramInt, true);
  }
  
  private static Calendar d()
  {
    TimeZone localTimeZone1 = a.getTimeZone();
    TimeZone localTimeZone2 = TimeZone.getDefault();
    int i;
    if ((localTimeZone2 != null) && (!TextUtils.equals(localTimeZone1.getID(), localTimeZone2.getID()))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      a.setTimeZone(localTimeZone2);
    }
    return a;
  }
  
  public static String e(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt / 3600;
    if (i < 10) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    i = paramInt % 3600 / 60;
    if (i < 10) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    paramInt %= 60;
    if (paramInt < 10) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String f(long paramLong, String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone(paramString));
    return localSimpleDateFormat.format(new Date(paramLong));
  }
  
  public static String g(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
  }
  
  public static String h(long paramLong)
  {
    return new SimpleDateFormat("MM.dd  EEEE", Locale.getDefault()).format(new Date(paramLong * 1000L));
  }
  
  public static String i(long paramLong, HashSet<String> paramHashSet)
  {
    Date localDate = new Date(paramLong);
    Calendar localCalendar = d();
    localCalendar.setTime(localDate);
    if ((localCalendar.get(1) != Calendar.getInstance().get(1)) && (paramHashSet != null) && (!paramHashSet.contains(String.valueOf(localCalendar.get(1)))))
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd  EEEE", Locale.getDefault());
      paramHashSet.add(String.valueOf(localCalendar.get(1)));
      paramHashSet = localSimpleDateFormat;
    }
    else
    {
      paramHashSet = new SimpleDateFormat("MM.dd  EEEE", Locale.getDefault());
    }
    return paramHashSet.format(localDate);
  }
  
  public static long j(long paramLong)
  {
    return paramLong - TimeZone.getDefault().getRawOffset();
  }
  
  public static long k(int paramInt, String paramString)
  {
    paramString = p0.d(paramString);
    int i = paramString.getRawOffset() / 1000;
    if (paramInt > 946656000) {
      return paramInt * 1000L;
    }
    i += paramInt;
    if (i >= 86400)
    {
      paramInt = i - 86400;
    }
    else
    {
      paramInt = i;
      if (i < 0) {
        paramInt = i + 86400;
      }
    }
    paramInt %= 86400;
    paramString = Calendar.getInstance(paramString);
    paramString.set(5, paramString.get(5));
    paramString.set(11, paramInt / 3600);
    paramString.set(12, paramInt % 3600 / 60);
    paramString.set(13, paramInt % 60);
    paramString.set(14, 0);
    return paramString.getTimeInMillis();
  }
  
  public static int l(long paramLong)
  {
    d().setTime(new Date(paramLong * 1000L));
    return d().get(11) * 60 + d().get(12);
  }
  
  public static int m(long paramLong)
  {
    d().setTime(new Date(paramLong));
    return d().get(11) * 60 + d().get(12);
  }
  
  public static String n(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return paramContext.getString(2131953209);
    }
    String str;
    if (paramInt < 0) {
      str = "-";
    } else {
      str = "+";
    }
    int i = Math.abs(paramInt);
    paramInt = i / 60 % 6;
    i %= 60;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramContext.getString(2131953395));
      return localStringBuilder.toString();
    }
    if (i == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramContext.getString(2131953394));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramContext.getString(2131953394));
    localStringBuilder.append(" ");
    localStringBuilder.append(i);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramContext.getString(2131953395));
    return localStringBuilder.toString();
  }
  
  public static String o(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    String str;
    if (paramInt < 0) {
      str = "-";
    } else {
      str = "+";
    }
    int i = Math.abs(paramInt);
    paramInt = i / 60 % 6;
    i %= 60;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramContext.getString(2131953395));
      return localStringBuilder.toString();
    }
    if (i == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramContext.getString(2131953394));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramContext.getString(2131953394));
    localStringBuilder.append(" ");
    localStringBuilder.append(i);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramContext.getString(2131953395));
    return localStringBuilder.toString();
  }
  
  public static boolean p(Context paramContext)
  {
    return DateFormat.is24HourFormat(paramContext);
  }
  
  public static boolean q(Context paramContext)
  {
    paramContext = ((SimpleDateFormat)DateFormat.getTimeFormat(paramContext)).toPattern();
    boolean bool;
    if ((paramContext.indexOf('a') != 0) && (paramContext.indexOf('A') != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static String r(long paramLong)
  {
    return new SimpleDateFormat("yyyy.MM.dd").format(new Date(paramLong));
  }
  
  public static long s(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone(paramString2));
    try
    {
      long l = localSimpleDateFormat.parse(paramString1).getTime();
      return l;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\o0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */