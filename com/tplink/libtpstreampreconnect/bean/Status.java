package com.tplink.libtpstreampreconnect.bean;

public enum Status
{
  static
  {
    Status localStatus1 = new Status("success", 0);
    success = localStatus1;
    Status localStatus2 = new Status("unknown", 1);
    unknown = localStatus2;
    Status localStatus3 = new Status("failed", 2);
    failed = localStatus3;
    $VALUES = new Status[] { localStatus1, localStatus2, localStatus3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreampreconnect\bean\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */