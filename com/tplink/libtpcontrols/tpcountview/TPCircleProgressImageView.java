package com.tplink.libtpcontrols.tpcountview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import androidx.annotation.DrawableRes;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.p0;
import com.tplink.libtpcontrols.x0;

public class TPCircleProgressImageView
  extends View
{
  private Point H3;
  private RectF I3;
  private Paint J3;
  private Paint K3;
  private Paint L3;
  private Bitmap M3;
  private int N3;
  private int O3 = -1;
  private Paint P3;
  private Paint Q3;
  private boolean R3 = false;
  private Point S3;
  private Point T3;
  private Point U3;
  private float V3;
  private float W3;
  private float X3;
  private float Y3;
  private float Z3;
  private float a4;
  private ObjectAnimator b4;
  private int c = 0;
  private ObjectAnimator c4;
  private float d = -90.0F;
  private ObjectAnimator d4;
  private ObjectAnimator e4;
  private int f = -16777216;
  private boolean f4 = false;
  private boolean g4 = false;
  private d h4 = null;
  private int p0 = 0;
  private boolean p1 = false;
  private float p2;
  private float p3;
  private int q = -16777216;
  private int x = -16777216;
  private float y = 2.0F;
  private float z = 2.0F;
  
  public TPCircleProgressImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPCircleProgressImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    j(paramContext, paramAttributeSet);
  }
  
  public TPCircleProgressImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    j(paramContext, paramAttributeSet);
  }
  
  private int e(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void f()
  {
    d locald = this.h4;
    if (locald != null) {
      locald.a(this.g4 ^ true);
    }
    this.f4 = false;
    this.g4 = false;
    this.c = 0;
  }
  
  private Bitmap g(@DrawableRes int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
    localOptions.inSampleSize = 1;
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
  }
  
  private ObjectAnimator getArcAnimator()
  {
    if (this.b4 == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "arcFraction", new float[] { this.d, 270.0F });
      this.b4 = localObjectAnimator;
      localObjectAnimator.setDuration(1200L);
      this.b4.setInterpolator(new LinearInterpolator());
      this.b4.setRepeatCount(-1);
    }
    return this.b4;
  }
  
  private ObjectAnimator getCircleAnimator()
  {
    if (this.c4 == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "circleFraction", new float[] { 0.0F, 1.0F });
      this.c4 = localObjectAnimator;
      localObjectAnimator.setDuration(500L);
      this.c4.addListener(new a());
    }
    return this.c4;
  }
  
  private ObjectAnimator getDismissAnimator()
  {
    if (this.e4 == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "dismissFraction", new float[] { 1.0F, 0.0F });
      this.e4 = localObjectAnimator;
      localObjectAnimator.setDuration(900L);
      this.e4.addListener(new c());
    }
    return this.e4;
  }
  
  private ObjectAnimator getHookAnimator()
  {
    if (this.d4 == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "hookFraction", new float[] { 0.0F, 20.0F });
      this.d4 = localObjectAnimator;
      localObjectAnimator.setDuration(600L);
      this.d4.addListener(new b());
    }
    return this.d4;
  }
  
  private int h(float paramFloat)
  {
    return (int)(paramFloat + 0.5F);
  }
  
  private void i()
  {
    m();
    l();
    k();
  }
  
  private void j(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPCircleProgressImageView);
    this.N3 = paramAttributeSet.getDimensionPixelOffset(x0.TPCircleProgressImageView_icon_center_size, -1);
    this.O3 = paramAttributeSet.getColor(x0.TPCircleProgressImageView_bur_center_color, ContextCompat.getColor(paramContext, p0.common_tplink_white_transparent_90));
    int i = x0.TPCircleProgressImageView_hook_color;
    paramContext = getContext();
    int j = p0.common_tplink_teal;
    this.x = paramAttributeSet.getColor(i, ContextCompat.getColor(paramContext, j));
    this.f = paramAttributeSet.getColor(x0.TPCircleProgressImageView_arc_color, ContextCompat.getColor(getContext(), j));
    this.q = paramAttributeSet.getColor(x0.TPCircleProgressImageView_circle_color, ContextCompat.getColor(getContext(), p0.white));
    this.z = paramAttributeSet.getDimensionPixelOffset(x0.TPCircleProgressImageView_hook_width, e(getContext(), 2.0F));
    this.y = paramAttributeSet.getDimensionPixelOffset(x0.TPCircleProgressImageView_arc_width, e(getContext(), 2.0F));
    i = x0.TPCircleProgressImageView_circle_padding;
    this.p2 = paramAttributeSet.getDimensionPixelOffset(i, e(getContext(), 5.0F));
    this.p3 = paramAttributeSet.getDimensionPixelOffset(i, e(getContext(), 6.0F));
    this.p1 = paramAttributeSet.getBoolean(x0.TPCircleProgressImageView_inner_arc, false);
    i();
    paramAttributeSet.recycle();
  }
  
  private void k()
  {
    double d1 = (int)(this.p0 - this.p3);
    double d2 = 0.5D * d1;
    float f1 = (float)(Math.cos(Math.toRadians(10.0D)) * d2);
    float f2 = (float)(d2 * Math.sin(Math.toRadians(10.0D)));
    d2 = 0.45D * d1;
    float f3 = (float)(Math.sin(Math.toRadians(16.0D)) * d2);
    float f5 = (float)(d2 * Math.cos(Math.toRadians(16.0D)));
    d1 *= 0.7D;
    float f6 = (float)(Math.cos(Math.toRadians(24.0D)) * d1);
    float f7 = (float)(d1 * Math.sin(Math.toRadians(24.0D)));
    Point localPoint = this.H3;
    this.S3 = new Point((int)(localPoint.x - f1), (int)(localPoint.y - f2));
    localPoint = this.H3;
    this.T3 = new Point((int)(localPoint.x - f3), (int)(localPoint.y + f5));
    localPoint = this.H3;
    this.U3 = new Point((int)(localPoint.x + f6), (int)(localPoint.y - f7));
  }
  
  private void l()
  {
    Paint localPaint = new Paint();
    this.J3 = localPaint;
    localPaint.setFlags(1);
    this.J3.setColor(this.f);
    this.J3.setStyle(Paint.Style.STROKE);
    this.J3.setStrokeWidth(this.y);
    localPaint = new Paint();
    this.K3 = localPaint;
    localPaint.setFlags(1);
    this.K3.setColor(this.q);
    this.K3.setStyle(Paint.Style.FILL);
    localPaint = new Paint();
    this.L3 = localPaint;
    localPaint.setFlags(1);
    this.L3.setColor(this.x);
    this.L3.setStyle(Paint.Style.STROKE);
    this.L3.setStrokeWidth(this.z);
    this.P3 = new Paint(1);
    localPaint = new Paint(1);
    this.Q3 = localPaint;
    localPaint.setColor(this.O3);
    this.Q3.setStyle(Paint.Style.FILL);
  }
  
  private void m()
  {
    int i = getWidth();
    int j = getHeight();
    int k = i / 2;
    int m = j / 2;
    Object localObject = new Point();
    this.H3 = ((Point)localObject);
    ((Point)localObject).x = (getPaddingLeft() + k);
    this.H3.y = (getPaddingTop() + m);
    int n = Math.min(k, m);
    this.p0 = n;
    if (!this.p1) {
      this.p0 = ((int)(n - this.p2));
    }
    if (this.N3 == -1) {
      this.N3 = this.p0;
    }
    localObject = new RectF();
    this.I3 = ((RectF)localObject);
    if (this.p1)
    {
      ((RectF)localObject).left = (this.H3.x - k + this.p2 + h(this.y / 2.0F));
      this.I3.right = (i - this.p2 - h(this.y / 2.0F));
      this.I3.top = (this.H3.y - m + this.p2 + h(this.y / 2.0F));
      this.I3.bottom = (j - this.p2 - h(this.y / 2.0F));
    }
    else
    {
      ((RectF)localObject).left = (this.H3.x - k + h(this.y / 2.0F));
      this.I3.right = (i - h(this.y / 2.0F));
      this.I3.top = (this.H3.y - m + h(this.y / 2.0F));
      this.I3.bottom = (j - h(this.y / 2.0F));
    }
  }
  
  private Bitmap n(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      float f1 = paramInt1 / i;
      float f2 = paramInt2 / j;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f2);
      return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
    }
    return null;
  }
  
  private void p(Canvas paramCanvas)
  {
    float f1 = this.Z3;
    Point localPoint1;
    int i;
    float f2;
    Point localPoint2;
    float f3;
    float f5;
    int j;
    int k;
    int m;
    if (f1 < 8.0F)
    {
      localPoint1 = this.S3;
      i = localPoint1.x;
      f2 = i;
      localPoint2 = this.T3;
      f3 = localPoint2.x;
      f5 = this.z;
      j = (int)(f2 + (f3 + f5 / 3.0F - i) * f1 / 12.0F);
      k = localPoint1.y;
      m = (int)(k + (localPoint2.y + f5 / 3.0F - k) * f1 / 12.0F);
      paramCanvas.drawLine(i, k, j, m, this.L3);
    }
    else
    {
      localPoint2 = this.T3;
      i = localPoint2.x;
      f2 = i;
      localPoint1 = this.U3;
      k = (int)(f2 + (localPoint1.x - i) * (f1 - 8.0F) / 12.0F);
      m = localPoint2.y;
      j = (int)(m + (localPoint1.y - m) * (f1 - 8.0F) / 12.0F);
      paramCanvas.drawLine(i, m, k, j, this.L3);
      localPoint1 = this.S3;
      f1 = localPoint1.x;
      f3 = localPoint1.y;
      localPoint1 = this.T3;
      f5 = localPoint1.x;
      f2 = this.z;
      paramCanvas.drawLine(f1, f3, f2 / 3.0F + f5, localPoint1.y + f2 / 3.0F, this.L3);
    }
  }
  
  public float getAngleFraction()
  {
    return this.V3;
  }
  
  public float getArcFraction()
  {
    return this.W3;
  }
  
  public float getArcToCircleFraction()
  {
    return this.X3;
  }
  
  public float getCircleFraction()
  {
    return this.Y3;
  }
  
  public float getDismissFraction()
  {
    return this.a4;
  }
  
  public float getHookFraction()
  {
    return this.Z3;
  }
  
  public void o()
  {
    this.f4 = true;
    this.c = 0;
    this.J3.setAlpha(255);
    this.K3.setAlpha(255);
    this.L3.setAlpha(255);
    getArcAnimator().cancel();
    getCircleAnimator().cancel();
    getHookAnimator().cancel();
    getDismissAnimator().cancel();
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.M3;
    if (localObject != null) {
      paramCanvas.drawBitmap((Bitmap)localObject, this.H3.x - h(this.N3 / 2.0F), this.H3.y - h(this.N3 / 2.0F), this.P3);
    }
    if (this.R3)
    {
      localObject = this.H3;
      paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, h(this.N3 / 2.0F), this.Q3);
    }
    if ((!this.f4) && (!this.R3))
    {
      int i = this.c;
      if (i == 2)
      {
        localObject = this.H3;
        paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, h(this.N3 / 2.0F), this.Q3);
        paramCanvas.drawArc(this.I3, this.W3, 270.0F, false, this.J3);
      }
      else if (i == 4)
      {
        this.K3.setAlpha(178);
        localObject = this.H3;
        paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.p0, this.K3);
      }
      else if (i == 5)
      {
        this.K3.setAlpha(178);
        localObject = this.H3;
        paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.p0, this.K3);
        p(paramCanvas);
      }
      else if (i == 6)
      {
        float f1 = this.a4;
        if (f1 < 0.1F)
        {
          this.J3.setAlpha((int)(f1 * 255.0F));
          this.K3.setAlpha((int)(this.a4 * 255.0F));
          this.L3.setAlpha((int)(this.a4 * 255.0F));
        }
        localObject = this.H3;
        paramCanvas.drawCircle(((Point)localObject).x, ((Point)localObject).y, this.p0, this.K3);
        localObject = this.S3;
        float f2 = ((Point)localObject).x;
        f1 = ((Point)localObject).y;
        localObject = this.T3;
        float f3 = ((Point)localObject).x;
        float f5 = this.z;
        paramCanvas.drawLine(f2, f1, f3 + f5 / 3.0F, ((Point)localObject).y + f5 / 3.0F, this.L3);
        localObject = this.T3;
        f1 = ((Point)localObject).x;
        f2 = ((Point)localObject).y;
        localObject = this.U3;
        paramCanvas.drawLine(f1, f2, ((Point)localObject).x, ((Point)localObject).y, this.L3);
      }
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    i();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  public void setAngleFraction(float paramFloat)
  {
    this.V3 = paramFloat;
    postInvalidate();
  }
  
  public void setArcColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  @Keep
  public void setArcFraction(float paramFloat)
  {
    this.W3 = paramFloat;
    postInvalidate();
  }
  
  public void setArcToCircleFraction(float paramFloat)
  {
    this.X3 = paramFloat;
    postInvalidate();
  }
  
  public void setArcWidth(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  public void setBurCenterColor(int paramInt)
  {
    this.O3 = paramInt;
  }
  
  public void setCenterImageResource(int paramInt)
  {
    Bitmap localBitmap = g(paramInt);
    paramInt = this.N3;
    this.M3 = n(localBitmap, paramInt, paramInt);
    postInvalidate();
  }
  
  public void setCircleColor(int paramInt)
  {
    this.q = paramInt;
  }
  
  @Keep
  public void setCircleFraction(float paramFloat)
  {
    this.Y3 = paramFloat;
    postInvalidate();
  }
  
  public void setCirclePadding(float paramFloat)
  {
    this.p2 = paramFloat;
    i();
  }
  
  public void setDisableView(boolean paramBoolean)
  {
    this.R3 = paramBoolean;
    postInvalidate();
  }
  
  @Keep
  public void setDismissFraction(float paramFloat)
  {
    this.a4 = paramFloat;
    postInvalidate();
  }
  
  public void setHookColor(int paramInt)
  {
    this.x = paramInt;
  }
  
  @Keep
  public void setHookFraction(float paramFloat)
  {
    this.Z3 = paramFloat;
    postInvalidate();
  }
  
  public void setHookPadding(float paramFloat)
  {
    this.p3 = paramFloat;
    i();
  }
  
  public void setHookWidth(float paramFloat)
  {
    this.z = paramFloat;
  }
  
  public void setIconCenterSize(int paramInt)
  {
    this.N3 = paramInt;
  }
  
  public void setInnerArc(boolean paramBoolean)
  {
    this.p1 = paramBoolean;
    i();
  }
  
  public void setOnAnimCompleteListener(d paramd)
  {
    this.h4 = paramd;
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPCircleProgressImageView.a(TPCircleProgressImageView.this, 5);
      TPCircleProgressImageView.b(TPCircleProgressImageView.this).start();
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
      TPCircleProgressImageView.c(TPCircleProgressImageView.this).start();
      TPCircleProgressImageView.a(TPCircleProgressImageView.this, 6);
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
      TPCircleProgressImageView.d(TPCircleProgressImageView.this);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpcountview\TPCircleProgressImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */