package com.tplink.libtpappcommonmedia.bean.stream;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MediaType
{
  public static final int DOUBLE_TALK = 2;
  public static final int LIVE = 0;
  public static final int PICTURE = 3;
  public static final int VOD = 1;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpappcommonmedia\bean\stream\MediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */