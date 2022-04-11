package com.tplink.iot.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tplink.iot.b;

public class CirclePercentBar
  extends FrameLayout
{
  private int H3;
  private Paint I3;
  private Paint J3;
  private ValueAnimator K3;
  private TimeInterpolator L3;
  private c M3;
  private Context c;
  private TextView d;
  private ImageView f;
  private int p0;
  private RectF p1;
  private int p2 = 0;
  private int p3;
  private int q;
  private int x;
  private int y;
  private int z;
  
  public CirclePercentBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CirclePercentBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CirclePercentBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    this.L3 = new DecelerateInterpolator();
    i(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    h();
  }
  
  private void h()
  {
    Paint localPaint = new Paint(1);
    this.J3 = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    this.J3.setStrokeWidth(this.x);
    this.J3.setColor(this.q);
    this.J3.setStrokeCap(Paint.Cap.BUTT);
    this.J3.setStrokeJoin(Paint.Join.ROUND);
    localPaint = new Paint(1);
    this.I3 = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    this.I3.setStrokeWidth(this.x);
    this.I3.setStrokeCap(Paint.Cap.BUTT);
    this.I3.setStrokeJoin(Paint.Join.ROUND);
    this.p1 = new RectF();
  }
  
  private void i(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.CirclePercentBar, paramInt, 0);
    this.q = paramAttributeSet.getColor(2, -1);
    this.x = paramAttributeSet.getDimensionPixelSize(4, 3);
    int i = paramAttributeSet.getColor(7, 3355443);
    paramInt = paramAttributeSet.getDimensionPixelSize(8, 16);
    this.y = paramAttributeSet.getDimensionPixelSize(3, 27);
    this.p3 = paramAttributeSet.getColor(1, ContextCompat.getColor(this.c, 2131099808));
    this.H3 = paramAttributeSet.getColor(0, ContextCompat.getColor(this.c, 2131099808));
    this.p0 = paramAttributeSet.getResourceId(5, 2131689642);
    this.z = paramAttributeSet.getDimensionPixelSize(6, 54);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131559435, this, true);
    paramContext = (TextView)paramAttributeSet.findViewById(2131364585);
    this.d = paramContext;
    paramContext.setTextColor(i);
    this.d.setTextSize(0, paramInt);
    paramContext = (ImageView)paramAttributeSet.findViewById(2131363109);
    this.f = paramContext;
    paramContext.setOnClickListener(new a());
  }
  
  private int j(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i != 1073741824)
    {
      int j = this.y * 2;
      if (i == Integer.MIN_VALUE) {
        paramInt = Math.min(j, paramInt);
      } else {
        paramInt = j;
      }
    }
    return paramInt;
  }
  
  private void l()
  {
    ValueAnimator localValueAnimator = this.K3;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.K3.cancel();
    }
  }
  
  public void k()
  {
    this.d.setVisibility(0);
    this.f.setVisibility(8);
    this.p2 = 0;
    this.p3 = getResources().getColor(2131099808);
    this.H3 = getResources().getColor(2131099808);
  }
  
  public void m()
  {
    this.d.setVisibility(8);
    this.f.setVisibility(0);
    this.p3 = getResources().getColor(2131099812);
    this.H3 = getResources().getColor(2131099812);
    invalidate();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    l();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.p2 < 100)
    {
      paramCanvas.rotate(-90.0F, getWidth() / 2, getHeight() / 2);
      Object localObject = this.p1;
      int i = this.x;
      ((RectF)localObject).set(i / 2, i / 2, getWidth() - this.x / 2, getHeight() - this.x / 2);
      if (this.q != -1) {
        paramCanvas.drawArc(this.p1, 0.0F, 360.0F, false, this.J3);
      }
      localObject = this.I3;
      float f1 = getWidth() / 2;
      float f2 = getHeight() / 2;
      i = this.p3;
      ((Paint)localObject).setShader(new SweepGradient(f1, f2, new int[] { i, this.H3, i }, null));
      paramCanvas.drawArc(this.p1, 0.0F, this.p2 * 360 / 100, false, this.I3);
      paramCanvas.rotate(90.0F, getWidth() / 2, getHeight() / 2);
      paramCanvas = getResources().getString(2131953423, new Object[] { Integer.valueOf(this.p2) });
      this.d.setText(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(j(paramInt1), j(paramInt2));
  }
  
  public void setListener(c paramc)
  {
    this.M3 = paramc;
  }
  
  public void setPercentData(int paramInt)
  {
    int i = this.p2;
    if (i == paramInt) {
      return;
    }
    this.K3 = ValueAnimator.ofInt(new int[] { i, paramInt });
    long l1 = Math.abs(this.p2 - paramInt) * 40L;
    long l2 = l1;
    if (l1 > 200L) {
      l2 = 200L;
    }
    this.K3.setDuration(l2);
    this.K3.addUpdateListener(new b());
    this.K3.setInterpolator(this.L3);
    this.K3.start();
  }
  
  public void setmInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    this.L3 = paramTimeInterpolator;
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (CirclePercentBar.a(CirclePercentBar.this) != null) {
        CirclePercentBar.a(CirclePercentBar.this).n();
      }
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      CirclePercentBar.b(CirclePercentBar.this, i);
      if (i < 100)
      {
        CirclePercentBar.c(CirclePercentBar.this).setVisibility(0);
        CirclePercentBar.d(CirclePercentBar.this).setVisibility(8);
      }
      else
      {
        CirclePercentBar.c(CirclePercentBar.this).setVisibility(8);
        paramValueAnimator = CirclePercentBar.this;
        paramValueAnimator.setBackgroundResource(CirclePercentBar.e(paramValueAnimator));
        paramValueAnimator = CirclePercentBar.this;
        CirclePercentBar.f(paramValueAnimator, CirclePercentBar.g(paramValueAnimator) / 2);
        CirclePercentBar.this.requestLayout();
      }
      CirclePercentBar.this.invalidate();
    }
  }
  
  public static abstract interface c
  {
    public abstract void n();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\CirclePercentBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */