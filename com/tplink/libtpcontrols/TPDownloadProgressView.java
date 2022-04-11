package com.tplink.libtpcontrols;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
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

public class TPDownloadProgressView
  extends View
{
  private int H3;
  private float I3;
  private float J3;
  private float K3;
  private float L3;
  private float M3;
  private float N3;
  private float O3;
  private float P3;
  private float Q3;
  private float R3;
  private float S3;
  private RectF T3;
  private RectF U3 = new RectF();
  private RectF V3 = new RectF();
  private ValueAnimator W3;
  private ValueAnimator X3;
  private ValueAnimator Y3;
  private ValueAnimator Z3;
  private ValueAnimator a4;
  private boolean b4 = false;
  private Paint c;
  private boolean c4 = false;
  private Paint d;
  private boolean d4 = true;
  private int e4;
  private Paint f;
  private c f4 = null;
  private b g4 = null;
  private float p0;
  private float p1;
  private float p2;
  private int p3;
  private Paint q;
  private int x;
  private int y;
  private float z = 0.4F;
  
  public TPDownloadProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPDownloadProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (!isInEditMode())
    {
      c(paramContext, paramAttributeSet);
      b();
      n();
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    this.T3 = new RectF();
    if (this.I3 == 0.0F) {
      this.I3 = (getMeasuredHeight() * this.z / 2.0F);
    }
    Object localObject = this.T3;
    ((RectF)localObject).left = 2.0F;
    ((RectF)localObject).top = (getMeasuredHeight() * (1.0F - this.z) / 2.0F + 2.0F);
    this.T3.right = (getMeasuredWidth() - 2);
    this.T3.bottom = (getMeasuredHeight() * (this.z + 1.0F) / 2.0F - 2.0F);
    int i = this.e4;
    float f1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          if (!this.c4)
          {
            this.c.setColor(this.x);
            localObject = this.V3;
            f1 = this.I3;
            paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.c);
            this.q.setShader(null);
            this.q.setColor(this.x);
            localObject = this.V3;
            f1 = this.I3;
            paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.q);
          }
          else
          {
            paramCanvas.drawCircle(this.I3 + this.S3, getMeasuredHeight() / 2.0F, this.J3, this.d);
          }
        }
      }
      else
      {
        float f2 = this.p0 / (this.p3 + 0.0F);
        f1 = getMeasuredWidth();
        int j = this.x;
        i = this.y;
        localObject = Shader.TileMode.CLAMP;
        localObject = new LinearGradient(0.0F, 0.0F, f1, 0.0F, new int[] { j, i }, new float[] { f2, f2 + 0.001F }, (Shader.TileMode)localObject);
        this.q.setShader((Shader)localObject);
        this.q.setColor(this.x);
        this.q.setShader((Shader)localObject);
        localObject = this.T3;
        f1 = this.I3;
        paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.q);
        if (this.b4)
        {
          double d1 = this.T3.right;
          f2 = this.I3;
          f1 = (float)(d1 - f2 * 1.5D);
          f2 += getMeasuredHeight() * (1.0F - this.z) / 2.0F;
          float f3 = this.K3;
          if ((f3 > 0.0F) && (f1 - f3 > this.I3 * 0.35D)) {
            paramCanvas.drawCircle(f1 - f3, f2 - this.L3, 10.0F, this.f);
          }
          f3 = this.M3;
          if ((f3 > 0.0F) && (f1 - f3 > this.I3 * 0.35D)) {
            paramCanvas.drawCircle(f1 - f3, f2 - this.N3, 4.0F, this.f);
          }
          f3 = this.O3;
          if ((f3 > 0.0F) && (f1 - f3 > this.I3 * 0.35D)) {
            paramCanvas.drawCircle(f1 - f3, f2 - this.P3, 6.0F, this.f);
          }
          f3 = this.Q3;
          if ((f3 > 0.0F) && (f1 - f3 > this.I3 * 0.35D)) {
            paramCanvas.drawCircle(f1 - f3, f2 - this.R3, 8.0F, this.f);
          }
          float f5 = this.Q3;
          if (f5 > 0.0F)
          {
            float f6 = this.I3;
            f1 = this.T3.right;
            i = this.p3;
            f3 = i;
            f2 = this.p0;
            if (f5 + f6 > f1 * (f3 - f2) / i)
            {
              this.b4 = false;
              if (this.p2 >= f2 + 10.0F) {
                setTargetProgress((int)(f2 / 10.0F) * 10 + 10);
              }
            }
          }
        }
        this.c.setColor(this.x);
        localObject = this.T3;
        f1 = this.I3;
        paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.c);
        f2 = this.T3.right;
        f1 = this.I3;
        paramCanvas.drawCircle(f2 - f1, f1 + getMeasuredHeight() * (1.0F - this.z) / 2.0F, this.I3 - 1.0F, this.d);
      }
    }
    else
    {
      if (this.q.getShader() != null) {
        this.q.setShader(null);
      }
      this.q.setColor(this.y);
      localObject = this.U3;
      f1 = this.I3;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.q);
      this.c.setColor(this.x);
      localObject = this.U3;
      f1 = this.I3;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.c);
      paramCanvas.drawCircle(this.I3 + 2.0F + this.S3, getMeasuredHeight() / 2.0F, this.J3, this.d);
    }
  }
  
  private void b()
  {
    this.p3 = 100;
    this.H3 = 0;
    this.p0 = 0.0F;
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
    this.e4 = 0;
    invalidate();
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPDownloadProgressView);
    this.x = paramContext.getColor(x0.TPDownloadProgressView_dl_progressbtn_backgroud_color, Color.parseColor("#FFcb00"));
    this.y = paramContext.getColor(x0.TPDownloadProgressView_dl_progressbtn_backgroud_second_color, -1);
    paramContext.recycle();
  }
  
  private void n()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1005.0F }).setDuration(2000L);
    this.W3 = localValueAnimator;
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.W3.setRepeatMode(1);
    this.W3.addUpdateListener(new x(this));
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(1500L);
    this.X3 = localValueAnimator;
    localValueAnimator.setRepeatMode(1);
    this.X3.addUpdateListener(new t(this));
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(1000L);
    this.Y3 = localValueAnimator;
    localValueAnimator.addUpdateListener(new u(this));
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 130.0F }).setDuration(1300L);
    this.Z3 = localValueAnimator;
    localValueAnimator.addUpdateListener(new w(this));
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 130.0F }).setDuration(1300L);
    this.a4 = localValueAnimator;
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.a4.addUpdateListener(new v(this));
  }
  
  @TargetApi(19)
  private void setTargetProgress(float paramFloat)
  {
    int i = this.H3;
    if ((paramFloat >= i) && (paramFloat <= this.p3))
    {
      this.p1 = paramFloat;
      this.X3.start();
    }
    else if (paramFloat < i)
    {
      this.p0 = 0.0F;
    }
    else if (paramFloat > this.p3)
    {
      this.p0 = 100.0F;
      invalidate();
    }
  }
  
  public int getMaxProgress()
  {
    return this.p3;
  }
  
  public int getMinProgress()
  {
    return this.H3;
  }
  
  public float getProgress()
  {
    return this.p0;
  }
  
  public int getState()
  {
    return this.e4;
  }
  
  public void o()
  {
    int i = this.e4;
    if (i == 2)
    {
      this.b4 = false;
      this.W3.cancel();
      invalidate();
    }
    else if (i == 0)
    {
      this.b4 = false;
      this.W3.cancel();
      invalidate();
    }
    else if ((i == 1) && (!this.W3.isRunning()) && (!this.X3.isRunning()))
    {
      this.b4 = true;
      this.W3.start();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.d4)
    {
      this.d4 = false;
      this.a4.start();
    }
    else if (!isInEditMode())
    {
      a(paramCanvas);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.e4 = SavedState.a(paramParcelable);
    this.p0 = SavedState.b(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    return new SavedState(super.onSaveInstanceState(), (int)this.p0, this.e4);
  }
  
  public void setCircleColor(int paramInt)
  {
    this.d.setColor(paramInt);
    invalidate();
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.p3 = paramInt;
  }
  
  public void setMinProgress(int paramInt)
  {
    this.H3 = paramInt;
  }
  
  public void setOnDownloadCompleteListener(b paramb)
  {
    this.g4 = paramb;
  }
  
  public void setOnProgressListener(c paramc)
  {
    this.f4 = paramc;
  }
  
  public void setProgress(float paramFloat)
  {
    this.p0 = paramFloat;
  }
  
  public void setState(int paramInt)
  {
    this.e4 = paramInt;
    if (paramInt == 2) {
      this.Y3.start();
    } else if (paramInt == 0) {
      invalidate();
    }
  }
  
  public void setToProgress(float paramFloat)
  {
    int i = this.H3;
    if ((paramFloat >= i) && (paramFloat <= this.p3))
    {
      if (this.p2 < paramFloat) {
        this.p2 = paramFloat;
      }
      if (this.p2 >= this.p0 + 10.0F) {
        o();
      }
    }
    else if (paramFloat < i)
    {
      this.p2 = 0.0F;
    }
    else if (paramFloat > this.p3)
    {
      this.p2 = 100.0F;
    }
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
      implements Parcelable.Creator<TPDownloadProgressView.SavedState>
    {
      public TPDownloadProgressView.SavedState a(Parcel paramParcel)
      {
        return new TPDownloadProgressView.SavedState(paramParcel, null);
      }
      
      public TPDownloadProgressView.SavedState[] b(int paramInt)
      {
        return new TPDownloadProgressView.SavedState[paramInt];
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onComplete();
  }
  
  public static abstract interface c
  {
    public abstract void a(float paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPDownloadProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */