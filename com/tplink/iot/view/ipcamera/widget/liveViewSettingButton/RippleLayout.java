package com.tplink.iot.view.ipcamera.widget.liveViewSettingButton;

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
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import b.d.q.b.o;
import com.tplink.iot.b;
import java.util.ArrayList;

public class RippleLayout
  extends RelativeLayout
{
  private AnimatorSet H3;
  private ArrayList<Animator> I3;
  private RelativeLayout.LayoutParams J3;
  private DisplayMetrics K3;
  private int c;
  private int d;
  private int f;
  private int p0;
  private float p1;
  private boolean p2;
  private Paint p3;
  private float q;
  private float x;
  private int y;
  private int z;
  
  public RippleLayout(Context paramContext)
  {
    super(paramContext);
    int i = o.a(getContext(), 1.5F);
    this.c = i;
    this.d = 0;
    this.q = i;
    this.x = 0;
    this.y = 1900;
    this.z = 2;
    this.p1 = 1.8F;
    this.p2 = false;
    this.p3 = new Paint();
    this.H3 = new AnimatorSet();
    this.I3 = new ArrayList();
    g(paramContext, null);
  }
  
  public RippleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = o.a(getContext(), 1.5F);
    this.c = i;
    this.d = 0;
    this.q = i;
    this.x = 0;
    this.y = 1900;
    this.z = 2;
    this.p1 = 1.8F;
    this.p2 = false;
    this.p3 = new Paint();
    this.H3 = new AnimatorSet();
    this.I3 = new ArrayList();
    g(paramContext, paramAttributeSet);
  }
  
  public RippleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = o.a(getContext(), 1.5F);
    this.c = paramInt;
    this.d = 0;
    this.q = paramInt;
    this.x = 0;
    this.y = 1900;
    this.z = 2;
    this.p1 = 1.8F;
    this.p2 = false;
    this.p3 = new Paint();
    this.H3 = new AnimatorSet();
    this.I3 = new ArrayList();
    g(paramContext, paramAttributeSet);
  }
  
  private void d(a parama, int paramInt)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(parama, "scaleX", new float[] { 1.0F, this.p1 });
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setRepeatMode(1);
    localObjectAnimator.setStartDelay(this.p0 * paramInt);
    localObjectAnimator.setDuration(this.y);
    this.I3.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(parama, "scaleY", new float[] { 1.0F, this.p1 });
    localObjectAnimator.setRepeatMode(1);
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setStartDelay(this.p0 * paramInt);
    localObjectAnimator.setDuration(this.y);
    this.I3.add(localObjectAnimator);
    parama = ObjectAnimator.ofFloat(parama, "alpha", new float[] { 0.3F, 0.0F });
    parama.setRepeatMode(1);
    parama.setRepeatCount(-1);
    parama.setStartDelay(paramInt * this.p0);
    parama.setDuration(this.y);
    this.I3.add(parama);
  }
  
  private void e()
  {
    this.p0 = 500;
  }
  
  private void f()
  {
    e();
    h();
    for (int i = 0; i < this.z; i++)
    {
      a locala = new a(getContext());
      addView(locala, this.J3);
      locala.setAlpha(0.3F);
      d(locala, i);
    }
    this.H3.playTogether(this.I3);
  }
  
  private void g(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.K3 = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.K3);
    this.x = o.a(getContext(), 27.0F);
    this.q = this.c;
    this.f = getResources().getColor(2131100154);
    if (isInEditMode()) {
      return;
    }
    if (paramAttributeSet != null) {
      k(paramContext, paramAttributeSet);
    }
    i();
    j();
    f();
  }
  
  private void h()
  {
    this.H3.setDuration(this.y);
    this.H3.setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  private void i()
  {
    Paint localPaint = new Paint();
    this.p3 = localPaint;
    localPaint.setAntiAlias(true);
    this.p3.setStyle(Paint.Style.STROKE);
    this.p3.setStrokeWidth(this.q);
    this.q = 0.0F;
    this.p3.setColor(this.f);
  }
  
  private void j()
  {
    int i = (int)((this.x + this.q) * 2.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    this.J3 = localLayoutParams;
    localLayoutParams.addRule(13, -1);
  }
  
  private void k(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.RippleLayout);
    this.f = paramContext.getColor(0, getResources().getColor(2131100154));
    this.q = paramContext.getDimension(5, this.c);
    this.x = paramContext.getDimension(4, this.d);
    this.y = paramContext.getInt(1, 1900);
    this.z = paramContext.getInt(2, 2);
    this.p1 = paramContext.getFloat(3, 1.8F);
    paramContext.recycle();
  }
  
  private void m()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if ((localView instanceof a))
      {
        localView.setScaleX(1.0F);
        localView.setScaleY(1.0F);
        localView.setAlpha(0.3F);
        localView.setVisibility(4);
      }
    }
  }
  
  private void n()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if ((localView instanceof a)) {
        localView.setVisibility(0);
      }
    }
  }
  
  public boolean l()
  {
    return this.p2;
  }
  
  public void o()
  {
    if (!l())
    {
      n();
      this.H3.start();
      this.p2 = true;
    }
  }
  
  public void p()
  {
    if (l())
    {
      m();
      this.H3.end();
      this.p2 = false;
    }
  }
  
  public void setmRippleColor(int paramInt)
  {
    this.f = paramInt;
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
      paramCanvas.drawCircle(RippleLayout.a(RippleLayout.this), RippleLayout.a(RippleLayout.this), RippleLayout.a(RippleLayout.this) - RippleLayout.b(RippleLayout.this), RippleLayout.c(RippleLayout.this));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\liveViewSettingButton\RippleLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */