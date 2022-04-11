package com.tplink.iot.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.tplink.iot.b;

public class RippleCardView
  extends CardView
{
  private int H3;
  private int I3;
  private int J3;
  private int K3;
  private int L3;
  private int M3;
  private float N3;
  private int O3;
  private int P3;
  private int Q3;
  private ObjectAnimator c;
  private boolean d;
  private boolean f;
  private float p0;
  private PorterDuffXfermode p1;
  private Paint p2;
  private RectF p3;
  private float q;
  private float x;
  private float y;
  private float z;
  
  public RippleCardView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RippleCardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RippleCardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, b.RippleCardView, paramInt, 0);
    this.O3 = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    d();
  }
  
  private void b(Canvas paramCanvas)
  {
    this.p3.set(0.0F, 0.0F, this.L3, this.M3);
    this.p2.setColor(-1);
    paramCanvas.drawRoundRect(this.p3, 20.0F, 20.0F, this.p2);
    int i = paramCanvas.saveLayer(this.p3, this.p2, 31);
    paramCanvas.drawRoundRect(this.p3, 20.0F, 20.0F, this.p2);
    this.p2.setXfermode(this.p1);
    this.p2.setColor(this.H3);
    paramCanvas.drawCircle(this.y, this.p0, this.x, this.p2);
    this.p2.setXfermode(null);
    paramCanvas.restoreToCount(i);
  }
  
  private void c(View paramView)
  {
    this.P3 = paramView.getLeft();
    this.Q3 = paramView.getTop();
    for (paramView = (ViewGroup)paramView.getParent(); (paramView != null) && (paramView != this); paramView = (ViewGroup)paramView.getParent())
    {
      this.P3 += paramView.getLeft();
      this.Q3 += paramView.getTop();
    }
  }
  
  private void d()
  {
    this.p1 = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    Object localObject = new Paint(1);
    this.p2 = ((Paint)localObject);
    ((Paint)localObject).setStyle(Paint.Style.FILL);
    this.p3 = new RectF();
    int i = Color.parseColor("#FF1BCBFF");
    this.I3 = Color.red(i);
    this.J3 = Color.green(i);
    this.K3 = Color.blue(i);
    localObject = ObjectAnimator.ofFloat(this, "animValue", new float[] { 0.0F, 1.0F });
    this.c = ((ObjectAnimator)localObject);
    ((ObjectAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    this.c.addListener(new a());
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.d) {
      b(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void e(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.d) {
      this.c.cancel();
    }
    this.c.setDuration(500L);
    this.c.start();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.L3 = getWidth();
    paramInt1 = getHeight();
    this.M3 = paramInt1;
    this.p3.set(0.0F, 0.0F, this.L3, paramInt1);
    paramInt2 = this.L3;
    paramInt1 = this.M3;
    this.q = ((float)Math.sqrt(paramInt2 * paramInt2 + paramInt1 * paramInt1));
    paramInt1 = this.O3;
    if (paramInt1 != 0)
    {
      View localView = findViewById(paramInt1);
      if (localView != null)
      {
        c(localView);
        paramInt1 = this.P3;
        if ((paramInt1 != 0) && (this.Q3 != 0))
        {
          this.y = ((float)(paramInt1 + localView.getMeasuredWidth() / 2.0D));
          this.z = ((float)(this.Q3 + localView.getMeasuredHeight() / 2.0D));
        }
      }
    }
    this.N3 = ((float)(this.M3 / 2.0D - this.z));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAnimValue(float paramFloat)
  {
    float f1 = this.q;
    boolean bool = this.f;
    if (bool) {
      f2 = paramFloat;
    } else {
      f2 = 1.0F - paramFloat;
    }
    this.x = (f1 * f2);
    if (bool) {
      f2 = paramFloat;
    } else {
      f2 = 1.0F - paramFloat;
    }
    this.H3 = Color.argb((int)(f2 * 255.0F), this.I3, this.J3, this.K3);
    float f2 = this.z;
    if (this.f) {
      paramFloat *= this.N3;
    } else {
      paramFloat = 0.0F;
    }
    this.p0 = (f2 + paramFloat);
    invalidate();
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      RippleCardView.a(RippleCardView.this, false);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      RippleCardView.a(RippleCardView.this, false);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      RippleCardView.a(RippleCardView.this, true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\RippleCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */