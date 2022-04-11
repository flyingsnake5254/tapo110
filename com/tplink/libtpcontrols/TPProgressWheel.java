package com.tplink.libtpcontrols;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import androidx.annotation.NonNull;

public class TPProgressWheel
  extends View
{
  private long H3 = 0L;
  private int I3 = -1426063361;
  private int J3 = 0;
  private Paint K3 = new Paint();
  private Paint L3 = new Paint();
  private RectF M3 = new RectF();
  private float N3 = 480.0F;
  private long O3 = 0L;
  private boolean P3;
  private float Q3 = 0.0F;
  private float R3 = 0.0F;
  private boolean S3 = false;
  private b T3;
  private boolean U3;
  private boolean V3 = false;
  private boolean W3 = false;
  private final int c = 16;
  private int d = 28;
  private int f = 4;
  private double p0 = 0.0D;
  private float p1 = 0.0F;
  private float p2 = 0.0F;
  private boolean p3 = true;
  private int q = 4;
  private boolean x = false;
  private double y = 0.0D;
  private double z = 360.0D;
  
  public TPProgressWheel(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public TPProgressWheel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPProgressWheel));
    f();
  }
  
  private void a(long paramLong)
  {
    if (this.p0 == 0.0D) {
      this.p0 = this.y;
    }
    double d1 = this.p0 + paramLong;
    this.p0 = d1;
    double d2 = this.z;
    if (d1 >= d2) {
      this.p0 = d2;
    }
    this.p1 = (((float)Math.cos((this.p0 / d2 + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F) * 344.0F);
  }
  
  private void b(TypedArray paramTypedArray)
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.f = ((int)TypedValue.applyDimension(1, this.f, localDisplayMetrics));
    this.q = ((int)TypedValue.applyDimension(1, this.q, localDisplayMetrics));
    int i = (int)TypedValue.applyDimension(1, this.d, localDisplayMetrics);
    this.d = i;
    this.d = ((int)paramTypedArray.getDimension(x0.TPProgressWheel_matProg_circleRadius, i));
    this.x = paramTypedArray.getBoolean(x0.TPProgressWheel_matProg_fillRadius, false);
    this.f = ((int)paramTypedArray.getDimension(x0.TPProgressWheel_matProg_barWidth, this.f));
    this.q = ((int)paramTypedArray.getDimension(x0.TPProgressWheel_matProg_rimWidth, this.q));
    this.N3 = (paramTypedArray.getFloat(x0.TPProgressWheel_matProg_spinSpeed, this.N3 / 360.0F) * 360.0F);
    this.z = paramTypedArray.getInt(x0.TPProgressWheel_matProg_barSpinCycleTime, (int)this.z);
    this.I3 = paramTypedArray.getColor(x0.TPProgressWheel_matProg_barColor, this.I3);
    this.J3 = paramTypedArray.getColor(x0.TPProgressWheel_matProg_rimColor, this.J3);
    this.P3 = paramTypedArray.getBoolean(x0.TPProgressWheel_matProg_linearProgress, false);
    if (paramTypedArray.getBoolean(x0.TPProgressWheel_matProg_progressIndeterminate, false)) {
      i();
    }
    paramTypedArray.recycle();
  }
  
  private void c()
  {
    if (this.T3 != null)
    {
      float f1 = Math.round(this.Q3 * 100.0F / 360.0F) / 100.0F;
      this.T3.a(f1);
    }
  }
  
  private void d(float paramFloat)
  {
    b localb = this.T3;
    if (localb != null) {
      localb.a(paramFloat);
    }
  }
  
  private void e(float paramFloat)
  {
    if (this.T3 != null)
    {
      paramFloat = Math.round(paramFloat * 100.0F / 360.0F) / 100.0F;
      this.T3.a(paramFloat);
    }
  }
  
  @TargetApi(17)
  private void f()
  {
    float f1;
    if (Build.VERSION.SDK_INT >= 17) {
      f1 = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
    } else {
      f1 = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
    }
    boolean bool;
    if (f1 != 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    this.U3 = bool;
  }
  
  private void g(int paramInt1, int paramInt2)
  {
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    int n;
    if (!this.x)
    {
      n = paramInt1 - k - m;
      paramInt1 = Math.min(Math.min(n, paramInt2 - j - i), this.d * 2 - this.f * 2);
      k = (n - paramInt1) / 2 + k;
      j = (paramInt2 - i - j - paramInt1) / 2 + i;
      paramInt2 = this.f;
      this.M3 = new RectF(k + paramInt2, j + paramInt2, k + paramInt1 - paramInt2, j + paramInt1 - paramInt2);
    }
    else
    {
      n = this.f;
      this.M3 = new RectF(k + n, i + n, paramInt1 - m - n, paramInt2 - j - n);
    }
  }
  
  private void h()
  {
    this.K3.setColor(this.I3);
    this.K3.setAntiAlias(true);
    this.K3.setStyle(Paint.Style.STROKE);
    this.K3.setStrokeWidth(this.f);
    this.L3.setColor(this.J3);
    this.L3.setAntiAlias(true);
    this.L3.setStyle(Paint.Style.STROKE);
    this.L3.setStrokeWidth(this.q);
  }
  
  private void j(long paramLong)
  {
    long l = this.H3;
    if (l >= 120L)
    {
      double d1 = this.y + paramLong;
      this.y = d1;
      double d2 = this.z;
      if (d1 > d2)
      {
        this.y = (d1 - d2);
        this.H3 = 0L;
        this.p3 ^= true;
      }
      float f1 = (float)Math.cos((this.y / d2 + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
      if (this.p3)
      {
        this.p2 = (f1 * 254.0F);
      }
      else
      {
        f1 = (1.0F - f1) * 254.0F;
        this.Q3 += this.p2 - f1;
        this.p2 = f1;
      }
    }
    else
    {
      this.H3 = (l + paramLong);
    }
  }
  
  public int getBarColor()
  {
    return this.I3;
  }
  
  public int getBarWidth()
  {
    return this.f;
  }
  
  public int getCircleRadius()
  {
    return this.d;
  }
  
  public float getProgress()
  {
    float f1;
    if (this.S3) {
      f1 = -1.0F;
    } else {
      f1 = this.Q3 / 360.0F;
    }
    return f1;
  }
  
  public int getRimColor()
  {
    return this.J3;
  }
  
  public int getRimWidth()
  {
    return this.q;
  }
  
  public float getSpinSpeed()
  {
    return this.N3 / 360.0F;
  }
  
  public void i()
  {
    this.O3 = SystemClock.uptimeMillis();
    this.S3 = true;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.V3)
    {
      paramCanvas.drawArc(this.M3, 360.0F, 360.0F, false, this.K3);
      return;
    }
    paramCanvas.drawArc(this.M3, 360.0F, 360.0F, false, this.L3);
    if (!this.U3) {
      return;
    }
    boolean bool = this.S3;
    float f1 = 0.0F;
    int i = 1;
    int j = 1;
    int k = 1;
    long l;
    float f2;
    if (bool)
    {
      l = SystemClock.uptimeMillis() - this.O3;
      f2 = (float)l * this.N3 / 1000.0F;
      j(l);
      f2 = this.Q3 + f2;
      this.Q3 = f2;
      if (f2 > 360.0F)
      {
        this.Q3 = (f2 - 360.0F);
        d(-1.0F);
      }
      this.O3 = SystemClock.uptimeMillis();
      f2 = this.Q3;
      f1 = this.p2;
      if (isInEditMode())
      {
        f2 = 0.0F;
        f1 = 135.0F;
      }
      else
      {
        f2 -= 90.0F;
        f1 += 16.0F;
      }
      paramCanvas.drawArc(this.M3, f2, f1, false, this.K3);
      k = j;
    }
    else if (!this.W3)
    {
      float f3 = this.Q3;
      if (f3 != this.R3)
      {
        f2 = (float)(SystemClock.uptimeMillis() - this.O3) / 1000.0F;
        float f4 = this.N3;
        this.Q3 = Math.min(this.Q3 + f2 * f4, this.R3);
      }
      else
      {
        k = 0;
      }
      if (f3 != this.Q3) {
        c();
      }
      f3 = this.Q3;
      f2 = f3;
      if (!this.P3)
      {
        f1 = (float)(1.0D - Math.pow(1.0F - f3 / 360.0F, 4.0F));
        f2 = (float)(1.0D - Math.pow(1.0F - this.Q3 / 360.0F, 2.0F));
        f1 *= 360.0F;
        f2 *= 360.0F;
      }
      if (isInEditMode()) {
        f2 = 360.0F;
      }
      paramCanvas.drawArc(this.M3, f1 - 90.0F, f2, false, this.K3);
    }
    else
    {
      l = SystemClock.uptimeMillis() - this.O3;
      f2 = (float)l * this.N3 / 1000.0F;
      f2 = this.Q3 + f2;
      this.Q3 = f2;
      if (f2 > 360.0F) {
        this.Q3 = (f2 - 360.0F);
      }
      f2 = this.p2;
      a(l);
      f2 = f2 + 16.0F + this.p1;
      if (isInEditMode()) {
        f2 = 360.0F;
      }
      if (f2 >= 360.0F)
      {
        k = 0;
        f2 = 360.0F;
      }
      else
      {
        k = i;
      }
      e(f2);
      this.O3 = SystemClock.uptimeMillis();
      paramCanvas.drawArc(this.M3, this.Q3 - 90.0F, f2, false, this.K3);
    }
    if (k != 0) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = this.d + getPaddingLeft() + getPaddingRight();
    int j = this.d + getPaddingTop() + getPaddingBottom();
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    if (k == 1073741824)
    {
      paramInt1 = m;
    }
    else
    {
      paramInt1 = i;
      if (k == Integer.MIN_VALUE) {
        paramInt1 = Math.min(i, m);
      }
    }
    if ((n != 1073741824) && (k != 1073741824))
    {
      paramInt2 = j;
      if (n == Integer.MIN_VALUE) {
        paramInt2 = Math.min(j, i1);
      }
    }
    else
    {
      paramInt2 = i1;
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof WheelSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (WheelSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Q3 = paramParcelable.c;
    this.R3 = paramParcelable.d;
    this.S3 = paramParcelable.f;
    this.V3 = paramParcelable.q;
    this.W3 = paramParcelable.x;
    this.N3 = paramParcelable.y;
    this.f = paramParcelable.z;
    this.I3 = paramParcelable.p0;
    this.q = paramParcelable.p1;
    this.J3 = paramParcelable.p2;
    this.d = paramParcelable.p3;
    this.P3 = paramParcelable.H3;
    this.x = paramParcelable.I3;
    this.O3 = SystemClock.uptimeMillis();
  }
  
  public Parcelable onSaveInstanceState()
  {
    WheelSavedState localWheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.c = this.Q3;
    localWheelSavedState.d = this.R3;
    localWheelSavedState.f = this.S3;
    localWheelSavedState.q = this.V3;
    localWheelSavedState.x = this.W3;
    localWheelSavedState.y = this.N3;
    localWheelSavedState.z = this.f;
    localWheelSavedState.p0 = this.I3;
    localWheelSavedState.p1 = this.q;
    localWheelSavedState.p2 = this.J3;
    localWheelSavedState.p3 = this.d;
    localWheelSavedState.H3 = this.P3;
    localWheelSavedState.I3 = this.x;
    return localWheelSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    g(paramInt1, paramInt2);
    h();
    invalidate();
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      this.O3 = SystemClock.uptimeMillis();
    }
  }
  
  public void setBarColor(int paramInt)
  {
    this.I3 = paramInt;
    h();
    if (!this.S3) {
      invalidate();
    }
  }
  
  public void setBarColorAfter(int paramInt)
  {
    this.I3 = paramInt;
    h();
    this.V3 = true;
    if (!this.S3) {
      invalidate();
    }
  }
  
  public void setBarWidth(int paramInt)
  {
    this.f = paramInt;
    if (!this.S3) {
      invalidate();
    }
  }
  
  public void setCallback(b paramb)
  {
    this.T3 = paramb;
    if (!this.S3) {
      c();
    }
  }
  
  public void setCircleRadius(int paramInt)
  {
    this.d = paramInt;
    if (!this.S3) {
      requestLayout();
    }
  }
  
  public void setInstantProgress(float paramFloat)
  {
    if (this.S3)
    {
      this.Q3 = 0.0F;
      this.S3 = false;
    }
    float f1;
    if (paramFloat > 1.0F)
    {
      f1 = paramFloat - 1.0F;
    }
    else
    {
      f1 = paramFloat;
      if (paramFloat < 0.0F) {
        f1 = 0.0F;
      }
    }
    if (f1 == this.R3) {
      return;
    }
    paramFloat = Math.min(f1 * 360.0F, 360.0F);
    this.R3 = paramFloat;
    this.Q3 = paramFloat;
    this.O3 = SystemClock.uptimeMillis();
    invalidate();
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    this.P3 = paramBoolean;
    if (!this.S3) {
      invalidate();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.S3)
    {
      this.S3 = false;
      c();
    }
    float f1;
    if (paramFloat > 1.0F)
    {
      f1 = paramFloat - 1.0F;
    }
    else
    {
      f1 = paramFloat;
      if (paramFloat < 0.0F) {
        f1 = 0.0F;
      }
    }
    paramFloat = this.R3;
    if (f1 == paramFloat) {
      return;
    }
    if (this.Q3 == paramFloat) {
      this.O3 = SystemClock.uptimeMillis();
    }
    this.R3 = Math.min(f1 * 360.0F, 360.0F);
    invalidate();
  }
  
  public void setRimColor(int paramInt)
  {
    this.J3 = paramInt;
    h();
    if (!this.S3) {
      invalidate();
    }
  }
  
  public void setRimWidth(int paramInt)
  {
    this.q = paramInt;
    if (!this.S3) {
      invalidate();
    }
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.N3 = (paramFloat * 360.0F);
  }
  
  static class WheelSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<WheelSavedState> CREATOR = new a();
    boolean H3;
    boolean I3;
    float c;
    float d;
    boolean f;
    int p0;
    int p1;
    int p2;
    int p3;
    boolean q;
    boolean x;
    float y;
    int z;
    
    private WheelSavedState(Parcel paramParcel)
    {
      super();
      this.c = paramParcel.readFloat();
      this.d = paramParcel.readFloat();
      int i = paramParcel.readByte();
      boolean bool1 = true;
      boolean bool2;
      if (i != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.f = bool2;
      if (paramParcel.readByte() != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.q = bool2;
      if (paramParcel.readByte() != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.x = bool2;
      this.y = paramParcel.readFloat();
      this.z = paramParcel.readInt();
      this.p0 = paramParcel.readInt();
      this.p1 = paramParcel.readInt();
      this.p2 = paramParcel.readInt();
      this.p3 = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.H3 = bool2;
      if (paramParcel.readByte() != 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      this.I3 = bool2;
    }
    
    WheelSavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeFloat(this.c);
      paramParcel.writeFloat(this.d);
      paramParcel.writeByte((byte)this.f);
      paramParcel.writeByte((byte)this.q);
      paramParcel.writeByte((byte)this.x);
      paramParcel.writeFloat(this.y);
      paramParcel.writeInt(this.z);
      paramParcel.writeInt(this.p0);
      paramParcel.writeInt(this.p1);
      paramParcel.writeInt(this.p2);
      paramParcel.writeInt(this.p3);
      paramParcel.writeByte((byte)this.H3);
      paramParcel.writeByte((byte)this.I3);
    }
    
    static final class a
      implements Parcelable.Creator<TPProgressWheel.WheelSavedState>
    {
      public TPProgressWheel.WheelSavedState a(Parcel paramParcel)
      {
        return new TPProgressWheel.WheelSavedState(paramParcel, null);
      }
      
      public TPProgressWheel.WheelSavedState[] b(int paramInt)
      {
        return new TPProgressWheel.WheelSavedState[paramInt];
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(float paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPProgressWheel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */