package com.tplink.cloud.define;

public enum EnumAccountStatus
{
  private String name;
  private int value;
  
  static
  {
    EnumAccountStatus localEnumAccountStatus1 = new EnumAccountStatus("ACCOUNT_STATUS_UNREGISTERED", 0, 0, "UNREGISTERED");
    ACCOUNT_STATUS_UNREGISTERED = localEnumAccountStatus1;
    EnumAccountStatus localEnumAccountStatus2 = new EnumAccountStatus("ACCOUNT_STATUS_NORMAL", 1, 1, "NORMAL");
    ACCOUNT_STATUS_NORMAL = localEnumAccountStatus2;
    EnumAccountStatus localEnumAccountStatus3 = new EnumAccountStatus("ACCOUNT_STATUS_LOCKED", 2, 2, "LOCKED");
    ACCOUNT_STATUS_LOCKED = localEnumAccountStatus3;
    EnumAccountStatus localEnumAccountStatus4 = new EnumAccountStatus("ACCOUNT_STATUS_UNACTIVATED", 3, 3, "UNACTIVATED");
    ACCOUNT_STATUS_UNACTIVATED = localEnumAccountStatus4;
    $VALUES = new EnumAccountStatus[] { localEnumAccountStatus1, localEnumAccountStatus2, localEnumAccountStatus3, localEnumAccountStatus4 };
  }
  
  private EnumAccountStatus(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.name = paramString;
  }
  
  public static EnumAccountStatus getStatusByInt(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return ACCOUNT_STATUS_UNACTIVATED;
        }
        return ACCOUNT_STATUS_LOCKED;
      }
      return ACCOUNT_STATUS_NORMAL;
    }
    return ACCOUNT_STATUS_UNREGISTERED;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\define\EnumAccountStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */