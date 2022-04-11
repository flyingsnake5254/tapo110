package com.tplink.iot.devices.lightstrip.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.tplink.iot.b;
import java.util.Objects;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public abstract class LightingEffectBaseView
  extends AppCompatImageView
{
  private float H3;
  private ValueAnimator I3;
  private boolean J3;
  private final f K3;
  private final Paint L3;
  private final int c = (int)e(76);
  private float d = e(4);
  private RectF f = new RectF();
  private boolean p0;
  private final f p1;
  private final Paint p2;
  private float p3;
  private final Paint q;
  private float x;
  private ValueAnimator y;
  private float z;
  
  public LightingEffectBaseView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public LightingEffectBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public LightingEffectBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Paint localPaint = new Paint(1);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor((int)4280011775L);
    localPaint.setStrokeWidth(this.d);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    p localp = p.a;
    this.q = localPaint;
    this.z = e(6);
    this.p1 = h.b(new b(paramContext));
    this.p2 = new Paint(3);
    this.p3 = 1.1F;
    this.K3 = h.b(new a(paramContext));
    this.L3 = new Paint(3);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.LightingEffectBaseView);
    this.d = paramContext.getDimension(1, this.d);
    this.z = paramContext.getDimension(1, this.z);
    paramContext.recycle();
    localPaint.setStrokeWidth(this.d);
  }
  
  private final int f(int paramInt)
  {
    int i = getMDefaultSize();
    int j = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (j != Integer.MIN_VALUE)
    {
      if (j != 0)
      {
        if (j != 1073741824) {
          paramInt = i;
        }
      }
      else {
        paramInt = getMDefaultSize();
      }
    }
    else {
      paramInt = Math.min(getMDefaultSize(), paramInt);
    }
    return paramInt;
  }
  
  private final void g()
  {
    Object localObject = this.I3;
    float f1 = 0.0F;
    float f2;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning() == true)) {
      f2 = this.H3;
    } else if (this.p0) {
      f2 = 0.0F;
    } else {
      f2 = this.p3;
    }
    if (this.p0) {
      f1 = this.p3;
    }
    localObject = this.I3;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    if (this.I3 == null)
    {
      localValueAnimator = new ValueAnimator();
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new c(this));
      localObject = p.a;
      this.I3 = localValueAnimator;
    }
    ValueAnimator localValueAnimator = this.I3;
    if (localValueAnimator != null)
    {
      if (this.p0) {
        localObject = new OvershootInterpolator();
      } else {
        localObject = new AnticipateInterpolator();
      }
      localValueAnimator.setInterpolator((TimeInterpolator)localObject);
      localValueAnimator.setFloatValues(new float[] { f2, f1 });
      localValueAnimator.start();
    }
  }
  
  private final Bitmap getMCenterEditIcon()
  {
    return (Bitmap)this.K3.getValue();
  }
  
  private final Bitmap getMEditIcon()
  {
    return (Bitmap)this.p1.getValue();
  }
  
  private final void h()
  {
    Object localObject = this.y;
    float f1 = 0.0F;
    float f2;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning() == true)) {
      f2 = this.x;
    } else if (isSelected()) {
      f2 = 0.0F;
    } else {
      f2 = 360.0F;
    }
    if (isSelected()) {
      f1 = 360.0F;
    }
    localObject = this.y;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    if (this.y == null)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new d(this));
      localObject = p.a;
      this.y = localValueAnimator;
    }
    localObject = this.y;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).setFloatValues(new float[] { f2, f1 });
      ((ValueAnimator)localObject).start();
    }
  }
  
  public abstract void c(Canvas paramCanvas);
  
  public final void d(boolean paramBoolean)
  {
    if (this.J3 != paramBoolean)
    {
      this.J3 = paramBoolean;
      invalidate();
    }
  }
  
  protected final float e(int paramInt)
  {
    float f1 = paramInt;
    Object localObject = getContext();
    j.d(localObject, "context");
    localObject = ((Context)localObject).getResources();
    j.d(localObject, "context.resources");
    return TypedValue.applyDimension(1, f1, ((Resources)localObject).getDisplayMetrics());
  }
  
  public final boolean getInEdit()
  {
    return this.p0;
  }
  
  protected int getMDefaultSize()
  {
    return this.c;
  }
  
  protected final float getMGapWidth()
  {
    return this.z;
  }
  
  protected final float getMHaloWidth()
  {
    return this.d;
  }
  
  public final void i(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.p0 != paramBoolean1)
    {
      this.p0 = paramBoolean1;
      if (paramBoolean2)
      {
        g();
      }
      else
      {
        float f1;
        if (paramBoolean1) {
          f1 = this.p3;
        } else {
          f1 = 0.0F;
        }
        this.H3 = f1;
        invalidate();
      }
    }
  }
  
  public final void j(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 != isSelected())
    {
      super.setSelected(paramBoolean1);
      if (paramBoolean2)
      {
        h();
      }
      else
      {
        float f1;
        if (isSelected()) {
          f1 = 360.0F;
        } else {
          f1 = 0.0F;
        }
        this.x = f1;
        invalidate();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    ValueAnimator localValueAnimator;
    float f1;
    if (!isSelected())
    {
      localValueAnimator = this.y;
      if ((localValueAnimator == null) || (localValueAnimator.isRunning() != true)) {}
    }
    else
    {
      f1 = this.d / 2.0F;
      this.f.set(f1, f1, getWidth() - f1, getHeight() - f1);
      paramCanvas.drawArc(this.f, -90.0F, this.x, false, this.q);
    }
    c(paramCanvas);
    float f2;
    if (!this.p0)
    {
      localValueAnimator = this.I3;
      if ((localValueAnimator == null) || (localValueAnimator.isRunning() != true)) {}
    }
    else
    {
      paramCanvas.save();
      f1 = this.d + this.z - 8.0F;
      f2 = this.H3;
      paramCanvas.scale(f2, f2, getWidth() - f1 - getMEditIcon().getWidth() / 2.0F, getMEditIcon().getWidth() / 2.0F + f1);
      paramCanvas.drawBitmap(getMEditIcon(), getWidth() - getMEditIcon().getWidth() - f1, f1, this.p2);
      paramCanvas.restore();
    }
    if (this.J3)
    {
      f1 = (getWidth() - getMCenterEditIcon().getWidth()) / 2.0F;
      f2 = (getHeight() - getMCenterEditIcon().getHeight()) / 2.0F;
      paramCanvas.drawBitmap(getMCenterEditIcon(), f1, f2, this.L3);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(f(paramInt1), f(paramInt2));
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.4F;
    }
    setAlpha(f1);
  }
  
  public final void setGapWidth(float paramFloat)
  {
    this.z = paramFloat;
    invalidate();
  }
  
  public final void setHaloWidth(float paramFloat)
  {
    this.d = paramFloat;
    this.q.setStrokeWidth(paramFloat);
    invalidate();
  }
  
  protected final void setMGapWidth(float paramFloat)
  {
    this.z = paramFloat;
  }
  
  protected final void setMHaloWidth(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (isSelected() != paramBoolean)
    {
      super.setSelected(paramBoolean);
      float f1;
      if (isSelected()) {
        f1 = 360.0F;
      } else {
        f1 = 0.0F;
      }
      this.x = f1;
      invalidate();
    }
  }
  
  static final class a
    extends Lambda
    implements a<Bitmap>
  {
    a(Context paramContext)
    {
      super();
    }
    
    public final Bitmap a()
    {
      return BitmapFactory.decodeResource(this.c.getResources(), 2131689757);
    }
  }
  
  static final class b
    extends Lambda
    implements a<Bitmap>
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final Bitmap a()
    {
      return BitmapFactory.decodeResource(this.c.getResources(), 2131231284);
    }
  }
  
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(LightingEffectBaseView paramLightingEffectBaseView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      LightingEffectBaseView localLightingEffectBaseView = this.c;
      j.d(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      Objects.requireNonNull(paramValueAnimator, "null cannot be cast to non-null type kotlin.Float");
      LightingEffectBaseView.a(localLightingEffectBaseView, ((Float)paramValueAnimator).floatValue());
      this.c.postInvalidateOnAnimation();
    }
  }
  
  static final class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d(LightingEffectBaseView paramLightingEffectBaseView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      LightingEffectBaseView localLightingEffectBaseView = this.c;
      j.d(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      Objects.requireNonNull(paramValueAnimator, "null cannot be cast to non-null type kotlin.Float");
      LightingEffectBaseView.b(localLightingEffectBaseView, ((Float)paramValueAnimator).floatValue());
      this.c.postInvalidateOnAnimation();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\LightingEffectBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */