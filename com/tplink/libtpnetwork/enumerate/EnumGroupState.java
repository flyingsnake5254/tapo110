package com.tplink.libtpnetwork.enumerate;

public enum EnumGroupState
{
  static
  {
    EnumGroupState localEnumGroupState1 = new EnumGroupState("LOADING", 0);
    LOADING = localEnumGroupState1;
    EnumGroupState localEnumGroupState2 = new EnumGroupState("ONLINE", 1);
    ONLINE = localEnumGroupState2;
    EnumGroupState localEnumGroupState3 = new EnumGroupState("PART_OFFLINE", 2);
    PART_OFFLINE = localEnumGroupState3;
    EnumGroupState localEnumGroupState4 = new EnumGroupState("OFFLINE", 3);
    OFFLINE = localEnumGroupState4;
    EnumGroupState localEnumGroupState5 = new EnumGroupState("EMPTY", 4);
    EMPTY = localEnumGroupState5;
    $VALUES = new EnumGroupState[] { localEnumGroupState1, localEnumGroupState2, localEnumGroupState3, localEnumGroupState4, localEnumGroupState5 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumGroupState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */