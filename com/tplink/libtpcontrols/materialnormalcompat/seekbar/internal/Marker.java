package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b.b;
import com.tplink.libtpcontrols.o0;
import com.tplink.libtpcontrols.w0;
import com.tplink.libtpcontrols.x0;

public class Marker
  extends ViewGroup
  implements b.b
{
  private TextView c;
  private int d;
  private int f;
  b q;
  private int x;
  
  public Marker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Marker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, o0.discreteSeekBarStyle);
  }
  
  public Marker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, "0");
  }
  
  public Marker(Context paramContext, AttributeSet paramAttributeSet, int paramInt, String paramString)
  {
    super(paramContext, paramAttributeSet, paramInt);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.DiscreteSeekBar, o0.discreteSeekBarStyle, w0.DefaultSeekBar);
    paramInt = paramAttributeSet.getDimensionPixelSize(x0.DiscreteSeekBar_dsb_indicatorPadding, -1);
    this.x = paramInt;
    if (paramInt > 0) {
      paramInt *= 2;
    } else {
      paramInt = 0;
    }
    int i = paramAttributeSet.getResourceId(x0.DiscreteSeekBar_dsb_indicatorTextAppearance, w0.DefaultIndicatorTextAppearance);
    TextView localTextView = new TextView(paramContext);
    this.c = localTextView;
    localTextView.setPadding(paramInt, 0, paramInt, 0);
    this.c.setTextAppearance(paramContext, i);
    this.c.setGravity(17);
    this.c.setText(paramString);
    this.c.setMaxLines(1);
    this.c.setSingleLine(true);
    com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.c.g(this.c, 5);
    this.c.setVisibility(4);
    setPadding(paramInt, paramInt, paramInt, paramInt);
    e(paramString);
    float f1 = localDisplayMetrics.density;
    this.f = ((int)(30.0F * f1));
    i = (int)(f1 * 22.0F);
    paramContext = new b(paramAttributeSet.getColorStateList(x0.DiscreteSeekBar_dsb_indicatorColor), i);
    this.q = paramContext;
    paramContext.setCallback(this);
    this.q.t(this);
    this.q.s(paramInt);
    ViewCompat.setElevation(this, paramAttributeSet.getDimension(x0.DiscreteSeekBar_dsb_indicatorElevation, localDisplayMetrics.density * 8.0F));
    if (Build.VERSION.SDK_INT >= 21) {
      com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.c.f(this, this.q);
    }
    paramAttributeSet.recycle();
  }
  
  public void a()
  {
    if ((getParent() instanceof b.b)) {
      ((b.b)getParent()).a();
    }
  }
  
  public void b()
  {
    this.c.setVisibility(0);
    if ((getParent() instanceof b.b)) {
      ((b.b)getParent()).b();
    }
  }
  
  public void c()
  {
    this.q.stop();
    this.c.setVisibility(4);
    this.q.l();
  }
  
  public void d()
  {
    this.q.stop();
    this.q.m();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.q.draw(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  public void e(String paramString)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    TextView localTextView = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    localTextView.setText(localStringBuilder.toString());
    int i = View.MeasureSpec.makeMeasureSpec(localDisplayMetrics.widthPixels, Integer.MIN_VALUE);
    int j = View.MeasureSpec.makeMeasureSpec(localDisplayMetrics.heightPixels, Integer.MIN_VALUE);
    this.c.measure(i, j);
    this.d = Math.max(this.c.getMeasuredWidth(), this.c.getMeasuredHeight());
    removeView(this.c);
    paramString = this.c;
    i = this.d;
    addView(paramString, new FrameLayout.LayoutParams(i, i, 51));
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    this.q.r(paramInt1, paramInt2);
  }
  
  public CharSequence getValue()
  {
    return this.c.getText();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.q.stop();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int j = getWidth();
    paramInt4 = getPaddingRight();
    int k = getHeight();
    paramInt3 = getPaddingBottom();
    TextView localTextView = this.c;
    paramInt2 = this.d;
    localTextView.layout(i, paramInt1, i + paramInt2, paramInt2 + paramInt1);
    this.q.setBounds(i, paramInt1, j - paramInt4, k - paramInt3);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChildren(paramInt1, paramInt2);
    int i = this.d;
    int j = getPaddingLeft();
    paramInt1 = getPaddingRight();
    int k = this.d;
    paramInt2 = getPaddingTop();
    int m = getPaddingBottom();
    int n = this.d;
    setMeasuredDimension(i + j + paramInt1, k + paramInt2 + m + (int)(n * 1.41F - n) / 2 + this.f);
  }
  
  public void setValue(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool;
    if ((paramDrawable != this.q) && (!super.verifyDrawable(paramDrawable))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */