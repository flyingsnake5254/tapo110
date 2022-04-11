package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.crashlytics.internal.Logger;

class BatteryState
{
  static final int VELOCITY_CHARGING = 2;
  static final int VELOCITY_FULL = 3;
  static final int VELOCITY_UNPLUGGED = 1;
  private final Float level;
  private final boolean powerConnected;
  
  private BatteryState(Float paramFloat, boolean paramBoolean)
  {
    this.powerConnected = paramBoolean;
    this.level = paramFloat;
  }
  
  public static BatteryState get(Context paramContext)
  {
    Object localObject1 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = bool2;
    try
    {
      Object localObject2 = new android/content/IntentFilter;
      bool3 = bool2;
      ((IntentFilter)localObject2).<init>("android.intent.action.BATTERY_CHANGED");
      bool3 = bool2;
      localObject2 = paramContext.registerReceiver(null, (IntentFilter)localObject2);
      paramContext = (Context)localObject1;
      bool3 = bool1;
      if (localObject2 != null)
      {
        bool3 = bool2;
        bool2 = isPowerConnected((Intent)localObject2);
        bool3 = bool2;
        paramContext = getLevel((Intent)localObject2);
        bool3 = bool2;
      }
    }
    catch (IllegalStateException paramContext)
    {
      Logger.getLogger().e("An error occurred getting battery state.", paramContext);
      paramContext = (Context)localObject1;
    }
    return new BatteryState(paramContext, bool3);
  }
  
  private static Float getLevel(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", -1);
    int j = paramIntent.getIntExtra("scale", -1);
    if ((i != -1) && (j != -1)) {
      return Float.valueOf(i / j);
    }
    return null;
  }
  
  private static boolean isPowerConnected(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("status", -1);
    boolean bool = false;
    if (i == -1) {
      return false;
    }
    if ((i == 2) || (i == 5)) {
      bool = true;
    }
    return bool;
  }
  
  public Float getBatteryLevel()
  {
    return this.level;
  }
  
  public int getBatteryVelocity()
  {
    if (this.powerConnected)
    {
      Float localFloat = this.level;
      if (localFloat != null)
      {
        if (localFloat.floatValue() < 0.99D) {
          return 2;
        }
        return 3;
      }
    }
    return 1;
  }
  
  boolean isPowerConnected()
  {
    return this.powerConnected;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\BatteryState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */