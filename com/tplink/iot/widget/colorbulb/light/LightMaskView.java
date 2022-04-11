package com.tplink.iot.widget.colorbulb.light;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

public class LightMaskView
  extends FrameLayout
{
  private ImageView c;
  private Drawable d;
  private Path f;
  private boolean p0;
  private int q = 50;
  private boolean x;
  private float y;
  private float z;
  
  public LightMaskView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LightMaskView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LightMaskView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new ImageView(paramContext);
    this.c = paramAttributeSet;
    addView(paramAttributeSet, new FrameLayout.LayoutParams(-2, -2));
    if (Build.VERSION.SDK_INT < 21) {
      paramContext = getResources().getDrawable(2131689588);
    } else {
      paramContext = getResources().getDrawable(2131689588, paramContext.getTheme());
    }
    paramContext = DrawableCompat.wrap(paramContext);
    this.d = paramContext;
    DrawableCompat.setTint(paramContext, -1);
    this.c.setImageDrawable(this.d);
    this.f = new Path();
  }
  
  private void b(Canvas paramCanvas, float paramFloat)
  {
    int i = (int)((100.0F - paramFloat) * 1.0D * getHeight() / 100.0D);
    this.f.reset();
    this.f.addRect(0.0F, i, getWidth(), getHeight(), Path.Direction.CCW);
    paramCanvas.clipPath(this.f);
  }
  
  public void a(float paramFloat)
  {
    if (this.x) {
      this.z = (this.y * paramFloat);
    } else {
      this.z = (this.y * (1.0F - paramFloat));
    }
    invalidate();
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    if (paramInt < 1) {
      return;
    }
    this.q = paramInt;
    this.x = paramBoolean;
    invalidate();
  }
  
  public void d(boolean paramBoolean, int paramInt)
  {
    float f1;
    if (paramBoolean) {
      f1 = paramInt;
    } else {
      f1 = this.q;
    }
    this.y = f1;
    this.x = paramBoolean;
    this.q = paramInt;
    invalidate();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.p0)
    {
      b(paramCanvas, this.z);
    }
    else
    {
      float f1;
      if (this.x)
      {
        int i = this.q;
        int j = i;
        if (i < 3) {
          j = 3;
        }
        f1 = j;
      }
      else
      {
        f1 = 0.0F;
      }
      b(paramCanvas, f1);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public int getBrightness()
  {
    return this.q;
  }
  
  public void setBrightness(int paramInt)
  {
    if (paramInt < 1) {
      return;
    }
    this.q = paramInt;
    invalidate();
  }
  
  public void setRunning(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
  }
  
  public void setTintColor(int paramInt)
  {
    DrawableCompat.setTint(this.d, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\light\LightMaskView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */