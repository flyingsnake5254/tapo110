package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class zai
  extends Drawable.ConstantState
{
  int mChangingConfigurations;
  int zanw;
  
  zai(zai paramzai)
  {
    if (paramzai != null)
    {
      this.mChangingConfigurations = paramzai.mChangingConfigurations;
      this.zanw = paramzai.zanw;
    }
  }
  
  public final int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public final Drawable newDrawable()
  {
    return new zae(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\base\zai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */