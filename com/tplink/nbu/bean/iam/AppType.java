package com.tplink.nbu.bean.iam;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AppType
{
  public static final String DECO = "deco";
  public static final String TAPO = "tapo";
  public static final String TETHER = "tether";
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\bean\iam\AppType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */