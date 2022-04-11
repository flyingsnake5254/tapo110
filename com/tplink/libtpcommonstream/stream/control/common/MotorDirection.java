package com.tplink.libtpcommonstream.stream.control.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MotorDirection
{
  public static final String DOWN = "down";
  public static final String LEFT = "left";
  public static final String LEFT_DOWN = "left_down";
  public static final String LEFT_UP = "left_up";
  public static final String RIGHT = "right";
  public static final String RIGHT_DOWN = "right_down";
  public static final String RIGHT_UP = "right_up";
  public static final String UP = "up";
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\common\MotorDirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */