package com.tplink.libtpcommonstream.stream.control.notification;

public enum MotorStatus
{
  private String value;
  
  static
  {
    MotorStatus localMotorStatus1 = new MotorStatus("IDLE", 0, "idle");
    IDLE = localMotorStatus1;
    MotorStatus localMotorStatus2 = new MotorStatus("MOVING", 1, "moving");
    MOVING = localMotorStatus2;
    $VALUES = new MotorStatus[] { localMotorStatus1, localMotorStatus2 };
  }
  
  private MotorStatus(String paramString)
  {
    this.value = paramString;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\MotorStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */