package com.tplink.libtpcommonstream.stream.control.notification;

public abstract interface StreamNotificationCallback
{
  public abstract void onReceiveDeviceLockedInfo(String paramString, DeviceLockedInfo paramDeviceLockedInfo);
  
  public abstract void onReceiveLensMaskInfo(String paramString, boolean paramBoolean);
  
  public abstract void onReceiveMotorStatus(String paramString, MotorStatus paramMotorStatus);
  
  public abstract void onReceiveStreamFinish(String paramString1, String paramString2);
  
  public abstract void onReceiveStreamStatus(String paramString, StreamStatus paramStreamStatus);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\StreamNotificationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */