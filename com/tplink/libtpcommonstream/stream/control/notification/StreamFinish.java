package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class StreamFinish
{
  @c("reason")
  private String reason;
  
  public String getReason()
  {
    return this.reason;
  }
  
  public void setReason(String paramString)
  {
    this.reason = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface StreamFinishReason
  {
    public static final String CHANNEL_INVALID = "channel_invalid";
    public static final String CHANNEL_OFFLINE = "channel_offline";
    public static final String FINISH = "finish";
    public static final String INTERNAL_ERROR = "internal_error";
    public static final String INTERRUPT = "interrupt";
    public static final String MEDIA_ENCRYPT_CHANGED = "media_encrypt_changed";
    public static final String PASSWORD_CHANGED = "password_changed";
    public static final String PERMISSION_DENY = "permission_deny";
    public static final String SHARE_FINISH = "share_finish";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\StreamFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */