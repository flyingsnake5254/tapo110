package com.tplink.iot.adapter.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.widget.colorbulb.ColorPointView;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.List;

public class ColorLightEffectAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private Context a;
  private List<LightStateBean> b;
  private c c;
  
  public ColorLightEffectAdapter(Context paramContext, List<LightStateBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private boolean m(int paramInt)
  {
    if (paramInt == getItemCount() - 1)
    {
      List localList = this.b;
      if ((localList != null) && (localList.size() != 8)) {
        return true;
      }
    }
    return false;
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() >= 8)) {
      return this.b.size();
    }
    localList = this.b;
    int i = 1;
    if (localList != null) {
      i = 1 + localList.size();
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1)
    {
      List localList = this.b;
      if ((localList != null) && (localList.size() < 8)) {
        return 1;
      }
    }
    return 0;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof b))
    {
      LightStateBean localLightStateBean = (LightStateBean)this.b.get(paramInt);
      b localb = (b)paramViewHolder;
      int i = i.d(localLightStateBean);
      localb.a.setInnerCircleColor(i);
      localb.a.setOutlineColor(-1315861);
    }
    paramViewHolder.itemView.setOnClickListener(new a(this, paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559015, paramViewGroup, false));
    }
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559014, paramViewGroup, false));
  }
  
  public void p(c paramc)
  {
    this.c = paramc;
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    ColorPointView a;
    
    public a(View paramView)
    {
      super();
      this.a = ((ColorPointView)paramView.findViewById(2131362897));
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    ColorPointView a;
    
    public b(View paramView)
    {
      super();
      this.a = ((ColorPointView)paramView.findViewById(2131362896));
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\widget\ColorLightEffectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */