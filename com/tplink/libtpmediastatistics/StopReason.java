package com.tplink.libtpmediastatistics;

public enum StopReason
{
  private int value;
  
  static
  {
    StopReason localStopReason1 = new StopReason("NAT_FAILURE", 0, -1);
    NAT_FAILURE = localStopReason1;
    StopReason localStopReason2 = new StopReason("USER_CLOSE", 1, 0);
    USER_CLOSE = localStopReason2;
    StopReason localStopReason3 = new StopReason("NETWORK_ERROR", 2, 1);
    NETWORK_ERROR = localStopReason3;
    StopReason localStopReason4 = new StopReason("RELAY_TO_P2P", 3, 2);
    RELAY_TO_P2P = localStopReason4;
    StopReason localStopReason5 = new StopReason("P2P_TO_RELAY", 4, 3);
    P2P_TO_RELAY = localStopReason5;
    StopReason localStopReason6 = new StopReason("P2P_AND_RELAY_TO_LOCAL", 5, 4);
    P2P_AND_RELAY_TO_LOCAL = localStopReason6;
    StopReason localStopReason7 = new StopReason("RELAY_TIME_LIMIT", 6, 5);
    RELAY_TIME_LIMIT = localStopReason7;
    $VALUES = new StopReason[] { localStopReason1, localStopReason2, localStopReason3, localStopReason4, localStopReason5, localStopReason6, localStopReason7 };
  }
  
  private StopReason(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static StopReason fromValue(int paramInt)
  {
    for (StopReason localStopReason : ) {
      if (localStopReason.value == paramInt) {
        return localStopReason;
      }
    }
    return NAT_FAILURE;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\StopReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */