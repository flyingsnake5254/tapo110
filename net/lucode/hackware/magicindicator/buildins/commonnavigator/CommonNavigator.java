package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.b.a;

public class CommonNavigator
  extends FrameLayout
  implements net.lucode.hackware.magicindicator.f.a, b.a
{
  private int H3;
  private int I3;
  private boolean J3;
  private boolean K3;
  private boolean L3 = true;
  private List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> M3 = new ArrayList();
  private DataSetObserver N3 = new a();
  private HorizontalScrollView c;
  private LinearLayout d;
  private LinearLayout f;
  private boolean p0;
  private float p1 = 0.5F;
  private boolean p2 = true;
  private boolean p3 = true;
  private net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c q;
  private net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a x;
  private net.lucode.hackware.magicindicator.b y;
  private boolean z;
  
  public CommonNavigator(Context paramContext)
  {
    super(paramContext);
    paramContext = new net.lucode.hackware.magicindicator.b();
    this.y = paramContext;
    paramContext.k(this);
  }
  
  private void j()
  {
    removeAllViews();
    if (this.z) {
      localObject = LayoutInflater.from(getContext()).inflate(net.lucode.hackware.magicindicator.d.pager_navigator_layout_no_scroll, this);
    } else {
      localObject = LayoutInflater.from(getContext()).inflate(net.lucode.hackware.magicindicator.d.pager_navigator_layout, this);
    }
    this.c = ((HorizontalScrollView)((View)localObject).findViewById(net.lucode.hackware.magicindicator.c.scroll_view));
    LinearLayout localLinearLayout = (LinearLayout)((View)localObject).findViewById(net.lucode.hackware.magicindicator.c.title_container);
    this.d = localLinearLayout;
    localLinearLayout.setPadding(this.I3, 0, this.H3, 0);
    Object localObject = (LinearLayout)((View)localObject).findViewById(net.lucode.hackware.magicindicator.c.indicator_container);
    this.f = ((LinearLayout)localObject);
    if (this.J3) {
      ((LinearLayout)localObject).getParent().bringChildToFront(this.f);
    }
    k();
  }
  
  private void k()
  {
    int i = this.y.g();
    for (int j = 0; j < i; j++)
    {
      localObject = this.x.c(getContext(), j);
      if ((localObject instanceof View))
      {
        View localView = (View)localObject;
        if (this.z)
        {
          localObject = new LinearLayout.LayoutParams(0, -1);
          ((LinearLayout.LayoutParams)localObject).weight = this.x.d(getContext(), j);
        }
        else
        {
          localObject = new LinearLayout.LayoutParams(-2, -1);
        }
        this.d.addView(localView, (ViewGroup.LayoutParams)localObject);
      }
    }
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a)localObject).b(getContext());
      this.q = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c)localObject);
      if ((localObject instanceof View))
      {
        localObject = new FrameLayout.LayoutParams(-1, -1);
        this.f.addView((View)this.q, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void l()
  {
    this.M3.clear();
    int i = this.y.g();
    for (int j = 0; j < i; j++)
    {
      net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a locala = new net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a();
      Object localObject = this.d.getChildAt(j);
      if (localObject != null)
      {
        locala.a = ((View)localObject).getLeft();
        locala.b = ((View)localObject).getTop();
        locala.c = ((View)localObject).getRight();
        int k = ((View)localObject).getBottom();
        locala.d = k;
        if ((localObject instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b))
        {
          localObject = (net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b)localObject;
          locala.e = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b)localObject).getContentLeft();
          locala.f = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b)localObject).getContentTop();
          locala.g = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b)localObject).getContentRight();
          locala.h = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b)localObject).getContentBottom();
        }
        else
        {
          locala.e = locala.a;
          locala.f = locala.b;
          locala.g = locala.c;
          locala.h = k;
        }
      }
      this.M3.add(locala);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = ((LinearLayout)localObject).getChildAt(paramInt1);
    if ((localObject instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d)) {
      ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d)localObject).a(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = ((LinearLayout)localObject).getChildAt(paramInt1);
    if ((localObject instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d)) {
      ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d)localObject).b(paramInt1, paramInt2, paramFloat, paramBoolean);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = ((LinearLayout)localObject).getChildAt(paramInt1);
    if ((localObject instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d)) {
      ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d)localObject).c(paramInt1, paramInt2);
    }
    if ((!this.z) && (!this.p3) && (this.c != null) && (this.M3.size() > 0))
    {
      paramInt1 = Math.min(this.M3.size() - 1, paramInt1);
      localObject = (net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)this.M3.get(paramInt1);
      if (this.p0)
      {
        float f1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).a() - this.c.getWidth() * this.p1;
        if (this.p2) {
          this.c.smoothScrollTo((int)f1, 0);
        } else {
          this.c.scrollTo((int)f1, 0);
        }
      }
      else
      {
        paramInt2 = this.c.getScrollX();
        paramInt1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).a;
        if (paramInt2 > paramInt1)
        {
          if (this.p2) {
            this.c.smoothScrollTo(paramInt1, 0);
          } else {
            this.c.scrollTo(paramInt1, 0);
          }
        }
        else
        {
          paramInt2 = this.c.getScrollX();
          paramInt1 = getWidth();
          int i = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).c;
          if (paramInt2 + paramInt1 < i) {
            if (this.p2) {
              this.c.smoothScrollTo(i - getWidth(), 0);
            } else {
              this.c.scrollTo(i - getWidth(), 0);
            }
          }
        }
      }
    }
  }
  
  public void d(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = ((LinearLayout)localObject).getChildAt(paramInt1);
    if ((localObject instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d)) {
      ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d)localObject).d(paramInt1, paramInt2, paramFloat, paramBoolean);
    }
  }
  
  public void e()
  {
    j();
  }
  
  public void f() {}
  
  public net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a getAdapter()
  {
    return this.x;
  }
  
  public int getLeftPadding()
  {
    return this.I3;
  }
  
  public net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c getPagerIndicator()
  {
    return this.q;
  }
  
  public int getRightPadding()
  {
    return this.H3;
  }
  
  public float getScrollPivotX()
  {
    return this.p1;
  }
  
  public LinearLayout getTitleContainer()
  {
    return this.d;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.x != null)
    {
      l();
      net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c localc = this.q;
      if (localc != null) {
        localc.a(this.M3);
      }
      if ((this.L3) && (this.y.f() == 0))
      {
        onPageSelected(this.y.e());
        onPageScrolled(this.y.e(), 0.0F, 0);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.x != null)
    {
      this.y.h(paramInt);
      net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c localc = this.q;
      if (localc != null) {
        localc.onPageScrollStateChanged(paramInt);
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.x != null)
    {
      this.y.i(paramInt1, paramFloat, paramInt2);
      Object localObject = this.q;
      if (localObject != null) {
        ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      if ((this.c != null) && (this.M3.size() > 0) && (paramInt1 >= 0) && (paramInt1 < this.M3.size()) && (this.p3))
      {
        paramInt2 = Math.min(this.M3.size() - 1, paramInt1);
        paramInt1 = Math.min(this.M3.size() - 1, paramInt1 + 1);
        localObject = (net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)this.M3.get(paramInt2);
        net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a locala = (net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)this.M3.get(paramInt1);
        float f1 = ((net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)localObject).a() - this.c.getWidth() * this.p1;
        float f2 = locala.a();
        float f3 = this.c.getWidth();
        float f4 = this.p1;
        this.c.scrollTo((int)(f1 + (f2 - f3 * f4 - f1) * paramFloat), 0);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.x != null)
    {
      this.y.j(paramInt);
      net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c localc = this.q;
      if (localc != null) {
        localc.onPageSelected(paramInt);
      }
    }
  }
  
  public void setAdapter(net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a parama)
  {
    net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a locala = this.x;
    if (locala == parama) {
      return;
    }
    if (locala != null) {
      locala.g(this.N3);
    }
    this.x = parama;
    if (parama != null)
    {
      parama.f(this.N3);
      this.y.m(this.x.a());
      if (this.d != null) {
        this.x.e();
      }
    }
    else
    {
      this.y.m(0);
      j();
    }
  }
  
  public void setAdjustMode(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void setEnablePivotScroll(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
  }
  
  public void setFollowTouch(boolean paramBoolean)
  {
    this.p3 = paramBoolean;
  }
  
  public void setIndicatorOnTop(boolean paramBoolean)
  {
    this.J3 = paramBoolean;
  }
  
  public void setLeftPadding(int paramInt)
  {
    this.I3 = paramInt;
  }
  
  public void setReselectWhenLayout(boolean paramBoolean)
  {
    this.L3 = paramBoolean;
  }
  
  public void setRightPadding(int paramInt)
  {
    this.H3 = paramInt;
  }
  
  public void setScrollPivotX(float paramFloat)
  {
    this.p1 = paramFloat;
  }
  
  public void setSkimOver(boolean paramBoolean)
  {
    this.K3 = paramBoolean;
    this.y.l(paramBoolean);
  }
  
  public void setSmoothScroll(boolean paramBoolean)
  {
    this.p2 = paramBoolean;
  }
  
  class a
    extends DataSetObserver
  {
    a() {}
    
    public void onChanged()
    {
      CommonNavigator.h(CommonNavigator.this).m(CommonNavigator.g(CommonNavigator.this).a());
      CommonNavigator.i(CommonNavigator.this);
    }
    
    public void onInvalidated() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\CommonNavigator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */