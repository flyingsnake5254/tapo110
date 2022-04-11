package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

public class TPRippleBackground
  extends RelativeLayout
{
  private ArrayList<Animator> H3;
  private RelativeLayout.LayoutParams I3;
  private ArrayList<a> J3 = new ArrayList();
  private int c;
  private float d;
  private float f;
  private int p0;
  private Paint p1;
  private boolean p2 = false;
  private AnimatorSet p3;
  private int q;
  private int x;
  private int y;
  private float z;
  
  public TPRippleBackground(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPRippleBackground(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext, paramAttributeSet);
  }
  
  public TPRippleBackground(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext, paramAttributeSet);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (isInEditMode()) {
      return;
    }
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPRippleBackground);
      this.c = paramContext.getColor(x0.TPRippleBackground_rb_color, getResources().getColor(p0.tp_rippelColor));
      this.d = paramContext.getDimension(x0.TPRippleBackground_rb_strokeWidth, getResources().getDimension(q0.tp_rippleStrokeWidth));
      this.f = paramContext.getDimension(x0.TPRippleBackground_rb_radius, getResources().getDimension(q0.tp_rippleRadius));
      this.q = paramContext.getInt(x0.TPRippleBackground_rb_duration, 3000);
      this.x = paramContext.getInt(x0.TPRippleBackground_rb_rippleAmount, 6);
      this.z = paramContext.getFloat(x0.TPRippleBackground_rb_scale, 6.0F);
      this.p0 = paramContext.getInt(x0.TPRippleBackground_rb_type, 0);
      paramContext.recycle();
      this.y = (this.q / this.x);
      paramContext = new Paint();
      this.p1 = paramContext;
      paramContext.setAntiAlias(true);
      if (this.p0 == 0)
      {
        this.d = 0.0F;
        this.p1.setStyle(Paint.Style.FILL);
      }
      else
      {
        this.p1.setStyle(Paint.Style.STROKE);
      }
      this.p1.setColor(this.c);
      float f1 = this.f;
      float f2 = this.d;
      paramContext = new RelativeLayout.LayoutParams((int)((f1 + f2) * 2.0F), (int)((f1 + f2) * 2.0F));
      this.I3 = paramContext;
      paramContext.addRule(13, -1);
      paramContext = new AnimatorSet();
      this.p3 = paramContext;
      paramContext.setInterpolator(new AccelerateDecelerateInterpolator());
      this.H3 = new ArrayList();
      for (int i = 0; i < this.x; i++)
      {
        paramContext = new a(getContext());
        addView(paramContext, this.I3);
        this.J3.add(paramContext);
        paramAttributeSet = ObjectAnimator.ofFloat(paramContext, "ScaleX", new float[] { 1.0F, this.z });
        paramAttributeSet.setRepeatCount(-1);
        paramAttributeSet.setRepeatMode(1);
        paramAttributeSet.setStartDelay(this.y * i);
        paramAttributeSet.setDuration(this.q);
        this.H3.add(paramAttributeSet);
        paramAttributeSet = ObjectAnimator.ofFloat(paramContext, "ScaleY", new float[] { 1.0F, this.z });
        paramAttributeSet.setRepeatCount(-1);
        paramAttributeSet.setRepeatMode(1);
        paramAttributeSet.setStartDelay(this.y * i);
        paramAttributeSet.setDuration(this.q);
        this.H3.add(paramAttributeSet);
        paramContext = ObjectAnimator.ofFloat(paramContext, "Alpha", new float[] { 1.0F, 0.0F });
        paramContext.setRepeatCount(-1);
        paramContext.setRepeatMode(1);
        paramContext.setStartDelay(this.y * i);
        paramContext.setDuration(this.q);
        this.H3.add(paramContext);
      }
      this.p3.playTogether(this.H3);
      return;
    }
    throw new IllegalArgumentException("Attributes should be provided to this view,");
  }
  
  public boolean d()
  {
    return this.p2;
  }
  
  public void e()
  {
    if (!d())
    {
      Iterator localIterator = this.J3.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).setVisibility(0);
      }
      this.p3.start();
      this.p2 = true;
    }
  }
  
  public void f()
  {
    if (d())
    {
      Iterator localIterator = this.J3.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).setVisibility(4);
      }
      this.p3.end();
      this.p2 = false;
    }
  }
  
  private class a
    extends View
  {
    public a(Context paramContext)
    {
      super();
      setVisibility(4);
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      float f = Math.min(getWidth(), getHeight()) / 2;
      paramCanvas.drawCircle(f, f, f - TPRippleBackground.a(TPRippleBackground.this), TPRippleBackground.b(TPRippleBackground.this));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPRippleBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */