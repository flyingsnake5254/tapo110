package com.tplink.libtpcontrols;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;

public class ShSwitchView
  extends View
{
  private int H3;
  private float I3;
  private int J3;
  private int K3;
  private Drawable L3;
  private RectF M3;
  private float N3;
  private float O3;
  private float P3;
  private float Q3;
  private boolean R3;
  private boolean S3;
  private boolean T3;
  private RectF U3;
  private float V3 = 1.0F;
  private float W3;
  private float X3;
  private int Y3;
  private int Z3;
  private int a4 = -3355444;
  private Paint b4;
  private ObjectAnimator c;
  private RectF c4;
  private Property<ShSwitchView, Float> d = new a(Float.class, "innerBound");
  private Path d4;
  private RectF e4;
  private ObjectAnimator f;
  private boolean f4 = false;
  private boolean g4 = false;
  private e h4;
  private GestureDetector.SimpleOnGestureListener p0 = new d();
  private int p1;
  private int p2;
  private int p3;
  private Property<ShSwitchView, Float> q = new b(Float.class, "knobExpand");
  private ObjectAnimator x;
  private Property<ShSwitchView, Float> y = new c(Float.class, "knobMove");
  private GestureDetector z;
  
  public ShSwitchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShSwitchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShSwitchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.ShSwitchView);
    paramInt = paramAttributeSet.getColor(x0.ShSwitchView_tintColor, -6493879);
    this.Y3 = paramInt;
    this.Z3 = paramInt;
    paramInt = (int)TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics());
    int i = (int)TypedValue.applyDimension(1, 5.0F, paramContext.getResources().getDisplayMetrics());
    this.K3 = paramAttributeSet.getDimensionPixelOffset(x0.ShSwitchView_outerStrokeWidth, paramInt);
    this.J3 = paramAttributeSet.getDimensionPixelOffset(x0.ShSwitchView_shadowSpace, i);
    paramAttributeSet.recycle();
    this.M3 = new RectF();
    this.U3 = new RectF();
    this.c4 = new RectF();
    this.e4 = new RectF();
    this.b4 = new Paint(1);
    this.d4 = new Path();
    paramAttributeSet = new GestureDetector(paramContext, this.p0);
    this.z = paramAttributeSet;
    paramAttributeSet.setIsLongpressEnabled(false);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    paramAttributeSet = ObjectAnimator.ofFloat(this, this.d, new float[] { this.V3, 1.0F });
    this.c = paramAttributeSet;
    paramAttributeSet.setDuration(300L);
    this.c.setInterpolator(new DecelerateInterpolator());
    paramAttributeSet = ObjectAnimator.ofFloat(this, this.q, new float[] { this.P3, 1.0F });
    this.f = paramAttributeSet;
    paramAttributeSet.setDuration(300L);
    this.f.setInterpolator(new DecelerateInterpolator());
    paramAttributeSet = ObjectAnimator.ofFloat(this, this.y, new float[] { this.Q3, 1.0F });
    this.x = paramAttributeSet;
    paramAttributeSet.setDuration(300L);
    this.x.setInterpolator(new DecelerateInterpolator());
    this.L3 = paramContext.getResources().getDrawable(r0.shadow);
  }
  
  private int a(float paramFloat, int paramInt1, int paramInt2)
  {
    int i = paramInt1 >> 16 & 0xFF;
    int j = paramInt1 >> 8 & 0xFF;
    paramInt1 &= 0xFF;
    return i + (int)(((paramInt2 >> 16 & 0xFF) - i) * paramFloat) << 16 | 0xFF000000 | j + (int)(((paramInt2 >> 8 & 0xFF) - j) * paramFloat) << 8 | paramInt1 + (int)(((paramInt2 & 0xFF) - paramInt1) * paramFloat);
  }
  
  private void p(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, Canvas paramCanvas, Paint paramPaint)
  {
    RectF localRectF = this.e4;
    localRectF.left = paramFloat1;
    localRectF.top = paramFloat2;
    localRectF.right = paramFloat3;
    localRectF.bottom = paramFloat4;
    paramCanvas.drawRoundRect(localRectF, paramFloat5, paramFloat5, paramPaint);
  }
  
  float getInnerContentRate()
  {
    return this.V3;
  }
  
  float getKnobExpandRate()
  {
    return this.P3;
  }
  
  float getKnobMoveRate()
  {
    return this.Q3;
  }
  
  public e getOnSwitchStateChangeListener()
  {
    return this.h4;
  }
  
  public int getTintColor()
  {
    return this.Y3;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.g4 = true;
    if (this.f4)
    {
      boolean bool = this.S3;
      this.R3 = bool;
      if (bool)
      {
        this.x.setFloatValues(new float[] { this.Q3, 1.0F });
        this.x.start();
        this.c.setFloatValues(new float[] { this.V3, 0.0F });
      }
      else
      {
        this.x.setFloatValues(new float[] { this.Q3, 0.0F });
        this.x.start();
        this.c.setFloatValues(new float[] { this.V3, 1.0F });
      }
      this.c.start();
      this.f.setFloatValues(new float[] { this.P3, 0.0F });
      this.f.start();
      e locale = this.h4;
      if (locale != null)
      {
        bool = this.S3;
        if (bool != this.T3) {
          locale.a(bool);
        }
      }
      this.f4 = false;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g4 = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.W3 / 2.0F;
    float f2 = this.V3;
    f1 *= f2;
    f2 = this.X3 / 2.0F * f2;
    RectF localRectF = this.U3;
    int i = this.p3;
    localRectF.left = (i - f1);
    int j = this.H3;
    localRectF.top = (j - f2);
    localRectF.right = (i + f1);
    localRectF.bottom = (j + f2);
    f2 = this.O3;
    f2 += (this.N3 - f2) * this.P3;
    localRectF = this.M3;
    if (localRectF.left + localRectF.width() / 2.0F > this.p3) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      localRectF = this.M3;
      localRectF.left = (localRectF.right - f2);
    }
    else
    {
      localRectF = this.M3;
      localRectF.right = (localRectF.left + f2);
    }
    f2 = this.M3.width();
    f1 = this.p1;
    float f3 = (this.J3 + this.K3) * 2;
    float f5 = this.Q3;
    j = a(f5, -3355444, this.Y3);
    this.a4 = j;
    localRectF = this.M3;
    f1 = this.J3 + this.K3 + (f1 - f2 - f3) * f5;
    localRectF.left = f1;
    localRectF.right = (f1 + f2);
    this.b4.setColor(j);
    this.b4.setStyle(Paint.Style.FILL);
    j = this.J3;
    p(j, j, this.p1 - j, this.p2 - j, this.I3, paramCanvas, this.b4);
    this.b4.setColor(-1052689);
    localRectF = this.U3;
    paramCanvas.drawRoundRect(localRectF, localRectF.height() / 2.0F, this.U3.height() / 2.0F, this.b4);
    localRectF = this.M3;
    f2 = this.I3;
    j = this.K3;
    paramCanvas.drawRoundRect(localRectF, f2 - j, f2 - j, this.b4);
    this.b4.setColor(-3355444);
    this.b4.setStyle(Paint.Style.STROKE);
    this.b4.setStrokeWidth(1.0F);
    localRectF = this.M3;
    f2 = this.I3;
    j = this.K3;
    paramCanvas.drawRoundRect(localRectF, f2 - j, f2 - j, this.b4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.p1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    this.p2 = i;
    float f1 = i;
    i = this.p1;
    if (f1 / i < 0.33333F)
    {
      this.p2 = ((int)(i * 0.33333F));
      super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.getMode(paramInt1)), View.MeasureSpec.makeMeasureSpec(this.p2, View.MeasureSpec.getMode(paramInt2)));
    }
    paramInt1 = this.p1;
    this.p3 = (paramInt1 / 2);
    i = this.p2;
    int j = i / 2;
    this.H3 = j;
    paramInt2 = this.J3;
    this.I3 = (j - paramInt2);
    RectF localRectF = this.U3;
    j = this.K3;
    localRectF.left = (j + paramInt2);
    localRectF.top = (j + paramInt2);
    localRectF.right = (paramInt1 - j - paramInt2);
    localRectF.bottom = (i - j - paramInt2);
    this.W3 = localRectF.width();
    this.X3 = this.U3.height();
    localRectF = this.M3;
    i = this.K3;
    paramInt2 = this.J3;
    localRectF.left = (i + paramInt2);
    localRectF.top = (i + paramInt2);
    paramInt1 = this.p2;
    localRectF.right = (paramInt1 - i - paramInt2);
    localRectF.bottom = (paramInt1 - i - paramInt2);
    this.O3 = localRectF.height();
    f1 = this.p1 * 0.7F;
    this.N3 = f1;
    if (f1 > this.M3.width() * 1.25F) {
      this.N3 = (this.M3.width() * 1.25F);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 3))
    {
      if (!this.R3)
      {
        localObject = ObjectAnimator.ofFloat(this, this.d, new float[] { this.V3, 1.0F });
        this.c = ((ObjectAnimator)localObject);
        ((ObjectAnimator)localObject).setDuration(300L);
        this.c.setInterpolator(new DecelerateInterpolator());
        this.c.start();
      }
      Object localObject = ObjectAnimator.ofFloat(this, this.q, new float[] { this.P3, 0.0F });
      this.f = ((ObjectAnimator)localObject);
      ((ObjectAnimator)localObject).setDuration(300L);
      this.f.setInterpolator(new DecelerateInterpolator());
      this.f.start();
      boolean bool = this.R3;
      this.S3 = bool;
      localObject = this.h4;
      if ((localObject != null) && (bool != this.T3)) {
        ((e)localObject).a(bool);
      }
    }
    return this.z.onTouchEvent(paramMotionEvent);
  }
  
  public void q(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.S3 == paramBoolean1) {
      return;
    }
    if ((!this.g4) && (paramBoolean2))
    {
      this.f4 = true;
      this.S3 = paramBoolean1;
      return;
    }
    this.S3 = paramBoolean1;
    this.R3 = paramBoolean1;
    if (!paramBoolean2)
    {
      if (paramBoolean1)
      {
        setKnobMoveRate(1.0F);
        setInnerContentRate(0.0F);
      }
      else
      {
        setKnobMoveRate(0.0F);
        setInnerContentRate(1.0F);
      }
      setKnobExpandRate(0.0F);
    }
    else
    {
      if (paramBoolean1)
      {
        this.x.setFloatValues(new float[] { this.Q3, 1.0F });
        this.x.start();
        this.c.setFloatValues(new float[] { this.V3, 0.0F });
      }
      else
      {
        this.x.setFloatValues(new float[] { this.Q3, 0.0F });
        this.x.start();
        this.c.setFloatValues(new float[] { this.V3, 1.0F });
      }
      this.c.start();
      this.f.setFloatValues(new float[] { this.P3, 0.0F });
      this.f.start();
    }
    e locale = this.h4;
    if (locale != null)
    {
      paramBoolean1 = this.S3;
      if (paramBoolean1 != this.T3) {
        locale.a(paramBoolean1);
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (paramBoolean) {
      this.Y3 = this.Z3;
    } else {
      this.Y3 = a(0.5F, this.Z3, -1);
    }
  }
  
  void setInnerContentRate(float paramFloat)
  {
    this.V3 = paramFloat;
    invalidate();
  }
  
  void setKnobExpandRate(float paramFloat)
  {
    this.P3 = paramFloat;
    invalidate();
  }
  
  void setKnobMoveRate(float paramFloat)
  {
    this.Q3 = paramFloat;
    invalidate();
  }
  
  public void setOn(boolean paramBoolean)
  {
    q(paramBoolean, false);
  }
  
  public void setOnSwitchStateChangeListener(e parame)
  {
    this.h4 = parame;
  }
  
  public void setTintColor(int paramInt)
  {
    this.Y3 = paramInt;
    this.Z3 = paramInt;
  }
  
  class a
    extends Property<ShSwitchView, Float>
  {
    a(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Float a(ShSwitchView paramShSwitchView)
    {
      return Float.valueOf(paramShSwitchView.getInnerContentRate());
    }
    
    public void b(ShSwitchView paramShSwitchView, Float paramFloat)
    {
      paramShSwitchView.setInnerContentRate(paramFloat.floatValue());
    }
  }
  
  class b
    extends Property<ShSwitchView, Float>
  {
    b(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Float a(ShSwitchView paramShSwitchView)
    {
      return Float.valueOf(paramShSwitchView.getKnobExpandRate());
    }
    
    public void b(ShSwitchView paramShSwitchView, Float paramFloat)
    {
      paramShSwitchView.setKnobExpandRate(paramFloat.floatValue());
    }
  }
  
  class c
    extends Property<ShSwitchView, Float>
  {
    c(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Float a(ShSwitchView paramShSwitchView)
    {
      return Float.valueOf(paramShSwitchView.getKnobMoveRate());
    }
    
    public void b(ShSwitchView paramShSwitchView, Float paramFloat)
    {
      paramShSwitchView.setKnobMoveRate(paramFloat.floatValue());
    }
  }
  
  class d
    extends GestureDetector.SimpleOnGestureListener
  {
    d() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      if (!ShSwitchView.this.isEnabled()) {
        return false;
      }
      paramMotionEvent = ShSwitchView.this;
      ShSwitchView.c(paramMotionEvent, ShSwitchView.d(paramMotionEvent));
      ShSwitchView.h(ShSwitchView.this).setFloatValues(new float[] { ShSwitchView.g(ShSwitchView.this), 0.0F });
      ShSwitchView.h(ShSwitchView.this).start();
      ShSwitchView.j(ShSwitchView.this).setFloatValues(new float[] { ShSwitchView.i(ShSwitchView.this), 1.0F });
      ShSwitchView.j(ShSwitchView.this).start();
      return true;
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (paramMotionEvent2.getX() > ShSwitchView.e(ShSwitchView.this))
      {
        if (!ShSwitchView.k(ShSwitchView.this))
        {
          ShSwitchView.l(ShSwitchView.this, true);
          ShSwitchView.n(ShSwitchView.this).setFloatValues(new float[] { ShSwitchView.m(ShSwitchView.this), 1.0F });
          ShSwitchView.n(ShSwitchView.this).start();
          ShSwitchView.h(ShSwitchView.this).setFloatValues(new float[] { ShSwitchView.g(ShSwitchView.this), 0.0F });
          ShSwitchView.h(ShSwitchView.this).start();
        }
      }
      else if (ShSwitchView.k(ShSwitchView.this))
      {
        ShSwitchView.l(ShSwitchView.this, false);
        ShSwitchView.n(ShSwitchView.this).setFloatValues(new float[] { ShSwitchView.m(ShSwitchView.this), 0.0F });
        ShSwitchView.n(ShSwitchView.this).start();
      }
      return true;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent) {}
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      paramMotionEvent = ShSwitchView.this;
      ShSwitchView.f(paramMotionEvent, ShSwitchView.k(paramMotionEvent));
      if (ShSwitchView.b(ShSwitchView.this) == ShSwitchView.d(ShSwitchView.this))
      {
        paramMotionEvent = ShSwitchView.this;
        ShSwitchView.f(paramMotionEvent, ShSwitchView.d(paramMotionEvent) ^ true);
        paramMotionEvent = ShSwitchView.this;
        ShSwitchView.l(paramMotionEvent, ShSwitchView.k(paramMotionEvent) ^ true);
      }
      if (ShSwitchView.k(ShSwitchView.this))
      {
        ShSwitchView.n(ShSwitchView.this).setFloatValues(new float[] { ShSwitchView.m(ShSwitchView.this), 1.0F });
        ShSwitchView.n(ShSwitchView.this).start();
        ShSwitchView.h(ShSwitchView.this).setFloatValues(new float[] { ShSwitchView.g(ShSwitchView.this), 0.0F });
      }
      else
      {
        ShSwitchView.n(ShSwitchView.this).setFloatValues(new float[] { ShSwitchView.m(ShSwitchView.this), 0.0F });
        ShSwitchView.n(ShSwitchView.this).start();
        ShSwitchView.h(ShSwitchView.this).setFloatValues(new float[] { ShSwitchView.g(ShSwitchView.this), 1.0F });
      }
      ShSwitchView.h(ShSwitchView.this).start();
      ShSwitchView.j(ShSwitchView.this).setFloatValues(new float[] { ShSwitchView.i(ShSwitchView.this), 0.0F });
      ShSwitchView.j(ShSwitchView.this).start();
      if ((ShSwitchView.o(ShSwitchView.this) != null) && (ShSwitchView.d(ShSwitchView.this) != ShSwitchView.b(ShSwitchView.this))) {
        ShSwitchView.o(ShSwitchView.this).a(ShSwitchView.d(ShSwitchView.this));
      }
      return true;
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\ShSwitchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */