package com.tplink.iot.musicphonerhythm.enumerate;

import androidx.annotation.Nullable;
import java.util.Arrays;

public enum SpeedGap
{
  private int[] value;
  
  static
  {
    SpeedGap localSpeedGap1 = new SpeedGap("VERY_SLOW", 0, new int[] { 125, 500 });
    VERY_SLOW = localSpeedGap1;
    SpeedGap localSpeedGap2 = new SpeedGap("SLOW", 1, new int[] { 187, 750 });
    SLOW = localSpeedGap2;
    SpeedGap localSpeedGap3 = new SpeedGap("NORMAL_SPEED", 2, new int[] { 250, 1000 });
    NORMAL_SPEED = localSpeedGap3;
    SpeedGap localSpeedGap4 = new SpeedGap("FAST", 3, new int[] { 375, 1500 });
    FAST = localSpeedGap4;
    SpeedGap localSpeedGap5 = new SpeedGap("VERY_FAST", 4, new int[] { 500, 2000 });
    VERY_FAST = localSpeedGap5;
    $VALUES = new SpeedGap[] { localSpeedGap1, localSpeedGap2, localSpeedGap3, localSpeedGap4, localSpeedGap5 };
  }
  
  private SpeedGap(int[] paramArrayOfInt)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\enumerate\SpeedGap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */