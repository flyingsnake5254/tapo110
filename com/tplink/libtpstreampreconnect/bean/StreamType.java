package com.tplink.libtpstreampreconnect.bean;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface StreamType
{
  public static final int DUAL_STREAM_AUDIO = 2;
  public static final int DUAL_STREAM_VIDEO = 3;
  public static final int MIXED_STREAM = 1;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreampreconnect\bean\StreamType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */