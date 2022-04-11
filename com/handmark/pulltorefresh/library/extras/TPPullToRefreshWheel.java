package com.handmark.pulltorefresh.library.extras;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
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

public class TPPullToRefreshWheel
  extends View
{
  private static final String c = TPPullToRefreshWheel.class.getSimpleName();
  private double H3 = 0.0D;
  private float I3 = 0.0F;
  private float J3 = 0.0F;
  private boolean K3 = true;
  private long L3 = 0L;
  private int M3 = -11809834;
  private int N3 = 16777215;
  private Paint O3 = new Paint();
  private Paint P3 = new Paint();
  private RectF Q3 = new RectF();
  private float R3 = 230.0F;
  private long S3 = 0L;
  private boolean T3;
  private float U3 = 0.0F;
  private float V3 = 0.0F;
  private boolean W3 = false;
  private b X3;
  private boolean Y3;
  private boolean Z3 = false;
  private boolean a4 = false;
  private final int d = 16;
  private final int f = 270;
  private int p0 = 2;
  private boolean p1 = false;
  private double p2 = 0.0D;
  private double p3 = 460.0D;
  private final long q = 200L;
  private final int x = 360;
  private int y = 25;
  private int z = 2;
  
  public TPPullToRefreshWheel(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public TPPullToRefreshWheel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
    f();
  }
  
  private void a(long paramLong)
  {
    if (this.H3 == 0.0D) {
      this.H3 = this.p2;
    }
    double d1 = this.H3 + paramLong;
    this.H3 = d1;
    double d2 = this.p3;
    if (d1 >= d2) {
      this.H3 = d2;
    }
    this.J3 = (((float)Math.cos((this.H3 / d2 + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F) * 344.0F);
  }
  
  private void b()
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.z = ((int)TypedValue.applyDimension(1, this.z, localDisplayMetrics));
    this.p0 = ((int)TypedValue.applyDimension(1, this.p0, localDisplayMetrics));
    this.y = ((int)TypedValue.applyDimension(1, this.y, localDisplayMetrics));
  }
  
  private void c()
  {
    if (this.X3 != null)
    {
      float f1 = Math.round(this.U3 * 100.0F / 360.0F) / 100.0F;
      this.X3.a(f1);
    }
  }
  
  private void d(float paramFloat)
  {
    b localb = this.X3;
    if (localb != null) {
      localb.a(paramFloat);
    }
  }
  
  private void e(float paramFloat)
  {
    if (this.X3 != null)
    {
      paramFloat = Math.round(paramFloat * 100.0F / 360.0F) / 100.0F;
      this.X3.a(paramFloat);
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
    this.Y3 = bool;
  }
  
  private void g(int paramInt1, int paramInt2)
  {
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    if (!this.p1)
    {
      m = paramInt1 - k - m;
      paramInt1 = Math.min(Math.min(m, paramInt2 - j - i), this.y * 2 - this.z * 2);
      k = (m - paramInt1) / 2 + k;
      i = (paramInt2 - i - j - paramInt1) / 2 + i;
      paramInt2 = this.z;
      this.Q3 = new RectF(k + paramInt2, i + paramInt2, k + paramInt1 - paramInt2, i + paramInt1 - paramInt2);
    }
    else
    {
      int n = this.z;
      this.Q3 = new RectF(k + n, i + n, paramInt1 - m - n, paramInt2 - j - n);
    }
  }
  
  private void h()
  {
    this.O3.setColor(this.M3);
    this.O3.setAntiAlias(true);
    this.O3.setStyle(Paint.Style.STROKE);
    this.O3.setStrokeWidth(this.z);
    this.P3.setColor(this.N3);
    this.P3.setAntiAlias(true);
    this.P3.setStyle(Paint.Style.STROKE);
    this.P3.setStrokeWidth(this.p0);
  }
  
  private void k(long paramLong)
  {
    long l = this.L3;
    if (l >= 200L)
    {
      double d1 = this.p2 + paramLong;
      this.p2 = d1;
      double d2 = this.p3;
      if (d1 > d2)
      {
        this.p2 = (d1 - d2);
        this.L3 = 0L;
        this.K3 ^= true;
      }
      float f1 = (float)Math.cos((this.p2 / d2 + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
      if (this.K3)
      {
        this.I3 = (f1 * 254.0F);
      }
      else
      {
        f1 = (1.0F - f1) * 254.0F;
        this.U3 += this.I3 - f1;
        this.I3 = f1;
      }
    }
    else
    {
      this.L3 = (l + paramLong);
    }
  }
  
  public int getBarColor()
  {
    return this.M3;
  }
  
  public int getBarWidth()
  {
    return this.z;
  }
  
  public int getCircleRadius()
  {
    return this.y;
  }
  
  public float getProgress()
  {
    float f1;
    if (this.W3) {
      f1 = -1.0F;
    } else {
      f1 = this.U3 / 360.0F;
    }
    return f1;
  }
  
  public int getRimColor()
  {
    return this.N3;
  }
  
  public int getRimWidth()
  {
    return this.p0;
  }
  
  public float getSpinSpeed()
  {
    return this.R3 / 360.0F;
  }
  
  public void i()
  {
    this.S3 = SystemClock.uptimeMillis();
    this.W3 = true;
    invalidate();
  }
  
  public void j()
  {
    this.W3 = false;
    this.Z3 = false;
    this.U3 = 0.0F;
    this.V3 = 0.0F;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.Z3)
    {
      paramCanvas.drawArc(this.Q3, 360.0F, 360.0F, false, this.O3);
      return;
    }
    paramCanvas.drawArc(this.Q3, 360.0F, 360.0F, false, this.P3);
    if (!this.Y3) {
      return;
    }
    boolean bool = this.W3;
    int i = 1;
    int j = 1;
    int k = 1;
    long l;
    float f1;
    float f2;
    if (bool)
    {
      l = SystemClock.uptimeMillis() - this.S3;
      f1 = (float)l * this.R3 / 1000.0F;
      k(l);
      f1 = this.U3 + f1;
      this.U3 = f1;
      if (f1 > 360.0F)
      {
        this.U3 = (f1 - 360.0F);
        d(-1.0F);
      }
      this.S3 = SystemClock.uptimeMillis();
      f2 = this.U3;
      f1 = this.I3;
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
      paramCanvas.drawArc(this.Q3, f2, f1, false, this.O3);
      k = j;
    }
    else if (!this.a4)
    {
      float f3 = this.U3;
      if (f3 != this.V3)
      {
        f2 = (float)(SystemClock.uptimeMillis() - this.S3) / 1000.0F;
        f1 = this.R3;
        this.U3 = Math.min(this.U3 + f2 * f1, this.V3);
      }
      else
      {
        k = 0;
      }
      if (f3 != this.U3) {
        c();
      }
      f1 = this.U3;
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      paramCanvas.drawArc(this.Q3, -90.0F, f1, false, this.O3);
    }
    else
    {
      l = SystemClock.uptimeMillis() - this.S3;
      f1 = (float)l * this.R3 / 1000.0F;
      f1 = this.U3 + f1;
      this.U3 = f1;
      if (f1 > 360.0F) {
        this.U3 = (f1 - 360.0F);
      }
      f1 = this.I3;
      a(l);
      f1 = f1 + 16.0F + this.J3;
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      if (f1 >= 360.0F)
      {
        k = 0;
        f1 = 360.0F;
      }
      else
      {
        k = i;
      }
      e(f1);
      this.S3 = SystemClock.uptimeMillis();
      paramCanvas.drawArc(this.Q3, this.U3 - 90.0F, f1, false, this.O3);
    }
    if (k != 0) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = this.y + getPaddingLeft() + getPaddingRight();
    int j = this.y + getPaddingTop() + getPaddingBottom();
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
    this.U3 = paramParcelable.c;
    this.V3 = paramParcelable.d;
    this.W3 = paramParcelable.f;
    this.R3 = paramParcelable.q;
    this.z = paramParcelable.x;
    this.M3 = paramParcelable.y;
    this.p0 = paramParcelable.z;
    this.N3 = paramParcelable.p0;
    this.y = paramParcelable.p1;
    this.T3 = paramParcelable.p2;
    this.p1 = paramParcelable.p3;
    this.S3 = SystemClock.uptimeMillis();
  }
  
  public Parcelable onSaveInstanceState()
  {
    WheelSavedState localWheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.c = this.U3;
    localWheelSavedState.d = this.V3;
    localWheelSavedState.f = this.W3;
    localWheelSavedState.q = this.R3;
    localWheelSavedState.x = this.z;
    localWheelSavedState.y = this.M3;
    localWheelSavedState.z = this.p0;
    localWheelSavedState.p0 = this.N3;
    localWheelSavedState.p1 = this.y;
    localWheelSavedState.p2 = this.T3;
    localWheelSavedState.p3 = this.p1;
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
      this.S3 = SystemClock.uptimeMillis();
    }
  }
  
  public void setBarColor(int paramInt)
  {
    this.M3 = paramInt;
    h();
    if (!this.W3) {
      invalidate();
    }
  }
  
  public void setBarColorAfter(int paramInt)
  {
    this.M3 = paramInt;
    h();
    this.Z3 = true;
    if (!this.W3) {
      invalidate();
    }
  }
  
  public void setBarWidth(int paramInt)
  {
    this.z = paramInt;
    if (!this.W3) {
      invalidate();
    }
  }
  
  public void setCallback(b paramb)
  {
    this.X3 = paramb;
    if (!this.W3) {
      c();
    }
  }
  
  public void setCircleRadius(int paramInt)
  {
    this.y = paramInt;
    if (!this.W3) {
      invalidate();
    }
  }
  
  public void setInstantProgress(float paramFloat)
  {
    if (this.W3)
    {
      this.U3 = 0.0F;
      this.W3 = false;
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
    if (f1 == this.V3) {
      return;
    }
    paramFloat = Math.min(f1 * 360.0F, 360.0F);
    this.V3 = paramFloat;
    this.U3 = paramFloat;
    this.S3 = SystemClock.uptimeMillis();
    invalidate();
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    this.T3 = paramBoolean;
    if (!this.W3) {
      invalidate();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.W3)
    {
      this.W3 = false;
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
    paramFloat = this.V3;
    if (f1 == paramFloat) {
      return;
    }
    if (this.U3 == paramFloat) {
      this.S3 = SystemClock.uptimeMillis();
    }
    this.V3 = Math.min(f1 * 360.0F, 360.0F);
    invalidate();
  }
  
  public void setRimColor(int paramInt)
  {
    this.N3 = paramInt;
    h();
    if (!this.W3) {
      invalidate();
    }
  }
  
  public void setRimWidth(int paramInt)
  {
    this.p0 = paramInt;
    if (!this.W3) {
      invalidate();
    }
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.R3 = (paramFloat * 360.0F);
  }
  
  static class WheelSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<WheelSavedState> CREATOR = new a();
    float c;
    float d;
    boolean f;
    int p0;
    int p1;
    boolean p2;
    boolean p3;
    float q;
    int x;
    int y;
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
      this.q = paramParcel.readFloat();
      this.x = paramParcel.readInt();
      this.y = paramParcel.readInt();
      this.z = paramParcel.readInt();
      this.p0 = paramParcel.readInt();
      this.p1 = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.p2 = bool2;
      if (paramParcel.readByte() != 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      this.p3 = bool2;
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
      paramParcel.writeFloat(this.q);
      paramParcel.writeInt(this.x);
      paramParcel.writeInt(this.y);
      paramParcel.writeInt(this.z);
      paramParcel.writeInt(this.p0);
      paramParcel.writeInt(this.p1);
      paramParcel.writeByte((byte)this.p2);
      paramParcel.writeByte((byte)this.p3);
    }
    
    static final class a
      implements Parcelable.Creator<TPPullToRefreshWheel.WheelSavedState>
    {
      public TPPullToRefreshWheel.WheelSavedState a(Parcel paramParcel)
      {
        return new TPPullToRefreshWheel.WheelSavedState(paramParcel, null);
      }
      
      public TPPullToRefreshWheel.WheelSavedState[] b(int paramInt)
      {
        return new TPPullToRefreshWheel.WheelSavedState[paramInt];
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(float paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\extras\TPPullToRefreshWheel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */