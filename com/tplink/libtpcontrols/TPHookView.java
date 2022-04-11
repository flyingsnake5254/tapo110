package com.tplink.libtpcontrols;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;

public class TPHookView
  extends View
{
  private static final int c = Color.rgb(255, 255, 255);
  private static final int d = Color.rgb(74, 203, 214);
  private int H3 = 12;
  private Paint I3;
  private Paint J3;
  private c K3;
  private c L3;
  private c M3;
  private c N3;
  private c O3;
  private ValueAnimator P3;
  private int Q3;
  private b R3 = null;
  private float f = 550.0F;
  private int p0 = 0;
  private float p1;
  private int p2 = 8;
  private int p3 = 8;
  private float q = 550.0F;
  private boolean x = true;
  private boolean y = false;
  private int z = 0;
  
  public TPHookView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPHookView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPHookView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPHookView);
    this.Q3 = paramContext.getColor(x0.TPHookView_hook_line_color, d);
    paramContext.recycle();
    b();
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.f, this.q, this.p1, this.I3);
  }
  
  private void b()
  {
    this.f = (getPaddingLeft() + getWidth() / 2.0F);
    this.q = (getPaddingTop() + getHeight() / 2.0F);
    this.p1 = Math.min(getWidth() / 2, getHeight() / 2);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 }).setDuration(400L);
    this.P3 = localValueAnimator;
    localValueAnimator.setInterpolator(new LinearInterpolator());
    this.P3.addUpdateListener(new d0(this));
    c();
    d();
  }
  
  private int g(int paramInt, boolean paramBoolean)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    int k;
    if (paramBoolean)
    {
      k = getPaddingLeft();
      paramInt = getPaddingRight();
    }
    else
    {
      k = getPaddingTop();
      paramInt = getPaddingBottom();
    }
    if (i == 1073741824)
    {
      paramInt = j;
    }
    else
    {
      int m;
      if (paramBoolean) {
        m = getSuggestedMinimumWidth();
      } else {
        m = getSuggestedMinimumHeight();
      }
      paramInt = m + (k + paramInt);
      if (i == Integer.MIN_VALUE) {
        if (paramBoolean) {
          paramInt = Math.max(paramInt, j);
        } else {
          paramInt = Math.min(paramInt, j);
        }
      }
    }
    return paramInt;
  }
  
  private void i(Canvas paramCanvas)
  {
    int i = this.z;
    int j = this.p3;
    c localc1;
    c localc2;
    float f1;
    c localc3;
    float f2;
    int k;
    if (i <= j)
    {
      localc1 = this.N3;
      localc2 = this.K3;
      f1 = localc2.a;
      localc3 = this.L3;
      f2 = localc3.a;
      k = this.p2;
      f1 += (f2 + k / 3.0F - f1) * i / j;
      localc1.a = f1;
      f2 = localc2.b;
      f2 += (localc3.b + k / 3.0F - f2) * i / j;
      localc1.b = f2;
      paramCanvas.drawLine(localc2.a, localc2.b, f1, f2, this.J3);
    }
    else
    {
      localc1 = this.O3;
      localc2 = this.L3;
      float f3 = localc2.a;
      localc3 = this.M3;
      f2 = localc3.a;
      f1 = i - j;
      k = this.H3;
      localc1.a = (f3 + (f2 - f3) * f1 / k);
      f1 = localc2.b;
      localc1.b = (f1 + (localc3.b - f1) * (i - j) / k);
      localc1 = this.K3;
      f1 = localc1.a;
      f2 = localc1.b;
      f3 = localc2.a;
      i = this.p2;
      paramCanvas.drawLine(f1, f2, f3 + i / 3.0F, localc2.b + i / 3.0F, this.J3);
      localc2 = this.L3;
      f2 = localc2.a;
      f1 = localc2.b;
      localc2 = this.O3;
      paramCanvas.drawLine(f2, f1, localc2.a, localc2.b, this.J3);
    }
  }
  
  protected void c()
  {
    Paint localPaint = new Paint();
    this.I3 = localPaint;
    localPaint.setAntiAlias(true);
    this.I3.setStyle(Paint.Style.FILL);
    this.I3.setColor(c);
    localPaint = new Paint();
    this.J3 = localPaint;
    localPaint.setAntiAlias(true);
    this.J3.setStyle(Paint.Style.FILL);
    this.J3.setColor(this.Q3);
    this.J3.setStrokeWidth(this.p2);
  }
  
  protected void d()
  {
    float f1 = (float)(this.p1 * 0.5D * Math.cos(Math.toRadians(10.0D)));
    float f2 = (float)(this.p1 * 0.5D * Math.sin(Math.toRadians(10.0D)));
    float f3 = (float)(this.p1 * 0.45D * Math.sin(Math.toRadians(16.0D)));
    float f4 = (float)(this.p1 * 0.45D * Math.cos(Math.toRadians(16.0D)));
    float f5 = (float)(this.p1 * 0.7D * Math.cos(Math.toRadians(24.0D)));
    float f6 = (float)(this.p1 * 0.7D * Math.sin(Math.toRadians(24.0D)));
    this.K3 = new c(this.f - f1, this.q - f2);
    this.L3 = new c(this.f - f3, this.q + f4);
    this.M3 = new c(this.f + f5, this.q - f6);
    this.N3 = new c(this.f - f1, this.q - f2);
    this.O3 = new c(this.f - f3, this.q + f4);
  }
  
  public void h()
  {
    if (!this.y)
    {
      this.y = true;
      if (!this.P3.isRunning()) {
        this.P3.start();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.x)
    {
      b();
      this.x = false;
    }
    a(paramCanvas);
    if (this.y) {
      i(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(g(paramInt1, true), g(paramInt2, false));
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof HookSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (HookSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.f = paramParcelable.c;
    this.q = paramParcelable.d;
    this.p1 = paramParcelable.f;
    this.x = paramParcelable.q;
    this.y = paramParcelable.x;
    this.z = paramParcelable.y;
    this.p0 = paramParcelable.z;
  }
  
  public Parcelable onSaveInstanceState()
  {
    HookSavedState localHookSavedState = new HookSavedState(super.onSaveInstanceState());
    localHookSavedState.c = this.f;
    localHookSavedState.d = this.q;
    localHookSavedState.f = this.p1;
    localHookSavedState.q = this.x;
    localHookSavedState.x = this.y;
    localHookSavedState.y = this.z;
    localHookSavedState.z = this.p0;
    return localHookSavedState;
  }
  
  public void setHookLineColor(@ColorInt int paramInt)
  {
    this.Q3 = paramInt;
  }
  
  public void setOnCompletedListener(b paramb)
  {
    this.R3 = paramb;
  }
  
  static class HookSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<HookSavedState> CREATOR = new a();
    float c;
    float d;
    float f;
    boolean q;
    boolean x;
    int y;
    int z;
    
    private HookSavedState(Parcel paramParcel)
    {
      super();
      this.c = paramParcel.readFloat();
      this.d = paramParcel.readFloat();
      this.f = paramParcel.readFloat();
      int i = paramParcel.readByte();
      boolean bool1 = true;
      boolean bool2;
      if (i != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.q = bool2;
      if (paramParcel.readByte() != 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      this.x = bool2;
      this.y = paramParcel.readInt();
      this.z = paramParcel.readInt();
    }
    
    HookSavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeFloat(this.c);
      paramParcel.writeFloat(this.d);
      paramParcel.writeFloat(this.f);
      paramParcel.writeByte((byte)this.q);
      paramParcel.writeByte((byte)this.x);
      paramParcel.writeInt(this.y);
      paramParcel.writeInt(this.z);
    }
    
    static final class a
      implements Parcelable.Creator<TPHookView.HookSavedState>
    {
      public TPHookView.HookSavedState a(Parcel paramParcel)
      {
        return new TPHookView.HookSavedState(paramParcel, null);
      }
      
      public TPHookView.HookSavedState[] b(int paramInt)
      {
        return new TPHookView.HookSavedState[paramInt];
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  static class c
  {
    public float a;
    public float b;
    
    public c(float paramFloat1, float paramFloat2)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPHookView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */