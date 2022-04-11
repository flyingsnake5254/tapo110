package com.tplink.iot.adapter.home;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.model.home.DeviceInfoHolder;
import com.tplink.iot.model.home.DeviceInfoHolder.e;
import com.tplink.iot.model.home.TitleHolder;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.j;
import com.tplink.iot.model.home.k;
import com.tplink.iot.viewmodel.home.t;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RoomDeviceListAdapter
  extends RecyclerView.Adapter
  implements DeviceInfoHolder.e
{
  private Context a;
  private List<com.tplink.iot.model.home.h> b;
  private Map<String, Boolean> c;
  private Map<String, e> d = new HashMap();
  private boolean e = false;
  private Animation f;
  private h g;
  
  public RoomDeviceListAdapter(Activity paramActivity)
  {
    this.a = paramActivity;
    this.b = new ArrayList();
    this.c = new HashMap();
    paramActivity = AnimationUtils.loadAnimation(this.a, 2130771982);
    this.f = paramActivity;
    paramActivity.setInterpolator(new LinearInterpolator());
  }
  
  private static String n(Context paramContext, String paramString, BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    paramString = EnumDeviceType.fromType(paramString);
    if (EnumDeviceType.BULB == paramString) {
      return paramContext.getResources().getString(2131952867);
    }
    if (EnumDeviceType.CAMERA == paramString) {
      return paramContext.getResources().getString(2131952870);
    }
    if (EnumDeviceType.HUB == paramString) {
      return paramContext.getResources().getString(2131952874);
    }
    if (EnumDeviceType.SENSOR == paramString) {
      return paramContext.getResources().getString(2131952882);
    }
    if (EnumDeviceType.SWITCH == paramString) {
      return paramContext.getResources().getString(2131952883);
    }
    if (EnumDeviceType.ENERGY == paramString) {
      return paramContext.getResources().getString(2131952884);
    }
    return paramContext.getResources().getString(2131952881);
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void b(e parame)
  {
    this.d.put(parame.e(), parame);
  }
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (!paramBoolean) {
      this.d.clear();
    }
    notifyDataSetChanged();
  }
  
  public void d(e parame)
  {
    this.d.remove(parame.e());
  }
  
  public boolean g(e parame)
  {
    return this.d.containsValue(parame);
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.b.isEmpty()) {
      return 1;
    }
    return ((com.tplink.iot.model.home.h)this.b.get(paramInt)).a();
  }
  
  public void h()
  {
    h localh = this.g;
    if (localh != null) {
      localh.b(this.d.size());
    }
  }
  
  public void i(e parame)
  {
    h localh = this.g;
    if (localh != null) {
      localh.i(parame);
    }
  }
  
  public void j(e parame)
  {
    h localh = this.g;
    if (localh != null) {
      localh.j(parame);
    }
  }
  
  public void l(int paramInt, e parame, boolean paramBoolean)
  {
    h localh = this.g;
    if (localh != null) {
      localh.l(paramInt, parame, paramBoolean);
    }
  }
  
  public List<e> o()
  {
    return new ArrayList(this.d.values());
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new a());
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject;
    if ((paramViewHolder instanceof DeviceInfoHolder))
    {
      localObject = (com.tplink.iot.model.home.h)this.b.get(paramInt);
      if ((localObject instanceof e))
      {
        localObject = (e)localObject;
        ((DeviceInfoHolder)paramViewHolder).s((e)localObject, paramInt, this);
      }
    }
    else if ((paramViewHolder instanceof TitleHolder))
    {
      localObject = (com.tplink.iot.model.home.h)this.b.get(paramInt);
      if ((localObject instanceof j))
      {
        localObject = (j)localObject;
        ((TitleHolder)paramViewHolder).c((j)localObject);
      }
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new TitleHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558999, paramViewGroup, false));
    }
    return new DeviceInfoHolder(this.a, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559019, paramViewGroup, false), this.f);
  }
  
  public boolean p()
  {
    Object localObject = new ArrayList(this.d.values());
    if (((List)localObject).isEmpty()) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      e locale = (e)((Iterator)localObject).next();
      if ((locale instanceof k))
      {
        if (!((k)locale).q()) {
          return true;
        }
      }
      else if (((locale instanceof g)) && (!((g)locale).j())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean q()
  {
    int i = this.c.size();
    boolean bool = true;
    if (i <= 1) {
      bool = false;
    }
    return bool;
  }
  
  public void r(List<e> paramList)
  {
    this.b.clear();
    this.c.clear();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        e locale = (e)paramList.next();
        if ((locale instanceof k))
        {
          k localk = (k)locale;
          if (localk.g() != null)
          {
            String str = t.c(localk);
            if (this.c.get(str) == null)
            {
              this.c.put(str, Boolean.TRUE);
              this.b.add(new j(n(this.a, str, localk.g())));
            }
            this.b.add(locale);
          }
        }
        else if (((locale instanceof g)) && (((g)locale).h() != null))
        {
          if (this.c.get("group") == null)
          {
            this.c.put("group", Boolean.TRUE);
            this.b.add(new j(this.a.getString(2131952791)));
          }
          this.b.add(locale);
        }
      }
    }
    if (this.c.size() == 1) {
      this.b.remove(0);
    }
    notifyDataSetChanged();
  }
  
  public void s(h paramh)
  {
    this.g = paramh;
  }
  
  class a
    extends GridLayoutManager.SpanSizeLookup
  {
    a() {}
    
    public int getSpanSize(int paramInt)
    {
      if (((com.tplink.iot.model.home.h)RoomDeviceListAdapter.m(RoomDeviceListAdapter.this).get(paramInt)).b()) {
        return 2;
      }
      return 1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\RoomDeviceListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */