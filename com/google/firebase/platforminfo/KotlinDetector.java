package com.google.firebase.platforminfo;

import androidx.annotation.Nullable;
import kotlin.d;

public final class KotlinDetector
{
  @Nullable
  public static String detectVersion()
  {
    try
    {
      String str = d.c.toString();
      return str;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\platforminfo\KotlinDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */