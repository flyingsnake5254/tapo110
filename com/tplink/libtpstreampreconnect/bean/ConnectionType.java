package com.tplink.libtpstreampreconnect.bean;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ConnectionType
{
  public static final int CONNECTION_INVALID = -1;
  public static final int CONNECTION_LOCAL = 256;
  public static final int CONNECTION_P2P = 16;
  public static final int CONNECTION_RELAY = 0;
  public static final int CONNECTION_UPNP = 17;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreampreconnect\bean\ConnectionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */