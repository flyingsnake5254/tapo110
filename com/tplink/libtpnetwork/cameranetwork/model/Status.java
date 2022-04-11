package com.tplink.libtpnetwork.cameranetwork.model;

public enum Status
{
  static
  {
    Status localStatus1 = new Status("success", 0, "success");
    success = localStatus1;
    Status localStatus2 = new Status("unknown", 1, "unknown");
    unknown = localStatus2;
    Status localStatus3 = new Status("failed", 2, "failed");
    failed = localStatus3;
    $VALUES = new Status[] { localStatus1, localStatus2, localStatus3 };
  }
  
  private Status(String paramString) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */