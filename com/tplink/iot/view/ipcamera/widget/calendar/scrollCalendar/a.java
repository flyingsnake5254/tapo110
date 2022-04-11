package com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.tplink.iot.view.ipcamera.widget.calendar.MonthDateView;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class a
  extends PagerAdapter
{
  private Context a;
  private Map<String, d> b;
  private Map<String, MonthDateView> c;
  private Map<String, List<Integer>> d;
  private d e;
  private d f;
  private int g;
  private b h;
  private boolean i = true;
  private Calendar j;
  private boolean k;
  private int l;
  private int m;
  private boolean n;
  
  a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap();
    this.c = new HashMap();
    this.d = new HashMap();
    this.k = false;
    this.n = false;
    this.l = ContextCompat.getColor(paramContext, 2131100106);
    this.m = ContextCompat.getColor(paramContext, 2131100107);
  }
  
  d a(int paramInt)
  {
    return (d)this.b.get(String.valueOf(paramInt));
  }
  
  void b(d paramd)
  {
    this.g = 99;
    this.f = paramd;
    this.e = paramd;
    this.b.clear();
    this.b.put(String.valueOf(this.g), this.f);
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = String.valueOf(paramInt);
    MonthDateView localMonthDateView = (MonthDateView)this.c.remove(paramObject);
    if (localMonthDateView != null)
    {
      localMonthDateView.setMonthDateClickListener(null);
      paramViewGroup.removeView(localMonthDateView);
    }
    this.b.remove(paramObject);
  }
  
  public void e(b paramb)
  {
    this.h = paramb;
  }
  
  void f(Map<String, List<Integer>> paramMap)
  {
    if (paramMap == null)
    {
      this.d.clear();
    }
    else
    {
      this.d = paramMap;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        Object localObject = (String)localEntry.getKey();
        localObject = (MonthDateView)this.c.get(localObject);
        if (localObject != null) {
          ((MonthDateView)localObject).setMarkedDays((List)localEntry.getValue());
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public void g(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public int getCount()
  {
    return 100;
  }
  
  public void h(int paramInt)
  {
    this.m = paramInt;
  }
  
  void i(d paramd, int paramInt)
  {
    this.g = paramInt;
    this.f = paramd.a();
    this.b.put(String.valueOf(paramInt), paramd);
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)((Map.Entry)localIterator.next()).getKey();
      paramd = (MonthDateView)this.c.get(str);
      if (paramd != null) {
        if (str.equals(String.valueOf(paramInt))) {
          paramd.setSelectedDayInfo(this.f);
        } else {
          paramd.m();
        }
      }
    }
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    String str = String.valueOf(paramInt);
    MonthDateView localMonthDateView;
    if (this.c.containsKey(str))
    {
      localMonthDateView = (MonthDateView)this.c.remove(str);
    }
    else
    {
      localMonthDateView = new MonthDateView(this.a);
      localMonthDateView.setIgnoreLastDay(this.i);
      localMonthDateView.setLastDay(this.j);
      localMonthDateView.setDayColor(this.l);
      localMonthDateView.setInterceptTouch(this.k);
      localMonthDateView.setOutOfDateTextColor(this.m);
      localMonthDateView.setOnlyMarkClick(this.n);
    }
    Object localObject;
    if (this.b.containsKey(str))
    {
      localObject = (d)this.b.get(str);
    }
    else
    {
      d locald = this.e.a();
      for (int i1 = 0;; i1++)
      {
        localObject = locald;
        if (i1 >= 99 - paramInt) {
          break;
        }
        locald.f();
      }
    }
    if (paramInt == this.g) {
      localMonthDateView.setSelectedDayInfo(this.f);
    } else {
      localMonthDateView.n(((d)localObject).e(), ((d)localObject).d());
    }
    if (this.d.containsKey(str)) {
      localMonthDateView.setMarkedDays((List)this.d.get(str));
    } else {
      localMonthDateView.setMarkedDays(null);
    }
    localMonthDateView.setTag(Integer.valueOf(paramInt));
    localMonthDateView.setMonthDateClickListener(this.h);
    paramViewGroup.addView(localMonthDateView);
    this.b.put(str, localObject);
    this.c.put(str, localMonthDateView);
    return localMonthDateView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    boolean bool;
    if (paramView == paramObject) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void j(Calendar paramCalendar, int paramInt)
  {
    this.j = paramCalendar;
    this.g = paramInt;
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)((Map.Entry)localIterator.next()).getKey();
      MonthDateView localMonthDateView = (MonthDateView)this.c.get(str);
      if ((localMonthDateView != null) && (str.equals(String.valueOf(paramInt)))) {
        localMonthDateView.o(paramCalendar);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\calendar\scrollCalendar\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */