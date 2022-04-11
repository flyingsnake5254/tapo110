package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class zae
  extends Drawable
  implements Drawable.Callback
{
  private int mAlpha = 0;
  private int mFrom;
  private boolean zamz = true;
  private int zanh = 0;
  private long zani;
  private int zanj;
  private int zank = 255;
  private int zanl;
  private boolean zanm;
  private zai zann;
  private Drawable zano;
  private Drawable zanp;
  private boolean zanq;
  private boolean zanr;
  private boolean zans;
  private int zant;
  
  public zae(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = zag.zacg();
    }
    this.zano = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.zann;
    int i = paramDrawable1.zanw;
    paramDrawable1.zanw = (((Drawable)localObject).getChangingConfigurations() | i);
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = zag.zacg();
    }
    this.zanp = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.zann;
    i = paramDrawable2.zanw;
    paramDrawable2.zanw = (paramDrawable1.getChangingConfigurations() | i);
  }
  
  zae(zai paramzai)
  {
    this.zann = new zai(paramzai);
  }
  
  private final boolean canConstantState()
  {
    if (!this.zanq)
    {
      boolean bool;
      if ((this.zano.getConstantState() != null) && (this.zanp.getConstantState() != null)) {
        bool = true;
      } else {
        bool = false;
      }
      this.zanr = bool;
      this.zanq = true;
    }
    return this.zanr;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int i = this.zanh;
    int j = 0;
    int k = 1;
    if (i != 1)
    {
      if ((i == 2) && (this.zani >= 0L))
      {
        float f = (float)(SystemClock.uptimeMillis() - this.zani) / this.zanl;
        if (f >= 1.0F) {
          j = k;
        } else {
          j = 0;
        }
        if (j != 0) {
          this.zanh = 0;
        }
        f = Math.min(f, 1.0F);
        this.mAlpha = ((int)(this.zanj * f + 0.0F));
      }
      else
      {
        j = 1;
      }
    }
    else
    {
      this.zani = SystemClock.uptimeMillis();
      this.zanh = 2;
    }
    k = this.mAlpha;
    boolean bool = this.zamz;
    Drawable localDrawable1 = this.zano;
    Drawable localDrawable2 = this.zanp;
    if (j != 0)
    {
      if ((!bool) || (k == 0)) {
        localDrawable1.draw(paramCanvas);
      }
      j = this.zank;
      if (k == j)
      {
        localDrawable2.setAlpha(j);
        localDrawable2.draw(paramCanvas);
      }
      return;
    }
    if (bool) {
      localDrawable1.setAlpha(this.zank - k);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.zank);
    }
    if (k > 0)
    {
      localDrawable2.setAlpha(k);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.zank);
    }
    invalidateSelf();
  }
  
  public final int getChangingConfigurations()
  {
    int i = super.getChangingConfigurations();
    zai localzai = this.zann;
    return i | localzai.mChangingConfigurations | localzai.zanw;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.zann.mChangingConfigurations = getChangingConfigurations();
      return this.zann;
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    return Math.max(this.zano.getIntrinsicHeight(), this.zanp.getIntrinsicHeight());
  }
  
  public final int getIntrinsicWidth()
  {
    return Math.max(this.zano.getIntrinsicWidth(), this.zanp.getIntrinsicWidth());
  }
  
  public final int getOpacity()
  {
    if (!this.zans)
    {
      this.zant = Drawable.resolveOpacity(this.zano.getOpacity(), this.zanp.getOpacity());
      this.zans = true;
    }
    return this.zant;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public final Drawable mutate()
  {
    if ((!this.zanm) && (super.mutate() == this)) {
      if (canConstantState())
      {
        this.zano.mutate();
        this.zanp.mutate();
        this.zanm = true;
      }
      else
      {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    this.zano.setBounds(paramRect);
    this.zanp.setBounds(paramRect);
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.mAlpha == this.zank) {
      this.mAlpha = paramInt;
    }
    this.zank = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.zano.setColorFilter(paramColorFilter);
    this.zanp.setColorFilter(paramColorFilter);
  }
  
  public final void startTransition(int paramInt)
  {
    this.mFrom = 0;
    this.zanj = this.zank;
    this.mAlpha = 0;
    this.zanl = 250;
    this.zanh = 1;
    invalidateSelf();
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
  
  public final Drawable zacf()
  {
    return this.zanp;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\base\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */