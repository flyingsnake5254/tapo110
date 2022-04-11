package com.tplink.libtpcommonstream.stream.control.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface StreamControlType
{
  public static final String NOTIFICATION = "notification";
  public static final String REQUEST = "request";
  public static final String RESPONSE = "response";
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\common\StreamControlType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */