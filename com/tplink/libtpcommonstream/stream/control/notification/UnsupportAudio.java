package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class UnsupportAudio
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
  public static @interface UnsupportReason
  {
    public static final String UNSUPPORT_CODEC = "unsupport_codec";
    public static final String UNSUPPORT_PARMAS = "unsupport_params";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\UnsupportAudio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */