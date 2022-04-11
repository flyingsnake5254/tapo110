package com.google.android.material.bottomnavigation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface LabelVisibilityMode
{
  public static final int LABEL_VISIBILITY_AUTO = -1;
  public static final int LABEL_VISIBILITY_LABELED = 1;
  public static final int LABEL_VISIBILITY_SELECTED = 0;
  public static final int LABEL_VISIBILITY_UNLABELED = 2;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\bottomnavigation\LabelVisibilityMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */