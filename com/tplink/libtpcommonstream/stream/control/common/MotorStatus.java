package com.tplink.libtpcommonstream.stream.control.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MotorStatus
{
  public static final String IDLE = "idle";
  public static final String MOVING = "moving";
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\common\MotorStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */