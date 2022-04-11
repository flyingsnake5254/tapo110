package com.tplink.libtpcommonstream.stream.control.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VodScale
{
  public static final String SCALE_1 = "1/1";
  public static final String SCALE_MINUS_16 = "1/16";
  public static final String SCALE_MINUS_2 = "1/2";
  public static final String SCALE_MINUS_4 = "1/4";
  public static final String SCALE_MINUS_8 = "1/8";
  public static final String SCALE_PLUS_16 = "16/1";
  public static final String SCALE_PLUS_2 = "2/1";
  public static final String SCALE_PLUS_4 = "4/1";
  public static final String SCALE_PLUS_8 = "8/1";
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\common\VodScale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */