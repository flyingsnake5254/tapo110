package com.tplink.iot.musicphonerhythm.enumerate;

import androidx.annotation.Nullable;
import java.util.Arrays;

public enum Sensitivity
{
  private int[] value;
  
  static
  {
    Sensitivity localSensitivity1 = new Sensitivity("VERY_SENSITIVE", 0, new int[] { 20, -12 });
    VERY_SENSITIVE = localSensitivity1;
    Sensitivity localSensitivity2 = new Sensitivity("SENSITIVE", 1, new int[] { 35, -21 });
    SENSITIVE = localSensitivity2;
    Sensitivity localSensitivity3 = new Sensitivity("NORMAL_SENSITIVE", 2, new int[] { 50, -30 });
    NORMAL_SENSITIVE = localSensitivity3;
    Sensitivity localSensitivity4 = new Sensitivity("LITTLE_SENSITIVE", 3, new int[] { 65, -39 });
    LITTLE_SENSITIVE = localSensitivity4;
    Sensitivity localSensitivity5 = new Sensitivity("LESS_SENSITIVE", 4, new int[] { 80, -48 });
    LESS_SENSITIVE = localSensitivity5;
    $VALUES = new Sensitivity[] { localSensitivity1, localSensitivity2, localSensitivity3, localSensitivity4, localSensitivity5 };
  }
  
  private Sensitivity(int[] paramArrayOfInt)
  {
    this.value = paramArrayOfInt;
  }
  
  @Nullable
  public static Sensitivity fromValue(int[] paramArrayOfInt)
  {
    for (Sensitivity localSensitivity : ) {
      if (Arrays.equals(localSensitivity.getValue(), paramArrayOfInt)) {
        return localSensitivity;
      }
    }
    return null;
  }
  
  public int[] getValue()
  {
    return this.value;
  }
  
  public void setValue(int[] paramArrayOfInt)
  {
    this.value = paramArrayOfInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\enumerate\Sensitivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */