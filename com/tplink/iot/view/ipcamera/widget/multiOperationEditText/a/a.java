package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

public class a
{
  public static final Interpolator a = new LinearInterpolator();
  public static final Interpolator b = new FastOutSlowInInterpolator();
  public static final Interpolator c = new FastOutLinearInInterpolator();
  public static final Interpolator d = new LinearOutSlowInInterpolator();
  public static final Interpolator e = new DecelerateInterpolator();
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\multiOperationEditText\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */