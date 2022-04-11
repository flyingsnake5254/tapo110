package com.tplink.libtpnetwork.libwss.enumerate;

public enum WssAccountBindState
{
  static
  {
    WssAccountBindState localWssAccountBindState1 = new WssAccountBindState("BIND", 0);
    BIND = localWssAccountBindState1;
    WssAccountBindState localWssAccountBindState2 = new WssAccountBindState("UNBIND", 1);
    UNBIND = localWssAccountBindState2;
    WssAccountBindState localWssAccountBindState3 = new WssAccountBindState("UNKNOWN", 2);
    UNKNOWN = localWssAccountBindState3;
    $VALUES = new WssAccountBindState[] { localWssAccountBindState1, localWssAccountBindState2, localWssAccountBindState3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\enumerate\WssAccountBindState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */