package com.tplink.libtpcontrols.horizontalpageview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager.widget.PagerAdapter;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.v0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TPHorizontalPagerAdapter
  extends PagerAdapter
{
  private Context a;
  private String b;
  private String c;
  private List<String> d = new ArrayList();
  private List<String> e = new ArrayList();
  private a f = null;
  
  public TPHorizontalPagerAdapter(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d.add(paramString1);
    this.e.add(this.c);
  }
  
  public int a()
  {
    return this.d.size();
  }
  
  public void d(a parama)
  {
    this.f = parama;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public void e(List<String> paramList)
  {
    this.d.clear();
    this.d.addAll(paramList);
    this.d.add(this.b);
    this.e.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      this.e.add(this.a.getString(v0.space_custom_mipmap_icon));
    }
    this.e.add(this.c);
    notifyDataSetChanged();
  }
  
  public void f(List<String> paramList)
  {
    this.d.clear();
    this.d.addAll(paramList);
    this.e.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      this.e.add(this.a.getString(v0.space_custom_mipmap_icon));
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int i;
    if (this.d.size() == 0) {
      i = 0;
    } else {
      i = (this.d.size() - 1) / 8 + 1;
    }
    return i;
  }
  
  @NonNull
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(t0.location_pager_adapter, null, false);
    RecyclerView localRecyclerView = (RecyclerView)localView.findViewById(s0.recycle_view);
    localRecyclerView.setLayoutManager(new TPHorizontalGridLayoutManager(paramViewGroup.getContext(), 2, 0, false));
    int i = (paramInt + 1) * 8;
    List localList;
    if (i > this.d.size())
    {
      localObject = this.d;
      i = paramInt * 8;
      localList = ((List)localObject).subList(i, ((List)localObject).size());
      localObject = this.e;
      localObject = ((List)localObject).subList(i, ((List)localObject).size());
    }
    else
    {
      localObject = this.d;
      int j = paramInt * 8;
      localList = ((List)localObject).subList(j, i);
      localObject = this.e.subList(j, i);
    }
    Object localObject = new TPHorizontalRecycleAdapter(this.a, localList, (List)localObject);
    localRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    ((TPHorizontalRecycleAdapter)localObject).q(new b(this, paramInt));
    paramViewGroup.addView(localView, -1, -1);
    return localView;
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    boolean bool;
    if (paramView == paramObject) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalpageview\TPHorizontalPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */