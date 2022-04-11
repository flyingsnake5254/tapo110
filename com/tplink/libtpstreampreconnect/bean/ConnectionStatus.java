package com.tplink.libtpstreampreconnect.bean;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ConnectionStatus
{
  public static final int CONNECTION_STATUS_FAILURE = 2;
  public static final int CONNECTION_STATUS_START = 0;
  public static final int CONNECTION_STATUS_SUCCESS = 1;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreampreconnect\bean\ConnectionStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */