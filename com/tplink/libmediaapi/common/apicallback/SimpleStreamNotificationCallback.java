package com.tplink.libmediaapi.common.apicallback;

import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.MotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;

public class SimpleStreamNotificationCallback
  implements StreamNotificationCallback
{
  public void onReceiveDeviceLockedInfo(String paramString, DeviceLockedInfo paramDeviceLockedInfo) {}
  
  public void onReceiveLensMaskInfo(String paramString, boolean paramBoolean) {}
  
  public void onReceiveMotorStatus(String paramString, MotorStatus paramMotorStatus) {}
  
  public void onReceiveStreamFinish(String paramString1, String paramString2) {}
  
  public void onReceiveStreamStatus(String paramString, StreamStatus paramStreamStatus) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\common\apicallback\SimpleStreamNotificationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */