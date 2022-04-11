package com.tplink.libtpnetwork.cameranetwork.business.model;

public enum DayOfWeek
{
  private static final DayOfWeek[] ENUMS = values();
  
  static
  {
    DayOfWeek localDayOfWeek1 = new DayOfWeek("MONDAY", 0);
    MONDAY = localDayOfWeek1;
    DayOfWeek localDayOfWeek2 = new DayOfWeek("TUESDAY", 1);
    TUESDAY = localDayOfWeek2;
    DayOfWeek localDayOfWeek3 = new DayOfWeek("WEDNESDAY", 2);
    WEDNESDAY = localDayOfWeek3;
    DayOfWeek localDayOfWeek4 = new DayOfWeek("THURSDAY", 3);
    THURSDAY = localDayOfWeek4;
    DayOfWeek localDayOfWeek5 = new DayOfWeek("FRIDAY", 4);
    FRIDAY = localDayOfWeek5;
    DayOfWeek localDayOfWeek6 = new DayOfWeek("SATURDAY", 5);
    SATURDAY = localDayOfWeek6;
    DayOfWeek localDayOfWeek7 = new DayOfWeek("SUNDAY", 6);
    SUNDAY = localDayOfWeek7;
    $VALUES = new DayOfWeek[] { localDayOfWeek1, localDayOfWeek2, localDayOfWeek3, localDayOfWeek4, localDayOfWeek5, localDayOfWeek6, localDayOfWeek7 };
  }
  
  public static DayOfWeek of(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 7)) {
      return ENUMS[(paramInt - 1)];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid value for DayOfWeek: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\DayOfWeek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */