package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import com.tplink.iot.Utils.s0;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;
import net.lucode.hackware.magicindicator.g.b;

public class ColorTemperatureView
  extends View
{
  private RectF H3;
  private RectF I3;
  private int J3;
  private float K3;
  private boolean L3 = false;
  private int M3 = 2700;
  private boolean N3 = false;
  private int O3 = 2700;
  private b P3;
  private c Q3;
  private boolean R3 = true;
  int S3;
  private int c = 2500;
  private int d = 6500;
  private int f = 4000;
  private Paint p0;
  private Paint p1;
  private Paint p2;
  private LinearGradient p3;
  private int q;
  private int x;
  private int y;
  private int z;
  
  public ColorTemperatureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorTemperatureView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorTemperatureView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.y = b.a(paramContext, 60.0D);
    this.z = b.a(paramContext, 240.0D);
    float f1 = this.z;
    paramAttributeSet = Shader.TileMode.CLAMP;
    this.p3 = new LinearGradient(0.0F, 0.0F, 0.0F, f1, new int[] { 49715, -657931, -9124865 }, new float[] { 0.0F, 0.5F, 1.0F }, paramAttributeSet);
    paramAttributeSet = new Paint(1);
    this.p0 = paramAttributeSet;
    paramAttributeSet.setColor(-1717986919);
    this.p0.setStrokeWidth(2.0F);
    this.p0.setPathEffect(new DashPathEffect(new float[] { 10.0F, 10.0F }, 0.0F));
    this.p1 = new Paint(1);
    this.H3 = new RectF();
    paramAttributeSet = new Paint(1);
    this.p2 = paramAttributeSet;
    paramAttributeSet.setColor(Color.parseColor("#F2F2F2"));
    this.p2.setStyle(Paint.Style.STROKE);
    this.p2.setStrokeWidth(12.0F);
    this.I3 = new RectF();
    this.J3 = b.a(paramContext, 10.0D);
  }
  
  private float e(int paramInt)
  {
    return (float)((paramInt - this.c) * 1.0D * this.x / this.f);
  }
  
  private boolean f(float paramFloat)
  {
    RectF localRectF = this.H3;
    boolean bool;
    if ((paramFloat >= localRectF.left) && (paramFloat <= localRectF.right)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean g(int paramInt)
  {
    boolean bool;
    if ((paramInt != 2700) && (paramInt != 4500) && (paramInt != 5500)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void i()
  {
    this.N3 = true;
    b localb = this.P3;
    if (localb != null) {
      localb.c();
    }
  }
  
  private int j(int paramInt)
  {
    int i = this.c;
    if (paramInt < i) {
      return i;
    }
    return Math.min(paramInt, this.d);
  }
  
  private int k(float paramFloat)
  {
    return j((int)(this.c + paramFloat * 1.0D / this.x * this.f)) / 5 * 5;
  }
  
  private void m()
  {
    c localc = this.Q3;
    if (localc != null) {
      localc.dispose();
    }
    this.R3 = false;
    this.S3 = this.M3;
    this.Q3 = q.a0(0L, 500L, TimeUnit.MILLISECONDS).L0(io.reactivex.l0.a.c()).G0(new a());
  }
  
  private void n(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentColorTemp=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", lastMoveColorTemp=");
    localStringBuilder.append(paramInt2);
    b.d.w.c.a.e("colorTemp", localStringBuilder.toString());
    if (g(paramInt2)) {
      return;
    }
    if (g(paramInt1)) {
      s0.D(getContext(), 100L);
    }
  }
  
  private void setInnerSetColorTemp(int paramInt)
  {
    this.M3 = paramInt;
    invalidate();
  }
  
  public int getColorTemp()
  {
    if (this.N3) {
      return this.M3;
    }
    return 0;
  }
  
  public boolean h()
  {
    return this.N3;
  }
  
  public void l(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return;
    }
    this.c = paramInt1;
    this.d = paramInt2;
    this.f = (paramInt2 - paramInt1);
    if (paramInt1 == paramInt2) {
      this.f = 1;
    }
    this.M3 = j(this.M3);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.p1.setShader(this.p3);
    this.H3.set(getWidth() / 2 - this.y / 2, 0.0F, getWidth() / 2 + this.y / 2, this.z);
    RectF localRectF = this.H3;
    int i = this.J3;
    paramCanvas.drawRoundRect(localRectF, i, i, this.p1);
    this.p1.setXfermode(null);
    if (this.N3)
    {
      float f1 = e(this.M3);
      float f2;
      if (f1 < 24.0F)
      {
        f2 = 24.0F;
      }
      else
      {
        i = this.x;
        f2 = f1;
        if (f1 > i - 24) {
          f2 = i - 24;
        }
      }
      localRectF = this.I3;
      i = this.q;
      int j = this.y;
      localRectF.set((i - j) / 2 - 10, f2 - 20.0F, (i + j) / 2 + 10, f2 + 20.0F);
      paramCanvas.drawRoundRect(this.I3, 10.0F, 10.0F, this.p2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 < b.a(getContext(), 74.0D)) {
      paramInt1 = b.a(getContext(), 74.0D);
    }
    setMeasuredDimension(paramInt1, b.a(getContext(), 240.0D));
    this.q = getMeasuredWidth();
    this.x = getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label244;
          }
        }
        else
        {
          if (!this.L3) {
            break label244;
          }
          f1 = this.K3;
          i = k(f1 + (int)(f2 - f1));
          n(i, this.O3);
          this.O3 = i;
          setInnerSetColorTemp(i);
          paramMotionEvent = this.P3;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(i);
          }
          invalidate();
          getParent().requestDisallowInterceptTouchEvent(true);
          return true;
        }
      }
      this.L3 = false;
      this.R3 = true;
    }
    else
    {
      if (f(f1))
      {
        this.K3 = f2;
        this.L3 = true;
        i();
        i = k(f2);
        n(i, this.O3);
        this.O3 = i;
        setInnerSetColorTemp(i);
        paramMotionEvent = this.P3;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(i);
        }
        paramMotionEvent = this.P3;
        if (paramMotionEvent != null) {
          paramMotionEvent.c();
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        this.R3 = false;
        m();
        return true;
      }
      this.R3 = true;
    }
    label244:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setColorTemp(int paramInt)
  {
    this.M3 = paramInt;
    i();
    invalidate();
  }
  
  public void setOnColorTemperatureListener(b paramb)
  {
    this.P3 = paramb;
  }
  
  public void setSelectedStatus(boolean paramBoolean)
  {
    if (this.N3 != paramBoolean)
    {
      this.N3 = paramBoolean;
      invalidate();
    }
  }
  
  class a
    implements g<Long>
  {
    a() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      int i = ColorTemperatureView.a(ColorTemperatureView.this);
      if (((i != ColorTemperatureView.this.S3) || (paramLong.longValue() == 0L)) && (ColorTemperatureView.b(ColorTemperatureView.this) != null)) {
        ColorTemperatureView.b(ColorTemperatureView.this).b(i);
      }
      paramLong = ColorTemperatureView.this;
      paramLong.S3 = i;
      if ((ColorTemperatureView.c(paramLong)) && (ColorTemperatureView.d(ColorTemperatureView.this) != null)) {
        ColorTemperatureView.d(ColorTemperatureView.this).dispose();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt);
    
    public abstract void b(int paramInt);
    
    public abstract void c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\ColorTemperatureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */