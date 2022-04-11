package com.tplink.libtpnetwork.TDPNetwork;

public enum NetworkStatusType
{
  private final String value;
  
  static
  {
    NetworkStatusType localNetworkStatusType1 = new NetworkStatusType("AVAILABLE", 0, "AVAILABLE");
    AVAILABLE = localNetworkStatusType1;
    NetworkStatusType localNetworkStatusType2 = new NetworkStatusType("LOSING", 1, "LOSING");
    LOSING = localNetworkStatusType2;
    NetworkStatusType localNetworkStatusType3 = new NetworkStatusType("LOST", 2, "LOST");
    LOST = localNetworkStatusType3;
    $VALUES = new NetworkStatusType[] { localNetworkStatusType1, localNetworkStatusType2, localNetworkStatusType3 };
  }
  
  private NetworkStatusType(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TDPNetwork\NetworkStatusType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */