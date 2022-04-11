package com.tplink.libtpnetwork.enumerate;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public enum EnumTRVState
{
  public static final a Companion = new a(null);
  public static final String TRV_DEVICE_ERROR = "device_error";
  public static final String TRV_FROST_PROTECTION = "frost_protection";
  public static final String TRV_HEATING = "heating";
  public static final String TRV_LOW_BATTERY = "low_battery";
  public static final String TRV_PROGRESS_CALIBRATION = "progress_calibration";
  public static final String TRV_REMOVING_SCALE = "removing_scale";
  public static final String TRV_SHUTDOWN = "shutdown";
  public static final String TRV_WINDOW_OPEN = "window_open";
  private final String value;
  
  static
  {
    EnumTRVState localEnumTRVState1 = new EnumTRVState("HEATING", 0, "heating");
    HEATING = localEnumTRVState1;
    EnumTRVState localEnumTRVState2 = new EnumTRVState("FROST_PROTECTION", 1, "frost_protection");
    FROST_PROTECTION = localEnumTRVState2;
    EnumTRVState localEnumTRVState3 = new EnumTRVState("PROGRESS_CALIBRATION", 2, "progress_calibration");
    PROGRESS_CALIBRATION = localEnumTRVState3;
    EnumTRVState localEnumTRVState4 = new EnumTRVState("REMOVING_SCALE", 3, "removing_scale");
    REMOVING_SCALE = localEnumTRVState4;
    EnumTRVState localEnumTRVState5 = new EnumTRVState("SHUTDOWN", 4, "shutdown");
    SHUTDOWN = localEnumTRVState5;
    EnumTRVState localEnumTRVState6 = new EnumTRVState("DEVICE_ERROR", 5, "device_error");
    DEVICE_ERROR = localEnumTRVState6;
    EnumTRVState localEnumTRVState7 = new EnumTRVState("WINDOW_OPEN", 6, "window_open");
    WINDOW_OPEN = localEnumTRVState7;
    EnumTRVState localEnumTRVState8 = new EnumTRVState("LOW_BATTERY", 7, "low_battery");
    LOW_BATTERY = localEnumTRVState8;
    $VALUES = new EnumTRVState[] { localEnumTRVState1, localEnumTRVState2, localEnumTRVState3, localEnumTRVState4, localEnumTRVState5, localEnumTRVState6, localEnumTRVState7, localEnumTRVState8 };
  }
  
  private EnumTRVState(String paramString)
  {
    this.value = paramString;
  }
  
  public static final EnumTRVState fromString(String paramString)
  {
    return Companion.a(paramString);
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public static final class a
  {
    public final EnumTRVState a(String paramString)
    {
      Object localObject1 = null;
      Object localObject2;
      if (paramString == null)
      {
        localObject2 = localObject1;
      }
      else
      {
        EnumTRVState[] arrayOfEnumTRVState = EnumTRVState.values();
        int i = arrayOfEnumTRVState.length;
        for (int j = 0;; j++)
        {
          localObject2 = localObject1;
          if (j >= i) {
            break;
          }
          localObject2 = arrayOfEnumTRVState[j];
          if (j.a(((EnumTRVState)localObject2).getValue(), paramString)) {
            break;
          }
        }
      }
      return (EnumTRVState)localObject2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumTRVState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */