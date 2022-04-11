package com.google.android.material.internal;

import android.os.Build;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ManufacturerUtils
{
  private static final String LGE = "lge";
  private static final String MEIZU = "meizu";
  private static final String SAMSUNG = "samsung";
  
  public static boolean isDateInputKeyboardMissingSeparatorCharacters()
  {
    boolean bool;
    if ((!isLGEDevice()) && (!isSamsungDevice())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isLGEDevice()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("lge");
  }
  
  public static boolean isMeizuDevice()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
  }
  
  public static boolean isSamsungDevice()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("samsung");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ManufacturerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */