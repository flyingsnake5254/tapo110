package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.core.text.TextUtilsCompat;

public class TPDownloadProgressV2View
  extends View
{
  private int H3 = 100;
  private int I3 = 0;
  private int J3 = 1;
  private float K3;
  private float L3;
  private float M3;
  private float N3;
  private float O3;
  private float P3;
  private float Q3;
  private float R3;
  private float S3;
  private RectF T3 = new RectF();
  private RectF U3 = new RectF();
  private RectF V3 = new RectF();
  private float W3;
  private float X3;
  private ValueAnimator Y3;
  private ValueAnimator Z3;
  private ValueAnimator a4;
  private ValueAnimator b4;
  private Paint c;
  private ValueAnimator c4;
  private Paint d;
  private boolean d4 = false;
  private boolean e4 = true;
  private Paint f;
  private int f4;
  private f g4 = null;
  private e h4 = null;
  private float p0;
  private float p1;
  private float p2;
  private float p3;
  private Paint q;
  private int x;
  private int y;
  private float z = 0.4F;
  
  public TPDownloadProgressV2View(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPDownloadProgressV2View(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    s(paramContext, paramAttributeSet);
    u();
    r();
  }
  
  private void G()
  {
    if (this.f4 == 2)
    {
      if ((!this.Y3.isRunning()) && (!this.Z3.isRunning()))
      {
        this.d4 = true;
        this.Y3.start();
      }
    }
    else
    {
      this.d4 = false;
      this.Y3.cancel();
      invalidate();
    }
  }
  
  private void H(float paramFloat)
  {
    this.U3.top = (getMeasuredHeight() * (1.0F - this.z) / 2.0F + 2.0F);
    this.U3.bottom = (getMeasuredHeight() * (this.z + 1.0F) / 2.0F - 2.0F);
    this.X3 = (this.W3 - 1.0F);
    float f1;
    float f2;
    if (v())
    {
      this.U3.left = (getMeasuredWidth() - 2 - this.W3 * 2.0F - (getMeasuredWidth() - 2 - this.W3 * 2.0F) * paramFloat);
      this.U3.right = (getMeasuredWidth() - 2);
      f1 = getMeasuredWidth() - 2;
      f2 = this.W3;
      this.S3 = ((f1 - f2 - f2 - 2.0F) * (1.0F - paramFloat));
    }
    else
    {
      RectF localRectF = this.U3;
      localRectF.left = 2.0F;
      localRectF.right = (this.W3 * 2.0F + (getMeasuredWidth() - 2 - this.W3 * 2.0F) * paramFloat);
      f1 = getMeasuredWidth() - 2;
      f2 = this.W3;
      this.S3 = ((f1 - f2 - f2 - 2.0F) * paramFloat);
    }
  }
  
  private void i(Canvas paramCanvas)
  {
    if (this.q.getShader() != null) {
      this.q.setShader(null);
    }
    this.q.setColor(this.y);
    RectF localRectF = this.U3;
    float f1 = this.W3;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.q);
    this.c.setColor(this.x);
    localRectF = this.U3;
    f1 = this.W3;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.c);
    paramCanvas.drawCircle(this.W3 + 2.0F + this.S3, getMeasuredHeight() / 2.0F, this.X3, this.d);
  }
  
  private void j(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.W3 + this.S3, getMeasuredHeight() / 2.0F, this.X3, this.d);
  }
  
  private void k(Canvas paramCanvas)
  {
    if (this.d4)
    {
      float f1 = this.W3 + getMeasuredHeight() * (1.0F - this.z) / 2.0F;
      double d1;
      float f2;
      float f5;
      if (v())
      {
        RectF localRectF = this.T3;
        d1 = localRectF.left;
        f2 = this.W3;
        f3 = (float)(d1 + f2 * 1.5D);
        f5 = this.K3;
        if ((f5 > 0.0F) && (f5 + f3 < localRectF.right - f2 * 0.35D)) {
          paramCanvas.drawCircle(f5 + f3, f1 - this.L3, 10.0F, this.f);
        }
        f2 = this.M3;
        if ((f2 > 0.0F) && (f2 + f3 < this.T3.right - this.W3 * 0.35D)) {
          paramCanvas.drawCircle(f2 + f3, f1 - this.N3, 4.0F, this.f);
        }
        f2 = this.O3;
        if ((f2 > 0.0F) && (f2 + f3 < this.T3.right - this.W3 * 0.35D)) {
          paramCanvas.drawCircle(f2 + f3, f1 - this.P3, 6.0F, this.f);
        }
        f2 = this.Q3;
        if ((f2 > 0.0F) && (f2 + f3 < this.T3.right - this.W3 * 0.35D)) {
          paramCanvas.drawCircle(f2 + f3, f1 - this.R3, 8.0F, this.f);
        }
      }
      else
      {
        d1 = this.T3.right;
        f2 = this.W3;
        f3 = (float)(d1 - f2 * 1.5D);
        f5 = this.K3;
        if ((f5 > 0.0F) && (f3 - f5 > f2 * 0.35D)) {
          paramCanvas.drawCircle(f3 - f5, f1 - this.L3, 10.0F, this.f);
        }
        f2 = this.M3;
        if ((f2 > 0.0F) && (f3 - f2 > this.W3 * 0.35D)) {
          paramCanvas.drawCircle(f3 - f2, f1 - this.N3, 4.0F, this.f);
        }
        f2 = this.O3;
        if ((f2 > 0.0F) && (f3 - f2 > this.W3 * 0.35D)) {
          paramCanvas.drawCircle(f3 - f2, f1 - this.P3, 6.0F, this.f);
        }
        f2 = this.Q3;
        if ((f2 > 0.0F) && (f3 - f2 > this.W3 * 0.35D)) {
          paramCanvas.drawCircle(f3 - f2, f1 - this.R3, 8.0F, this.f);
        }
      }
      float f3 = this.Q3;
      if (f3 > 0.0F)
      {
        f1 = this.W3;
        f2 = this.T3.right;
        int i = this.H3;
        if (f3 + f1 > f2 * (i - this.p0) / i) {
          q();
        }
      }
    }
  }
  
  private void l(Canvas paramCanvas)
  {
    this.c.setColor(this.x);
    RectF localRectF = this.T3;
    float f1 = this.W3;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.c);
    float f2;
    if (v())
    {
      f2 = this.T3.left;
      f1 = this.W3;
      paramCanvas.drawCircle(f2 + f1, f1 + getMeasuredHeight() * (1.0F - this.z) / 2.0F, this.W3 - 1.0F, this.d);
    }
    else
    {
      f1 = this.T3.right;
      f2 = this.W3;
      paramCanvas.drawCircle(f1 - f2, f2 + getMeasuredHeight() * (1.0F - this.z) / 2.0F, this.W3 - 1.0F, this.d);
    }
  }
  
  private void m(Canvas paramCanvas)
  {
    this.c.setColor(this.x);
    Object localObject = this.V3;
    float f1 = this.W3;
    paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.c);
    f1 = this.p0;
    float f2;
    if (f1 == 0.0F)
    {
      this.q.setShader(null);
      this.q.setColor(this.y);
    }
    else
    {
      f2 = this.H3;
      localObject = this.V3;
      float f3 = ((RectF)localObject).right;
      float f5 = ((RectF)localObject).left;
      localObject = this.T3;
      f2 = f2 * (f3 - f5) / (((RectF)localObject).right - ((RectF)localObject).left);
      if (f1 < f2)
      {
        f2 = f1 / (f2 + 0.0F);
        f1 = getMeasuredWidth();
        int i = this.x;
        int j = this.y;
        localObject = Shader.TileMode.CLAMP;
        localObject = new LinearGradient(0.0F, 0.0F, f1, 0.0F, new int[] { i, j }, new float[] { f2, f2 + 0.001F }, (Shader.TileMode)localObject);
        this.q.setShader((Shader)localObject);
      }
      else
      {
        this.q.setShader(null);
        this.q.setColor(this.x);
      }
    }
    localObject = this.V3;
    f1 = this.W3;
    paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.q);
    if (v())
    {
      f1 = this.V3.left;
      f2 = this.W3;
      paramCanvas.drawCircle(f1 + f2, f2 + getMeasuredHeight() * (1.0F - this.z) / 2.0F, this.W3 - 1.0F, this.d);
    }
    else
    {
      f2 = this.V3.right;
      f1 = this.W3;
      paramCanvas.drawCircle(f2 - f1, f1 + getMeasuredHeight() * (1.0F - this.z) / 2.0F, this.W3 - 1.0F, this.d);
    }
  }
  
  private void n(Canvas paramCanvas)
  {
    float f1 = this.p0 / (this.H3 + 0.0F);
    float f2;
    int i;
    int j;
    if (v())
    {
      f2 = getMeasuredWidth();
      i = this.x;
      j = this.y;
      localObject = Shader.TileMode.CLAMP;
      localObject = new LinearGradient(f2, 0.0F, 0.0F, 0.0F, new int[] { i, j }, new float[] { f1, f1 + 0.001F }, (Shader.TileMode)localObject);
    }
    else
    {
      f2 = getMeasuredWidth();
      i = this.x;
      j = this.y;
      localObject = Shader.TileMode.CLAMP;
      localObject = new LinearGradient(0.0F, 0.0F, f2, 0.0F, new int[] { i, j }, new float[] { f1, f1 + 0.001F }, (Shader.TileMode)localObject);
    }
    this.q.setColor(this.x);
    this.q.setShader((Shader)localObject);
    Object localObject = this.T3;
    f1 = this.W3;
    paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.q);
  }
  
  private void o(Canvas paramCanvas)
  {
    float f1 = this.W3;
    paramCanvas.drawCircle(getMeasuredWidth() / 2.0F, getMeasuredHeight() / 2.0F, f1 - 1.0F + f1 * 2.5F * 0.3F, this.d);
  }
  
  private void p(Canvas paramCanvas)
  {
    int i = this.f4;
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              o(paramCanvas);
            }
          }
          else {
            j(paramCanvas);
          }
        }
        else {
          m(paramCanvas);
        }
      }
      else
      {
        n(paramCanvas);
        k(paramCanvas);
        l(paramCanvas);
      }
    }
    else {
      i(paramCanvas);
    }
  }
  
  private void q()
  {
    this.d4 = false;
    this.Y3.cancel();
    float f1 = this.p2;
    float f2 = this.p0;
    int i = this.J3;
    if (f1 >= i + f2) {
      setInterTargetProgress((int)((f1 - f2) / i) * i + f2);
    }
  }
  
  private void r()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.c4 = localValueAnimator;
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.c4.addUpdateListener(new r(this));
    this.c4.addListener(new a());
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1005.0F }).setDuration(2000L);
    this.Y3 = localValueAnimator;
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.Y3.addUpdateListener(new o(this));
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.Z3 = localValueAnimator;
    localValueAnimator.addUpdateListener(new s(this));
    this.Z3.addListener(new b());
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(1000L);
    this.a4 = localValueAnimator;
    localValueAnimator.addUpdateListener(new q(this));
    this.a4.addListener(new c());
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 130.0F }).setDuration(1300L);
    this.b4 = localValueAnimator;
    localValueAnimator.addUpdateListener(new p(this));
    this.b4.addListener(new d());
  }
  
  private void s(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPDownloadProgressView);
    this.x = paramContext.getColor(x0.TPDownloadProgressView_dl_progressbtn_backgroud_color, Color.parseColor("#FFcb00"));
    this.y = paramContext.getColor(x0.TPDownloadProgressView_dl_progressbtn_backgroud_second_color, -1);
    paramContext.recycle();
  }
  
  private void setInterTargetProgress(float paramFloat)
  {
    int i = this.I3;
    if ((paramFloat >= i) && (paramFloat <= this.H3))
    {
      this.p1 = paramFloat;
      paramFloat -= this.p0;
      this.p3 = paramFloat;
      this.Z3.setDuration((paramFloat * 150.0F));
      this.Z3.start();
    }
    else if (paramFloat < i)
    {
      this.p0 = 0.0F;
    }
    else if (paramFloat > this.H3)
    {
      this.p0 = 100.0F;
      invalidate();
    }
  }
  
  private void setState(int paramInt)
  {
    this.f4 = paramInt;
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt == 5) {
          invalidate();
        }
      }
      else {
        this.b4.start();
      }
    }
    else
    {
      if ((this.Y3.isStarted()) || (this.Y3.isRunning())) {
        this.Y3.cancel();
      }
      if ((this.Z3.isStarted()) || (this.Z3.isRunning())) {
        this.Z3.cancel();
      }
      this.a4.start();
    }
  }
  
  private void t()
  {
    if (this.W3 == 0.0F) {
      this.W3 = (getMeasuredHeight() * this.z / 2.0F);
    }
    RectF localRectF = this.T3;
    localRectF.left = 2.0F;
    localRectF.top = (getMeasuredHeight() * (1.0F - this.z) / 2.0F + 2.0F);
    this.T3.right = (getMeasuredWidth() - 2);
    this.T3.bottom = (getMeasuredHeight() * (this.z + 1.0F) / 2.0F - 2.0F);
  }
  
  private void u()
  {
    Paint localPaint = new Paint();
    this.c = localPaint;
    localPaint.setAntiAlias(true);
    this.c.setStrokeWidth(3.0F);
    this.c.setStyle(Paint.Style.STROKE);
    localPaint = new Paint();
    this.q = localPaint;
    localPaint.setAntiAlias(true);
    this.q.setStyle(Paint.Style.FILL);
    localPaint = new Paint();
    this.d = localPaint;
    localPaint.setAntiAlias(true);
    this.d.setStyle(Paint.Style.FILL);
    this.d.setColor(this.x);
    localPaint = new Paint();
    this.f = localPaint;
    localPaint.setAntiAlias(true);
    this.f.setStyle(Paint.Style.FILL);
    this.f.setColor(this.x);
    this.f4 = 0;
    invalidate();
  }
  
  public int getMaxProgress()
  {
    return this.H3;
  }
  
  public int getMinProgress()
  {
    return this.I3;
  }
  
  public float getProgress()
  {
    return this.p0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.e4) {
      this.e4 = false;
    } else {
      p(paramCanvas);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.f4 = SavedState.a(paramParcelable);
    this.p0 = SavedState.b(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    return new SavedState(super.onSaveInstanceState(), (int)this.p0, this.f4);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    t();
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    invalidate();
  }
  
  public void setCircleColor(int paramInt)
  {
    this.d.setColor(paramInt);
    invalidate();
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.H3 = paramInt;
  }
  
  public void setMinProgress(int paramInt)
  {
    this.I3 = paramInt;
  }
  
  public void setOnMoveToCenterCallback(e parame)
  {
    this.h4 = parame;
  }
  
  public void setOnProgressListener(f paramf)
  {
    this.g4 = paramf;
  }
  
  public void setProgress(float paramFloat)
  {
    this.e4 = false;
    int i = this.I3;
    if ((paramFloat >= i) && (paramFloat <= this.H3))
    {
      if (this.p2 <= paramFloat) {
        this.p2 = paramFloat;
      }
      if (this.p2 >= this.p0 + this.J3) {
        G();
      }
    }
    else if (paramFloat < i)
    {
      this.p2 = i;
    }
    else
    {
      i = this.H3;
      if (paramFloat > i) {
        this.p2 = i;
      }
    }
  }
  
  protected boolean v()
  {
    int i = TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    private int c;
    private int d;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable, int paramInt1, int paramInt2)
    {
      super();
      this.c = paramInt1;
      this.d = paramInt2;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.d);
    }
    
    static final class a
      implements Parcelable.Creator<TPDownloadProgressV2View.SavedState>
    {
      public TPDownloadProgressV2View.SavedState a(Parcel paramParcel)
      {
        return new TPDownloadProgressV2View.SavedState(paramParcel, null);
      }
      
      public TPDownloadProgressV2View.SavedState[] b(int paramInt)
      {
        return new TPDownloadProgressV2View.SavedState[paramInt];
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
      TPDownloadProgressV2View.a(TPDownloadProgressV2View.this, 2);
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
      TPDownloadProgressV2View.b(TPDownloadProgressV2View.this).cancel();
      if ((TPDownloadProgressV2View.c(TPDownloadProgressV2View.this) >= TPDownloadProgressV2View.d(TPDownloadProgressV2View.this) + TPDownloadProgressV2View.e(TPDownloadProgressV2View.this)) && (!TPDownloadProgressV2View.f(TPDownloadProgressV2View.this).isRunning()))
      {
        TPDownloadProgressV2View.g(TPDownloadProgressV2View.this, true);
        TPDownloadProgressV2View.f(TPDownloadProgressV2View.this).start();
      }
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
      TPDownloadProgressV2View.a(TPDownloadProgressV2View.this, 4);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class d
    implements Animator.AnimatorListener
  {
    d() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPDownloadProgressV2View.a(TPDownloadProgressV2View.this, 5);
      if (TPDownloadProgressV2View.h(TPDownloadProgressV2View.this) != null) {
        TPDownloadProgressV2View.h(TPDownloadProgressV2View.this).a();
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  public static abstract interface e
  {
    public abstract void a();
  }
  
  public static abstract interface f
  {
    public abstract void a(float paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPDownloadProgressV2View.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */