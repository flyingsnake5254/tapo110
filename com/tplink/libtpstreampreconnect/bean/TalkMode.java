package com.tplink.libtpstreampreconnect.bean;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TalkMode
{
  public static final String AEC = "aec";
  public static final String HALP_DUPLEX = "half_duplex";
  public static final String VAD = "vad";
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreampreconnect\bean\TalkMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */