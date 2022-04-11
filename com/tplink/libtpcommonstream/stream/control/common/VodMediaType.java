package com.tplink.libtpcommonstream.stream.control.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VodMediaType
{
  public static final int NORMAL_IMAGE = 2;
  public static final int PUSH_IMAGE = 1;
  public static final int THUMBNAIL = 3;
  public static final int VIDEO = 0;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\common\VodMediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */