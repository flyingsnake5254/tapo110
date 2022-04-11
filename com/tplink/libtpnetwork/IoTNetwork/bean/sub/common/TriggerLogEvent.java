package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TriggerLogEvent
{
  public static final String CLOSE = "close";
  public static final Companion Companion = Companion.$$INSTANCE;
  public static final String DOUBLE_CLICK = "doubleClick";
  public static final String KEEP_OPEN = "keepOpen";
  public static final String MOTION = "motion";
  public static final String OPEN = "open";
  public static final String ROTATION = "rotation";
  public static final String SINGLE_CLICK = "singleClick";
  
  public static final class Companion
  {
    public static final String CLOSE = "close";
    public static final String DOUBLE_CLICK = "doubleClick";
    public static final String KEEP_OPEN = "keepOpen";
    public static final String MOTION = "motion";
    public static final String OPEN = "open";
    public static final String ROTATION = "rotation";
    public static final String SINGLE_CLICK = "singleClick";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\common\TriggerLogEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */