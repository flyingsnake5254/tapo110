package com.tplink.iot.devices.lightstrip.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import java.util.List;
import java.util.Objects;
import kotlin.collections.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;

public final class LightStripBrightnessController
  extends View
{
  private final PorterDuffXfermode H3;
  private boolean I3;
  private final RectF J3;
  private final Paint K3;
  private final Paint L3;
  private final RectF M3;
  private final Path N3;
  private final Paint O3;
  private final int P3;
  private final int Q3;
  private final float R3;
  private final int S3;
  private final int T3;
  private int U3;
  private boolean V3;
  private boolean W3;
  private float X3;
  private float Y3;
  private a Z3;
  private ValueAnimator a4;
  private final int[] c = { (int)4294960006L, (int)4294945232L, (int)4290550772L, (int)4284477183L };
  private final List<Integer> d = l.h(new Integer[] { Integer.valueOf(-3355444) });
  private final float f = d(150);
  private final float p0 = d(10);
  private final float p1 = d(28);
  private final float p2 = d(4);
  private final float p3;
  private final float q = d(240);
  private final float x = d(360);
  private final float y = d(24);
  private final float z = d(18);
  
  public LightStripBrightnessController(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public LightStripBrightnessController(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public LightStripBrightnessController(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f1 = d(4);
    this.p3 = f1;
    this.H3 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.J3 = new RectF();
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setColor((int)4294945485L);
    paramAttributeSet = kotlin.p.a;
    this.K3 = paramContext;
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setStyle(Paint.Style.FILL);
    paramContext.setColor(335544320);
    this.L3 = paramContext;
    this.M3 = new RectF();
    this.N3 = new Path();
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setStyle(Paint.Style.FILL_AND_STROKE);
    paramContext.setStrokeWidth(f1);
    paramContext.setStrokeCap(Paint.Cap.ROUND);
    paramContext.setStrokeJoin(Paint.Join.ROUND);
    this.O3 = paramContext;
    this.P3 = -1;
    this.Q3 = -16777216;
    this.R3 = 0.01F;
    this.S3 = 1;
    this.T3 = 100;
    this.U3 = 1;
    this.Y3 = 0.5F;
  }
  
  private final boolean b()
  {
    float f1 = this.p3;
    float f2 = this.p2;
    boolean bool;
    if ((getHeight() - this.p0 * 2.0F) * this.Y3 >= f1 + f2 * 2.0F) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final float d(int paramInt)
  {
    float f1 = paramInt;
    Object localObject = getContext();
    j.d(localObject, "context");
    localObject = ((Context)localObject).getResources();
    j.d(localObject, "context.resources");
    return TypedValue.applyDimension(1, f1, ((Resources)localObject).getDisplayMetrics());
  }
  
  private final int e(int paramInt1, int paramInt2, kotlin.jvm.b.p<? super Integer, ? super Integer, Integer> paramp)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE)
    {
      if (i == 1073741824) {
        paramInt1 = paramInt2;
      }
    }
    else {
      paramInt1 = ((Number)paramp.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2))).intValue();
    }
    return paramInt1;
  }
  
  private final void f()
  {
    if (this.a4 == null)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new b(this));
      kotlin.p localp = kotlin.p.a;
      this.a4 = localValueAnimator;
    }
  }
  
  private final void g()
  {
    int i = this.U3;
    float f1;
    if (i == this.S3) {
      f1 = this.R3;
    } else if (i == this.T3) {
      f1 = 1.0F;
    } else {
      f1 = this.Y3;
    }
    this.Y3 = f1;
    invalidate();
  }
  
  private final void h()
  {
    if (!this.I3)
    {
      this.I3 = true;
      if (this.d.size() == 1)
      {
        this.K3.setShader(null);
        this.K3.setColor(((Number)this.d.get(0)).intValue() & 0xFFFFFF | (int)3003121664L);
      }
      else if (this.d.size() > 1)
      {
        this.K3.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, getHeight(), l.R(this.d), null, Shader.TileMode.CLAMP));
      }
      else
      {
        this.K3.setShader(null);
        this.K3.setColor(-1);
      }
    }
  }
  
  private final void j(float paramFloat)
  {
    paramFloat = Math.min(Math.max(this.R3, this.Y3 + paramFloat), 1.0F);
    this.Y3 = paramFloat;
    int i = (int)(paramFloat * this.T3);
    this.U3 = i;
    a locala = this.Z3;
    if (locala != null) {
      locala.d(i);
    }
    invalidate();
  }
  
  private final void l(float paramFloat, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = this.a4;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    if (paramBoolean)
    {
      f();
      localValueAnimator = this.a4;
      if (localValueAnimator != null)
      {
        localValueAnimator.setFloatValues(new float[] { this.Y3, paramFloat });
        localValueAnimator.start();
      }
    }
    else
    {
      this.Y3 = paramFloat;
      invalidate();
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    setEnabled(false);
    this.V3 = true;
    k(paramBoolean);
  }
  
  public final int getBrightness()
  {
    return this.U3;
  }
  
  public final void i(int paramInt, boolean paramBoolean)
  {
    if (this.W3) {
      return;
    }
    int i = Math.max(this.S3, Math.min(paramInt, this.T3));
    this.U3 = i;
    paramInt = this.S3;
    float f1 = (i - paramInt) / (this.T3 - paramInt);
    f1 = Math.max(this.R3, Math.min(f1, 1.0F));
    setEnabled(true);
    this.V3 = false;
    l(f1, paramBoolean);
  }
  
  public final void k(boolean paramBoolean)
  {
    this.U3 = 0;
    l(0.0F, paramBoolean);
  }
  
  public final void m(List<Integer> paramList)
  {
    j.e(paramList, "colors");
    this.d.clear();
    this.d.addAll(paramList);
    this.I3 = false;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (!this.V3)
    {
      h();
      this.J3.set(0.0F, 0.0F, getWidth(), getHeight());
      localRectF = this.J3;
      f1 = this.y;
      paramCanvas.drawRoundRect(localRectF, f1, f1, this.K3);
    }
    RectF localRectF = this.J3;
    float f1 = this.p0;
    localRectF.set(f1, f1, getWidth() - this.p0, getHeight() - this.p0);
    localRectF = this.J3;
    f1 = this.z;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.L3);
    int i = paramCanvas.saveLayer(null, null, 31);
    this.O3.setColor(this.P3);
    this.O3.setStrokeWidth(0.0F);
    float f2 = this.p0 + (getHeight() - this.p0 * 2.0F) * (1.0F - this.Y3);
    paramCanvas.clipPath(this.N3);
    paramCanvas.drawRect(this.p0, f2, getWidth() - this.p0, getHeight() - this.p0, this.O3);
    if (b())
    {
      this.O3.setColor(this.Q3);
      this.O3.setStrokeWidth(this.p3);
      this.O3.setXfermode(this.H3);
      float f3 = getWidth();
      f1 = this.p1;
      f3 = (f3 - f1) / 2.0F;
      f2 = f2 + this.p2 + this.p3 / 2.0F;
      paramCanvas.drawLine(f3, f2, f3 + f1, f2, this.O3);
      this.O3.setXfermode(null);
    }
    paramCanvas.restoreToCount(i);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.M3;
    float f1 = this.p0;
    ((RectF)localObject).set(f1, f1, getWidth() - this.p0, getHeight() - this.p0);
    this.N3.reset();
    localObject = this.N3;
    RectF localRectF = this.M3;
    f1 = this.z;
    ((Path)localObject).addRoundRect(localRectF, f1, f1, Path.Direction.CW);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(e((int)this.f, paramInt1, d.c), Math.max(Math.min(e((int)this.q, paramInt2, c.c), (int)this.x), (int)this.q));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    j.e(paramMotionEvent, "event");
    if (!isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label153;
          }
        }
        else
        {
          this.W3 = true;
          j((this.X3 - paramMotionEvent.getY()) / getHeight());
          this.X3 = paramMotionEvent.getY();
          break label153;
        }
      }
      this.W3 = false;
      this.X3 = 0.0F;
      g();
      paramMotionEvent = this.Z3;
      if (paramMotionEvent != null) {
        paramMotionEvent.b();
      }
    }
    else
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      this.V3 = false;
      this.W3 = true;
      this.X3 = paramMotionEvent.getY();
      paramMotionEvent = this.Z3;
      if (paramMotionEvent != null) {
        paramMotionEvent.a();
      }
    }
    label153:
    return true;
  }
  
  public final void setOnBrightnessChangeListener(a parama)
  {
    j.e(parama, "listener");
    this.Z3 = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void d(int paramInt);
  }
  
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(LightStripBrightnessController paramLightStripBrightnessController) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      LightStripBrightnessController localLightStripBrightnessController = this.c;
      j.d(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      Objects.requireNonNull(paramValueAnimator, "null cannot be cast to non-null type kotlin.Float");
      LightStripBrightnessController.a(localLightStripBrightnessController, ((Float)paramValueAnimator).floatValue());
      this.c.postInvalidateOnAnimation();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\LightStripBrightnessController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */