package com.tplink.libtpcontrols.horizontalpageview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.v0;
import java.util.List;

public class TPHorizontalPageView
  extends LinearLayout
{
  private b c = null;
  private b d = null;
  private TPHorizontalPagerAdapter f;
  private boolean p0 = true;
  private ViewPager q;
  private TPCircleIndicator x;
  private int y;
  private int z = 0;
  
  public TPHorizontalPageView(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public TPHorizontalPageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public TPHorizontalPageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(t0.location_view, this);
    this.q = ((ViewPager)localView.findViewById(s0.viewpager));
    this.x = ((TPCircleIndicator)localView.findViewById(s0.indicator));
    paramContext = new TPHorizontalPagerAdapter(paramContext, getResources().getString(v0.space_add_room), getResources().getString(v0.space_add_room_mipmap_icon));
    this.f = paramContext;
    this.q.setAdapter(paramContext);
    this.x.setViewPager(this.q);
    this.f.d(new a(this));
    this.q.addOnPageChangeListener(new a());
  }
  
  public void setAdapterList(List<String> paramList)
  {
    if (this.z == 0)
    {
      this.p0 = true;
      this.f.e(paramList);
    }
    else if (paramList.size() < this.z * 8)
    {
      this.p0 = true;
      this.f.e(paramList);
    }
    else
    {
      this.p0 = false;
      this.f.f(paramList);
    }
    this.q.setAdapter(this.f);
    this.q.setCurrentItem(this.y);
    this.x.setViewPager(this.q);
  }
  
  public void setMaxPage(int paramInt)
  {
    if (paramInt >= 0) {
      this.z = paramInt;
    } else {
      Log.d("TPHorizontalPageView", "Max Page Number should be Greater than or equal to zero.");
    }
  }
  
  public void setOnAddClickListener(b paramb)
  {
    this.d = paramb;
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.c = paramb;
  }
  
  class a
    implements ViewPager.OnPageChangeListener
  {
    a() {}
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      TPHorizontalPageView.a(TPHorizontalPageView.this, paramInt);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalpageview\TPHorizontalPageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */