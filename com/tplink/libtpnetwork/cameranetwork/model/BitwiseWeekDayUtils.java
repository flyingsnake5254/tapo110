package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class BitwiseWeekDayUtils
{
  public static final BitwiseWeekDayUtils INSTANCE = new BitwiseWeekDayUtils();
  private static final List<BitwiseWeekDay> allDays = daysFromRawSet(BitwiseWeekDay.Companion.getEveryday());
  
  public static final List<BitwiseWeekDay> daysFromRawSet(int paramInt)
  {
    BitwiseWeekDay[] arrayOfBitwiseWeekDay = BitwiseWeekDay.values();
    ArrayList localArrayList = new ArrayList();
    int i = arrayOfBitwiseWeekDay.length;
    for (int j = 0; j < i; j++)
    {
      BitwiseWeekDay localBitwiseWeekDay = arrayOfBitwiseWeekDay[j];
      if (localBitwiseWeekDay.isIn(paramInt)) {
        localArrayList.add(localBitwiseWeekDay);
      }
    }
    return localArrayList;
  }
  
  public static final int daysToRawSet(List<? extends BitwiseWeekDay> paramList)
  {
    j.e(paramList, "days");
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((BitwiseWeekDay)paramList.next()).or(i)) {}
    return i;
  }
  
  public static final List<BitwiseWeekDay> getAllDays()
  {
    return allDays;
  }
  
  public static final boolean isEveryday(int paramInt)
  {
    boolean bool;
    if (normalize(paramInt) == BitwiseWeekDay.Companion.getEveryday()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean isWeekend(int paramInt)
  {
    boolean bool;
    if (normalize(paramInt) == BitwiseWeekDay.Companion.getWeekend()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean isWorkday(int paramInt)
  {
    boolean bool;
    if (normalize(paramInt) == BitwiseWeekDay.Companion.getWorkday()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final int normalize(int paramInt)
  {
    return paramInt & BitwiseWeekDay.Companion.getEveryday();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\BitwiseWeekDayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */