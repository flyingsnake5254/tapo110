package com.wdullaer.materialdatetimepicker.time;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class RadialSelectorView
  extends View
{
  private boolean H3;
  private int I3;
  private int J3;
  private int K3;
  private int L3;
  private float M3;
  private float N3;
  private int O3;
  private int P3;
  private a Q3;
  private int R3;
  private double S3;
  private boolean T3;
  private final Paint c = new Paint();
  private boolean d = false;
  private boolean f;
  private float p0;
  private float p1;
  private float p2;
  private boolean p3;
  private float q;
  private float x;
  private float y;
  private float z;
  
  public RadialSelectorView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a(float paramFloat1, float paramFloat2, boolean paramBoolean, Boolean[] paramArrayOfBoolean)
  {
    if (!this.f) {
      return -1;
    }
    int i = this.K3;
    float f1 = i;
    float f2 = i;
    i = this.J3;
    double d1 = Math.sqrt((paramFloat2 - f1) * (paramFloat2 - f2) + (paramFloat1 - i) * (paramFloat1 - i));
    boolean bool = this.H3;
    int j = 1;
    int m;
    if (bool)
    {
      if (paramBoolean)
      {
        if ((int)Math.abs(d1 - (int)(this.L3 * this.y)) <= (int)Math.abs(d1 - (int)(this.L3 * this.z))) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramArrayOfBoolean[0] = Boolean.valueOf(paramBoolean);
      }
      else
      {
        int k = this.L3;
        f1 = k;
        f2 = this.y;
        i = (int)(f1 * f2);
        m = this.P3;
        float f3 = k;
        f1 = this.z;
        n = (int)(f3 * f1);
        k = (int)(k * ((f1 + f2) / 2.0F));
        if ((d1 >= i - m) && (d1 <= k)) {
          paramArrayOfBoolean[0] = Boolean.TRUE;
        } else if ((d1 <= n + m) && (d1 >= k)) {
          paramArrayOfBoolean[0] = Boolean.FALSE;
        } else {
          return -1;
        }
      }
    }
    else if ((!paramBoolean) && ((int)Math.abs(d1 - this.O3) > (int)(this.L3 * (1.0F - this.p0)))) {
      return -1;
    }
    int n = (int)(Math.asin(Math.abs(paramFloat2 - this.K3) / d1) * 180.0D / 3.141592653589793D);
    if (paramFloat1 > this.J3) {
      m = 1;
    } else {
      m = 0;
    }
    if (paramFloat2 >= this.K3) {
      j = 0;
    }
    if ((m != 0) && (j != 0))
    {
      i = 90 - n;
    }
    else if ((m != 0) && (j == 0))
    {
      i = n + 90;
    }
    else if ((m == 0) && (j == 0))
    {
      i = 270 - n;
    }
    else
    {
      i = n;
      if (m == 0)
      {
        i = n;
        if (j != 0) {
          i = n + 270;
        }
      }
    }
    return i;
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.R3 = paramInt;
    this.S3 = (paramInt * 3.141592653589793D / 180.0D);
    this.T3 = paramBoolean2;
    if (this.H3) {
      if (paramBoolean1) {
        this.p0 = this.y;
      } else {
        this.p0 = this.z;
      }
    }
  }
  
  public ObjectAnimator getDisappearAnimator()
  {
    if ((this.d) && (this.f))
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.2F, this.M3), Keyframe.ofFloat(1.0F, this.N3) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) }) }).setDuration('Ǵ');
      localObjectAnimator.addUpdateListener(this.Q3);
      return localObjectAnimator;
    }
    Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
    return null;
  }
  
  public ObjectAnimator getReappearAnimator()
  {
    if ((this.d) && (this.f))
    {
      float f1 = 'Ǵ';
      int i = (int)(1.25F * f1);
      f1 = f1 * 0.25F / i;
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, this.N3), Keyframe.ofFloat(f1, this.N3), Keyframe.ofFloat(1.0F - (1.0F - f1) * 0.2F, this.M3), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(f1, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) }).setDuration(i);
      localObjectAnimator.addUpdateListener(this.Q3);
      return localObjectAnimator;
    }
    Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() != 0) && (this.d))
    {
      boolean bool1 = this.f;
      boolean bool2 = true;
      if (!bool1)
      {
        this.J3 = (getWidth() / 2);
        j = getHeight() / 2;
        this.K3 = j;
        j = (int)(Math.min(this.J3, j) * this.q);
        this.L3 = j;
        if (!this.p3)
        {
          k = (int)(j * this.x);
          this.K3 = ((int)(this.K3 - k * 0.75D));
        }
        this.P3 = ((int)(j * this.p1));
        this.f = true;
      }
      int j = (int)(this.L3 * this.p0 * this.p2);
      this.O3 = j;
      j = this.J3 + (int)(j * Math.sin(this.S3));
      int k = this.K3 - (int)(this.O3 * Math.cos(this.S3));
      this.c.setAlpha(this.I3);
      float f1 = j;
      float f2 = k;
      paramCanvas.drawCircle(f1, f2, this.P3, this.c);
      bool1 = this.T3;
      if (this.R3 % 30 == 0) {
        bool2 = false;
      }
      int i;
      if ((bool2 | bool1))
      {
        this.c.setAlpha(255);
        paramCanvas.drawCircle(f1, f2, this.P3 * 2 / 7, this.c);
        bool2 = k;
      }
      else
      {
        j = this.O3;
        k = this.P3;
        i = this.J3;
        double d1 = j - k;
        j = (int)(Math.sin(this.S3) * d1);
        k = this.K3;
        int m = (int)(d1 * Math.cos(this.S3));
        j += i;
        i = k - m;
      }
      this.c.setAlpha(255);
      this.c.setStrokeWidth(3.0F);
      paramCanvas.drawLine(this.J3, this.K3, j, i, this.c);
    }
  }
  
  public void setAnimationRadiusMultiplier(float paramFloat)
  {
    this.p2 = paramFloat;
  }
  
  private class a
    implements ValueAnimator.AnimatorUpdateListener
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\time\RadialSelectorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */