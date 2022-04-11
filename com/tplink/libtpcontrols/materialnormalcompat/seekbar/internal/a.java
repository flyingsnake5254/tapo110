package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.c;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b.b;

public class a
{
  private final WindowManager a;
  private boolean b;
  private a c;
  private b.b d;
  private int[] e = new int[2];
  Point f = new Point();
  
  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt, String paramString)
  {
    this.a = ((WindowManager)paramContext.getSystemService("window"));
    this.c = new a(paramContext, paramAttributeSet, paramInt, paramString);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.f.set(paramContext.widthPixels, paramContext.heightPixels);
  }
  
  private int b(int paramInt)
  {
    return paramInt & 0xFFF97DE7 | 0x8000 | 0x8 | 0x10 | 0x200;
  }
  
  private WindowManager.LayoutParams c(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.gravity = 8388659;
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.flags = b(localLayoutParams.flags);
    localLayoutParams.type = 1000;
    localLayoutParams.token = paramIBinder;
    localLayoutParams.softInputMode = 3;
    paramIBinder = new StringBuilder();
    paramIBinder.append("DiscreteSeekBar Indicator:");
    paramIBinder.append(Integer.toHexString(hashCode()));
    localLayoutParams.setTitle(paramIBinder.toString());
    return localLayoutParams;
  }
  
  private void f(WindowManager.LayoutParams paramLayoutParams)
  {
    this.a.addView(this.c, paramLayoutParams);
    a.c(this.c).d();
  }
  
  private void h()
  {
    int i = View.MeasureSpec.makeMeasureSpec(this.f.x, 1073741824);
    int j = View.MeasureSpec.makeMeasureSpec(this.f.y, Integer.MIN_VALUE);
    this.c.measure(i, j);
  }
  
  private void n(int paramInt)
  {
    this.c.e(paramInt + this.e[0]);
  }
  
  private void o(View paramView, WindowManager.LayoutParams paramLayoutParams, int paramInt)
  {
    h();
    int i = this.c.getMeasuredHeight();
    int j = a.c(this.c).getPaddingBottom();
    paramView.getLocationInWindow(this.e);
    paramLayoutParams.x = 0;
    paramLayoutParams.y = (this.e[1] - i + paramInt + j);
    paramLayoutParams.width = this.f.x;
    paramLayoutParams.height = i;
  }
  
  public void d()
  {
    a.c(this.c).c();
  }
  
  public void e()
  {
    if (g())
    {
      this.b = false;
      this.a.removeViewImmediate(this.c);
    }
  }
  
  public boolean g()
  {
    return this.b;
  }
  
  public void i(int paramInt)
  {
    if (!g()) {
      return;
    }
    n(paramInt);
  }
  
  public void j(int paramInt1, int paramInt2)
  {
    this.c.d(paramInt1, paramInt2);
  }
  
  public void k(b.b paramb)
  {
    this.d = paramb;
  }
  
  public void l(CharSequence paramCharSequence)
  {
    a.c(this.c).setValue(paramCharSequence);
  }
  
  public void m(View paramView, Rect paramRect)
  {
    if (g())
    {
      a.c(this.c).d();
      return;
    }
    Object localObject = paramView.getWindowToken();
    if (localObject != null)
    {
      localObject = c((IBinder)localObject);
      ((WindowManager.LayoutParams)localObject).gravity = 8388659;
      o(paramView, (WindowManager.LayoutParams)localObject, paramRect.bottom);
      this.b = true;
      n(paramRect.centerX());
      f((WindowManager.LayoutParams)localObject);
    }
  }
  
  public void p(String paramString)
  {
    e();
    a locala = this.c;
    if (locala != null) {
      a.c(locala).e(paramString);
    }
  }
  
  private class a
    extends FrameLayout
    implements b.b
  {
    private Marker c;
    private int d;
    
    public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt, String paramString)
    {
      super();
      this$1 = new Marker(paramContext, paramAttributeSet, paramInt, paramString);
      this.c = a.this;
      addView(a.this, new FrameLayout.LayoutParams(-2, -2, 51));
    }
    
    public void a()
    {
      if (a.a(a.this) != null) {
        a.a(a.this).a();
      }
      a.this.e();
    }
    
    public void b()
    {
      if (a.a(a.this) != null) {
        a.a(a.this).b();
      }
    }
    
    public void d(int paramInt1, int paramInt2)
    {
      this.c.f(paramInt1, paramInt2);
    }
    
    public void e(int paramInt)
    {
      this.d = paramInt;
      int i = this.c.getMeasuredWidth() / 2;
      Marker localMarker = this.c;
      localMarker.offsetLeftAndRight(paramInt - i - localMarker.getLeft());
      if (!c.b(this)) {
        invalidate();
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt1 = this.c.getMeasuredWidth() / 2;
      paramInt1 = this.d - paramInt1;
      Marker localMarker = this.c;
      localMarker.layout(paramInt1, 0, localMarker.getMeasuredWidth() + paramInt1, this.c.getMeasuredHeight());
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      measureChildren(paramInt1, paramInt2);
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.c.getMeasuredHeight());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */