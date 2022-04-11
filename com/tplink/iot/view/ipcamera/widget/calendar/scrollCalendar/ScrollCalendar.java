package com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class ScrollCalendar
  extends FrameLayout
  implements ViewPager.OnPageChangeListener
{
  private ScrollCalendarViewPager c;
  private a d;
  private TimeZone f = TimeZone.getDefault();
  private d q;
  private c x;
  private int y;
  private a z = a.c;
  
  public ScrollCalendar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollCalendar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    c(paramContext);
    b(paramContext, paramAttributeSet);
  }
  
  public ScrollCalendar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext);
    b(paramContext, paramAttributeSet);
  }
  
  private int a(d paramd)
  {
    return 99 - ((this.q.e() - paramd.e()) * 12 + (this.q.d() - paramd.d()));
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, com.tplink.iot.b.ScrollCalendar);
      paramAttributeSet.getColor(4, ContextCompat.getColor(getContext(), 2131099678));
      paramAttributeSet.getColor(5, ContextCompat.getColor(getContext(), 2131099678));
      int i = paramAttributeSet.getColor(0, ContextCompat.getColor(paramContext, 2131100106));
      int j = paramAttributeSet.getColor(2, ContextCompat.getColor(paramContext, 2131100107));
      boolean bool1 = paramAttributeSet.getBoolean(3, false);
      boolean bool2 = paramAttributeSet.getBoolean(1, false);
      this.d.c(i);
      this.d.h(j);
      this.d.g(bool1);
      this.d.d(bool2);
      paramAttributeSet.recycle();
    }
  }
  
  private void c(Context paramContext)
  {
    this.c = ((ScrollCalendarViewPager)LayoutInflater.from(paramContext).inflate(2131559455, this, true).findViewById(2131364857));
    paramContext = new a(getContext());
    this.d = paramContext;
    this.c.setAdapter(paramContext);
    this.c.addOnPageChangeListener(this);
    this.c.setCurrentItem(99);
  }
  
  public void d(Calendar paramCalendar)
  {
    this.y = 99;
    this.d.j(paramCalendar, 99);
    this.c.setCurrentItem(this.y);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.y == paramInt) {
      return;
    }
    this.y = paramInt;
    if (this.x != null)
    {
      d locald = this.d.a(paramInt);
      if (locald != null)
      {
        locald = locald.a();
        this.x.M0(locald);
      }
    }
  }
  
  public void setCurrentDate(d paramd)
  {
    this.q = paramd;
    this.d.b(paramd);
    this.y = 99;
  }
  
  public void setMarkDays(List<d> paramList)
  {
    if (paramList != null)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        String str = String.valueOf(a(locald));
        List localList = (List)localHashMap.get(str);
        paramList = localList;
        if (localList == null) {
          paramList = new ArrayList();
        }
        paramList.add(Integer.valueOf(locald.c()));
        localHashMap.put(str, paramList);
      }
      this.d.f(localHashMap);
    }
    else
    {
      this.d.f(null);
    }
  }
  
  public void setMonthDateClickListener(com.tplink.iot.view.ipcamera.widget.calendar.b paramb)
  {
    this.d.e(paramb);
  }
  
  public void setOnMonthSelectedListener(c paramc)
  {
    this.x = paramc;
  }
  
  public void setSelectMonth(d paramd)
  {
    int i = a(paramd);
    this.y = i;
    this.c.setCurrentItem(i);
  }
  
  public void setSelectedDay(d paramd)
  {
    if (paramd == null) {
      return;
    }
    if (this.q == null) {
      this.q = new d(paramd.e(), paramd.d(), paramd.c());
    }
    int i = a(paramd);
    this.y = i;
    this.d.i(paramd, i);
    this.c.setCurrentItem(this.y);
  }
  
  private static enum a
  {
    static
    {
      a locala1 = new a("HIDDEN", 0);
      c = locala1;
      a locala2 = new a("SHOWN", 1);
      d = locala2;
      f = new a[] { locala1, locala2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\calendar\scrollCalendar\ScrollCalendar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */