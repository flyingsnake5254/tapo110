package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class MsgPushInfo
{
  @c("notification_enabled")
  private final String notificationEnabled;
  @c("rich_notification_enabled")
  private final String richNotificationEnabled;
  
  public MsgPushInfo(String paramString1, String paramString2)
  {
    this.notificationEnabled = paramString1;
    this.richNotificationEnabled = paramString2;
  }
  
  public final String component1()
  {
    return this.notificationEnabled;
  }
  
  public final String component2()
  {
    return this.richNotificationEnabled;
  }
  
  public final MsgPushInfo copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "notificationEnabled");
    j.e(paramString2, "richNotificationEnabled");
    return new MsgPushInfo(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MsgPushInfo))
      {
        paramObject = (MsgPushInfo)paramObject;
        if ((j.a(this.notificationEnabled, ((MsgPushInfo)paramObject).notificationEnabled)) && (j.a(this.richNotificationEnabled, ((MsgPushInfo)paramObject).richNotificationEnabled))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getNotificationEnabled()
  {
    return this.notificationEnabled;
  }
  
  public final String getRichNotificationEnabled()
  {
    return this.richNotificationEnabled;
  }
  
  public int hashCode()
  {
    String str = this.notificationEnabled;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.richNotificationEnabled;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgPushInfo(notificationEnabled=");
    localStringBuilder.append(this.notificationEnabled);
    localStringBuilder.append(", richNotificationEnabled=");
    localStringBuilder.append(this.richNotificationEnabled);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MsgPushInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */