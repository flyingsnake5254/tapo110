package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;

public class TPCircleProgress
  extends View
{
  private Paint H3;
  private Paint I3;
  private Point J3;
  private Point K3;
  private Point L3;
  private float M3;
  private float N3;
  private float O3;
  private float P3;
  private ObjectAnimator Q3;
  private ObjectAnimator R3;
  private ObjectAnimator S3;
  private ObjectAnimator T3;
  private boolean U3 = false;
  private boolean V3 = false;
  private d W3 = null;
  private int c = 0;
  private float d = -90.0F;
  private int f = -16777216;
  private Point p0;
  private int p1 = 0;
  private RectF p2;
  private Paint p3;
  private int q = -16777216;
  private int x = -16777216;
  private float y = 2.0F;
  private float z = 4.0F;
  
  public TPCircleProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  public TPCircleProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void f()
  {
    d locald = this.W3;
    if (locald != null) {
      locald.a(this.V3);
    }
    this.U3 = false;
    this.V3 = false;
    this.c = 0;
  }
  
  private void g()
  {
    Context localContext = getContext();
    int i = p0.common_tplink_teal;
    this.x = ContextCompat.getColor(localContext, i);
    this.f = ContextCompat.getColor(getContext(), i);
    this.q = ContextCompat.getColor(getContext(), p0.white);
    j();
    i();
    h();
  }
  
  private ObjectAnimator getArcAnimator()
  {
    if (this.Q3 == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "arcFraction", new float[] { this.d, 270.0F });
      this.Q3 = localObjectAnimator;
      localObjectAnimator.setDuration(1200L);
      this.Q3.setInterpolator(new LinearInterpolator());
      this.Q3.setRepeatCount(-1);
    }
    return this.Q3;
  }
  
  private ObjectAnimator getCircleAnimator()
  {
    if (this.R3 == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "circleFraction", new float[] { 0.0F, 1.0F });
      this.R3 = localObjectAnimator;
      localObjectAnimator.setDuration(500L);
      this.R3.addListener(new a());
    }
    return this.R3;
  }
  
  private ObjectAnimator getDismissAnimator()
  {
    if (this.T3 == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "dismissFraction", new float[] { 1.0F, 0.0F });
      this.T3 = localObjectAnimator;
      localObjectAnimator.setDuration(800L);
      this.T3.addListener(new c());
    }
    return this.T3;
  }
  
  private ObjectAnimator getHookAnimator()
  {
    if (this.S3 == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "hookFraction", new float[] { 0.0F, 20.0F });
      this.S3 = localObjectAnimator;
      localObjectAnimator.setDuration(600L);
      this.S3.addListener(new b());
    }
    return this.S3;
  }
  
  private void h()
  {
    float f1 = (float)(this.p1 * 0.5D * Math.cos(Math.toRadians(10.0D)));
    float f2 = (float)(this.p1 * 0.5D * Math.sin(Math.toRadians(10.0D)));
    float f3 = (float)(this.p1 * 0.45D * Math.sin(Math.toRadians(16.0D)));
    float f4 = (float)(this.p1 * 0.45D * Math.cos(Math.toRadians(16.0D)));
    float f5 = (float)(this.p1 * 0.7D * Math.cos(Math.toRadians(24.0D)));
    float f6 = (float)(this.p1 * 0.7D * Math.sin(Math.toRadians(24.0D)));
    Point localPoint = this.p0;
    this.J3 = new Point((int)(localPoint.x - f1), (int)(localPoint.y - f2));
    localPoint = this.p0;
    this.K3 = new Point((int)(localPoint.x - f3), (int)(localPoint.y + f4));
    localPoint = this.p0;
    this.L3 = new Point((int)(localPoint.x + f5), (int)(localPoint.y - f6));
  }
  
  private void i()
  {
    Paint localPaint = new Paint();
    this.p3 = localPaint;
    localPaint.setFlags(1);
    this.p3.setColor(this.f);
    this.p3.setStyle(Paint.Style.STROKE);
    this.p3.setStrokeWidth(this.y);
    localPaint = new Paint();
    this.H3 = localPaint;
    localPaint.setFlags(1);
    this.H3.setColor(this.q);
    this.H3.setStyle(Paint.Style.FILL);
    localPaint = new Paint();
    this.I3 = localPaint;
    localPaint.setFlags(1);
    this.I3.setColor(this.x);
    this.I3.setStyle(Paint.Style.STROKE);
    this.I3.setStrokeWidth(this.z);
  }
  
  private void j()
  {
    int i = e(getContext(), 5.0F);
    this.y = e(getContext(), 2.0F);
    this.z = e(getContext(), 4.0F);
    Point localPoint = new Point();
    this.p0 = localPoint;
    localPoint.x = (getPaddingLeft() + getWidth() / 2);
    this.p0.y = (getPaddingTop() + getHeight() / 2);
    int j = Math.min(getWidth() / 2, getHeight() / 2);
    this.p1 = j;
    this.p1 = (j - i);
    i = getWidth();
    j = getHeight();
    RectF localRectF = new RectF();
    this.p2 = localRectF;
    localPoint = this.p0;
    float f1 = localPoint.x;
    float f2 = i;
    float f3 = f2 / 2.0F;
    float f4 = this.y;
    localRectF.left = (f1 - f3 + f4 / 2.0F);
    localRectF.right = (f2 - f4 / 2.0F);
    f3 = localPoint.y;
    f1 = j;
    localRectF.top = (f3 - f1 / 2.0F + f4 / 2.0F);
    localRectF.bottom = (f1 - f4 / 2.0F);
  }
  
  private void k(Canvas paramCanvas)
  {
    float f1 = this.O3;
    Point localPoint1;
    int i;
    float f2;
    Point localPoint2;
    float f3;
    float f4;
    int j;
    int k;
    int m;
    if (f1 < 8.0F)
    {
      localPoint1 = this.J3;
      i = localPoint1.x;
      f2 = i;
      localPoint2 = this.K3;
      f3 = localPoint2.x;
      f4 = this.z;
      j = (int)(f2 + (f3 + f4 / 3.0F - i) * f1 / 12.0F);
      k = localPoint1.y;
      m = (int)(k + (localPoint2.y + f4 / 3.0F - k) * f1 / 12.0F);
      paramCanvas.drawLine(i, k, j, m, this.I3);
    }
    else
    {
      localPoint1 = this.K3;
      k = localPoint1.x;
      f3 = k;
      localPoint2 = this.L3;
      j = (int)(f3 + (localPoint2.x - k) * (f1 - 8.0F) / 12.0F);
      i = localPoint1.y;
      m = (int)(i + (localPoint2.y - i) * (f1 - 8.0F) / 12.0F);
      paramCanvas.drawLine(k, i, j, m, this.I3);
      localPoint2 = this.J3;
      f4 = localPoint2.x;
      f1 = localPoint2.y;
      localPoint2 = this.K3;
      f3 = localPoint2.x;
      f2 = this.z;
      paramCanvas.drawLine(f4, f1, f2 / 3.0F + f3, localPoint2.y + f2 / 3.0F, this.I3);
    }
  }
  
  public int e(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public float getArcFraction()
  {
    return this.M3;
  }
  
  public float getCircleFraction()
  {
    return this.N3;
  }
  
  public float getDismissFraction()
  {
    return this.P3;
  }
  
  public float getHookFraction()
  {
    return this.O3;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.U3)
    {
      int i = this.c;
      if (i == 2)
      {
        paramCanvas.drawArc(this.p2, this.M3, 270.0F, false, this.p3);
      }
      else
      {
        Point localPoint;
        if (i == 4)
        {
          paramCanvas.drawArc(this.p2, this.d, 360.0F, false, this.p3);
          this.H3.setAlpha((int)(this.N3 * 178.0F));
          localPoint = this.p0;
          paramCanvas.drawCircle(localPoint.x, localPoint.y, this.p1, this.H3);
        }
        else if (i == 5)
        {
          paramCanvas.drawArc(this.p2, this.d, 360.0F, false, this.p3);
          this.H3.setAlpha(178);
          localPoint = this.p0;
          paramCanvas.drawCircle(localPoint.x, localPoint.y, this.p1, this.H3);
          k(paramCanvas);
        }
        else if (i == 6)
        {
          float f1 = this.P3;
          if (f1 < 0.5F)
          {
            this.p3.setAlpha((int)(f1 * 255.0F));
            this.H3.setAlpha((int)(this.P3 * 255.0F));
            this.I3.setAlpha((int)(this.P3 * 255.0F));
          }
          paramCanvas.drawArc(this.p2, this.d, 360.0F, false, this.p3);
          localPoint = this.p0;
          paramCanvas.drawCircle(localPoint.x, localPoint.y, this.p1, this.H3);
          localPoint = this.J3;
          float f2 = localPoint.x;
          float f3 = localPoint.y;
          localPoint = this.K3;
          f1 = localPoint.x;
          float f4 = this.z;
          paramCanvas.drawLine(f2, f3, f1 + f4 / 3.0F, localPoint.y + f4 / 3.0F, this.I3);
          localPoint = this.K3;
          f3 = localPoint.x;
          f1 = localPoint.y;
          localPoint = this.L3;
          paramCanvas.drawLine(f3, f1, localPoint.x, localPoint.y, this.I3);
        }
      }
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    g();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ProgressSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ProgressSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.U3 = paramParcelable.c;
    this.V3 = paramParcelable.d;
    this.c = paramParcelable.f;
    this.M3 = paramParcelable.q;
    this.N3 = paramParcelable.x;
    this.O3 = paramParcelable.y;
    this.P3 = paramParcelable.z;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ProgressSavedState localProgressSavedState = new ProgressSavedState(super.onSaveInstanceState());
    localProgressSavedState.c = this.U3;
    localProgressSavedState.d = this.V3;
    localProgressSavedState.f = this.c;
    localProgressSavedState.q = this.M3;
    localProgressSavedState.x = this.N3;
    localProgressSavedState.y = this.O3;
    localProgressSavedState.z = this.P3;
    return localProgressSavedState;
  }
  
  public void setArcFraction(float paramFloat)
  {
    this.M3 = paramFloat;
    postInvalidate();
  }
  
  public void setCircleFraction(float paramFloat)
  {
    this.N3 = paramFloat;
    postInvalidate();
  }
  
  public void setDismissFraction(float paramFloat)
  {
    this.P3 = paramFloat;
    postInvalidate();
  }
  
  public void setHookFraction(float paramFloat)
  {
    this.O3 = paramFloat;
    postInvalidate();
  }
  
  public void setOnAnimCompleteListener(d paramd)
  {
    this.W3 = paramd;
  }
  
  static class ProgressSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<ProgressSavedState> CREATOR = new a();
    boolean c;
    boolean d;
    int f;
    float q;
    float x;
    float y;
    float z;
    
    private ProgressSavedState(Parcel paramParcel)
    {
      super();
      int i = paramParcel.readByte();
      boolean bool1 = true;
      boolean bool2;
      if (i != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.c = bool2;
      if (paramParcel.readByte() != 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      this.d = bool2;
      this.f = paramParcel.readInt();
      this.q = paramParcel.readFloat();
      this.x = paramParcel.readFloat();
      this.y = paramParcel.readFloat();
      this.z = paramParcel.readFloat();
    }
    
    ProgressSavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeByte((byte)this.c);
      paramParcel.writeByte((byte)this.d);
      paramParcel.writeInt(this.f);
      paramParcel.writeFloat(this.q);
      paramParcel.writeFloat(this.x);
      paramParcel.writeFloat(this.y);
      paramParcel.writeFloat(this.z);
    }
    
    static final class a
      implements Parcelable.Creator<TPCircleProgress.ProgressSavedState>
    {
      public TPCircleProgress.ProgressSavedState a(Parcel paramParcel)
      {
        return new TPCircleProgress.ProgressSavedState(paramParcel, null);
      }
      
      public TPCircleProgress.ProgressSavedState[] b(int paramInt)
      {
        return new TPCircleProgress.ProgressSavedState[paramInt];
      }
    }
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPCircleProgress.a(TPCircleProgress.this, 5);
      TPCircleProgress.b(TPCircleProgress.this).start();
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class b
    implements Animator.AnimatorListener
  {
    b() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPCircleProgress.c(TPCircleProgress.this).start();
      TPCircleProgress.a(TPCircleProgress.this, 6);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class c
    implements Animator.AnimatorListener
  {
    c() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPCircleProgress.d(TPCircleProgress.this);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPCircleProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */