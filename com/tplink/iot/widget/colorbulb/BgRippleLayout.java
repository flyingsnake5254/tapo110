package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BgRippleLayout
  extends FrameLayout
{
  private Path c;
  private float d;
  private boolean f;
  private boolean q;
  
  public BgRippleLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BgRippleLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BgRippleLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.c = new Path();
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (this.q)
    {
      int i = getWidth();
      int j = getHeight();
      int k = paramCanvas.save();
      this.c.reset();
      Path localPath;
      float f2;
      float f3;
      if (this.f)
      {
        localPath = this.c;
        float f1 = j;
        localPath.lineTo(0.0F, f1);
        this.c.lineTo(0.0F, this.d);
        localPath = this.c;
        f2 = this.d;
        f3 = i / 2;
        float f4 = i;
        localPath.cubicTo(0.0F, f2, f3, f2 - 150.0F, f4, f2);
        this.c.lineTo(f4, f1);
        this.c.lineTo(0.0F, f1);
      }
      else
      {
        this.c.lineTo(0.0F, 0.0F);
        localPath = this.c;
        f3 = i;
        localPath.lineTo(f3, 0.0F);
        this.c.lineTo(f3, this.d);
        localPath = this.c;
        f2 = this.d;
        localPath.cubicTo(f3, f2, i / 2, f2 - 150.0F, 0.0F, f2);
        this.c.lineTo(0.0F, 0.0F);
      }
      paramCanvas.clipPath(this.c);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(k);
      return bool;
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  @Keep
  public void setAnimValue(float paramFloat)
  {
    setAlpha(paramFloat);
    float f1 = paramFloat;
    if (this.f) {
      f1 = 1.0F - paramFloat;
    }
    this.d = (f1 * getHeight());
    invalidate();
  }
  
  public void setOn(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setRunning(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\BgRippleLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */