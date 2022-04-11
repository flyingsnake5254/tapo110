package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class ScheduleParser
{
  public static final ScheduleParser INSTANCE = new ScheduleParser();
  private static final Pattern pattern = Pattern.compile(".*(\\d{2})(\\d{2})-(\\d{2})(\\d{2})[,:](\\d+).*");
  private static final Pattern pattern2 = Pattern.compile(".*(\\d{2})(\\d{2})-(\\d{2})(\\d{2}).*");
  
  public static final String formatAlarmSchedule(Schedule paramSchedule)
  {
    j.e(paramSchedule, "schedule");
    paramSchedule = String.format(Locale.US, "%02d%02d-%02d%02d,%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramSchedule.getStartHour()), Integer.valueOf(paramSchedule.getStartMinute()), Integer.valueOf(paramSchedule.getEndHour()), Integer.valueOf(paramSchedule.getEndMinute()), Integer.valueOf(paramSchedule.getType()) }, 5));
    j.d(paramSchedule, "java.lang.String.format(locale, this, *args)");
    return paramSchedule;
  }
  
  public static final String formatIntrusionSchedule(IntrusionSchedule paramIntrusionSchedule)
  {
    j.e(paramIntrusionSchedule, "schedule");
    paramIntrusionSchedule = String.format(Locale.US, "\"%02d%02d-%02d%02d\"", Arrays.copyOf(new Object[] { Integer.valueOf(paramIntrusionSchedule.getStartHour()), Integer.valueOf(paramIntrusionSchedule.getStartMinute()), Integer.valueOf(paramIntrusionSchedule.getEndHour()), Integer.valueOf(paramIntrusionSchedule.getEndMinute()) }, 4));
    j.d(paramIntrusionSchedule, "java.lang.String.format(locale, this, *args)");
    return paramIntrusionSchedule;
  }
  
  public static final String formatIntrusionSchedules(List<IntrusionSchedule> paramList)
  {
    if (paramList != null)
    {
      paramList = kotlin.collections.l.E(paramList, ",", "[", "]", 0, null, formatIntrusionSchedules.1.INSTANCE, 24, null);
      if (paramList != null) {}
    }
    else
    {
      paramList = "[]";
    }
    return paramList;
  }
  
  public static final String formatRecordSchedule(Schedule paramSchedule)
  {
    j.e(paramSchedule, "schedule");
    paramSchedule = String.format(Locale.US, "\"%02d%02d-%02d%02d:%d\"", Arrays.copyOf(new Object[] { Integer.valueOf(paramSchedule.getStartHour()), Integer.valueOf(paramSchedule.getStartMinute()), Integer.valueOf(paramSchedule.getEndHour()), Integer.valueOf(paramSchedule.getEndMinute()), Integer.valueOf(paramSchedule.getType()) }, 5));
    j.d(paramSchedule, "java.lang.String.format(locale, this, *args)");
    return paramSchedule;
  }
  
  public static final String formatRecordSchedules(List<Schedule> paramList)
  {
    if (paramList != null)
    {
      paramList = kotlin.collections.l.E(paramList, ",", "[", "]", 0, null, formatRecordSchedules.1.INSTANCE, 24, null);
      if (paramList != null) {}
    }
    else
    {
      paramList = "[]";
    }
    return paramList;
  }
  
  public static final String formatTime(int paramInt1, int paramInt2)
  {
    String str = String.format(Locale.US, "%02d%02d", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
    j.d(str, "java.lang.String.format(locale, this, *args)");
    return str;
  }
  
  public static final IntrusionSchedule parseIntrusionSchedule(String paramString)
  {
    if (paramString != null)
    {
      paramString = pattern2.matcher(paramString);
      if (paramString.matches())
      {
        String str = paramString.group(1);
        j.d(str, "matcher.group(1)");
        int i = Integer.parseInt(str);
        str = paramString.group(2);
        j.d(str, "matcher.group(2)");
        int j = Integer.parseInt(str);
        str = paramString.group(3);
        j.d(str, "matcher.group(3)");
        int k = Integer.parseInt(str);
        paramString = paramString.group(4);
        j.d(paramString, "matcher.group(4)");
        return new IntrusionSchedule(i, j, k, Integer.parseInt(paramString));
      }
    }
    return null;
  }
  
  public static final List<IntrusionSchedule> parseIntrusionSchedules(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString != null)
    {
      paramString = m.e0(paramString, new char[] { ',' }, false, 0, 6, null).iterator();
      while (paramString.hasNext())
      {
        IntrusionSchedule localIntrusionSchedule = parseIntrusionSchedule((String)paramString.next());
        if (localIntrusionSchedule != null) {
          localArrayList.add(localIntrusionSchedule);
        }
      }
    }
    return localArrayList;
  }
  
  public static final Schedule parseSchedule(String paramString)
  {
    if (paramString != null)
    {
      paramString = pattern.matcher(paramString);
      if (paramString.matches())
      {
        String str = paramString.group(1);
        j.d(str, "matcher.group(1)");
        int i = Integer.parseInt(str);
        str = paramString.group(2);
        j.d(str, "matcher.group(2)");
        int j = Integer.parseInt(str);
        str = paramString.group(3);
        j.d(str, "matcher.group(3)");
        int k = Integer.parseInt(str);
        str = paramString.group(4);
        j.d(str, "matcher.group(4)");
        int m = Integer.parseInt(str);
        paramString = paramString.group(5);
        j.d(paramString, "matcher.group(5)");
        return new Schedule(i, j, k, m, Integer.parseInt(paramString));
      }
    }
    return null;
  }
  
  public static final List<Schedule> parseSchedules(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString != null)
    {
      paramString = m.e0(paramString, new char[] { ',' }, false, 0, 6, null).iterator();
      while (paramString.hasNext())
      {
        Schedule localSchedule = parseSchedule((String)paramString.next());
        if (localSchedule != null) {
          localArrayList.add(localSchedule);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ScheduleParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */