package com.tplink.libtpnetwork.enumerate;

public enum EnumHomeState
{
  static
  {
    EnumHomeState localEnumHomeState1 = new EnumHomeState("NO_INTERNET", 0);
    NO_INTERNET = localEnumHomeState1;
    EnumHomeState localEnumHomeState2 = new EnumHomeState("LOCAL_OFFLINE", 1);
    LOCAL_OFFLINE = localEnumHomeState2;
    EnumHomeState localEnumHomeState3 = new EnumHomeState("ONLINE", 2);
    ONLINE = localEnumHomeState3;
    $VALUES = new EnumHomeState[] { localEnumHomeState1, localEnumHomeState2, localEnumHomeState3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumHomeState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */