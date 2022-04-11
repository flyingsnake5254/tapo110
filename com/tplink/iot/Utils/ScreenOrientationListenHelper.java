package com.tplink.iot.Utils;

import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.OrientationEventListener;

public class ScreenOrientationListenHelper
{
  private OrientationEventListener a;
  private b b;
  private Orientation c = Orientation.PORTRAIT;
  private Context d;
  
  public ScreenOrientationListenHelper(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool = false;
    int i;
    try
    {
      i = Settings.System.getInt(paramContext.getContentResolver(), "accelerometer_rotation");
    }
    catch (Settings.SettingNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      i = 0;
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public void d()
  {
    h();
    this.a = null;
  }
  
  public void f(b paramb)
  {
    this.b = paramb;
  }
  
  public void g()
  {
    if (this.a == null) {
      this.a = new a(this.d, 3);
    }
    this.a.enable();
  }
  
  public void h()
  {
    OrientationEventListener localOrientationEventListener = this.a;
    if (localOrientationEventListener != null) {
      localOrientationEventListener.disable();
    }
  }
  
  public static enum Orientation
  {
    static
    {
      Orientation localOrientation1 = new Orientation("PORTRAIT", 0);
      PORTRAIT = localOrientation1;
      Orientation localOrientation2 = new Orientation("LANDSCAPE", 1);
      LANDSCAPE = localOrientation2;
      Orientation localOrientation3 = new Orientation("REVERSE_LANDSCAPE", 2);
      REVERSE_LANDSCAPE = localOrientation3;
      $VALUES = new Orientation[] { localOrientation1, localOrientation2, localOrientation3 };
    }
  }
  
  class a
    extends OrientationEventListener
  {
    a(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public void onOrientationChanged(int paramInt)
    {
      if (ScreenOrientationListenHelper.a(ScreenOrientationListenHelper.this) == null) {
        return;
      }
      boolean bool1 = true;
      boolean bool2 = true;
      boolean bool3 = true;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramInt < 100) && (paramInt > 80))
      {
        localObject1 = ScreenOrientationListenHelper.a(ScreenOrientationListenHelper.this);
        localObject2 = ScreenOrientationListenHelper.b(ScreenOrientationListenHelper.this);
        localObject3 = ScreenOrientationListenHelper.Orientation.REVERSE_LANDSCAPE;
        if (localObject2 == localObject3) {
          bool3 = false;
        }
        ((ScreenOrientationListenHelper.b)localObject1).a(bool3, (ScreenOrientationListenHelper.Orientation)localObject3);
        ScreenOrientationListenHelper.c(ScreenOrientationListenHelper.this, (ScreenOrientationListenHelper.Orientation)localObject3);
      }
      else if ((paramInt < 280) && (paramInt > 260))
      {
        localObject2 = ScreenOrientationListenHelper.a(ScreenOrientationListenHelper.this);
        localObject1 = ScreenOrientationListenHelper.b(ScreenOrientationListenHelper.this);
        localObject3 = ScreenOrientationListenHelper.Orientation.LANDSCAPE;
        if (localObject1 != localObject3) {
          bool3 = bool1;
        } else {
          bool3 = false;
        }
        ((ScreenOrientationListenHelper.b)localObject2).a(bool3, (ScreenOrientationListenHelper.Orientation)localObject3);
        ScreenOrientationListenHelper.c(ScreenOrientationListenHelper.this, (ScreenOrientationListenHelper.Orientation)localObject3);
      }
      else if (((paramInt > 0) && (paramInt < 10)) || (paramInt > 350))
      {
        localObject3 = ScreenOrientationListenHelper.a(ScreenOrientationListenHelper.this);
        localObject2 = ScreenOrientationListenHelper.b(ScreenOrientationListenHelper.this);
        localObject1 = ScreenOrientationListenHelper.Orientation.PORTRAIT;
        if (localObject2 != localObject1) {
          bool3 = bool2;
        } else {
          bool3 = false;
        }
        ((ScreenOrientationListenHelper.b)localObject3).a(bool3, (ScreenOrientationListenHelper.Orientation)localObject1);
        ScreenOrientationListenHelper.c(ScreenOrientationListenHelper.this, (ScreenOrientationListenHelper.Orientation)localObject1);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, ScreenOrientationListenHelper.Orientation paramOrientation);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\ScreenOrientationListenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */