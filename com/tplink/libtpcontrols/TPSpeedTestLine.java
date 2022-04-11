package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import b.d.w.c.a;

public class TPSpeedTestLine
  extends AppCompatImageView
{
  private float H3;
  private float I3;
  private float J3;
  private float K3;
  private boolean L3 = false;
  private boolean M3 = false;
  private boolean N3 = false;
  private boolean O3 = false;
  private boolean P3 = false;
  private Paint c;
  private Paint d;
  private float f = -40.0F;
  private float p0 = -40.0F;
  private float p1;
  private float p2;
  private float p3;
  private float q = -20.0F;
  private ObjectAnimator x;
  private ObjectAnimator y;
  private ObjectAnimator z;
  
  public TPSpeedTestLine(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPSpeedTestLine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPSpeedTestLine);
    int i = x0.TPSpeedTestLine_sp_line_color;
    int j = p0.common_tplink_green;
    this.H3 = paramAttributeSet.getColor(i, ContextCompat.getColor(paramContext, j));
    this.J3 = paramAttributeSet.getColor(x0.TPSpeedTestLine_sp_point_color, ContextCompat.getColor(paramContext, j));
    this.I3 = paramAttributeSet.getDimension(x0.TPSpeedTestLine_sp_line_width, 10.0F);
    this.K3 = paramAttributeSet.getDimension(x0.TPSpeedTestLine_sp_point_radius, 20.0F);
    paramAttributeSet.recycle();
    float f1 = this.K3;
    this.f = (0.0F - f1 * 2.5F);
    this.q = (0.0F - this.I3 * 2.5F);
    this.p0 = (0.0F - f1 * 2.5F);
  }
  
  private void c()
  {
    Paint localPaint = new Paint(1);
    this.c = localPaint;
    Context localContext = getContext();
    int i = p0.common_tplink_green;
    localPaint.setColor(ContextCompat.getColor(localContext, i));
    localPaint = new Paint(1);
    this.d = localPaint;
    localPaint.setColor(ContextCompat.getColor(getContext(), i));
    this.d.setStrokeWidth(this.I3);
    this.P3 = true;
  }
  
  private ObjectAnimator getDownAnimator()
  {
    if (this.y == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "cyPoint", new float[] { this.p0, this.p1 });
      this.y = localObjectAnimator;
      localObjectAnimator.setDuration(800L);
      this.y.setInterpolator(new AccelerateDecelerateInterpolator());
      this.y.setRepeatCount(-1);
      this.y.addListener(new b());
    }
    return this.y;
  }
  
  private ObjectAnimator getLineAnimator()
  {
    if (this.x == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "cyLine", new float[] { this.p0, this.p1 });
      this.x = localObjectAnimator;
      localObjectAnimator.setDuration(1000L);
      this.x.setInterpolator(new LinearInterpolator());
      this.x.addListener(new a());
    }
    return this.x;
  }
  
  private ObjectAnimator getUpAnimator()
  {
    if (this.z == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "cyPoint", new float[] { this.p1, this.p0 });
      this.z = localObjectAnimator;
      localObjectAnimator.setDuration(800L);
      this.z.setInterpolator(new AccelerateDecelerateInterpolator());
      this.z.setRepeatCount(-1);
      this.z.addListener(new c());
    }
    return this.z;
  }
  
  public void b()
  {
    this.f = (this.p1 * 2.0F);
    postInvalidate();
  }
  
  public float getCyLine()
  {
    return this.q;
  }
  
  public float getCyPoint()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = getLeft() + this.p2 / 2.0F;
    if (!this.O3)
    {
      if (!this.N3) {
        paramCanvas.drawCircle(f1, this.f, this.K3, this.c);
      } else {
        paramCanvas.drawCircle(f1, this.p1 * 2.0F, this.K3, this.c);
      }
      if (!this.M3)
      {
        if (this.L3) {
          paramCanvas.drawLine(f1, 0.0F, f1, this.p3, this.d);
        } else {
          paramCanvas.drawLine(f1, 0.0F, f1, this.q, this.d);
        }
      }
      else {
        paramCanvas.drawLine(f1, 0.0F, f1, this.p3, this.d);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    c();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    a.c("widthSize ", localStringBuilder.toString());
    setMeasuredDimension(paramInt1, paramInt2);
    this.p2 = paramInt1;
    float f1 = paramInt2;
    this.p3 = f1;
    this.p1 = (-this.p0 + f1);
  }
  
  public void setCyLine(float paramFloat)
  {
    this.q = paramFloat;
    postInvalidate();
  }
  
  public void setCyPoint(float paramFloat)
  {
    this.f = paramFloat;
    postInvalidate();
  }
  
  public void setLineDrawed(boolean paramBoolean)
  {
    this.L3 = paramBoolean;
    invalidate();
  }
  
  public void setLineFocusDrawed(boolean paramBoolean)
  {
    this.M3 = paramBoolean;
    invalidate();
  }
  
  public void setPointFocusStop(boolean paramBoolean)
  {
    this.N3 = paramBoolean;
    if (paramBoolean)
    {
      this.f = (this.p1 * 2.0F);
      invalidate();
    }
  }
  
  public void setStopDrawing(boolean paramBoolean)
  {
    this.O3 = paramBoolean;
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPSpeedTestLine.a(TPSpeedTestLine.this, true);
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPSpeedTestLine.this.b();
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPSpeedTestLine.this.b();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPSpeedTestLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */