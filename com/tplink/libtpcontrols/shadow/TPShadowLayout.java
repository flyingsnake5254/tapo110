package com.tplink.libtpcontrols.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import b.d.w.c.a;
import com.hitomi.cslibrary.base.view.CornerShadowView;
import com.hitomi.cslibrary.base.view.CornerShadowView.b;
import com.hitomi.cslibrary.base.view.EdgeShadowView;
import com.hitomi.cslibrary.base.view.EdgeShadowView.b;
import com.tplink.libtpcontrols.p0;
import com.tplink.libtpcontrols.x0;

public class TPShadowLayout
  extends FrameLayout
{
  private CornerShadowView H3 = null;
  private int[] I3 = new int[3];
  private float c = 9.0F;
  private float d = 0.0F;
  private int f = -1;
  private EdgeShadowView p0 = null;
  private CornerShadowView p1 = null;
  private CornerShadowView p2 = null;
  private CornerShadowView p3 = null;
  private Context q = null;
  private EdgeShadowView x = null;
  private EdgeShadowView y = null;
  private EdgeShadowView z = null;
  
  public TPShadowLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPShadowLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPShadowLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    c();
    e();
    g();
    i();
    f();
    j();
    h();
    d();
  }
  
  private void b()
  {
    this.I3[0] = ColorUtils.setAlphaComponent(this.f, 255);
    this.I3[1] = ColorUtils.setAlphaComponent(this.f, 128);
    this.I3[2] = ColorUtils.setAlphaComponent(this.f, 0);
  }
  
  private void c()
  {
    this.x = new EdgeShadowView.b().b(this.q).e(this.I3).c(this.d).f(this.c).g(getWidth() - (this.c + this.d) * 2.0F).d(8).a();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    int i = getHeight();
    float f1 = this.c;
    localLayoutParams.topMargin = (i - (int)f1);
    localLayoutParams.leftMargin = ((int)(f1 + this.d));
    addView(this.x, localLayoutParams);
  }
  
  private void d()
  {
    this.H3 = new CornerShadowView.b().b(this.q).e(this.I3).f(this.c).c(this.d).d(128).a();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = (getHeight() - (int)(this.c + this.d));
    addView(this.H3, localLayoutParams);
  }
  
  private void e()
  {
    this.z = new EdgeShadowView.b().b(this.q).e(this.I3).c(this.d).f(this.c).g(getHeight() - (this.c + this.d) * 2.0F).d(1).a();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    float f1 = this.c;
    float f2 = this.d;
    localLayoutParams.topMargin = ((int)(f1 + f2));
    localLayoutParams.bottomMargin = ((int)(f1 + f2));
    addView(this.z, localLayoutParams);
  }
  
  private void f()
  {
    this.p1 = new CornerShadowView.b().b(this.q).e(this.I3).f(this.c).c(this.d).d(16).a();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = 0;
    localLayoutParams.leftMargin = 0;
    addView(this.p1, localLayoutParams);
  }
  
  private void g()
  {
    this.p0 = new EdgeShadowView.b().b(this.q).e(this.I3).c(this.d).f(this.c).g(getHeight() - (this.c + this.d) * 2.0F).d(4).a();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = ((int)(this.c + this.d));
    localLayoutParams.leftMargin = (getWidth() - (int)this.c);
    addView(this.p0, localLayoutParams);
  }
  
  private void h()
  {
    this.p3 = new CornerShadowView.b().b(this.q).e(this.I3).f(this.c).c(this.d).d(64).a();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = (getHeight() - (int)(this.c + this.d));
    localLayoutParams.leftMargin = (getWidth() - (int)(this.c + this.d));
    addView(this.p3, localLayoutParams);
  }
  
  private void i()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TPShadowLayout getWidth = ");
    ((StringBuilder)localObject).append(getWidth());
    a.d(((StringBuilder)localObject).toString());
    this.y = new EdgeShadowView.b().b(this.q).e(this.I3).c(this.d).f(this.c).g(getWidth() - (this.c + this.d) * 2.0F).d(2).a();
    localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(this.c + this.d));
    addView(this.y, (ViewGroup.LayoutParams)localObject);
  }
  
  private void j()
  {
    this.p2 = new CornerShadowView.b().b(this.q).e(this.I3).f(this.c).c(this.d).d(32).a();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = 0;
    localLayoutParams.leftMargin = (getWidth() - (int)(this.c + this.d));
    addView(this.p2, localLayoutParams);
  }
  
  private void k(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.q = paramContext;
    this.f = ContextCompat.getColor(paramContext, p0.common_tplink_teal);
    if (paramAttributeSet != null)
    {
      paramContext = this.q.obtainStyledAttributes(paramAttributeSet, x0.TPShadowLayout);
      this.c = paramContext.getDimension(x0.TPShadowLayout_sl_shadow_radius, this.c);
      this.d = paramContext.getDimension(x0.TPShadowLayout_sl_shadow_corner_radius, this.d);
      this.f = paramContext.getColor(x0.TPShadowLayout_sl_shadow_color, this.f);
      paramContext.recycle();
    }
    b();
    post(new c(this));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setShadowColor(int paramInt)
  {
    this.f = paramInt;
    b();
    post(new d(this));
  }
  
  public void setShadowCornerRadius(float paramFloat)
  {
    this.d = paramFloat;
    removeAllViews();
    requestLayout();
    post(new c(this));
  }
  
  public void setShadowRadius(float paramFloat)
  {
    this.c = paramFloat;
    removeAllViews();
    requestLayout();
    post(new c(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\shadow\TPShadowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */