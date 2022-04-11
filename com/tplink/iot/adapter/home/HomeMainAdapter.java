package com.tplink.iot.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.s;
import com.tplink.iot.model.home.DeviceInfoHolder;
import com.tplink.iot.model.home.DeviceInfoHolder.e;
import com.tplink.iot.model.home.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeMainAdapter
  extends RecyclerView.Adapter
  implements DeviceInfoHolder.e
{
  private boolean a = false;
  private List<e> b;
  private Map<String, e> c = new HashMap();
  private Context d;
  private Animation e;
  private h f;
  private boolean g = true;
  
  public HomeMainAdapter(Context paramContext)
  {
    this(paramContext, true);
  }
  
  public HomeMainAdapter(Context paramContext, boolean paramBoolean)
  {
    this.d = paramContext;
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130771982);
    this.e = paramContext;
    paramContext.setInterpolator(new LinearInterpolator());
    this.g = paramBoolean;
  }
  
  private void p(List<e> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() >= 2) && (paramInt1 != paramInt2) && (paramInt1 >= 0) && (paramInt1 < paramList.size()) && (paramInt2 >= 0) && (paramInt2 < paramList.size())) {
      paramList.add(paramInt2, (e)paramList.remove(paramInt1));
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void b(e parame)
  {
    this.c.put(parame.e(), parame);
  }
  
  public void c(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (!paramBoolean) {
      this.c.clear();
    }
    notifyDataSetChanged();
  }
  
  public void d(e parame)
  {
    this.c.remove(parame.e());
  }
  
  public boolean g(e parame)
  {
    return this.c.containsValue(parame);
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public void h()
  {
    h localh = this.f;
    if (localh != null) {
      localh.b(this.c.size());
    }
  }
  
  public void i(e parame)
  {
    h localh = this.f;
    if (localh != null) {
      localh.i(parame);
    }
  }
  
  public void j(e parame)
  {
    h localh = this.f;
    if (localh != null) {
      localh.j(parame);
    }
  }
  
  public void l(int paramInt, e parame, boolean paramBoolean)
  {
    h localh = this.f;
    if (localh != null) {
      localh.l(paramInt, parame, paramBoolean);
    }
  }
  
  public List<e> m()
  {
    return this.b;
  }
  
  public List<e> n()
  {
    return new ArrayList(this.c.values());
  }
  
  public boolean o()
  {
    return s.b(this.b);
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((DeviceInfoHolder)paramViewHolder).s((e)this.b.get(paramInt), paramInt, this);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559019, paramViewGroup, false);
    return new DeviceInfoHolder(this.d, paramViewGroup, this.e, this.g);
  }
  
  public void q(int paramInt) {}
  
  public boolean r(int paramInt1, int paramInt2)
  {
    p(this.b, paramInt1, paramInt2);
    notifyItemMoved(paramInt1, paramInt2);
    h localh = this.f;
    if (localh != null) {
      localh.f(paramInt1, paramInt2);
    }
    return true;
  }
  
  public void s(List<e> paramList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void t(List<e> paramList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.clear();
    this.b.addAll(paramList);
    this.c.clear();
    notifyDataSetChanged();
  }
  
  public void u(h paramh)
  {
    this.f = paramh;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\HomeMainAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */