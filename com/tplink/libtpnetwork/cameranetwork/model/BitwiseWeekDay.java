package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public enum BitwiseWeekDay
{
  public static final Companion Companion;
  private static final int everyday;
  private static final int weekend;
  private static final int workday;
  private final int raw;
  
  static
  {
    BitwiseWeekDay localBitwiseWeekDay1 = new BitwiseWeekDay("SUN", 0, 1);
    SUN = localBitwiseWeekDay1;
    BitwiseWeekDay localBitwiseWeekDay2 = new BitwiseWeekDay("MON", 1, 2);
    MON = localBitwiseWeekDay2;
    BitwiseWeekDay localBitwiseWeekDay3 = new BitwiseWeekDay("TUE", 2, 4);
    TUE = localBitwiseWeekDay3;
    BitwiseWeekDay localBitwiseWeekDay4 = new BitwiseWeekDay("WED", 3, 8);
    WED = localBitwiseWeekDay4;
    BitwiseWeekDay localBitwiseWeekDay5 = new BitwiseWeekDay("THU", 4, 16);
    THU = localBitwiseWeekDay5;
    BitwiseWeekDay localBitwiseWeekDay6 = new BitwiseWeekDay("FRI", 5, 32);
    FRI = localBitwiseWeekDay6;
    BitwiseWeekDay localBitwiseWeekDay7 = new BitwiseWeekDay("SAT", 6, 64);
    SAT = localBitwiseWeekDay7;
    $VALUES = new BitwiseWeekDay[] { localBitwiseWeekDay1, localBitwiseWeekDay2, localBitwiseWeekDay3, localBitwiseWeekDay4, localBitwiseWeekDay5, localBitwiseWeekDay6, localBitwiseWeekDay7 };
    Companion localCompanion = new Companion(null);
    Companion = localCompanion;
    int i = localBitwiseWeekDay1.or(localBitwiseWeekDay7);
    weekend = i;
    int j = Companion.access$or(localCompanion, Companion.access$or(localCompanion, Companion.access$or(localCompanion, localBitwiseWeekDay2.or(localBitwiseWeekDay3), localBitwiseWeekDay4), localBitwiseWeekDay5), localBitwiseWeekDay6);
    workday = j;
    everyday = j | i;
  }
  
  private BitwiseWeekDay(int paramInt)
  {
    this.raw = paramInt;
  }
  
  public static final int getEveryday()
  {
    return everyday;
  }
  
  public static final int getWeekend()
  {
    return weekend;
  }
  
  public static final int getWorkday()
  {
    return workday;
  }
  
  public final int and(int paramInt)
  {
    return paramInt & this.raw;
  }
  
  public final int and(BitwiseWeekDay paramBitwiseWeekDay)
  {
    j.e(paramBitwiseWeekDay, "day");
    int i = this.raw;
    return paramBitwiseWeekDay.raw & i;
  }
  
  public final boolean isIn(int paramInt)
  {
    boolean bool;
    if (and(paramInt) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final int or(int paramInt)
  {
    return paramInt | this.raw;
  }
  
  public final int or(BitwiseWeekDay paramBitwiseWeekDay)
  {
    j.e(paramBitwiseWeekDay, "day");
    int i = this.raw;
    return paramBitwiseWeekDay.raw | i;
  }
  
  public static final class Companion
  {
    private final int or(int paramInt, BitwiseWeekDay paramBitwiseWeekDay)
    {
      return paramInt | BitwiseWeekDay.access$getRaw$p(paramBitwiseWeekDay);
    }
    
    public final int getEveryday()
    {
      return BitwiseWeekDay.access$getEveryday$cp();
    }
    
    public final int getWeekend()
    {
      return BitwiseWeekDay.access$getWeekend$cp();
    }
    
    public final int getWorkday()
    {
      return BitwiseWeekDay.access$getWorkday$cp();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\BitwiseWeekDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */